<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import = "java.util.*, dto.UserInfo" %>
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

<body>
<h2>EL - �� ������</h2>
<%	// ������ �غ�
	pageContext.setAttribute("scores", new int[]{90,80,70,100});
	List<String> nameList = new LinkedList<String>();
	nameList.add("ȫ�浿");
	nameList.add("�Ӳ���");
	nameList.add("������");
	pageContext.setAttribute("nameList",nameList);
	Map<String,String> map = new HashMap<String,String>();
	map.put("s01", "ȫ�浿");
	map.put("s02", "�Ӳ���");
	map.put("s03", "������");
	pageContext.setAttribute("map", map);
	pageContext.setAttribute("userinfo", new UserInfo()
			.setId("abc").setPw("123").setName("ȫ�浿"));
%>
<table>
	<tr><th>���</th><th>EL �ڵ�</th><th>����</th></tr>
	<tr>
	<td>�迭</td><td>\${myArray[2]}</td><td>�迭���� �ش� �ε����� ���� ������.<br>
	<pre>
	[�ڹ��ڵ�]
	pageContext.setAttribute("scores", new int[]{90,80,70,100});
	
	[���� ���]
	\${scores[2]} = ${scores[2]}
	
	[JSTL]
	<% int[] scoreList = (int[])pageContext.getAttribute("scores"); %><%= "scores[2] = " + scoreList[2] %>
	</pre>
	</td></tr>
	
	<tr><td>����Ʈ</td><td>\${myList[1]}</td><td>List ��ü���� �ε����� ������ �׸��� ���� ������.<br>
	<pre>
	[�ڹ��ڵ�]
	List<String> nameList = new LinkedList<String>();
	nameList.add("ȫ�浿");
	nameList.add("�Ӳ���");
	nameList.add("������");
	pageContext.setAttribute("nameList",nameList);
	
	[���� ���]
	\${nameList[1]} = ${nameList[1]}	</pre>
	</td></tr>
	
	<tr><td>��</td><td>\${myMap.keyName}</td><td>Map ��ü���� Ű�� �ش��ϴ� ���� ������.<br>
	<pre>
	[�ڹ��ڵ�]
	Map<String,String> map = new HashMap<String,String>();
	map.put("s01", "ȫ�浿");
	map.put("s02", "�Ӳ���");
	map.put("s03", "������");
	pageContext.setAttribute("map", map);
	
	[���� ���]
	\${map.s02} = ${map.s02}	</pre>
	</td></tr>
	
	<tr><td>��Bean</td><td>\${myObj.propName}</td><td>�ڹ� ��ü���� ������Ƽ�� ���� ������.(getter �޼��带 ȣ���Ѵ�)<br>
	<pre>
	[�ڹ��ڵ�]
	pageContext.setAttribute("userinfo", new UserInfo()
			.setId("abc").setPw("123").setName("ȫ�浿"));
	
	[���� ���]
	\${userinfo.getId()} = ${userinfo.getId()}	</pre>
	</td></tr>
</table>

<p><a href="Ex1.jsp">[����]</a><a href="Ex3.jsp">[����]</a></p>
</body>

</html>