<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>c:remove 태그</h2>
<h3>보관소에 저장된 값 제거</h3>
<% pageContext.setAttribute("username1","홍길동"); %>
1) ${username1}<br>
<c:remove var = "username1"/>
2) ${username1}<br>

</body>
</html>