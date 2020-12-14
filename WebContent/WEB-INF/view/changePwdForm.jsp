<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>change password</h1>
		<form action="changePwd.do" method="post">
			<p>
				current password: <br /> <input type="password" name="curPwd" id="" />
				<c:if test="${errors.curpwd }">enter current password</c:if>
				<c:if test="${errors.badCurPwd }">current password does not match</c:if>
			</p>
			<p>
				new password: <br /> <input type="password" name="newPwd" id="" />
				<c:if test="${errors.newPwd }">reset password</c:if>
			</p>
			<input type="submit" value="change password" />
		</form>
	</div>
</body>
</html>