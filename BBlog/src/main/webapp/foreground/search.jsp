<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<ol class="breadcrumb">
	<li>博客</li>
	<li>搜索</li>
</ol>
<div class="data_list">
	<div class="data_list_title">
	<span class="glyphicon glyphicon-send" aria-hidden="true"></span>
	&nbsp;搜索&nbsp;<font color="red">${q }</font>&nbsp;的结果 &nbsp;(共&nbsp;${resultTotal }&nbsp;条记录) </div>
	<div class="datas search">
		<ul class="nav nav-sidebar">
			<c:choose>
				<c:when test="${blogList.size()==0 }">
					<div align="center" style="padding-top: 20px">未查询到结果，请换个关键字试试看！</div>
				</c:when>
				<c:otherwise>
					<c:forEach var="blog" items="${blogList }">
				  	  <li style="margin-bottom: 20px">
					  	<span class="title"><a href="blog/articles/${blog.id}" target="_blank">${blog.title }</a></span>
					  	<span class="summary">摘要: ${blog.content }...</span>
					  	<span class="link">&nbsp;&nbsp;&nbsp;&nbsp;发布日期：
					  	<fmt:formatDate value="${blog.updateTime }" pattern="yyyy-MM-dd"/></span>
					  </li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	${pageCode }
</div>