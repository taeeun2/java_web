<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "dto.UserInfo,java.util.*"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
	table{
	width : 100%;
	border-collapse : collapse;
	text-align : center;
	margin-top : 20px;
	margin-bottom : 20px;
	}
	th, td{
		padding: 10px;
		border: 1px solid #444444;
	}
	.title{
		 align : center;
		 background-color : slateblue;
		 color : white;
		 border-bottom : double black;
		 
	}
	th{
		background-color : ivory;
	}
</style>
</head>
<body>
<jsp:include page = "../../include/header.jsp"/>
<h1>ȸ�����</h1>
		<p><a href='UserInfoAddServlet'>�ű� ȸ��</a></p>
		<table id = "zipcode">
		<tr>
			<th>���̵�</th>
			<th>��й�ȣ</th>
			<th>�̸�</th>
			<th>����</th>	
		</tr>
		<%-- <% 
		List<UserInfo> userInfos = 
			(ArrayList<UserInfo>)request.getAttribute("userinfos");
		
		for(UserInfo userInfo : userInfos){
		%>	<tr>
			<td><a href = 'UserInfoUpdateServlet?id=<%=userInfo.getId() %>'><%=userInfo.getId() %></a></td>
			<td>
			<%=userInfo.getPw() %>
			</td>
			<td>
			<%=userInfo.getName() %>
			</td>
			<td>
			<a href = 'UserInfoDeleteServlet?id=<%=userInfo.getId() %>'>[����]</a>
			</td>
			</tr>
					
	<% 	}%> --%>
	
		<c:set var = "userinfos" value = "${requestScope.userinfos}"></c:set>
		<c:forEach var = "userinfo"  items =  "${userinfos}">
			<tr>
			<td><a href = 'UserInfoUpdateServlet?id=${userinfo.id}'>${userinfo.id}</a></td>
			<td>${userinfo.pw}</td>
			<td>${userinfo.name}</td>
			<td><a href = 'UserInfoDeleteServlet?id=${userinfo.id}'>[����]</a></td>
		</c:forEach>
	
	</table>
		
<jsp:include page="../../include/footer.jsp"/>
<hr>
</body>
</html>