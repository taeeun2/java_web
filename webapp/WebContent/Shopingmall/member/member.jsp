<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="member.js" charset="utf-8"></script>
</head>

<body>
<jsp:include page="../include/Header.jsp"/>
<%-- <% include file = "sub_menu.html"; %> --%>
<form name = "formm">
	<table>
			<th> ȸ�� ����â</th>
			<tr>
				<td>���̵�</td>
				<td><input type = "text" name = "id">
				<input type = "button" value = "���̵� �ߺ�üũ" onclick = "idCheck()"></td>
				</td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>�̸���</td>
				<td><input type = "text" name = "email"></td>
			</tr>
			<!-- �߰� -->
			<tr>
				<td>�����ȣ</td>
				<td><input type = "text" name = "post">
				<input type = "button" value = "�����ȣ �˻�", onclick = "searchPost2()">
				</td>
			</tr>
			<tr>
				<td>�ּ�</td>
				<td><input type = "text" name = "address"></td>
				
			</tr>
			<tr>
				<td>�޴��� ��ȣ</td>
				<td><input type = "text" name = "phone"></td>
			</tr>
			
	</table>
	<input type = "button" value = "�����ϱ�" onclick = "go_save()">
	<input type = "reset" value = "�ٽ��Է�">
	<input type = "hidden" name = "command" value = "addMember">
	</form>

</body>
</html>