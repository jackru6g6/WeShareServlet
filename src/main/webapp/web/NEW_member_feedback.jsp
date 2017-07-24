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
<!-- 紀錄與評價樣式 member_feedback.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_feedback.css">
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
					<!-- title -->
					<div class="row">
						<div id="member_feedback_content_title" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_contnet_title">
							<h3>
								<b>紀錄與評價</b>
							</h3>
						</div>
					</div>
					
					<!-- body -->
					<div class="row">
						<div id="member_feedback_content_body" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_body">							
							
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row">								
										<!-- 排序選項 -->
										<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
											<div class="dropdown">
												<button type="button" name="" value="" id="feedback_priority_button" class="btn btn-block dropdown-toggle" data-toggle="dropdown">
													排序
													<span class="caret"></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="#">依時間排序</a></li>
													<li><a href="#">依分數排序</a></li>
													<li><a href="#">依給評人排序</a></li>
												</ul>
											</div>
										</div>
										
										<!-- 查詢欄位 -->
										<div class="col-xs-12 col-sm-6 col-md-8 col-lg-8">
											<div class="input-group" id="feedback_search_bar">
												<input type="search" name="" value="" class="form-control" id="feedback_search_bar_input">
												<span class="input-group-btn">
													<button type="button" name="" value="" id="feedback_search_button" class="btn btn-block">
														<span class="glyphicon glyphicon-search"></span>
														搜尋
													</button>
												</span>
											</div>	
										</div>
									</div>
								</div>
							</div>
							
							
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div id="btStatusAll">
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
												<button id="btStatus0" class="btn btn-default btStatusStyle">等待回應</button>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
												<button id="btStatus1" class="btn btn-default btStatusStyle">已接受</button>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
												<button id="btStatus2" class="btn btn-default btStatusStyle">已完成</button>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
												<button id="btStatus3" class="btn btn-default btStatusStyle">已取消</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							
							<!-- 紀錄與評價 -->
							<div id="dealContent">
				
							</div>
						</div>
					</div>
									
					<!-- footer -->
					<div class="row">
						<div id="member_feedback_content_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">	
						</div>
					</div>
				</article>
			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
<!-- 相關的javascript===================================================================================================================================== -->
	<script src="${pageContext.request.contextPath}/dist/js/member_feedback.js"></script>
	<script src="${pageContext.request.contextPath}/dist/js/lightbox.js"></script>
	<script>
		// 紀錄與評價__按下選單的按鈕，要求資料
		$('#member_menu_feedback_button').click(function(){
			var xhrDealData = new XMLHttpRequest();
			var servletPath = javaRoot + '/web/_05_deal/controller/FindDEALByKey';
			var responseDealData;
			
			// 點等待回應
			$('#btStatus0').click(function(){
				xhrDealData.open('GET', servletPath, true);
				xhrDealData.send();
				xhrDealData.onreadystatechange = function(){
					if(xhrDealData.status == 200 && xhrDealData.readyState == 4){
						responseDealData = JSON.parse(xhrDealData.responseText);
						// 產生等待回應的訂單
						showStatus0Date(responseDealData, javaRoot);
						// 點接受交易
						$('.btAgree').click(function(){
							dealAgree($(this));
						});
						// 點取消交易
						$('.btCancel').click(function(){
							dealCancel($(this));
						});
					}
				}
			});
			
			// 點已接受
			$('#btStatus1').click(function(){
				xhrDealData.open('GET', servletPath, true);
				xhrDealData.send();
				xhrDealData.onreadystatechange = function(){
					if(xhrDealData.status == 200 && xhrDealData.readyState == 4){
						responseDealData = JSON.parse(xhrDealData.responseText);
						// 產生已接受的訂單
						showStatus1Date(responseDealData, javaRoot);
						// 點結單
						$('.btDealMsg').click(function(){
							sendDealMsg($(this));
						});
					}
				}
			});
			
			// 點已完成
			$('#btStatus2').click(function(){
				xhrDealData.open('GET', servletPath, true);
				xhrDealData.send();
				xhrDealData.onreadystatechange = function(){
					if(xhrDealData.status == 200 && xhrDealData.readyState == 4){
						responseDealData = JSON.parse(xhrDealData.responseText);
						// 產生已完成的訂單
						showStatus2Date(responseDealData, javaRoot);
						// 點送出評價
						$('.btGiveFeedbackClass').click(function(){
							sendFeedback($(this));
						});
					}
				}
			});
			
			// 點已取消
			$('#btStatus3').click(function(){
				xhrDealData.open('GET', servletPath, true);
				xhrDealData.send();
				xhrDealData.onreadystatechange = function(){
					if(xhrDealData.status == 200 && xhrDealData.readyState == 4){
						responseDealData = JSON.parse(xhrDealData.responseText);
						// 產生已取消的訂單
						showStatus3Date(responseDealData, javaRoot);
					}
				}
			});
		});
	</script>
</body>
</html>