<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!-- DECLARE JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>新增訂單${ LoginOK.indid }</h1>
	<form ENCTYPE="multipart/form-data" method="POST"
		action="<c:url value='/web/_05_deal/controller/InsertDEAL.do' />">
		<br>物資編號:<input type="text" name="GOODSNO" placeholder="物資編號"
			value="${param.GOODSNO}"><font color="red" size="-1">${MsgMap.errorGOODSNO}</font>
		<br>需求數量:<input type="text" name="DEALQTY" placeholder="物資數量"
			value="${param.DEALQTY}"><font color="red" size="-1">${MsgMap.errorDEALQTY}</font>
		<br>交易備註:<input type="text" name="DEALNOTE" placeholder="備註"
			value="${param.DEALNOTE}"><font color="red" size="-1">${MsgMap.errorDEALNOTE}</font>
		<br>交易方式: <label><input type="radio" name="GOODSTYPE"
			value="0" checked>面交</label> <label><input type="radio"
			name="GOODSTYPE" value="1">宅配</label> <br>
		<input type="submit" value="送出"> <font color="red" size="-1">${MsgMap.errorans}</font>
	</form>
</body>
</html>