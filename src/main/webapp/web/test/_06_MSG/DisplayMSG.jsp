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
<script type="text/javascript">
function readMSG(n) {
	
		document.forms[0].action="<c:url value='/web/_06_MSG/controller/ChangeMSGstatus.do?key=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
}
function loadMSG(n) {
	
	document.forms[0].action="<c:url value='/web/_06_MSG/controller/FindMSGByRoomNo.do?key=" + n +"' />" ;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
</script>
<body>
	<header>
		<jsp:include page="../../../fragment/header.jsp" />
	</header>

	<section>
		<jsp:include page="../top.jsp" />
		<h1>訊息查詢 ${fn:toLowerCase(LoginOK.indid)}</h1>

		<c:if test="${!empty MSGROOM_DATA}">
			<table border='1'>
				<tr height='18' bgColor="${rowColor}">
					<td>聊天室名稱</td>
					<td>訊息/圖片</td>
					<td>時間</td>
					<td>查看</td>
				</tr>
				<c:forEach varStatus="stVar" var="MSG" items="${MSGROOM_DATA}">
					<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
					<c:set var="rowColor" value="#DEFADE" />
					<c:if test="${ stVar.count % 2 == 0 }">
						<c:set var="rowColor" value="#FFEBFF" />
					</c:if>
					<tr height='18' bgColor="${rowColor}">
						<td><c:if test="${MSG.MSGENDID == fn:toLowerCase(LoginOK.indid)}">${MSG.MSGSOURCEID}</c:if>
							<c:if test="${MSG.MSGENDID != fn:toLowerCase(LoginOK.indid)}">${MSG.MSGENDID}</c:if>
						</td>
						<td>${MSG.MSGTEXT}<c:if test="${!empty MSG.MSGFILENAME}">
								<img height='40px' width='30px'
									src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${MSG.MSGNO}&type=MSG' />
							</c:if>
						</td>
						<td>${MSG.POSTDATE}</td>
						<td><c:choose>
								<c:when
									test="${(MSG.MSGSTATUS == 2) && (MSG.MSGENDID == fn:toLowerCase(LoginOK.indid))}">
									<Input type="button" name="read" value="已讀"
										onClick="readMSG(${MSG.ROOMNO})">
								</c:when>
								<c:otherwise>
									<Input type="button" name="read" value="查看"
										onClick="loadMSG(${MSG.ROOMNO})">
								</c:otherwise>
							</c:choose></td>
					</tr>

				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty MSGROOM_DATA}">
			<h1>你沒有訊息</h1>
		</c:if>

		<form>
			<input type="hidden" name="a" />
		</form>
	</section>

	<footer>
		<jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>