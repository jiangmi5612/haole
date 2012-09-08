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
<script>
	//绑定表单提交事件
	$(function(){
		$("#categoryId").change(function(){
			$("form")[0].submit();
		});
	});
</script>
<title>产品列表</title>
</head>
<body>
	<div>
		<s:form action="listProduct" method="GET" theme="simple">
			<span><s:select list="listCategory" listKey="id" listValue="catName" name="categoryId" id="categoryId" ></s:select>
			</span>
		</s:form>
		<s:iterator value="%{pageInfo.list}" id="product" status="st">
			<div class="list_item">
				<span class="list_item_img">
					<img alt="${product.productName}" src="${product.productImg}">
				</span>
				<span class="list_item_title"><s:property value="#product.productName"/></span>
				<span class="list_item_category"><s:property value="#product.categoryName"/></span>
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
		<s:include value="pageNav.jsp"></s:include>
	</div>
</body>
</html>