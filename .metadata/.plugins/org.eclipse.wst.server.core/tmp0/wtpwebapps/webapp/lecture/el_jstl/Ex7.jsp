<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
</head>

<h2>c:if 태그</h2>
<c:if test = "${10>20 }" var = "result1">
	1) 10은 20보다 크다.<br>
</c:if>
2)${result1}<br>
<c:if test="${10<20 }" var = "result2">
	3) 10은 20보다 작다.<br>
</c:if>
4)${result2}<br>

<body>
</body>
</html>