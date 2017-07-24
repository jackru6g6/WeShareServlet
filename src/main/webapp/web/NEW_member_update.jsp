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
<!-- 修改會員資料樣式：member_update.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_update.css">
<!-- JS -->
<jsp:include page="../fragment/refJs.jsp" />
<title>WeShare 微分享</title>
</head>
<body>

	<!-- 跳出修改會員密碼視窗 -->
	<div class="modal fade" id="password_update_modal" role="dialog" aria-labelledby="password_update_modal_title" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<!-- 修改會員密碼視窗_header -->
				<div class="modal-header" id="password_update_modal_header">
					<!-- 標題及關閉符號(X) -->
					<button type="button" class="close" id="password_update_modal_header_close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="password_update_modal_title"><b>修改會員密碼</b></h4>
				</div>
				<!-- 修改會員密碼視窗_body -->
				<div class="modal-body">
					<!-- 修改會員密碼 -->
					<div>
						<!-- 請輸入舊密碼 -->
						<div class="form-group" id="old_password_form_group">
							<label class="control-label" id="old_password_form_label">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								請輸入舊密碼
							</label>														
							
							<input type="password" name="" value="" id="old_password_form_input" class="form-control">																
						</div>
						<!-- 請輸入新密碼 -->
						<div class="form-group" id="new_password_form_group">
							<label class="control-label" id="new_password_form_label">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								請輸入新密碼
							</label>														
						
							<input type="password" name="" value="" id="new_password_form_input" class="form-control">																
						</div>
						<!-- 再次確認密碼 -->
						<div class="form-group" id="check_password_form_group">
							<label class="control-label" id="check_password_form_label">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								再次確認密碼
							</label>														
							
							<input type="password" name="" value="" id="check_password_form_input" class="form-control">																
						</div>															
					
						<!-- 修改會員密碼按鈕 -->
						<button type="submit" name="" value="" id="password_update_form_submit_button" class="btn btn-block" data-dismiss="modal">
							<b>修改會員密碼</b>
						</button>
					</div>
				</div>
				<!-- 修改會員密碼視窗_footer -->
				<div class="modal-footer" id="password_update_modal_footer"></div>
			</div>
		</div>						
	</div>

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
						<div id="member_update_content_title" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_contnet_title">
							<h3>
								<b>修改會員資料</b>
							</h3>
						</div>
					</div>
					
					<!-- body -->
					<div class="row">
						<div id="member_update_content_body" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_body">
							<div id="member_update_form_horizontal" class="form-horizontal">
								<!-- NEW_membere_update.js 動態產生內容 -->
							</div>
						</div>
					</div>
					
					<!-- footer -->
					<div class="row">
						<div id="member_update_content_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">
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
	<script src="${pageContext.request.contextPath}/dist/js/NEW_member_update.js"></script>
	<script>
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var Update_img_ind = "";  //修改會員資料_會員照片
		var Update_img_org = "";  //修改會員資料_社福照片
		// 修改會員資料__按下左側選單的按鈕，要求資料
		window.onload = function(){
			var xhrMbData = new XMLHttpRequest();
			var servletPath = javaRoot + '/web/_03_updateMember/controller/FindMemberServlet';
			var responseMbData;
			
			
			
			xhrMbData.open('GET', servletPath, true);
			xhrMbData.send();
			xhrMbData.onreadystatechange = function(){
				if(xhrMbData.status == 200 && xhrMbData.readyState == 4){
					responseMbData = JSON.parse(xhrMbData.responseText);

					// 產生會員資料
					showMbData(responseMbData, javaRoot);
				
					// 預覽個人圖片
					$("#upload_img_ind").change(function(){				
						if (this.files && this.files[0]) {
							Update_img_ind = new FileReader();				
							Update_img_ind.onload = function (e) {
								$("#preview_img_ind").attr("src", this.result);
							}				
							Update_img_ind.readAsDataURL(this.files[0]);
						}				
					});
					
					
		 			// 預覽社福圖片
					$("#upload_img_org").change(function(){
						if (this.files && this.files[0]) {
							Update_img_org = new FileReader();				
							Update_img_org.onload = function (e) {
								$("#preview_img_org").attr("src", this.result);
							}				
							Update_img_org.readAsDataURL(this.files[0]);
						}
					});


					// 修改密碼，按下"修改會員密碼"按鈕，送出修改資料
					$("#password_update_form_submit_button").click(function(){
						passwordUpdate();
					});
					
				 	// 修改會員資料_點選"修改"按鈕，送出資料
					$(".member_update_submit_button").click(function() {
						memberDataUpdate();
					});
					
				}
			}
		}
	</script>
</body>
</html>