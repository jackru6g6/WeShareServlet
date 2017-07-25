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
<!-- member_message.css	-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/NEW_member_message.css">
<!-- JS -->
<jsp:include page="../fragment/refJs.jsp" />
<title>WeShare 微分享</title>
</head>
<body>
	<!-- 跳出撰寫站內信視窗 -->
	<div class="modal fade" id="message_insert_modal" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- 撰寫站內信視窗內容 -->
			<div class="modal-content">
				<!-- 撰寫站內信視窗_header -->
				<div class="modal-header" id="message_insert_modal_header">
					<!-- 標題及關閉符號(X) -->
					<button type="button" class="close" id="message_insert_modal_header_close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="message_insert_modal_title"><b>撰寫站內信</b></h4>
				</div>
				<!-- 撰寫站內信視窗_body -->
				<div class="modal-body">
					<!-- 撰寫站內信 -->
					<div id="member_message_form_horizontal" class="form-horizontal">
						<!-- 收件人 -->
						<div class="form-group member_message_form_group">
							<label class="control-label col-sm-3 message_insert_form_label">
								<span class="glyphicon glyphicon-user"></span>
								&nbsp收&nbsp &nbsp件&nbsp &nbsp人&nbsp &nbsp
							</label>
							<div class="col-sm-9">
								<input type="text" class="form-control message_insert_form_input msgendId" placeholder="請輸入收件人帳號" required>
							</div>
						</div>													
						
						<!-- 信件內容 -->
						<div class="form-group member_message_form_group">
							<label class="control-label col-sm-3 message_insert_form_label">
								<span class="glyphicon glyphicon-list"></span>
								&nbsp信&nbsp件&nbsp內&nbsp容&nbsp &nbsp
							</label>
							<div class="col-sm-9">
								<textarea class="form-control message_insert_form_input msgText" rows="5"  Wrap="physical" required></textarea>
							</div>
						</div>			
						
						<!-- 附加檔案 -->
						<div class="form-group member_message_form_group">
							<label class="control-label col-sm-3 message_insert_form_label">
								<span class="glyphicon glyphicon-paperclip"></span>
								&nbsp附&nbsp加&nbsp檔&nbsp案&nbsp &nbsp
							</label>
							<!-- 上傳及預覽檔案 -->
							<div class="col-sm-9">																	
								<input type="file" id="upload_img_message">
									<img id="preview_img_message">
							</div>																												
						</div>
						<!-- 發送按鈕 -->
						<button id="message_insert_form_submit_button" class="btn btn-block" data-dismiss="modal">
							<b>發&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp送</b>
						</button>
					</div>
				</div>
				
				<!-- 撰寫站內信視窗_footer -->
				<div class="modal-footer" id="message_insert_modal_footer"></div>
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
						<div id="member_message_content_title" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_contnet_title">
							<h3>
								<b>我的站內信</b>
							</h3>
						</div>
					</div>
					
					<!-- body -->
					<div class="row">
						<div id="member_message_content_body" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_body">
							<!-- 我的站內信_撰寫站內信按鈕 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<button type="button" name="" value="" id="message_insert_button" class="btn btn-block" data-toggle="modal" data-target="#message_insert_modal">
										<span class="glyphicon glyphicon-edit"></span>
										<b>撰寫站內信</b>
									</button>										
								</div>
							</div>
							<!-- 站內信_table -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<table class="table table-hover" id="member_message_table">
										<thead>
											<tr>												
												<th><b>對象</b></th>													
												<th><b>最新消息</b></th>
												<th><b>內容</b></th>
											</tr>
										</thead>
