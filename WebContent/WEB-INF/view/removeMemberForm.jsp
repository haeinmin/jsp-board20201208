<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
	<u:navbar></u:navbar>
	<!-- .container>.row>.col-3+col-6>h1+form -->
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h1>회원 탈퇴</h1>
				<form action="${root }/removeMember.do" method="post">
					<!-- div.form-group*2>label+input.form-control -->
					<div class="form-group">
						<label for="input1-password">비밀번호</label> <input
							id="input1-password" type="password" class="form-control"
							name="password" />
						<c:if test="${errors.emptyPw }">
							<small class="form-text text-muted"> 비밀번호를 입력하세요. </small>
						</c:if>
						<c:if test="${errors.wrongPw }">
							<small class="form-text text-muted"> 올바른 비밀번호가 아닙니다. </small>
						</c:if>
					</div>
					<button type="submit" class="btn btn-primary">탈퇴</button>
				</form>
			</div>
		</div>
	</div>
	
	
<%-- <div class="container">
<h1>delete account</h1>
<form action="removeMember.do" method="post">
password: <br />
 <input type="password" name="password" id="" />
 <c:if test="${errors.emptyPw }">enter password</c:if>
 <c:if test="${errors.wrongPw }">check your password</c:if>
 <br />
 <input type="submit" value="go" />
</form>
</div> --%>
</body>
</html>