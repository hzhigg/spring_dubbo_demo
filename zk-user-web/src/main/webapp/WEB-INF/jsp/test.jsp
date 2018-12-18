<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/upload.js"></script>
<title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data" method="POST">
	<input type="file" id="excelFile" name="excelFile" class="test"/>
	<!-- <button type="submit">提交(读取excel数据)</button> -->
	<input type="button" value="上传文件(上传单个文件)" />
</form>

<div>
 <form  enctype="multipart/form-data" method="POST">
	<input type="file" id="myfiles" name="myfiles" class="test"/>
	<input type="button" value="上传文件(上传单个文件)"/>
 </form>	 
</div>

<!-- <div>
	<form action="uploadfile/springUpload" enctype="multipart/form-data" method="POST">
		<input type="file" id="myfiles2" name="myfiles2"/>
		<input type="file" id="myfiles" name="myfiles"/>
		<button type="submit">提交(上传多个文件)</button>
	</form>
</div>

<div>
	<button type="button" onclick="downExcel();">下载</button>
</div> -->
</body>
</html>