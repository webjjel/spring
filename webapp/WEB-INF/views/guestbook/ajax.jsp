<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
$(function() {
	$("input[type='submit']").click(function() {
		event.preventDefault();
		
		var data = {
			name: $("input[name='name']").val(),
			message: $("textarea[name='message']").val(),
			password: $("input[name='password']").val()
		};
		
		$.ajax({
			url : "${pageContext.request.contextPath }/guestbook/api/insert",
		    type: "post",
		    dataType: "json",
		    data: JSON.stringify(data),
		    contentType: "application/json",
		    success: function(response){
				console.log(response);
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
			<div id="guestbook">
				<form method="post" action="${pageContext.request.contextPath }/guestbook/insert">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<c:set var="count" value="${fn:length(list) }"/>
					<c:forEach items="${list }" var="vo" varStatus="status">
						<li>
							<table>
								<tr>
									<td>[${count - status.index }]</td>
									<td>${vo.name }</td>
									<td>${vo.regDate }</td>
									<td><a href="${pageContext.request.contextPath }/guestbook/deleteform/${vo.no }">삭제</a></td>
								</tr>
								<tr>
									<td colspan=4>${vo.message }</td>
								</tr>
							</table>
							<br>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2014 </p>
		</div>
	</div>
</body>
</html>