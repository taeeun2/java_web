<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type = "text/css">
	body{
		font-size : small;
		}
	table{
	border : thin soild gray;
	border-collapse : collapse;
	}
	
	th,td{
		border: thin dotted gray;
		padding : 2px;
	}
	th{
		background-color : lightgray;
		}
		
	pre{
		font-size:90%
	}
</style>
</head>
<body>
<p><a href = "Ex2.jsp">[����]</a></p>
<h2>EL - ���ͷ� ǥ����</h2>
<table>
	<tr><th>��������</th><th>EL�ڵ�</th><th>������</th></tr>
	<tr><td>���ڿ�</td><td>${"test"}</td><td>test</td></tr>
	<tr><td>���ڿ�</td><td>${'test'}</td><td>test</td></tr>
	<tr><td>����</td><td>${20}</td><td>20</td></tr>
	<tr><td>�ε� �Ҽ���</td><td>${3.14}</td><td>3.14</td></tr>
	<tr><td>�Ҹ�</td><td>${true}</td><td>true</td></tr>
	<tr><td>�ΰ�</td><td>${null}</td><td></td></tr>
	
</table>

</body>
</html>