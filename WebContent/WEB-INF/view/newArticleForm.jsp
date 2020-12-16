<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
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
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
	<u:navbar></u:navbar>
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h1>게시글 작성</h1>
				<form action="${root }/article/write.do" method="post">
					<div class="form-group">
						<label for="input1-title">제목</label> <input type="text"
							class="form-control" id="input1-title" name="title"
							value="${param.title }">
						<c:if test="${errors.title }">
							<small class="form-text text-muted"> 제목을 입력하세요. </small>
						</c:if>
					</div>
					<div class="form-group">
						<label for="content">본문</label>
						<textarea class="form-control" id="textarea" rows="5" cols="30"
							name="content"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">등록</button>
				</form>
			</div>
		</div>
	</div>

	<%-- 	<form action="write.do" method="post">
		<p>
			title: <br /> <input type="text" name="title"
				value="${param.title }" />
			<c:if test="${errors.title }">insert subject</c:if>
		</p>
		<p>
			content: <br />
			<textarea name="content" id="" cols="30" rows="5"></textarea>
		</p>
		<input type="submit" value="go" />
	</form> --%>
</body>
</html>