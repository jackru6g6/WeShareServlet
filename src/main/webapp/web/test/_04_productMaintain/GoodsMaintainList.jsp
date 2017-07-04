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

		<!-- 下列敘述設定變數funcName的值為BMT，top.jsp 會用到此變數 -->
		<c:set var="funcName" value="BMT" scope="session" />

		<div id='main'>
			<center>${ BookDeleteMsg }<br>
				<c:remove var="BookDeleteMsg" />

				<div>
					<a href="<c:url value='index.jsp' /> ">回首頁</a>
				</div>

				<table border='2' width="690">

					<TR>
						<TD colspan='3'>
							<TABLE width="680" BORDER='0' style="background: #ffE4C4">
								<TR height='5'>
									<TD align='center'>&nbsp;</TD>
								</TR>
								<TR height='30'>
									<TD align='center'><FONT color='#8000FA' size='+2'
										style="font-weight: 900;"> 物資箱維護 </FONT></TD>
								</TR>
								<TR height='5'>
									<TD align='center'>&nbsp;</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<!-- 
      forEach 顯示物資箱的內容
   -->
					<c:forEach varStatus="stVar" var="aBookBean"
						items="${products_DPP}">
						<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
						<c:set var="rowColor" value="#DEFADE" />
						<c:if test="${ stVar.count % 2 == 0 }">
							<c:set var="rowColor" value="#FFEBFF" />
						</c:if>

						<tr height='18' bgColor="${rowColor}">
							<td width='600' colspan='2' align='left'>
								<table border='1' width='600'>
									<tr>
										<td width='600' align="left">物資編號：<a
											href="FindGoodsServlet?pk=${aBookBean.goodsno}">${aBookBean.goodsno}</a>

										</td>
									</tr>
								</table>
							</td>
					</c:forEach>
				</TABLE>
			</CENTER>
		</div>

	</section>

	<footer>
		<jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>
