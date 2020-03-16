<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头条</title>
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />

<link rel="stylesheet" type="text/css" href="/resource/index.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<!-- 先引入jquery,再引入bootstrap -->
<script type="text/javascript" src="/resource/popper.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fluid">
		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px; line-height: 34px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">下载APP</font>

				<!-- 注册 -->
				<div style="float: right; margin-right: 20px">
					<c:if test="${sessionScope.user==null}">
						<!-- 登录 -->
						<!--从session获取当前有没有登陆，如果用户已经登陆，则不显示登录和注册-->					
						<button type="button" class="btn btn-link" data-toggle="modal" onclick="login()" data-target="#exampleModal">
					 		<font color="white">登录</font>
						</button>	
						
						<button type="button" class="btn btn-link" data-toggle="modal" onclick="reg()" data-target="#exampleModal">
							<font color="white">注册</font> 
						</button>						
										
					</c:if>
					<c:if test="${sessionScope.user!=null}">
						<div class="btn-group dropleft">
							<button type="button" class="btn btn-link dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								<font color="white">用户登录信息</font>
							</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">${sessionScope.user.username}</a> 
								<a class="dropdown-item" href="/my">个人中心</a>
								<a class="dropdown-item" href="/passport/logout">注销</a>
							</div>
							
						</div>
					</c:if>					
				</div>				
			</div>
		</div>

		<div class="row">
			<div class="col-md-2" style="padding-top: 10px">
				<ul>
					<!-- 今日头条图标 -->
					<li style="margin-bottom: 10px"><a href="/"> <img alt=""
							src="/resource/images/logo-index.png"
							style="width: 108px; height: 27px;">

					</a></li>

					<!-- 热点文章 -->
					<li><a href="/?hot=1"
						class="channel-item ${article.channelId==null?'active':''}">热点</a></li>
					<!-- 遍历所有栏目 -->
					<c:forEach items="${channels}" var="channel" varStatus="i">
						<li><a href="/?channelId=${channel.id}"
							class="channel-item ${article.channelId==channel.id?'active':''}">${channel.name }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-md-7">
				<!-- 如果栏目ID 为null 说明点击左侧的栏目热点 这显示轮播图 -->
				<c:if test="${article.channelId==null}">
					<!-- 如果 -->
					<div style="margin: 5px 5px 5px 5px;">
						<div id="carouselExampleCaptions" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<c:forEach items="${slides}" var="slide" varStatus="i">
									<li data-target="#carouselExampleCaptions"
										data-slide-to="${i.index}" class="active"></li>
								</c:forEach>
							</ol>
							<!-- 轮播图 -->
							<div class="carousel-inner">
								<c:forEach items="${slides}" var="slide" varStatus="i">
									<div class="carousel-item ${i.index==0?'active':''}">
										<img src="/pic/${slide.url}" class="d-block w-100 rounded"
											alt="..." style="width: 590px; height: 470px">
										<div class="carousel-caption d-none d-md-block">
											<h5>${slide.title}</h5>
										</div>
									</div>
								</c:forEach>
							</div>
							<a class="carousel-control-prev" href="#carouselExampleCaptions"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>
					<hr>
				</c:if>
				<!-- 如果栏目ID 不为null 说明点击左侧的栏目 -->
				<c:if test="${article.channelId!=null}">
					<!-- 子分类 -->
					<div class="subchannel">
						<ul>
							<li
								class="sub-item ${article.categoryId==null?'sub-selected':''}"><a
								href="/?channelId=${article.channelId}">全部</a></li>
							<c:forEach items="${categorys}" var="category">
								<li
									class="sub-item ${article.categoryId==category.id?'sub-selected':''}"><a
									href="/?channelId=${article.channelId}&categoryId=${category.id}">${category.name }</a></li>
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<!-- 分类下的文章 -->
				<div>
					<c:forEach items="${info.list}" var="article">
						<div class="media">
							<img src="/pic/${article.picture}" class="mr-3 rounded" alt="..."
								style="width: 190px; height: 124px">
							<div class="media-body">
								<h5 class="mt-0">
									<a href="/articleDetail?id=${article.id}" target="_blank">${article.title}</a>
								</h5>
								<p>${article.user.username}.
									${article.hits} 浏览 .
									<fmt:formatDate value="${article.created}"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</p>
							</div>
						</div>
						<hr>
					</c:forEach>
					<!-- 分页 -->
					<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card" style="width: 18rem; margin-top: 10px;">
					<div class="card-header">
						<h4>24小时热闻</h4>
					</div>
					<div class="card-body">
						<!-- 最新文章 10篇 -->
						<c:forEach items="${lastArticles.list}" var="lastArticle">
							<div class="media">
								<img src="/pic/${lastArticle.picture}" class="mr-3" alt="..."
									style="width: 60px; height: 60px">
								<div class="media-body">
									<p><a href="/articleDetail?id=${lastArticle.id}" target="_blank">${lastArticle.title}</a></p>
								</div>
							</div>
							<hr>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<!-- 注册,登录 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">
							<span id="title"></span>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="passport"></div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function reg() {
			$("#title").append("用户注册");
			$("#passport").load("/passport/reg");
		}
		function login() {
			$("#title").append("用户登录");
			$("#passport").load("/passport/login");
		}
		function goPage(page) {
			var channelId = '${article.channelId}';//栏目Id
			var categoryId = '${article.categoryId}';//分类id
			var url = "/?channelId=" + channelId + "&page=" + page;
			if (categoryId != "") { //如果分类不为空则传递分类的查询条件
				url = url + "&categoryId=" + categoryId;
			}
			location.href = url;
		}
	</script>
</body>
</html>