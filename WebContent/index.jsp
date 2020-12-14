<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
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
<%--
<c:if test="${not empty authUser }">
Hi, ${authUser.name }
<a href="logout.do">[logout]</a>
<a href="changePwd.do">[change password]</a>
</c:if>
<c:if test="${empty authUser }">
<a href="join.do">[create account]</a>
<a href="login.do">[sign in]</a>
</c:if>
 --%>
 <u:isLogin>       <%-- 사용자 정의 태그  --%>
Hi, ${authUser.name }
<a href="logout.do">[logout]</a>
<a href="changePwd.do">[change password]</a>
<a href="removeMember.do">[delete account]</a>
<a href="article/write.do">[post article]</a>
</u:isLogin>
<u:notLogin>
<a href="join.do">[create account]</a>
<a href="login.do">[sign in]</a>
</u:notLogin>
</div>
</body>
</html>