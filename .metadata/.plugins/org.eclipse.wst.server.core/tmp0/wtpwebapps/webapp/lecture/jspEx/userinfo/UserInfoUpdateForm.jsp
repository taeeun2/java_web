<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "dto.UserInfo"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%-- <% UserInfo userinfo = (UserInfo)request.getAttribute("userinfo"); %> --%>
<c:set var = "userinfo" value = "${requestScope.userinfo}"></c:set>
<body>
	<jsp:include page="../../include/header.jsp"/>
	<form action="UserInfoUpdateServlet" method = "post">
	<table border = "0">
	<tr>
		<th>���̵�</th>
<%-- 		<td><input type = "text" name = "id" value = "<%=userinfo.getId()%>"readonly/></td>
 --%>		<td><input type = "text" name = "id" value = "${userinfo.getId()}"readonly/></td>
 
 	</tr>
	<tr>	
		<th>��й�ȣ</th>
 		<td><input type = "text" name = "pw" value = "${userinfo.getPw()}"/></td>
 
 	</tr>
	<tr>	
		<th>�̸�</th>
		<td><input type = "text" name = "name" value = "${userinfo.getName()}"/></td>
	</tr>
	<tr>	
		<th><input type = "submit" value = "ȸ�� ����"/></th>
		<th><input type = "button" value = "����"
				onclick = 'location.href="UserInfoDeleteServlet?id=${userinfo.getId()}";'>
			<input type = "button" value = "���" onclick = 'location.href="/webapp/UserInfoListServlet"'></th>
			
	</tr>
	</table>
	</form>
	<jsp:include page="../../include/footer.jsp"/>
</body>
</html>