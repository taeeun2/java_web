<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
</head>
<body>
<h2>날짜 다루기</h2>
<h3>fmt:parseDate 태그</h3>
<code>
	&lt;fmt:parseDate var="date1" value="2021-09-03" pattern="yyyy-MM-dd"/>
</code>
<fmt:parseDate var = "date1" value="2021-09-03" pattern="yyyy-MM-dd"/>
<h3>fmt:formatDate 태그</h3>
<fmt:formatDate value="${date1}" pattern="MM/dd/yy"/>
</html>