<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type = "text/javascript">
	function fn_sendMember(){
		//alert("fn_sendMember()");
 		var frmMember = document.frmMember;
 		var id = frmMember.id.value.trim();
		var pwd = frmMember.pwd.value.trim();
		var name = frmMember.name.value.trim();
		var email = frmMember.email.value.trim();
		var post = frmMember.post.value.trim();
	//	document.getElementById("name").value = 'val';
		if(id.length == 0 || id == '')
			alert("���̵�� �ʼ��Դϴ�.");
		else if(pwd.length == 0 || pwd == '')
			alert("��й�ȣ�� �ʼ��Դϴ�.");
		else if(name.length == 0 || name == '')
			alert("�̸��� �ʼ��Դϴ�.");
		else if(email.length == 0 || email == '')
			alert("�̸����� �ʼ��Դϴ�.");
		else if(post.length == 0 || post == '')
			alert("������ȣ�� �ʼ��Դϴ�.");
		else{
			frmMember.method = "post";
			frmMember.action = "UserInfoAddServlet";
			frmMember.submit();
		}
 	}
	
	function idCheck(){
 		//var frmMember = document.frmMember;
		var id = frmMember.id.value;
		if(id.length == 0 || id == '')
			alert("���̵�� �ʼ��Դϴ�.");
		else{
			//�˾�â
			window.open('CheckIdServlet?id='+id, 'pop', 'width=300,height=300');//����° ���ڰ� �ϳ��� ���� ��
		}
	}
	
	function searchPost(){
		var post = frmMember.post.value;
		window.open('jspEx/Post.jsp', 'pop', 'width=500,height=500');//����° ���ڰ� �ϳ��� ���� ��
		
		
	}
	
	function searchPost(){
		var dong = frmMember.post.value.trim();
		console.log(dong.length+'->'+dong);
		if(dong.length == null || dong == '')
			alert("~���� �Է����ּ���");
		else{
			window.open('/webapp/PostServlet?dong='+dong,'pop','width=600,height=500');
		}
	
	}
</script>
<body>
<jsp:include page="../include/header.jsp"/>

<%--  <%@ include file = "../include/header.jsp" %>	--%> 
 <form name = "frmMember">
	<table>
		<th> ȸ�� ����â</th>
		<tr>
			<td>���̵�</td>
			<td><input type = "text" name = "id">
<!-- 				<input type = "button" value = "���̵� �ߺ�üũ" onclick = "location.href = '/webapp/jspEx/CheckId.jsp?id =12'">
-->			<input type = "button" value = "���̵� �ߺ�üũ" onclick = "idCheck()"></td>
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
			<td>������ȣ</td>
			<td><input type = "text" name = "post">
			<input type = "button" value = "������ȣ �˻�", onclick = "searchPost()">
			</td>
		</tr>
		
	</table>
	<input type = "button" value = "�����ϱ�" onclick = "fn_sendMember()">
	<input type = "reset" value = "�ٽ��Է�">
	<input type = "hidden" name = "command" value = "addMember">
	</form>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>