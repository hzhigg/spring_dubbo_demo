<%@page import="com.ssm.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
function ajaxTest(){
	  $.ajax({
             type: "post",
             url: "../user/testAjax",
             data: {'userName':"Alan"},
             dataType: "json",
             success: function(data){
                   console.log(data.code);    
             }
       });
}
</script>
<title>Insert title here</title>
</head>
<body>
1 <br/><button value="发送请求" onclick="ajaxTest();">发送请求</button>
${users.age }
 <c:out value="${requestScope.users.userName }"></c:out> 
</body>
</html>