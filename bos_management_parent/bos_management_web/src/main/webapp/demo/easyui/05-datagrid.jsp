<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyUI-messager-消息框</title>
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<h3>1.将html的table标签转换成datagrid</h3>
	<table class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'telephone'">电话</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>马容</td>
				<td>13838389438</td>
			</tr>
			<tr>
				<td>2</td>
				<td>宋吉吉</td>
				<td>13838389438</td>
			</tr>
		</tbody>
	</table>
	
	<h3>2.动态加载datagrid数据</h3>
	<table class="easyui-datagrid" data-options="url:'${pageContext.request.contextPath}/data/courier.json'">
		<thead>
			<tr>
				<!-- field:设置从返回的json数据的哪个key上取值 -->
				<th data-options="field:'id'">编号</th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'telephone'">电话</th>
			</tr>
		</thead>
	</table>
	
	<h3>3.使用api动态构建datagrid</h3>
	<table id="grid"></table>
	<script type="text/javascript">
		$(function(){
			$('#grid').datagrid({
				url:'${pageContext.request.contextPath}/data/courier.json',
				columns:[[
				          {title:'编号',field:'id',checkbox:true},//title：列名,checkbox:开启复选框
				          {title:'姓名',field:'name'},
				          {title:'电话',field:'telephone'}
				          ]],//二维数组，设置表格的列属性
				toolbar:[
				         {text:'增加', iconCls:'icon-add',handler:function(){
				        	 alert(1);
				         }},//text:设置按钮的名称,handler相当于onclick
				         {text:'修改'},
				         {text:'作废'},
				         {text:'还原'}
				         ],//工具条，一位数组
				 pagination:true,//开启分页查询条
				 pageList:[10,30,50]//定制每页显示条数选项
			});
		});
	</script>
</body>
</html>