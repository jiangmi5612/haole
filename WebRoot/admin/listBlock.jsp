<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet/less" type="text/css" href="style.less" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/less-1.3.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<s:if test="%{pageInfo.list.size() > 0}">
			<table class="listTable" cellspacing="0" border="0">
				<thead>
					<tr>
						<th>ID</th>
						<th>功能块类型</th>
						<th>功能块名称</th>
						<th>功能块介绍</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="%{pageInfo.list}" id="block"	status="st">
						<tr>
							<td><s:property value="#block.id"/></td>
							<td><s:property value="#block.blockType"/></td>
							<td><s:property value="#block.blockName"/></td>
							<td><s:property value="#block.blockDescription"/></td>
							<td>
								<s:url id="edtUrl" action="edtBlock.action">
									<s:param name="blockId"><s:property value="#block.id" /></s:param>
								</s:url>
								<s:url id="delUrl" action="delBlock.action">
									<s:param name="blockId"><s:property value="#block.id" /></s:param>
								</s:url>
								<s:a href="%{edtUrl}">编辑</s:a>
								<s:a href="%{delUrl}">删除</s:a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<s:include value="pageNav.jsp"></s:include>
		</s:if>
		<s:else>
			<p>目前系统中还没有功能块，请添加。</p>
		</s:else>
	</div>
</body>
</html>