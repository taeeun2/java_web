<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>EL(Expression Language)</title>

<style type="text/css">
body{
	font-size: small;
}
table{
	border: thin solid gray;
	border-collapse: collapse;
}
td, th{
	border: thin dotted gray;
	padding: 10px;
}
th{
	background-color: lightgray;
}
pre{
	font-size: 90%;
}
</style>	
	
</head>
<% pageContext.setAttribute("title", "EL연산자!"); %>
<body>
<h2>연산자</h2>

<table>
	<tr><th>분류</th><th>연산자</th><th>EL 코드 = 실행 결과</th></tr>
	<tr><td>산술</td><td>+, -, *, /(div), %(mod)</td>
	<td>
	<pre>
\${10 + 20} = ${10 + 20}
\${10 - 20} = ${10 - 20}
\${10 * 20} = ${10 * 20}
\${10 / 20} = ${10 / 20}
\${10 % 20} = ${10 % 20}
\${10 mod 20} = ${10 mod 20}
	</pre>
	</td></tr>
	
	<tr><td>관계</td><td>==(eq), !=(ne), &lt;(lt), &gt;(gt), &lt;=(le), &gt;=(ge)</td>
	<td>
	<pre>
\${10 == 11} = ${10 == 11}
\${10 eq 11} = ${10 eq 11}
\${10 != 11} = ${10 != 11}
\${10 < 11}  = ${10 < 11}
\${10 lt 11} = ${10 lt 11}
\${10 > 11}  = ${10 > 11}
\${10 gt 11} = ${10 gt 11}
\${10 <= 11} = ${10 <= 11}
\${10 le 11} = ${10 le 11}
\${10 >= 11} = ${10 >= 11}
\${10 ge 11} = ${10 ge 11}
	</pre>
	</td></tr>
	
	<tr><td>Empty 검사</td><td>empty</td>
	<td>
	<pre>
\${empty title} = ${empty title}
\${empty title2} = ${empty title2}
	</pre>
	</td></tr>
	
</table>

<p><a href="Ex2.jsp">[이전]</a><a href="Ex4.jsp">[다음]</a></p>
</body>

</html>