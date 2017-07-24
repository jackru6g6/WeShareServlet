<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">
<head>
	<jsp:include page="../fragment/refCss.jsp" />	
	<!-- 會員首頁樣式：member_home.css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/NEW_member_home.css">	
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>
<body>
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div class="container" id="background_img">
			<!-- 會員圖像 -->
			<div class="row">					
				<div class="col-xs- col-sm-4 col-md-4 col-lg-4"></div> 
				
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4"  id="member_home_img_row">
					<img src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER" class="img-circle" id="member_img">	
				</div>  

				<div class="col-xs- col-sm-4 col-md-4 col-lg-4"></div> 
			</div>
		   
			<!-- 會員名稱 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="member_name">
					<p>
						<b>${LoginOK.indname}</b>
					</p>
				</div>   
			</div>
			
			<!-- 會員專區功能按鈕 -->
			<div class="row">
			
				<div class="col-xs- col-sm-2 col-md-2 col-lg-2"></div> 
				
				<div class="col-xs-6 col-sm-4 ol-md-4 col-lg-4 member_home_button_row">
					<a href="${pageContext.request.contextPath}/web/NEW_member_update.jsp">
						<button id="update_button" class="btn member_home_button">
							<span class="glyphicon glyphicon-pencil">
								<b>修改會員資料</b>
							</span>
						</button>
					</a>
				</div>  

				<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 member_home_button_row">
					<a href="${pageContext.request.contextPath}/web/NEW_member_goodsCart.jsp">
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
			
				<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 member_home_button_row">
					<a href="${pageContext.request.contextPath}/web/NEW_member_message.jsp">
						<button id="message_button" class="btn member_home_button">
							<span class="glyphicon glyphicon-envelope">
								<b>我的站內信</b>
							</span>
						</button>
					</a>
				</div>  

				<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 member_home_button_row">
					<a href="${pageContext.request.contextPath}/web/NEW_member_feedback.jsp">
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