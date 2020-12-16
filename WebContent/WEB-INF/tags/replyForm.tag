<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="articleNo" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty sessionScope.authUser }">
  <div>
    <form action="${root }/reply/add.do" method="post">
      <input type="number" value="${articleNo }" name="no" id="" hidden />
      <input type="text" name="body" id="" />
      <input type="submit" value="go" />
    </form>
  
  </div>
</c:if>