<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ page isELIgnored="false" %><!-- el����ȵɶ� -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ȸ�� ���</h1>
<p><a href="list.do">�ű� ȸ��</a></p>
<c:forEach var="member" items="${members}">
${member.no},
<%-- <a href = 'update.do?no=${member.no}'>${member.name }</a>
${member.email},
${member.createdDate}
<a href='delete.do?no=${member.no}'>[����]</a><br> --%>
</c:forEach>
</body>
</html>