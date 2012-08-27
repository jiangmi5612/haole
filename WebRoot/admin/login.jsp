<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet/less" type="text/css" href="style.less" />
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/less-1.3.0.js"></script>
<title>管理员登陆</title>
</head>
<body>
	<div class="login_box">
		<s:form action="login">
			<table>
				<tr>
					<td colspan="2" class="login_title">
						好乐小企业快速建站系统
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="username" label="用户名"></s:textfield>
					</td>
				</tr>
				<tr>
					<td><s:password name="password" label="密码"></s:password></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="登陆"></s:submit></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>