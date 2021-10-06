<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "../include/Header.jsp"/>
<form action = "../../NonageServlet?command=login" method = "post">
아이디 : <input type = "text" name = "id">
비밀번호 : <input type = "text" name = "pwd">

<input type = "submit" value = "로그인">
<input type = "button" value = "회원가입" >
</form>
</body>
</html>