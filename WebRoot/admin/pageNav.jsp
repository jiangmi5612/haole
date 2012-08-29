<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	//引用该模块时，需要页面有PageInfo类的名为pageInfo的对象
%>
<div class="pageNav">
	<span>共<s:property value="pageInfo.allRow"/>条记录</span>
	<span>共<s:property value="pageInfo.totalPage" />页</span>
	<span>当前第<s:property value="pageInfo.currentPage"/>页</span>
	<s:if test="%{pageInfo.isFirstPage()}">
		<span>第一页</span>
		<span>上一页</span>
	</s:if>
	<s:else>
		<s:a href="%{pageInfo.listPage + 1}">第一页</s:a>
		<s:a href="%{pageInfo.listPage + (pageInfo.currentPage - 1).toString()}">上一页</s:a>
	</s:else>
	<s:if test="%{pageInfo.isLastPage()}">
		<span>下一页</span>
		<span>最后一页</span>
	</s:if>
	<s:else>
		<s:a href="%{pageInfo.listPage + (pageInfo.currentPage + 1).toString()}">下一页</s:a>
		<s:a href="%{pageInfo.listPage + pageInfo.totalPage}">最后一页</s:a>
	</s:else>
</div>