<!-- 										<tbody id="member_message">	 -->
<!-- 											<tr class="message_data notread">	 -->
<!-- 												<td> -->
<!-- 													<ul> -->
<!-- 														<li> -->
<%-- 															<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].MSGENDID}&type=MEMBER" class="message_end_img"> --%>
<!-- 														</li> -->
<!-- 													</ul> -->
<!-- 												</td>													 -->
<!-- 												<td> -->
<!-- 													<ul> -->
<!-- 														<li class="member_message_data"> -->
<%-- 															${data.coll[i].MSGENDNAME} --%>
<!-- 														</li> -->
<!-- 														<li class="member_message_data"> -->
<%-- 															${data.coll[i].POSTDATE} --%>
<!-- 														</li> -->
<!-- 														<li class="member_message_data"> -->
<%-- 															${data.coll[i].MSGTEXT} --%>
<!-- 														</li> -->
<!-- 													</ul>										 -->
<!-- 												</td> -->
<!-- 												<td class="button_row">									 -->
<!-- 													<button class="btn btn-default member_message_show_button"> -->
<!-- 														<span class="glyphicon glyphicon-list-alt"></span> -->
<!-- 														內容 -->
<!-- 													</button>														 -->
<!-- 												</td>												 -->
<!-- 											</tr> -->
<!-- 											<tr> -->
<!-- 												<td colspan="4" class="member_message_all"> -->
<!-- 													<div class="member_message_all_content"> -->
<!-- 														<div> -->
<!-- 															A名稱   時間 -->
<!-- 															<br> -->
<!-- 															內容 -->
<!-- 															<br> -->
<!-- 														</div> -->
<!-- 													</div> -->
<!-- 													<textarea class="member_message_sendBack" rows="3" wrap="physical" placeholder="請輸入信息內容" required></textarea> -->
<!-- 													<button class="btn member_message_sendBack_button">送出</button> -->
<!-- 												</td> -->
<!-- 											</tr> -->
<!-- 										</tbody> -->
									</table>
								</div>								
							</div>
						</div>
					</div>
									
					<!-- footer -->
					<div class="row">
						<div id="member_message_content_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">	
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
	<script src="${pageContext.request.contextPath}/dist/js/NEW_member_message.js"></script>
	<script>
	
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var messageImg = "";
		// 我的站內信_顯示站內信
		window.onload = function(){
			var xhrMSG_Data = new XMLHttpRequest();
			var servletPath = javaRoot + '/web/_06_MSG/controller/FindMSGByKey';
			var responseMSG_Data;
			
	
			xhrMSG_Data.open('GET', servletPath, true);
			xhrMSG_Data.send();
			xhrMSG_Data.onreadystatechange = function(){
				if(xhrMSG_Data.status == 200 && xhrMSG_Data.readyState == 4){
					responseMSG_Data = JSON.parse(xhrMSG_Data.responseText);
					// 產生會員資料
					showMSG_Data(responseMSG_Data, javaRoot);
					
					// 按下"送出"按鈕，送出textarea內的信息
					$(".member_message_sendBack_button").click(function(){
							secndBackMessage($(this));
					});
					
					// 按下"內容"按鈕，滑出聊天室內容
					$(".member_message_show_button").click(function() {
						$(this).closest(".member_message").find(".member_message_all").slideToggle();
						var roomNo = $(this).val();
						
						//向Servlet要求聊天室內容
						var xhrDetail_MSG_Data = new XMLHttpRequest();
						var servletPath = javaRoot + '/web/_06_MSG/controller/FindMSGByRoomNo?key=' + roomNo;
						var responseDetail_MSG_Data;
						
						xhrDetail_MSG_Data.open('GET', servletPath, true);
						xhrDetail_MSG_Data.send();
						xhrDetail_MSG_Data.onreadystatechange = function(){
							if(xhrDetail_MSG_Data.status == 200 && xhrDetail_MSG_Data.readyState == 4){
								responseDetail_MSG_Data = JSON.parse(xhrDetail_MSG_Data.responseText);
								// 產生聊天室詳細內容
								showDetail_MSG_Data(responseDetail_MSG_Data, javaRoot);
								
								// 預覽站內信圖片(發送訊息)
// 								$(".member_message_img").change(function(e){
// 										messageImg = new FileReader();
// 										messageImg.readAsDataURL(this.files[0]);
// 										messageImg.onload = function () {
// 											thisE.closest(".member_message_all").find(".member_message_show_img").attr("src", this.result);
// 										}			
// 								});
							}
						}
					});
					
				}
			}
		};
		
		
		// 新增站內信
		var insertMessage_img = ""; //新增站內信照片
		$("#message_insert_form_submit_button").click(function() {
			insertMessage();
		});
		
		// 預覽上傳的附加檔案
		$("#upload_img_message").change(function(){
			if (this.files && this.files[0]) {
				insertMessage_img = new FileReader();
				insertMessage_img.onload = function (e) {
					$("#preview_img_message").attr("src", this.result);
				}
				insertMessage_img.readAsDataURL(this.files[0]);
			}
		});
	
	</script>
</body>
</html>