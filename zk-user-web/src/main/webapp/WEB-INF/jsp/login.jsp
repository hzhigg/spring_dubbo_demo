<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" id="test" value="123"/>
	<button onclick="loing();">登入页面</button>
</body>
<!-- <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> -->
<script type="text/javascript" src="http://www.w3school.com.cn/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function loing(){

	  $.ajax({
             type: "get",
             url: "../user/login",
             dataType: "json",
             success: function(data){
                   console.log(data.code);    
             }
       });
}
</script>
</html>