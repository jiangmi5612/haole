<%@page import="java.util.Map,java.util.HashMap,com.ckeditor.CKEditorConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet/less" type="text/css" href="style.less" />
<script type="text/javascript" src="../js/less-1.3.0.js"></script>
<title>增加功能块</title>
</head>
<body>
		<% 
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
		%>
	<s:form action="edtBlock" method="post">
		<s:hidden name="blockId"></s:hidden>
		<s:if test="%{listBlockType.size>0}">
			<s:combobox label="功能块类型" list="listBlockType" name="block.blockType" headerKey="-1" headerValue="----可选择----"  emptyOption="true"></s:combobox>
		</s:if>
		<s:else>
			<s:textfield label="功能块类型" name="block.blockType"></s:textfield>
		</s:else>
		<s:textfield label="功能块名称" name="block.blockName" size="70"></s:textfield>
		<s:textfield label="功能块描述" name="block.blockDescription" size="70"></s:textfield>
		<s:textarea label="功能块内容" name="block.blockHtml"></s:textarea>
		<s:submit value="提交"></s:submit>
	</s:form>
	<ckeditor:replace config="<%=settings %>" replace="edtBlock_block_blockHtml" basePath="/haole/ckeditor/" />
</body>
</html>