<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>hello world</title>
</head>
<body>
	<div class="container">
		<table id="tbSection" cellspacing="0" width="100%" class="table table-striped"
			style="overflow-x: auto">
			<thead>
				<tr>
				<th>方法名</th>
				<th>作者</th>
				<th>客户端</th>
				<th>模块</th>
				<th>服务</th>
				<th>备注</th>
				<th>操作</th>
			</tr>

			</thead>

		</table>
	</div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<!--jquery datatable文件  -->
	<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//var data = eval("(" + '${anoList}' + ")");
			var data = $.parseJSON('${anoList}');
			 if (data!=null) {
                 var userSection = data.anoL;
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
		});
	</script>
</body>
</html>