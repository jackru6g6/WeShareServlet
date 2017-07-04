<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="utf-8">
<jsp:include page="../../../fragment/refCss.jsp" />
<jsp:include page="../../../fragment/refJs.jsp" />
<title>WeShare 微分享</title>
</head>
<body>
	<header>
		<jsp:include page="../../../fragment/header.jsp" />
	</header>

	<section>
		<jsp:include page="../top.jsp" />
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
	</section>

	<footer>
		<jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>