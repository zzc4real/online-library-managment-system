<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addreader.css">

<script src="${pageContext.request.contextPath}/js/AddReaderScript.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<html>
<head>
    <title>书本添加</title>
</head>
<body>
<form action="BookAction?action=addtemp" onsubmit="return errorsubmit()" method="post">
	<div class = "stuinfo">
		<div class = "title">
			<span>请输入学生信息</span>
		</div>
		<div>
			<span class="infotitle">学号：</span>
			<input name="stuID" class="required" id="stuID">
			<div>
				<button >
			</div>
		</div>
	</div>>
</form>
</body>
</html>