<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action = "/webapp/FileUpload.do" method = "post" enctype = "multipart/form-data">
	����1 : <input type = "file" name = "file1"><br>
	����2 : <input type = "file" name = "file2"><br>
	�Ű�����1 : <input type = "text" name = "param1"><br>
	�Ű�����2 : <input type = "text" name = "param2"><br>
	�Ű�����3 : <input type = "text" name = "param3"><br>	
	<input type = "submit" value = "���ε�">
</form>
</body>
</html>