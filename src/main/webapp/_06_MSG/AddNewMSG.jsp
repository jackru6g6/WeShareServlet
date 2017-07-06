<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!-- DECLARE JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>新增訊息</h1>
	<form ENCTYPE="multipart/form-data" method="POST"
		action="<c:url value='/web/_06_MSG/controller/AddNewMSG.do' />">
		<table border="1" bordercolor="#f00">

			<tr>
				<td>*收信者:</td>
				<td><input type="text" name="MSGENDID" placeholder="收信者"
					value="${param.MSGENDID}"><font color="red" size="-1">${MsgMap.errorMSGENDID}</font></td>

			</tr>
			<tr>
				<td>*訊息內容:</td>
				<td><input type="text" name="MSGTEXT" placeholder="訊息內容"
					value="${param.MSGTEXT}"><font color="red" size="-1">${MsgMap.errorMSGTEXT}</font></td>

			</tr>
			<tr>
				<td>訊息圖片:</td>
				<td><input Type="file" name="MSGIMAGE"></td>
			</tr>
		</table>
		<input type="submit" id="submit" value="送出"><font color="red"
			size="-1">${MsgMap.errorAns}</font>
	</form>
</body>
</html>