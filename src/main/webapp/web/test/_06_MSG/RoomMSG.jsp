<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../../fragment/refCss.jsp" />
<jsp:include page="../../../fragment/refJs.jsp" />
<title>WeShare 微分享</title>
</head>


<script type="text/javascript">
	function checkText() {
		var x = document.getElementById("input1").value;
		if (x.length != 0) {
			document.getElementById("submit").disabled = false;
		} else {
			document.getElementById("submit").disabled = true;
		}
	}
</script>



<body>
	<header>
		<jsp:include page="../../../fragment/header.jsp" />
	</header>

	<section>
		<jsp:include page="../top.jsp" />
		<h1>聊天室</h1>
		<a href="<c:url value='/web/_06_MSG/controller/FindMSGByKey.do' />">回上一頁</a>
		<c:if test="${!empty ROOMNO_DATA}">
			<table border='1'>
				<tr height='18' bgColor="${rowColor}">
					<td>A姓名</td>
					<td>A訊息/圖片</td>
					<td>B訊息/圖片</td>
					<td>B姓名</td>
					<td>發送時間</td>
				</tr>
				<c:forEach varStatus="stVar" var="MSG" items="${ROOMNO_DATA}">
					<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
					<c:set var="rowColor" value="#DEFADE" />
					<c:if test="${ stVar.count % 2 == 0 }">
						<c:set var="rowColor" value="#FFEBFF" />
					</c:if>
					<tr height='18' bgColor="${rowColor}">
						<c:choose>
							<c:when test="${MSG.MSGENDID == fn:toLowerCase(LoginOK.indid)}">
								<td>${fn:toLowerCase(MSG.MSGSOURCEID)}<c:set var="to"
										scope="session" value="${fn:toLowerCase(MSG.MSGSOURCEID)}" />
								</td>
								<td>${MSG.MSGTEXT}<c:if test="${!empty MSG.MSGFILENAME}">
										<img height='40px' width='30px'
											src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${MSG.MSGNO}&type=MSG' />
									</c:if>
								</td>
								<td></td>
								<td></td>
								<td>${MSG.POSTDATE}</td>
							</c:when>
							<c:otherwise>
								<td></td>
								<td></td>
								<td>${MSG.MSGTEXT}<c:if test="${!empty MSG.MSGFILENAME}">
										<img height='40px' width='30px'
											src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${MSG.MSGNO}&type=MSG' />
									</c:if>
								</td>
								<td>${fn:toLowerCase(MSG.MSGSOURCEID)}</td>
								<td>${MSG.POSTDATE}</td>
							</c:otherwise>
						</c:choose>
					</tr>

				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty ROOMNO_DATA}">
			<h1>你沒有訊息</h1>
		</c:if>
		<form ENCTYPE="multipart/form-data" method="POST"
			action="<c:url value='/web/_06_MSG/controller/AddNewMSG.do?key=${ROOMKEY}&to=${to}' />">
			<table border="1" bordercolor="#f00">

				<tr>
					<td><input id="input1" type="text" name="MSGTEXT"
						placeholder="訊息內容" value="${param.MSGTEXT}" oninput="checkText()"></td>
					</td>
					<td><input Type="file" name="MSGIMAGE"></td>
				</tr>

			</table>
			<input type="submit" id="submit" value="送出" disabled>
		</form>

		<form>
			<input type="hidden" name="a" />
		</form>
	</section>

	<footer>
		<jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>