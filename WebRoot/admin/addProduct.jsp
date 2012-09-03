<%@page import="java.util.Map,java.util.HashMap,com.ckeditor.CKEditorConfig,org.apache.commons.codec.digest.DigestUtils,java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet/less" type="text/css" href="style.less" />
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/less-1.3.0.js"></script>
	<script>
	    // 这个函数将来会被iframe用到
	    function getImgPath()
	    {
	        $("#addProduct_product_img")[0].value = window.frames[0].window.name;
	        $("#addProduct")[0].submit();
	    }
	</script>

	<title>新增产品</title>
</head>
<body>
	<div>
		<% 
			Map<String, String> attr = new HashMap<String, String>();
			attr.put("height","500px");
			//CKEditor的功能项配置
			CKEditorConfig settings = new CKEditorConfig();
			settings.addConfigValue("toolbar","[{name: 'document', items: ['Source', '-', 'NewPage']},"
						+"{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },"
						+"{ name: 'editing', items : [ 'Find','Replace','-','SelectAll','-','Scayt' ] },"
						+"{ name: 'insert', items : [ 'Image','Table','HorizontalRule','Smiley','SpecialChar' ] },"
				        +"        '/',"
						+"{ name: 'styles', items : [ 'Styles','Format' ] },"
						+"{ name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] },"
						+"{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote' ] },"
						+"{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },"
					+"]");
			settings.addConfigValue("height","500");
			
			//生成随机字符串
			int length = 10;
			String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   
	        Random random = new Random();   
	        StringBuffer sb = new StringBuffer();   
	        for (int i = 0; i < length; i++) {   
	            int number = random.nextInt(base.length());   
	            sb.append(base.charAt(number));   
	        } 
	        String rdm = sb.toString();
	        String key = "a";
			//计算与SAE通信的MD5密码
			String password = DigestUtils.md5Hex(rdm+key);
		%>
		<!-- 构建一个iframe用于上传文件 -->
		<iframe id="imgUp" src="http://pysaeimg.sinaapp.com/?rdm=<%=rdm %>&password=<%=password %>&site=321haole&pageback=http://321haole.com:8080/haole/admin/showpic.html" frameborder="0"></iframe>
		<s:if test="%{product.img.length() > 0}">
			<script>
				window.frames[0].window.name = "${product.img}";
				window.frames[0].location = "showpic.html";
			</script>
		</s:if>
		<s:form action="addProduct" method="post" theme="simple">
		<table cellspacing="0" border="0" id="productBasicInfo">
			<tr>
				<td>
		 			<label>产品类别：</label><s:select list="listCategory" listKey="id" listValue="catName" name="categoryId" value="%{categoryId}"></s:select>
		 		</td>
		 	</tr>
		 	<tr>
		 		<td>
		 			<label>产品名称：</label><s:textfield name="product.productName"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>市场价：</label><s:textfield name="product.marketPrice"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>价格：</label><s:textfield name="product.productPrice"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>产品简述：</label><s:textfield name="product.productDescription"></s:textfield>
		 		</td>
		 	</tr>
			
			<tr>
		 		<td>
		 			<label>产品特性：</label><s:textarea name="product.productFeature" rows="6" cols="45"></s:textarea>
		 		</td>
		 	</tr>
		</table>
			<div class="clear"></div>
			<div id="productDetail">
			<label>产品详情：</label>
	 			<s:div id="ckeditor">
					<ckeditor:editor config="<%=settings %>" textareaAttributes="<%=attr %>" basePath="/haole/ckeditor/" editor="product.productInfo"  value="${product.productInfo}" />
				</s:div>
			</div>
			<s:hidden name="product.browseTimes" value="0"></s:hidden>
 			<s:hidden name="product.img"></s:hidden>
			<s:hidden name="productId"></s:hidden>
			<button type="button" value="提交" class="metro-button default right" onclick="getImgPath()">提交</button>
		</s:form>
	</div>
</body>
</html>