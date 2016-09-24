<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>hello world</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script type="text/javascript">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js">
</script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!--jquery datatable文件  -->
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
</script>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h4>方法列表</h4>
				<fieldset>
					<div class="form-group">
						<label for="lblAuthor" class="col-md-1">开发人:</label>
						<div class="col-md-3">
							<div class="input-group">
								<select id="crt_Author" tabindex="10" style="width: 150px;"
									class="form-control" name="author">
									<option value="-1" selected="selected">请选择</option>
									<c:forEach items="${authorList}" var="al">
										<option value="${al.value}">${al.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<label for="lblClient" class="col-md-1">客户端:</label>
						<div class="col-md-3">
							<div class="input-group">
								<select id="crt_ClientType" tabindex="10" style="width: 150px;"
									class="form-control" name="clientType">
									<option value="-1" selected="selected">请选择</option>
									<c:forEach items="${clientList}" var="cl">
										<option value="${cl.key}">${cl.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>


						<label for="lblAuthor" class="col-md-1">方法:</label>
						<div class="col-md-3">
							<div class="input-group">
								<input type="text" class="form-control" id="txtMethodOrDes"
									name="methodOrDes" placeholder="输入方法名或备注">
							</div>
						</div>
					</div>
					<div class="col-md-12" style="margin-top: 5px;">
						<button id="btnSearch" class="btn  btn-primary"
							" style="width: 100px;">查询</button>
					</div>
				</fieldset>
		</div>
		<%-- <table class="table table-striped">
			<tr>
				<th>方法名</th>
				<th>作者</th>
				<th>客户端</th>
				<th>模块</th>
				<th>服务</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty anoList}">
					<c:forEach var="ano" items="${anoList}" varStatus="i">
						<tr>
							<td>${ano.method}</td>
							<td>${ano.author}</td>
							<td>${ano.clienttype}</td>
							<td>${ano.module }</td>
							<td>${ano.service }</td>
							<td>${ano.descre }</td>
							<td><a
								href="${pageContext.request.contextPath}/ano/showAno/${ano.id}"
								type="button" class="btn btn-sm btn-success">详情</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="15" style="text-align: center">没有数据显示</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table> --%>
		<div>
			<jsp:include page="partialAnoList.jsp" />
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#btnSearch")
					.click(
							function() {
								var clientType = $("#crt_ClientType").val();
								var author = $("#crt_Author").val();
								var methodOrDes = $("#txtMethodOrDes").val();
								$.ajax({
											"url" : "${pageContext.request.contextPath}/ano/hello/anoListByWhere",
											"type" : "POST",
											"dataType" : 'json',
											"data" : {
												"clientType" : clientType,
												"author" : author,
												"methodOrDes" : methodOrDes
											},
											"success" : function(data) {
												 if (data!=null) {
													 $("#tbSection").html(null);
									                 var userSection = data.anoList;
									                 for (var i = 0; i < userSection.length; i++) {
									                     $("#tbSection").append("<tr></tr>");
									                     $("#tbSection tr").last().append("<td>" + userSection[i].method + "</td>");
									                     $("#tbSection tr").last().append("<td>" + userSection[i].author+ "</td>");
									                     $("#tbSection tr").last().append("<td>" + userSection[i].clienttype + "</td>");
									                     $("#tbSection tr").last().append("<td>" + userSection[i].module + "</td>");
									                     $("#tbSection tr").last().append("<td>" + userSection[i].service + "</td>");
									                     $("#tbSection tr").last().append("<td>" + userSection[i].descre + "</td>");
									                     $("#tbSection tr").last().append("<td><a type='button' class='btn btn-sm btn-success' href='${pageContext.request.contextPath}/ano/showAno/"+userSection[i].id +"'>详情</a></td>");
									                 }
									             }
									             else
									                 $("#tbSection").append('<tr><td colspan="12">暂无数据！</td></tr>');
											}
										});
							});

		})
	</script>
</body>
</html>
