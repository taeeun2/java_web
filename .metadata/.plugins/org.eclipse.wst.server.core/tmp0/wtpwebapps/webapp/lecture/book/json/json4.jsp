<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON �׽�Ʈ</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	 $("#checkJson").click(function() {	      
	    var jsonStr = '{"members":[{"name":"������","age":"25","gender":"����","nickname":"��������"}'
	    	           +', {"name":"�����","age":"30","gender":"����","nickname":"��ũ"}] }';
	    var jsonInfo = JSON.parse(jsonStr);
	    var output ="ȸ�� ����<br>";
	    output += "=======<br>";
	    for(var i in jsonInfo.members){
               output += "�̸�: " + jsonInfo.members[i].name+"<br>";
	       output += "����: " + jsonInfo.members[i].age+"<br>";
	       output += "����: " + jsonInfo.members[i].gender+"<br>";
	       output += "����: " +jsonInfo.members[i].nickname+"<br><br><br>";
	    }
	    $("#output").html(output);
	 });
     });
</script>
</head>
<body>
    <a id="checkJson" style="cursor:pointer">���</a><br><br>
    <div id="output"></div>
</body>
</html>