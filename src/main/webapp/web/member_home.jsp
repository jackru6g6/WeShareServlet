<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
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
		href="${pageContext.request.contextPath}/dist/css/member_home.css">
	
	
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body>
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div class="container" id="background_img">
			
			<!-- 背景圖案 -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="member_home_Data">	 -->
<%-- 					<img src="${pageContext.request.contextPath}/dist/img/member_home_background.jpg" id="background_img"> --%>
<!-- 				</div>    -->
<!-- 			</div> -->
			
			
			<!-- 會員圖像 -->
			<div class="row">					
				<div class="col-xs- col-sm-4 col-md-4 col-lg-4"></div> 
				
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<img src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER" class="img-circle" id="member_img">	
				</div>  

				<div class="col-xs- col-sm-4 col-md-4 col-lg-4"></div> 
			</div>
		   
			<!-- 會員名稱 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<p id="member_name">
						<b>${LoginOK.indname}</b>
					</p>
				</div>   
			</div>
			
			<!-- 會員評價 -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 					<p id="member_feedback"> -->
<!-- 						<b>會員評價：</b> -->
<!-- 					</p> -->
<!-- 				</div>    -->
<!-- 			</div> -->
		   	   
		   
			<!-- 會員專區功能按鈕 -->
			<div class="row">
			
				<div class="col-xs- col-sm-2 col-md-2 col-lg-2"></div> 
				
				<div class="col-xs-6 col-sm-4 ol-md-4 col-lg-4">
					<a href="member_menu.jsp">
						<button id="update_button" class="btn member_home_button">
							<span class="glyphicon glyphicon-pencil">
								<b>修改會員資料</b>
							</span>
						</button>
					</a>
				</div>  

				<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
					<a href="member_menu.jsp">
						<button id="goodsCart_button" class="btn member_home_button">
							<span class="glyphicon glyphicon-gift">
								<b>我的物資箱</b>
							</span>
						</button>
					</a>
				</div> 
				
				<div class="col-xs- col-sm-2 col-md-2 col-lg-2"></div> 
				
			</div>
			
			<div class="row">
			
				<div class="col-xs- col-sm-2 col-md-2 col-lg-2"></div> 
			
				<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
					<a href="member_menu.jsp">
						<button id="message_button" class="btn member_home_button">
							<span class="glyphicon glyphicon-envelope">
								<b>我的站內信</b>
							</span>
						</button>
					</a>
				</div>  

				<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4">
					<a href="member_menu.jsp">
						<button id="feedback_button" class="btn member_home_button">
						<span class="glyphicon glyphicon-star">	
							<b>紀錄與評價</b>
						</span>
						</button>
					</a>
				</div> 
			</div>
			
			<div class="col-xs- col-sm-2 col-md-2 col-lg-2"></div> 
		   
		</div>
	
	</section>
	
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
</body>

</html>