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
<script type="text/javascript">
	function CancelDEAL(n) {
		document.forms[0].action = "<c:url value='/web/_05_deal/controller/CancelByKey.do?key=" + n +"' />" ;
		document.forms[0].method = "POST";
		document.forms[0].submit();
	}
	function OKDEAL(n,index) {
		var x = "shipno" + index;
		var shipno = document.getElementById(x).value;
		alert("n="+n+"index="+index+"shipno="+shipno);
		document.forms[0].action = "<c:url value='/web/_05_deal/controller/SubmitByKey.do?key=" + n +"&shipno="+shipno+"' />" ;
		document.forms[0].method = "POST";
		document.forms[0].submit();
	}
</script>
<body>
	<header> <jsp:include page="../../../fragment/header.jsp" />
	</header>

	<section> <jsp:include page="../top.jsp" />
	<h1>訂單查詢${ LoginOK.indid }</h1>
	<c:if test="${!empty DEALEND_DATA}">
		<h3>訂單(接受者)</h3>
		<table border='1'>
			<tr height='18' bgColor="${rowColor}">
				<td>交易編號</td>
				<td>下單時間</td>
				<td>物資類別</td>
				<td>物資名稱</td>
				<td>物資備註(提供者)</td>
				<td>數量(接受者)</td>
				<td>交易備註(接受者)</td>
				<td>配送方式(0面交1物流)</td>

				<td>提供者</td>
				<td>訂單狀態(0處理1送出2取消)</td>
				<td>物流編號(可有可無)</td>
				<td>提供者處理時間</td>

			</tr>
			<c:forEach varStatus="stVar" var="DEALEND" items="${DEALEND_DATA}">
				<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
				<c:set var="rowColor" value="#DEFADE" />
				<c:if test="${ stVar.count % 2 == 0 }">
					<c:set var="rowColor" value="#FFEBFF" />
				</c:if>
				<tr height='18' bgColor="${rowColor}">
					<td>${DEALEND.DEALNO}</td>
					<td>${DEALEND.POSTDATE}</td>
					<td>${DEALEND.GOODSTYPES}</td>
					<td>${DEALEND.GOODSNAME}</td>
					<td>${DEALEND.GOODSNOTE}</td>
					<td>${DEALEND.DEALQTY}</td>
					<td>${DEALEND.DEALNOTE}</td>
					<td><c:choose>
							<c:when test="${DEALEND.ENDSHIPWAY==0}">
								面交
							</c:when>
							<c:when test="${DEALEND.ENDSHIPWAY==1}">
								物流
							</c:when>
						</c:choose></td>
					<td>${DEALEND.SOURCEID}</td>
					<td><c:choose>
							<c:when test="${DEALEND.DEALSTATUS==0}">
								處理中
							</c:when>
							<c:when test="${DEALEND.DEALSTATUS==1}">
								已送出
							</c:when>
							<c:when test="${DEALEND.DEALSTATUS==2}">
								取消
							</c:when>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${empty DEALEND.SHIPNO}">
							</c:when>
							<c:otherwise>
							${DEALEND.SHIPNO}
							</c:otherwise>
						</c:choose>
					<td>${DEALEND.SHIPDATE}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if> <c:if test="${empty DEALEND_DATA}">
		<h1>你沒有任何訂單(接受者)</h1>
	</c:if> <c:if test="${!empty DEALSOURCE_DATA}">
		<h3>訂單(提供者)</h3>
		<table border='1'>
			<tr height='18' bgColor="${rowColor}">
				<td>交易編號</td>
				<td>下單時間</td>
				<td>物資類別</td>
				<td>物資名稱</td>
				<td>物資備註(提供者)</td>
				<td>接受者</td>
				<td>數量(接受者)</td>
				<td>交易備註(接受者)</td>
				<td>配送方式(0面交1物流)</td>
				<td>訂單狀態(0處理1送出2取消)</td>
				<td>物流編號(可有可無)</td>
				<td>提供者處理時間</td>

			</tr>
			<c:forEach varStatus="stVar" var="DEALSOURCE"
				items="${DEALSOURCE_DATA}">
				<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
				<c:set var="rowColor" value="#DEFADE" />
				<c:if test="${ stVar.count % 2 == 0 }">
					<c:set var="rowColor" value="#FFEBFF" />
				</c:if>
				<tr height='18' bgColor="${rowColor}">
					<td>${DEALSOURCE.DEALNO}</td>
					<td>${DEALSOURCE.POSTDATE}</td>
					<td>${DEALSOURCE.GOODSTYPES}</td>
					<td>${DEALSOURCE.GOODSNAME}</td>
					<td>${DEALSOURCE.GOODSNOTE}</td>
					<td>${DEALSOURCE.ENDID}</td>
					<td>${DEALSOURCE.DEALQTY}</td>
					<td>${DEALSOURCE.DEALNOTE}</td>
					<td><c:choose>
							<c:when test="${DEALSOURCE.ENDSHIPWAY==0}">
								面交
							</c:when>
							<c:when test="${DEALSOURCE.ENDSHIPWAY==1}">
								物流
							</c:when>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${DEALSOURCE.DEALSTATUS==0}">
								處理中
								<Input type="button" name="cancel" value="取消"
									onClick="CancelDEAL(${DEALSOURCE.DEALNO})">
								<Input type="button" name="OK" value="結單"
									onClick="OKDEAL(${DEALSOURCE.DEALNO},${stVar.index})">
							</c:when>
							<c:when test="${DEALSOURCE.DEALSTATUS==1}">
								已送出
							</c:when>
							<c:when test="${DEALSOURCE.DEALSTATUS==2}">
								取消
							</c:when>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${empty DEALSOURCE.SHIPNO}">
								<c:if
									test="${(DEALSOURCE.DEALSTATUS==0)&&(DEALSOURCE.ENDSHIPWAY==1)}">
									<input id="shipno${stVar.index}" type="text" name="SHIPNO"
										placeholder="物流編號 (可不輸入)">
								</c:if>
								<c:if
									test="${(DEALSOURCE.DEALSTATUS==0)&&(DEALSOURCE.ENDSHIPWAY==0)}">
									<input id="shipno${stVar.index}" type="hidden" name="SHIPNO"
										value="">
								</c:if>
							</c:when>

							<c:otherwise>
							${DEALSOURCE.SHIPNO}
							</c:otherwise>
						</c:choose>
					<td>${DEALSOURCE.SHIPDATE}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if> <c:if test="${empty DEALSOURCE_DATA}">
		<h1>你沒有任何訂單(提供者)</h1>
	</c:if>
	<form>
		<input type="hidden" name="a" />
	</form>
	</section>

	<footer> <jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>