<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>类别列表</title>
</head>
<body>
	<div>
		<table>
			<s:if test="%{listCategory.size()!=0}">
			<s:iterator value="%{listCategory}" id="category">
				<tr>
					<td><s:property value="#category.catName"/></td>
					<td><s:property value="#category.catDescription" /></td>
				</tr>
			</s:iterator>
			</s:if>
			<s:else>
				<p>目前系统中还没有产品类别，请添加。</p>
			</s:else>
		</table>
	</div>
</body>
</html>