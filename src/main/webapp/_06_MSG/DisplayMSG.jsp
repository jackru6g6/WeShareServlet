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
<script type="text/javascript">
function readMSG(n) {
	
		document.forms[0].action="<c:url value='/web/_06_MSG/controller/ChangeMSGstatus.do?key=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
}
</script>
<body>
<jsp:include page="/top.jsp" />
	<h1>訊息查詢</h1>
	<c:if test="${!empty MSG_DATA}">
		<table border='1'>
			<tr height='18' bgColor="${rowColor}">
				<td>訊息編號</td>
				<td>訊息狀態</td>
				<td>訊息時間</td>
				<td>發信者</td>
				<td>收信者</td>
				<td>訊息內容</td>
				<td>圖片</td>
				<td>圖片檔名</td>
				<td>按鈕</td>
			</tr>
			<c:forEach varStatus="stVar" var="MSG" items="${MSG_DATA}">
				<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
				<c:set var="rowColor" value="#DEFADE" />
				<c:if test="${ stVar.count % 2 == 0 }">
					<c:set var="rowColor" value="#FFEBFF" />
				</c:if>
				<tr height='18' bgColor="${rowColor}">
					<td>${MSG.MSGNO}</td>
					<td>${MSG.MSGSTATUS}</td>
					<td>${MSG.POSTDATE}</td>
					<td>${MSG.MSGSOURCEID}</td>
					<td>${MSG.MSGENDID}</td>
					<td>${MSG.MSGTEXT}</td>
					<td><img height='40px' width='30px'
						src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${MSG.MSGNO}&type=MSG' />
					</td>
					<td>${MSG.MSGFILENAME}</td>
					<c:if test="${MSG.MSGSTATUS==2}">
						<td><Input type="button" name="read" value="已讀"
							onClick="readMSG(${MSG.MSGNO})"></td>
					</c:if>
				</tr>

			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty MSG_DATA}">
		<h1>你沒有訊息</h1>
	</c:if>

	<form>
		<input type="hidden" name="a" />
	</form>
</body>
</html>