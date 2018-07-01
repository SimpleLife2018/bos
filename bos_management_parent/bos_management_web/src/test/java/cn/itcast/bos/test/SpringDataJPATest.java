package cn.itcast.bos.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.bos.dao.StandardRepository;
import cn.itcast.bos.domain.base.Standard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataJPATest {

	@Resource
	private StandardRepository standardRepository;
	
	@Test
	public void testDemo1(){
		//查询所有取派标准数据
		List<Standard> list = standardRepository.findAll();
		for(Standard st : list){
			System.out.println(st.getName());
		}
	}
	
	/**
	 * //方法名解析：根据名称查询取派标准的数据
	 */
	@Test
	public void testDemo2(){
		List<Standard> list = standardRepository.findByName("10~20公斤");//where name = ?
		for(Standard st : list){
			System.out.println(st.getName());
		}
	}
	
	/**
	 * //方法名解析：根据名称模糊查询取派标准的数据
	 */
	@Test
	public void testDemo3(){
		List<Standard> list = standardRepository.findByNameLike("%20%");//where name = ?
		for(Standard st : list){
			System.out.println(st.getName());
		}
	}
	
	/**
	 * //query注解查询：根据名称模糊查询取派标准的数据
	 */
	@Test
	public void testDemo4(){
		List<Standard> list = standardRepository.getNameLike("%20%");//where name = ?
		for(Standard st : list){
			System.out.println(st.getName());
		}
	}
}
