<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyUI-accordion-折叠面板</title>
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<!-- title：标题，可以使区域折叠
		region：设置区域值
	 -->
	<div title="xx管理系统" data-options="region:'north'" style="height:100px">北部区域</div>
	<div title="菜单管理" data-options="region:'west'"  style="width:200px">
		<!-- 折叠面板
				fit:自适应属性，设置是否填充满父容器，true-填充满
		 -->
		<div class="easyui-accordion" fit="true">
			<div title="面板1" data-options="iconCls:'icon-help'"></div>
			<div title="面板2"></div>
			<div title="面板3"></div>
			<div title="面板4"></div>
		</div>
	</div>
	<div data-options="region:'center'">中部区域</div>
	<div data-options="region:'east'"  style="width:100px">东部区域</div>
	<div data-options="region:'south'" style="height:100px">南部区域</div>
</body>
</html>