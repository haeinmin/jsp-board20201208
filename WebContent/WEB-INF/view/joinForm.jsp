<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h1>create account</h1>
  <form action="join.do" method="post">
    <p>
      id : <br />
      <input type="text" name="id" value="${param.id }" />
      <c:if test="${errors.id }" >enter id </c:if>
      <c:if test="${errors.duplicateId }">this id is already in use</c:if>
    </p>
    <p>
      name : <br />
      <input type="text" name="name" value="${param.name }" />
      <c:if test="${errors.name }" >enter name </c:if>
    </p>
    <p>
      password : <br />
      <input type="password" name="password" />
      <c:if test="${errors.password }" >enter password </c:if>
    </p>
    <p>
      confirm : <br />
      <input type="password" name="confirmPassword" />
      <c:if test="${errors.confirmPassword }" >reenter password </c:if>
      <c:if test="${errors.notMatch }" >confirm password </c:if>
    </p>
    <input type="submit" value="submit" />
  </form>
</div>
</body>
</html>



