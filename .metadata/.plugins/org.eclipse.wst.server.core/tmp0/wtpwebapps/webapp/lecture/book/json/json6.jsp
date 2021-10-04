<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
  <title>JSON �׽�Ʈ</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
    $(function() {
        $("#checkJson").click(function() {
    	$.ajax({
            type:"post",
            async:false, 
            url:"${contextPath}/json2",
            success:function (data,textStatus){
            	var jsonInfo = JSON.parse(data);
            	var memberInfo ="ȸ�� ����<br>";
	        memberInfo += "=======<br>";
	        for(var i in jsonInfo.members){
		   memberInfo += "�̸�: " + jsonInfo.members[i].name+"<br>";
		   memberInfo += "����: " + jsonInfo.members[i].age+"<br>";
		   memberInfo += "����: " + jsonInfo.members[i].gender+"<br>";
		   memberInfo += "����: " + jsonInfo.members[i].nickname+"<br><br><br>";
	        }
	        $("#output").html(memberInfo);
	       },
	      error:function(data,textStatus){
	         alert("������ �߻��߽��ϴ�.");��
	      },
	      complete:function(data,textStatus){
	      }
	   }); 
       });
    });
 </script>
</head>
<body>
   <a id="checkJson" style="cursor:pointer">ȸ�� ���� �����ϱ�</a><br><br>
    <div id="output"></div>