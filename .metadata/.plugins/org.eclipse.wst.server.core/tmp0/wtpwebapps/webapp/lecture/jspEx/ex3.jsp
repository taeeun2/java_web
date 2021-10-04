<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>HTML Layouts</title>
	
	<style>
		header {
			background-color:lightgrey;
			height:100px;
		}
		nav {
			background-color:#339999;
			
			color:white;
			width:200px;
			height:300px;
			float:left; 
		}
		section {
			/* width:200px;
			text-align:left;
			float:left;
			padding:10px; */
		}
		footer {
			background-color:#FFCC00;
			height:100px;
			clear:both;
		}
		table{
			margin-top : 20px;
			
		}
		header, nav, section, footer { text-align:center; }
		header, footer { line-height:100px; }
/* 		nav, section { line-height:240px; }
 */	</style>

</head>
<body>


<header>
HEADER 영역
</header>
<nav>
	<form action="/webapp/UserInfoLoginServlet" method="post">
			<table>
			<tr>
				<th colspan = "2"> Log-in</th>
			<tr>
				<th>id</th> 
				<td> 
				<input type = "text" name = "id"></td>
			<tr>
				<th>pw</th>
				<td><input type = "password" name = "pw" ></td>
			<tr>
				<td colspan = "2">
				<input type = "submit" value = "로그인">
				<input type = 'button' value = '회원가입' onclick = 'location.href = "/webapp/UserInfoAddServlet"'>
				</td>
			</table>
	</form>
</nav>
<section>
SECTION 영역
</section>
<footer>
FOOTER 영역
</footer>
</body>
</html>