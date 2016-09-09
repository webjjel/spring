<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
$(function() {
	$("input[type='button']").click(function() {
		var email = $('#email').val();
		if (email == "") {
			return;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath }/user/api/checkemail",
		    type: "get",
		    dataType: "json",
		    data: {email: email},
		    //contentType: "application/json",
		    success: function(response){
				if (response.result == "fail") {
					console.error(response.message);
					return;
				}
				
				if (response.data == false) {
					alert("사용중입니다.");
					$('#email').val('').focus();
					return;
				}
				
				
		    },
		    error: function(jqXHR, status, error){
				console.log(status + " : " + error);
		    }
		});
	});
});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="user">

				<form:form modelAttribute="userVo" id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath }/user/join">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">
					<!-- <form:input path="name" /> -->
					<p style="text-align:left;color:red">
						<form:errors path="name" />
					</p>
					
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<input type="button" value="중복체크">
					<img id="check_img" src="${pageContext.request.contextPath }/assets/images/check.png" style="display:none">
					<spring:hasBindErrors name="userVo">
		 			    <c:if test="${errors.hasFieldErrors('email') }">
							<p style="text-align:left;color:red">					   
					        	<strong>
					        		<spring:message code="${errors.getFieldError('email').codes[0] }" text="${errors.getFieldError('email').defaultMessage }" />
					        	</strong>
					        </p>
		 			    </c:if>
					</spring:hasBindErrors>
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					<spring:hasBindErrors name="userVo">
		 			    <c:if test="${errors.hasFieldErrors('password') }">
							<p style="text-align:left;color:red">					   
					        	<strong>
					        		<spring:message code="${errors.getFieldError('password').codes[0] }" text="${errors.getFieldError('password').defaultMessage }" />
					        	</strong>
					        </p>
		 			    </c:if>
					</spring:hasBindErrors>
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="FEMALE" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="MALE">
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form:form>
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