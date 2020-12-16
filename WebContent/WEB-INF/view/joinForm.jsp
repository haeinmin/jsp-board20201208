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
	<u:navbar />

	<div class="container">
	  <!-- <div class="row">
	    <div class="col-2">
	    	<div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Debitis libero.</div>
	    </div>
	    <div class="col-4">
	    	<div>Adipisci repellat nemo temporibus itaque pariatur placeat minima explicabo incidunt.</div>
	    </div>
	    <div class="col-1">
	    	<div>Necessitatibus reprehenderit nostrum eum ut magnam provident cumque saepe laudantium.</div>
	    </div> -->
	 
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
      <h1>회원 가입</h1>
    <form action="${root }/join.do" method="post">
      <div class="form-group">
        <label for="input1-id">아이디</label> <input
          type="text" name="id" value="${param.id }" class="form-control" id="input1-id"
          >
          <c:if test="${errors.id }">
            <small class="form-text text-muted">
              ID를 입력하세요.
            </small>
          </c:if> 
          <c:if test="${errors.duplicateId }">
            <small class="form-text text-muted">
              이미 사용중인 아이디입니다.
            </small>
          </c:if>
      </div>
      <div class="form-group">
        <label for="input2-name">이름</label> <input
          type="text" name="name" value="${param.name }" id="input2-name" class="form-control">
          
          <c:if test="${errors.name }">
            <small class="form-text text-muted">
              이름을 입력하세요. 
            </small>
          </c:if>
      </div>
      <div class="form-group">
        <label for="input3-password">비밀번호</label> <input
          type="password" name="password" class="form-control"
          id="input3-password">
          <c:if test="${errors.password }">
            <small class="form-text text-muted">
              암호를 입력하세요.
            </small>
          </c:if>
      </div>
      <div class="form-group">
        <label for="input4-confirmPassword">비밀번호 확인</label> <input
          type="password" name="confirmPassword" class="form-control"
          id="input4-confirmPassword">
          <c:if test="${errors.confirmPassword }">
            <small class="form-text text-muted">
              비밀번호를 재입력하세요.
            </small>
          </c:if>
          <c:if test="${errors.notMatch }">
            <small class="form-text text-muted">
              비밀번호가 일치하지 않습니다.
            </small>
          </c:if>
      </div>
      <button type="submit" class="btn btn-primary">회원가입</button>
    </form>
      </div>
      <div class="col-3"></div>
    </div>
    

  </div>
	  
<!-- 
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
 -->
</body>
</html>



