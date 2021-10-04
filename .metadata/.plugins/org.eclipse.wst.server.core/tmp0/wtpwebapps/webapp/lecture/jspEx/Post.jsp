<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "dto.AddressVo, java.util.*" %>
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
<script type = "text/javascript">
	function searchPost(){
			var form = document.form;
			var dong = form.dong.value.trim();
			
			if(dong.length == null || dong == '')
				alert("~���� �Է����ּ���");
			else{
				form.method = "post";
				form.action = '../../PostServlet?dong='+encodeURI(dong);
				form.submit();
			}
		}
</script>
<body>
	<h1>�����ȣ �˻�</h1>
	<form name = "form">
	 	�� �̸� : <input type = "text" name = "dong"/>
	 	<input type = "button" value = "ã��" onclick = "searchPost()"/>
	</form>
	<table id = "zipcode">
		<tr>
			<th>�����ȣ</th>
			<th>�ּ�</th>
		</tr>
		<% 
			@SuppressWarnings("unchecked")
			ArrayList<AddressVo> list = (ArrayList<AddressVo>)request.getAttribute("addressList");
			if(list == null) return;
		%>
		<% for(AddressVo  data : list){ %>
			<tr>
				<td><%= data.getZipCode() %></td>
				<td><a href = "#" ><%= data.getZipCode() %></a>
				<%= data.getSido() %>', '<%= data.getGugun() %>', '<%= data.getDong() %>
				</td>	
			</tr>	
		<%} %>	
	</table>
</body>
</html>
