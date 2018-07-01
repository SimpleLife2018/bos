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
	<script type="text/javascript">
		//1.messager：简单提示框alert
		//参数1：标题
		//参数2：提示内容
		//参数3：提示级别，info、warning、error
		/* $.messager.alert('提示框','上课不要走神儿！','error'); */
		//2.messager：确认框confirm
		//参数1：标题
		//参数2：确认内容
		//参数3：回调函数，参数r，r=true，客户选择的是确定；r=false，客户选择取消
	/* 	$.messager.confirm('确认框','你确定要上课走神儿么！',function(r){
			alert(r);
			if(r){
				//执行客户操作
			}
		}); */
		//3.messager：欢迎框show
		window.setTimeout(function(){
			$.messager.show({
				title:'欢迎框',
				msg:'欢迎管理员登录系统！',
				timeout:3000,
				showType:'fade'
			});
		}, 3000);//延迟执行函数
	</script>
</body>
</html>