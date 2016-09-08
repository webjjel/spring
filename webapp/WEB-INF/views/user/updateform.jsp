<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="user">

				<form id="update-form" name="updateForm" method="post" action="${pageContext.request.contextPath}/user/update">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${userVo.name}">

					<label class="block-label" for="email">이메일</label>
					<h5>${userVo.email}</h5>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<c:choose>
							<c:when test="${userVo.gender == 'FEMALE'}">
								<label>여</label> <input type="radio" name="gender" value="FEMALE" checked="checked">
								<label>남</label> <input type="radio" name="gender" value="MALE">
							</c:when>
							<c:otherwise>
								<label>여</label> <input type="radio" name="gender" value="FEMALE">
								<label>남</label> <input type="radio" name="gender" value="MALE" checked="checked">							
							</c:otherwise>
						</c:choose>
					</fieldset>
					
					<input type="submit" value="수정하기">
					
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2015</p>
		</div>
	</div>
</body>
</html>