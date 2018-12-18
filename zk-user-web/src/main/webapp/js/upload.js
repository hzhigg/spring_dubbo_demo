function ajaxFileUpload(){  
//执行上传文件操作的函数
     $.ajaxFileUpload({
         //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
         url:'uploadfile/fileUpload?uname=黄智',
         secureuri:false,                           //是否启用安全提交,默认为false 
         fileElementId:"myfiles",               //文件选择框的id属性
         dataType:'text',                           //服务器返回的格式,可以是json或xml等
         success:function(data, status){            //服务器响应成功时的处理函数
            alert("成功");
         },
         error:function(data, status, e){ //服务器响应失败时的处理函数
             $('#result').html('图片上传失败，请重试！！');
         }                                                       
     });
}


function downExcel(){
	window.open("uploadfile/importexcel");
}

$(function(){
	$(".test").on("change",function(event,data){
		alert(1);
	});
});

