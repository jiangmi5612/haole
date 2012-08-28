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
<title>产品列表</title>
</head>
<body>
	<div>
		<!-- 表现方式二 -->
		<s:iterator value="%{listProduct}" id="product" status="st">
			<div class="list_item">
				<span class="list_item_img">
					<img alt="${product.productName}" src="${product.img}">
				</span>
				<span class="list_item_title"><s:property value="#product.productName"/></span>
				<span class="list_item_description"><s:property value="#product.productDescription"/></span>
				<span class="list_item_detail">
					价格：<s:property value="#product.productPrice"/>&nbsp;
					浏览：<s:property value="#product.browseTimes"/>
				</span>
				<span class="list_item_oprate">
					<s:url id="edtUrl" action="edtProduct.action">
						<s:param name="productId"><s:property value="#product.id" /></s:param>
					</s:url>
					<s:url id="delUrl" action="delProduct.action">
						<s:param name="productId"><s:property value="#product.id" /></s:param>
					</s:url>
					<s:a href="%{edtUrl}">编辑</s:a>
					<s:a href="%{delUrl}">删除</s:a>
				</span>
			</div>
		</s:iterator>
		<ul>
			<li>
				<s:a href="listProduct.action?pageNo=%{pageNo-1}">上一页</s:a>
				<s:a href="listProduct.action?pageNo=%{pageNo+1}">下一页</s:a>
			</li>
		</ul>
	</div>
</body>
</html>