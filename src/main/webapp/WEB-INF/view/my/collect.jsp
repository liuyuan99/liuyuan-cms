<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<title>我的收藏</title>
	
</head>
<body>
<div class="container">
	<c:forEach items="${info.list}" var="collect">
		<dl>
			<dt><a href="${collect.url}" target="_blank">${collect.text}</a></dt>
			<dd>
				<fmt:formatDate value="${collect.created}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;
				<button type="button" class="btn btn-warning btn-sm" onclick="deleteCollect(${collect.id})">取消收藏</button>
			</dd>
		</dl>
	</c:forEach>
	<jsp:include page="/WEB-INF/view/common/pages.jsp"/>
</div>
</body>
<script type="text/javascript">
	function deleteCollect(id) {
		$.post("/deleteCollect",{id:id},function(flag){
			if(flag){
				$("#center").load("/my/collect");
			}
		})
	}
	function goPage(page) {
		$("#center").load("/my/collect?page="+page);
	}
</script>
</html>