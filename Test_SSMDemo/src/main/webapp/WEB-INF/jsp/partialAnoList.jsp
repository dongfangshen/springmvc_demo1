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
</head>
<body>
	<div class="container">
		<table id="tbSection" class="display" cellspacing="0" width="100%"
			style="overflow-x: auto">

			<thead>

				<tr>

					<th>Name</th>


					<th>Desgination</th>


					<th>Salary</th>


					<th>Country</th>

				</tr>

			</thead>

		</table>
	</div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

	<!-- Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<!--jquery datatable文件  -->
	<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">
		$(function() {
			alert("进来");
			//var data = eval('${anoList}');
			alert('${anoList}');
			//var data = eval("(" + '${anoList}' + ")");
			var data = $.parseJSON('${anoList}');
			alert(data.anoL);
			 if (1==1) {
                 var userSection = data.anoL;
                 alert(userSection.length);
                 for (var i = 0; i < userSection.length; i++) {
                     $("#tbSection").append("<tr></tr>");
                     $("#tbSection tr").last().append("<td>" + userSection[i].name + "</td>");
                     $("#tbSection tr").last().append("<td>" + userSection[i].desgination+ "</td>");
                     $("#tbSection tr").last().append("<td>" + userSection[i].salary + "</td>");
                     $("#tbSection tr").last().append("<td>" + userSection[i].country + "</td>");
                 }
             }
             else
                 $("#tbSection").append('<tr><td colspan="12">暂无数据！</td></tr>');
		});
	</script>
</body>
</html>