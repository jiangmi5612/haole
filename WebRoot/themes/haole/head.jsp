<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet/less" type="text/css" href="themes/haole/style.less" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/less-1.3.0.js"></script>
    <script type="text/javascript" src="js/slides.min.jquery.js"></script>
    <script>
        $(function(){
            $("#slides").slides({
            	preload:true,
            	preloadImage:'image/loading141.gif',
            	pagination:false,
            	generatePagination:false,
            	play:2000,
            	pause:4000,
            	hoverPause:true
            });
        });
    </script>
    <title>好乐维修网</title>
  </head>
  <body>
    <div id="page-wrapper">
		<!--头部-->
		<div class="header">
			<div class="logo">好乐维修网</div>
			<!--搜索框-->
			<script type="text/javascript">
				function clearIt(what)
				{
				if(what.value == what.defaultValue) what.value = '';
				}
				function setIt(what)
				{
				if(what.value == '') what.value = what.defaultValue;
				}
			</script>
			<form id="search" name="search" method="get" action="search.action">
				<span id="searchInputContainer">
					<input type="text" name="query" value="请输入关键词" class="textinput" onfocus="clearIt(this)" onblur="setIt(this)"/>
					<input type="image" src="image/search-field-bg-2.png" name="searchBtn" value="search"/>
				</span>
			</form>
		</div>
		
		<!--横向导航-->
		<div class="nav">
			<ul class="nav_ul">
				<li class="nav_item all_product">全部产品类别</li>
				<li class="nav_item"><a href="###">首页</a></li>
				<li class="nav_item"><a href="###">重装系统</a></li>
				<li class="nav_item"><a href="###">电脑硬件维修</a></li>
				<li class="nav_item"><a href="###">打印机维修</a></li>
			</ul>
		</div>