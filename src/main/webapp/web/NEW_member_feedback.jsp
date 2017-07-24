<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta charset="utf-8">
<jsp:include page="../fragment/refCss.jsp" />
<!-- CSS -->
<!-- 會員專區_左側導覽列：member_menu.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_menu.css">
<!-- 會員專區_右側內容共同樣式：member_content.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_content.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/XXXXXXXXXX.css">
<!-- JS -->
<jsp:include page="../fragment/refJs.jsp" />
<title>WeShare 微分享</title>
</head>
<body>
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	<section>
		<div class="container">
			<div class="row">
				<aside class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
					<jsp:include page="NEW_member_aside.jsp" />
				</aside>
				<article class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
					
					
					評價與紀錄
					
					內容
					
					
					
					
				</article>
			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
<!-- 相關的javascript===================================================================================================================================== -->
	<script src="${pageContext.request.contextPath}/dist/js/XXXXXXXXXXXXX.js"></script>
	<script>
	
	</script>
</body>
</html>