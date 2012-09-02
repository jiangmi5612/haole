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
<link rel="stylesheet" href="../css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="../js/jquery.ztree.core-3.3.min.js"></script>

<!-- 用于加载目录树的js代码 -->
<!-- TODO:后期应加入到单独的js文件中 -->
<!-- 如有需要，此处的目录树结构数据可以写入一个Block中，然后以ajax的形式返回得到 -->
<script type="text/javascript">
	var setting = {
			data:{
				simpleData:{
					enable:true
				}
			}
	};
	
	var Nodes=[
	           {id:1,pId:0,name:"好乐快速建站系统",open:true},
	           {id:11,pId:1,name:"类别管理",open:true},
	           {id:111,pId:11,name:"增加类别",url:"addCategory.jsp",target:"adminPages"},
	           {id:112,pId:11,name:"类别列表",url:"listCategory.action",target:"adminPages"},
	           {id:12,pId:1,name:"产品管理",open:true},
	           {id:121,pId:12,name:"增加产品",url:"renderCatList.action",target:"adminPages"},
	           {id:122,pId:12,name:"产品列表",url:"listProduct.action",target:"adminPages"},
	           {id:13,pId:1,name:"功能块",open:true},
	           {id:131,pId:13,name:"增加功能块",url:"renderBlockTypeList.action",target:"adminPages"},
	           {id:131,pId:13,name:"功能块列表",url:"listBlock.action",target:"adminPages"}
	           ];
	
	$(document).ready(function(){
		$.fn.zTree.init($("#tree"),setting,Nodes);
		
	});
</script>
<title>后台管理 - 好乐快速建站系统</title>
</head>
<body class="bg">
	<div class="main">
		<!-- 后台管理主页的顶部标题栏 -->
		<div class="main_top">
			<h1>好乐快速建站系统</h1>
			<a href="/haole" class="a_left">返回前台</a>
			<a href="http://www.misins.org" class="a_right">前往信研所</a>
		</div>
		<div class="main_body">
			<!-- 后台管理主页的左侧用于放置功能目录树 -->
			<div class="main_left">
				<ul id="tree" class="ztree"></ul>
			</div>
			<!-- 后台管理主页的右侧是一个iframe，用于指向特定的功能处理页面 -->
			<div class="main_right">
				<iframe id="adminPages" name="adminPages" class="adminPages" onload="this.height=0;this.height=adminPages.document.body.scrollHeight+600" frameborder="0"></iframe>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>