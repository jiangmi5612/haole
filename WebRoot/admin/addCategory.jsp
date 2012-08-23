<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>增加类别</title>
</head>
<body>
	<s:form action="/admin/addCategory.action" method="post">
		<s:textfield label="类别名称" name="categoryName"></s:textfield>
		<s:textarea label="类别描述" cols="60" rows="5" name="categoryDescription"></s:textarea>
		<s:submit value="确定"></s:submit>
	</s:form>
</body>
</html>