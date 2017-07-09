<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html lang="zh-Hant">

<head>
<meta charset="utf-8">
<jsp:include page="../fragment/refCss.jsp" />
<!-- 自訂CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/dist/css/member.css">
<jsp:include page="../fragment/refJs.jsp" />
<!-- 自訂js -->
<script src="${pageContext.request.contextPath}/dist/js/member.js"></script>

<title>WeShare 微分享</title>
</head>

<body>

	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>

	<section>
		<div class="container-fluid">
			<div class="row">
				<!-- 左側導覽列 -->
				<aside class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
					<jsp:include page="/web/member/membermenu.jsp" />
				</aside>

				<!-- 頁面內容 -->
				<article class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
					<!-- 個人檔案 -->
					<div class="row">
						<div
							class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content"
							id="member_home">

							<!-- 個人檔案title -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h3 id="member_content_title">
										<b>我的物資箱</b>
									</h3>
									<hr id="member_content_hr">
								</div>
							</div>

							<!-- 個人檔案內容 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"></div>
							</div>

						</div>
					</div>
				</article>
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>

</body>
</html>