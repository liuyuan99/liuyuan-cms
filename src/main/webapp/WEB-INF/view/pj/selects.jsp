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
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<title>外派单</title>
</head>
<body>
	<div class="form-group form-inline">
		<input type="button" value="添加" oncancel="add()">&nbsp;
			联络单号:<input type="text" value="${llnum1}" name="llnum1">&nbsp;&nbsp;
			
			<button type="button" class="btn btn-outline-info">查询</button>
			
	</div>
	
		<table class="table table-bordered table-hover" style="text-align:center;">
			<tr style="background-color: skyblue">
				<td>报送日期</td>
				<td>联络单</td>
				<td>制造部编号</td>
				<td>制造部</td>
				<td>配件编号</td>
				<td>配件名称</td>
				<td>参考单价</td>
				<td>数量</td>
				<td>金额</td>
				<td>设备部编号</td>
				<td>设备部</td>
				<td>具体技术要求</td>
				<td>审核单价</td>
				<td>审核金额</td>
				<td>配件外送时间</td>
				<td>加工检验</td>
				<td>配件送回时间</td>
				<td>备注</td>
			</tr>
			<c:forEach items="${info.list}" var="i" varStatus="count">
				<tr>
					<td>${count.count}</td>
					<td>${i.bsdate}</td>
					<td>${i.llnum}</td>
					<td>${i.zzbid}</td>
					<td>${i.zzb}</td>
					<td>${i.pid}</td>
					<td>
						<c:forEach items="${i.pj}" var="p">
							${p.name}
						</c:forEach>
					</td>
					<td>${i.price}</td>
					<td>${i.num}</td>
					<td>${i.money}</td>
					<td>${i.sid}</td>
					<td>${i.sname}</td>
					<td>${i.other}</td>
					<td>${i.shmoney}</td>
					<td>${i.shmoneys}</td>
					<td>${i.psdate}</td>
					<td>${i.img}</td>
					<td>${i.songdate}</td>
					<td>${i.other1}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>