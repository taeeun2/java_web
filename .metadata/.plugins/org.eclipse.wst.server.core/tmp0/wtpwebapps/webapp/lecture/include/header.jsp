<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "dto.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%-- <jsp:useBean id = "userinfo" scope = "session" class = "dto.UserInfo"/> --%>
<%	UserInfo userinfo = (UserInfo)session.getAttribute("userinfo"); %>
<body>
<div style="background-color:#00008b;
	color:white; height:20px; padding : 5px;">
	UserInfoSystem Header Page
	<%	if(userinfo!=null && userinfo.getId() !=null){%>
		<span style="float:right;"><%--오른쪽 정렬--%>
		<%=userinfo.getName() %>
		<a style="color:white;" href = "UserInfoLogOutServlet">로그아웃</a>
	<%} else{
			response.sendRedirect("/webapp/auth/LogInForm.jsp");
		
	%>
	
	<% } %>
</div>

</body>
</html>