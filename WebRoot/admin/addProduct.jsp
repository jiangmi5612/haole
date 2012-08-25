<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css" />
	<link rel="stylesheet" type="text/css" href="ajaxfileupload.css" />
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="ajaxfileupload.js"></script>
	<script type="text/javascript">
		function ajaxFileUpload()
		{
			$("#loading")
			.ajaxStart(function(){
				$(this).show();
			})
			.ajaxComplete(function(){
				$(this).hide();
			});
	
			$.ajaxFileUpload
			(
				{
					url:'http://321haola.sinaapp.com/upload.php?namespace=321haola&dest=test.png&password=.com.cn',
					secureuri:false,
					fileElementId:'file',
					dataType: 'json',
					data:{name:'logan', id:'id'},
					success: function (data, status)
					{
						if(typeof(data.error) != 'undefined')
						{
							if(data.error != '')
							{
								alert(data.error);
							}else
							{
								alert(data.msg);
							}
						}
					},
					error: function (data, status, e)
					{
						alert(e);
					}
				}
			)
			
			return false;
	
		}
	</script>
	<title>新增产品</title>
</head>
<body>
	<div>
		<img id="loading" src="loading.gif" style="display:none;">
		<form action="">
			<input id="file" type="file" size="45" name="file" class="input">
			<button class="button" id="buttonUpload" onclick="return ajaxFileUpload();">上传</button>
		</form>
		<s:form action="addProduct" method="post">
			<s:textfield label="图片地址" name="img"></s:textfield>
			<s:select label="产品类别" list="listCategory" listKey="id" listValue="catName" name="categoryId"></s:select>
			<s:textfield label="产品名称" name="productName"></s:textfield>
			<s:textfield label="市场价" name="marketPrice"></s:textfield>
			<s:textfield label="价格" name="productPrice"></s:textfield>
			<s:textfield label="产品简述" name="productDescription"></s:textfield>
			<s:textarea label="产品特性" name="productFeature" rows="5" cols="60"></s:textarea>
			<s:textarea label="产品介绍" name="productInfo" rows="15" cols="60"></s:textarea>
			<s:hidden name="browseTimes" value="0"></s:hidden>
			<s:hidden name="productId"></s:hidden>
			<s:submit value="提交"></s:submit>
		</s:form>
	</div>
</body>
</html>