<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
	</div>
	<div class="container" style="background-color: pink">
		aaa
	</div>
	<div class="container-fluid" style="background-color: pink">
	
		<div class="row">
			<div class="col-md-2" style="background-color: red">占2列</div>
			<div class="col-md-3" style="background-color: pink">占3列</div>
			<div class="col-md-4" style="background-color: blue">占4列</div>
			<div class="col-md-3" style="background-color: yellow">占3列</div>
		</div>
	
		<div class="row">
			<div class="col-md-7" style="background-color: yellow">占7列</div>
			<div class="col-md-5" style="background-color: red">占5列</div>
		</div>
		
		<div class="row">
			<div class="col-md-12" style="background-color: yellow">占12列</div>
		</div>
	</div>
</body>
</html>