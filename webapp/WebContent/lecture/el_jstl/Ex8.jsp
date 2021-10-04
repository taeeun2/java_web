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
<h2>c:choose 태그</h2>
<c:set var="userid" value = "admin"/>
<c:choose>
	<c:when test = "${userid == 'hong'}">
		홍길동님 반갑습니다.
	</c:when>
	<c:when test = "${userid == 'leem' }">
		임꺽정님 반갑습니다.
	</c:when>
	<c:when test = "${userid == 'admin' }">
		관리자 전용 페이지입니다.
	</c:when>
	<c:otherwise>
		등록되지 않은 사용자입니다.
	</c:otherwise>
</c:choose>
</body>
</html>