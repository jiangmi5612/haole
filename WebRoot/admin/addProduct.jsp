<%@page import="java.util.Map,java.util.HashMap,com.ckeditor.CKEditorConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
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
		<% 
			Map<String, String> attr = new HashMap<String, String>();
			attr.put("rows", "30");
			attr.put("cols", "30");
			//CKEditor的功能项配置
			CKEditorConfig settings = new CKEditorConfig();
			settings.addConfigValue("toolbar","["
						+"{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },"
						+"{ name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','Scayt' ] },"
						+"{ name: 'insert', items : [ 'Image','Table','HorizontalRule','Smiley','SpecialChar' ] },"
				        +"        '/',"
						+"{ name: 'styles', items : [ 'Styles','Format' ] },"
						+"{ name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] },"
						+"{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote' ] },"
						+"{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },"
					+"]");
		%>
		<s:form action="addProduct" method="post" theme="simple">
		<table cellspacing="0" border="0">
			<tr>
				<td>
		 			<label>产品类别：</label><s:select list="listCategory" listKey="id" listValue="catName" name="categoryId"></s:select>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td>
		 			<label>产品名称：</label><s:textfield name="productName"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>市场价：</label><s:textfield name="marketPrice"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>价格：</label><s:textfield label="" name="productPrice"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>产品简述：</label><s:textfield name="productDescription"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>产品特性：</label><s:textarea name="productFeature" rows="5" cols="60"></s:textarea>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>产品介绍：</label>
		 			<s:div id="ckeditor">
						<ckeditor:editor config="<%=settings %>" textareaAttributes="<%=attr %>" basePath="/haole/ckeditor/" editor="productInfo"  value="${productInfo}" />
					</s:div>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td>
		 			<s:hidden name="browseTimes" value="0"></s:hidden>
		 			<s:hidden name="img"></s:hidden>
					<s:hidden name="productId"></s:hidden>
					<button type="submit" value="提交" class="metro-button default right">提交</button>
		 		</td>
		 	</tr>
		</table>
		</s:form>
	</div>
</body>
</html>