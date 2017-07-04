<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
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
	</section>

	<footer>
		<jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>