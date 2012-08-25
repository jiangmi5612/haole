<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>产品列表</title>
</head>
<body>
	<div>
		<table class="listTable" cellspacing="0" border="0">
			<thead>
				<tr>
					<th>编号</th>
					<th>类别</th>
					<th>缩略图</th>
					<th>产品名称</th>
					<th>价格</th>
					<th>浏览次数</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="%{listProduct.size()!=0}">
					<s:iterator value="%{listProduct}" id="product" status="st">
						<tr>
							<td><s:property value="#product.id"/></td>
							<td><s:property value="#product.category.catName"/></td>
							<td><img src="${product.img}" width="80" /></td>
							<td><s:property value="#product.productName"/></td>
							<td><s:property value="#product.productPrice"/></td>
							<td><s:property value="#product.browseTimes"/></td>
							<td>
								<s:url id="edtUrl" action="edtProduct.action">
								<s:param name="productId"><s:property value="#product.id" /></s:param>
								</s:url>
								<s:url id="delUrl" action="delProduct.action">
									<s:param name="productId"><s:property value="#product.id" /></s:param>
								</s:url>
								<s:a href="%{edtUrl}">编辑</s:a>
								<s:a href="%{delUrl}">删除</s:a>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</tbody>
		</table>
		<ul>
			<li>
				<s:a href="listProduct.action?pageNo=%{pageNo-1}">上一页</s:a>
				<s:a href="listProduct.action?pageNo=%{pageNo+1}">下一页</s:a>
			</li>
		</ul>
	</div>
</body>
</html>