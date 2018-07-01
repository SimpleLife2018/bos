package cn.itcast.bos.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.service.ICourierService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@ParentPackage("struts-default")
@Namespace("/")
@Actions
@Controller//相当于bean标签
@Scope("prototype")//相当于bean标签中的scope属性，必须设置为prototype-多例
public class CourierAction extends ActionSupport implements ModelDriven<Courier> {

	private Courier model = new Courier();
	
	@Resource
	private ICourierService courierService;
	
	@Override
	public Courier getModel() {
		return model;
	}

	@Action(value="courierAction_add", results={
			@Result(name="success", location="/pages/base/courier.jsp")
	})
	public String add(){
		courierService.add(model);
		return "success";
	}
	
	private Integer page;//当前页
	
	private Integer rows;//每页条数
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	@Action(value="courierAction_pageQuery")
	public String pageQuery() throws IOException{
		//1.封装分页查询参数
		//参数1：（当前页-1）
		//参数2：每页条数
		Pageable pageable = new PageRequest(page - 1, rows);
		//2.执行分页查询（总条数和每页显示的数据集合）
		Page<Courier> page = courierService.pageQuery(pageable);
		//3.将查询结果转换成json数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotalElements());//总条数
		map.put("rows", page.getContent());//每页数据集合
		//json-lib将java数据转换成json数据
		//JSONObject：将java数据转换成json对象
		//JSONArray：将java数据转换成json数组
		//JsonConfig：将转换结果中不需要的属性排除
		JsonConfig jsonConfig = new JsonConfig();
		String[] excludes = {"fixedAreas"};
		jsonConfig.setExcludes(excludes);
		JSONObject jsonObject = JSONObject.fromObject(map, jsonConfig);
		String json = jsonObject.toString();
		//4.通过response将json返回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
}
