<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>方法详情</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3>${ano.method}:${ano.descre}</h3>
		<hr />
		<table>
			<tr>
				<th>开发人(Author)</th>
				<td>${ano.author}</td>
			</tr>
			<tr>
				<th>类型(ClientType)</th>
				<td>${ano.clienttype}</td>
			</tr>
			<tr>
				<th>模块</th>
				<td>${ano.module}</td>
			</tr>
			<tr>
				<th>服务</th>
				<td>${ano.service}</td>
			</tr>
			<tr>
				<th>方法名</th>
				<td>${ano.method}</td>
			</tr>

			<tr>
				<td colspan="2">
					<table class="table table-bordered">
						<tr>
							<th>输入</th>
							<td colspan="2"></td>
						</tr>
						<tr style="background-color: gray;">
							<th>英文名</th>
							<th>中文名</th>
							<th>类型</th>

						</tr>
						<c:choose>
							<c:when test="${!empty listInput}">
								<c:forEach var="uk" items="${listInput}">
									<tr>
										<td>${uk.enName}</td>
										<td><c:out value="${uk.type}" /></td>
										<td><c:out value="${uk.cnName}" /></td>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="15" style="text-align: center">没有数据显示</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
					<table class="table table-bordered">
						<tr>
							<th>输出</th>
							<td colspan="2"></td>
						</tr>
						<tr style="background-color: gray;">
							<th>英文名</th>
							<th>中文名</th>
							<th>类型</th>

						</tr>
						<c:choose>
							<c:when test="${!empty listOutput}">
								<c:forEach var="ul" items="${listOutput}">
									<tr>
										<td>${ul.enName}</td>
										<td><c:out value="${ul.type}" /></td>
										<td><c:out value="${ul.cnName}" /></td>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="15" style="text-align: center">没有数据显示</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>