<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
</head>
<body>
<p><a href = "Ex3.jsp">[이전]</a><a href = "Ex5.jsp">[다음]</a></p>
<h2>c:out 태그</h2>
1) <c:out value = "안녕하세요!"/></br>
2) <c:out value = "${null}">반갑습니다.</c:out><br>
3) <c:out value = "안녕하세요!">반갑습니다.</c:out><br>
4) <c:out value = "${null}"/><br>


</body>
</html>