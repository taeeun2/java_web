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
			<th> 회원 가입창</th>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "id">
				<input type = "button" value = "아이디 중복체크" onclick = "idCheck()"></td>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "text" name = "email"></td>
			</tr>
			<!-- 추가 -->
			<tr>
				<td>우편번호</td>
				<td><input type = "text" name = "post">
				<input type = "button" value = "우편번호 검색", onclick = "searchPost2()">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type = "text" name = "address"></td>
				
			</tr>
			<tr>
				<td>휴대폰 번호</td>
				<td><input type = "text" name = "phone"></td>
			</tr>
			
	</table>
	<input type = "button" value = "가입하기" onclick = "go_save()">
	<input type = "reset" value = "다시입력">
	<input type = "hidden" name = "command" value = "addMember">
	</form>

</body>
</html>