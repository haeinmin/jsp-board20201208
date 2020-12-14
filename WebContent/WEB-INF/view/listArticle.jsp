<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<table border="1">
  <tr>
    <td colspan="4"><a href="write.do">write</a></td>
  </tr>
  <tr>
    <td>no</td>
    <td>subject</td>
  	<td>writer</td>
    <td>viewed</td>
  </tr>
<c:if test="${articlePage.hasNoArticles() }">
  <tr>
    <td colspan="4">no articles</td>
  </tr>
</c:if>
<c:forEach var="article" items="${articlePage.content }">
  <tr>
    <td>${article.number }</td>
    <td>
      <a href=""read.do?no=${article.number }&pageNo=${articlePage.currentPage }">
        <c:out value="${article.title }"></c:out>
      </a>
    </td>
    <td>${article.writer.name }</td>
    <td>${article.readCount }</td>
  </tr>
</c:forEach>
<c:if test="${articlePage.hasArticles() }">
  <tr>
    <td colspan="4">
      <c:if test="${articlePage.startPage>5 }">         <!-- by 5, it means size here  -->
      <a href="list.do?pageNo=${articlePage.startPage-5 }">[previous]</a>
      </c:if>
      <c:forEach var="pNo" begin="${articlePage.startPage }" end="${articlePage.endPage }">
      <a href="list.do?pageNo=${pNo }">[${pNo}]</a>
      </c:forEach>
      <c:if test="${articlePage.endPage < articlePage.totalPages }">
      <a href="list.do?pageNo=${articlePage.startPage+5 }">[next]</a>
      </c:if>
    </td>
  </tr>
</c:if>
</table>
</body>
</html>