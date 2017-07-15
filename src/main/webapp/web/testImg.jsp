<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="UTF-8">
	<style type="text/css">
	div{
		margin: 10px;
		padding: 10px;
	}
	div:nth-child(5){
		word-wrap: break-word;
		word-break: normal; 
	}
	#path{
		width: 400px;
		height: 50px;
	}
	</style>
	<script src="${pageContext.request.contextPath}/dist/bower_components/jquery/dist/jquery.min.js"></script>
	<title>image</title>
</head>
<body>
	<div>
		<input id="msgImg" type="file" accept="image/*">
	</div>
	<div>
		<input id="path" type="text" placeholder="路徑">
	</div>
	<div>
		<input id="submit" type="submit" value="傳送(post方法)">
	</div>
	<div>
		<img id="image">
	</div>
	<div id="info1"></div>
	<div id="info2"></div>
	
	<script type="text/javascript">
		var readImg;
		$('#msgImg').change(function(){
			readImg = new FileReader();
			readImg.readAsDataURL(this.files[0]);
			// 圖片讀取完畢再執行以下方法
			readImg.onload = function(){
				var image = document.getElementById('image');
				image.src = this.result;
			}
		});
		
		$('#submit').click(function(){
			var javaRoot = "${pageContext.servletContext.contextPath}";
			var path = $('#path').val();
			var xhr = new XMLHttpRequest();
			var servletPath = javaRoot + path;
			$('#info1').html("路徑 = " + servletPath + "<br>傳送資料 = " + readImg.result);
			$.ajax({
				type: 'post',
				url: servletPath,
				data: {
					msgImg : readImg.result
				},
				dataType: 'json',
				success: function(response){
					$('#info2').html("response = " + response);
				}
			});
		});
		
		
	</script>
</body>
</html>