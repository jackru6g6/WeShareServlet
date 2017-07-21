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

<!-- member_menu.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_menu.css">
<!-- member_content.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_content.css">
<!-- member_update.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_update.css">
<!-- member_goodsCart.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_goodsCart.css">
<!-- member_message.css	-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_message.css">
<!-- member_feedback.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_feedback.css">

<jsp:include page="../fragment/refJs.jsp" />

<!-- 自訂js -->
<%-- <script src="${pageContext.request.contextPath}/dist/js/.js"></script> --%>

<title>WeShare 微分享</title>
</head>

<body>


<!-- 跳出新增物資視窗 -->
<div class="modal fade" id="goods_insert_modal" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- 新增物資視窗內容 -->
		<div class="modal-content">
			
			<!-- 新增物資視窗_header -->
			<div class="modal-header" id="goods_insert_modal_header">
				<!-- 標題及關閉符號(X) -->
				<button type="button" class="close" id="goods_insert_modal_header_close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="goods_insert_modal_title"><b>新增物資</b></h4>
			</div>
			
			<!-- 新增物資視窗_body -->
			<div class="modal-body">
<!-- 				<form id="goods_insert_form_horizontal" class="form-horizontal " action=""> -->
				<div id="goods_insert_form_horizontal" class="form-horizontal">
					<!-- 需求名稱 -->
					<div class="form-group goods_insert_form_group">																			
						<label class="control-label col-sm-3 goods_insert_form_label">														
							<span class="glyphicon glyphicon-tag"></span>
							&nbsp需&nbsp求&nbsp名&nbsp稱&nbsp &nbsp													
						</label>
													
						<div class="col-sm-9">
							<input type="text" class="form-control goods_insert_form_input goods_name">
						</div>																
					</div>
					
					<!-- 物品類別 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-th-list"></span>
							&nbsp物&nbsp品&nbsp類&nbsp別&nbsp &nbsp
						</label>
													
						<div class="col-sm-9">
							<select class="form-control goods_insert_form_input goods_type">
								<option value="1">食品</option>
								<option value="2">服飾配件</option>
								<option value="3">生活用品</option>
								<option value="4">家電機器</option>
								<option value="5">其他</option>
							</select>
						</div>
					</div>
					
					<!-- 需求類別 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-list-alt"></span>
							&nbsp需&nbsp求&nbsp類&nbsp別&nbsp &nbsp
						</label>
													
						<div class="col-sm-9">
							<select class="form-control goods_insert_form_input goods_status">
								<option value="1">募資</option>
								<option value="2">捐贈</option>
								<option value="3">以物易物</option>								
							</select>
						</div>
					</div>
					
					<!-- 需求地區 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-map-marker"></span>
							&nbsp需&nbsp求&nbsp地&nbsp區&nbsp &nbsp
						</label>
																					
						<div class="col-sm-9">
							<select class="form-control goods_insert_form_input goods_loc" required>																	
								<option value="1">苗栗縣</option>
								<option value="2">桃園市</option>
								<option value="4">新北市</option>
								<option value="6">新竹縣</option>
								<option value="7">臺北市</option>
								<option value="13">臺中市</option>
								<option value="15">高雄市</option>
							</select>
						</div>
					</div>
					
					<!-- 需求數量 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-hourglass"></span>
							&nbsp需&nbsp求&nbsp數&nbsp量&nbsp &nbsp
						</label>
													
						<div class="col-sm-9">
							<input type="number" class="form-control goods_insert_form_input qty" min="1">
						</div>
					</div>
					
					<!-- 需求方式 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-plane"></span>
							&nbsp需&nbsp求&nbsp方&nbsp式&nbsp &nbsp
						</label>
													
						<div class="col-sm-9">
							<select class="form-control goods_insert_form_input goods_shipway">
								<option value="1">面交</option>
								<option value="2">物流</option>
								<option value="3">皆可</option>
							</select>
						</div>
					</div>
					
					<!-- 截止時間 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-calendar"></span>
							&nbsp截&nbsp止&nbsp時&nbsp間&nbsp &nbsp 
						</label>
													
						<div class="col-sm-9">
							<input type="date" class="form-control goods_insert_form_input deadline">
						</div>
					</div>
					
					<!-- 需求說明 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-edit"></span>
							&nbsp需&nbsp求&nbsp說&nbsp明&nbsp &nbsp
						</label>
													
						<div class="col-sm-9">
							<textarea class="form-control goods_insert_form_input goods_note" rows="5"  Wrap="physical"></textarea>
						</div>
					</div>
					
					<!-- 圖片 -->
					<div class="form-group goods_insert_form_group">
						<label class="control-label col-sm-3 goods_insert_form_label">
							<span class="glyphicon glyphicon-picture"></span>
							&nbsp圖&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp片&nbsp &nbsp
						</label>

						<!-- 上傳及預覽檔案 -->
						<div class="col-sm-9">																	
							<input type="file" name="goods_image_upload" value="" id="upload_img_goods" accept="image/jpeg, image/png">
							<img id="preview_img_goods">																		
						</div>
										
					</div>
					
					
				</div>	
<!-- 				</form> -->
			</div>
			
			<!-- 新增物資視窗_footer -->
			<div class="modal-footer" id="goods_insert_modal_footer">
				<!-- 新增物資按鈕 -->
					<button id="goods_insert_form_submit_button" class="btn btn-block">
						<b>新&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp增</b>
					</button>
					
					<button class="btn btn-block" data-dismiss="modal">
						<b>關閉</b>
					</button>
			</div>
			
		</div>
	</div>
</div>	
	
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
				<form id="member_message_form_horizontal" class="form-horizontal" action="">
					
					<!-- 收件人 -->
					<div id="member_message_form_group" class="form-group">
						<label id="message_insert_form_label" class="control-label col-sm-3">
							<span class="glyphicon glyphicon-user"></span>
							&nbsp收&nbsp &nbsp件&nbsp &nbsp人&nbsp &nbsp
						</label>
						
						<div class="col-sm-9">
							<input type="text" name="goods_name" value="" id="message_insert_form_input" class="form-control" placeholder="請輸入收件人帳號" required>
						</div>
					</div>													
					
					
					<!-- 信件內容 -->
					<div id="member_message_form_group" class="form-group">
						<label id="message_insert_form_label" class="control-label col-sm-3">
							<span class="glyphicon glyphicon-list"></span>
							&nbsp信&nbsp件&nbsp內&nbsp容&nbsp &nbsp
						</label>
						
						<div class="col-sm-9">
							<textarea name="" value="" id="message_insert_form_input" class="form-control" rows="5"  Wrap="physical" required></textarea>
						</div>
					</div>			
					
					
					<!-- 附加檔案 -->
					<div id="member_message_form_group" class="form-group">
						<label id="message_insert_form_label" class="control-label col-sm-3">
							<span class="glyphicon glyphicon-paperclip"></span>
							&nbsp附&nbsp加&nbsp檔&nbsp案&nbsp &nbsp
						</label>

						<!-- 上傳及預覽檔案 -->
						<div class="col-sm-9">																	
							<input type="file" name="goods_image_upload" value="" id="upload_img_message">
								<img id="preview_img_message">
						</div>																												
					
					</div>
					
					<!-- 發送按鈕 -->
					<button type="submit" name="" value="" id="message_insert_form_submit_button" class="btn btn-block" data-dismiss="modal">
						<b>發&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp送</b>
					</button>

				</form>
			</div>
			
			<!-- 撰寫站內信視窗_footer -->
			<div class="modal-footer" id="message_insert_modal_footer"></div>
			
		</div>
	</div>
</div>
	
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
				<form>
					
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

				</form>
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
				<!-- 左側導覽列 ********************************************************* -->
				<aside class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
							
					<!-- 左側導覽列title、會員圖片 -->
			        <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<h3 id="member_menu_title"><b>會員專區</b></h3>
							<img id="member_menu_img" 
								 src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER">
						</div>	
					</div>
								
								
					<!-- 左側導覽列選項按鈕 -->
					<ul>					
						<!-- 修改會員資料 -->
						<li>
							<a href="#member_update_content" data-toggle="tab">
								<button id="member_menu_update_button" class="btn btn-block member_menu_button">
									<span class="glyphicon glyphicon-pencil">
										<b>修改會員資料</b>
									</span>
								</button>
							</a>
						</li>
									
						<!-- 我的物資箱 -->
						<li>
							<a href="#member_goodsCart_content_jsp" data-toggle="tab">
								<button id="member_menu_goodsCart_button" class="btn btn-block member_menu_button">
									<span class="glyphicon glyphicon-gift">
										<b>我的物資箱</b>
									</span>
								</button>
							</a>
						</li>
									
						<!-- 我的站內信 -->
						<li>
							<a href="#member_message_content" data-toggle="tab">
								<button id="member_menu_message_button" class="btn btn-block member_menu_button">
									<span class="glyphicon glyphicon-envelope">
										<b>我的站內信</b>
									</span>
								</button>
							</a>
						</li>
									
						<!-- 紀錄與評價 -->
						<li>
							<a href="#member_feedback_content" data-toggle="tab">
								<button id="member_menu_feedback_button" class="btn btn-block member_menu_button">
									<span class="glyphicon glyphicon-star">	
										<b>紀錄與評價</b>
									</span>
								</button>
							</a>
						</li>
									
					</ul>
				</aside>
				
				
				<!-- 頁面內容 ********************************************************* -->
                <article class="col-xs-12 col-sm-9 col-md-9 col-lg-9 tab-content">
                
                	<!-- 修改會員資料 -->
<!-- 					<div id="member_update_content" class="tab-pane fade in active"> -->
					<div id="member_update_content" class="tab-pane fade">
						<jsp:include page="/web/member_update.jsp" />
					</div>
					
					<!-- 我的物資箱 -->
					<div id="member_goodsCart_content_jsp" class="tab-pane fade">
						<jsp:include page="/web/member_goodsCart.jsp" />
					</div>
					
					<!-- 我的站內信 -->
					<div id="member_message_content" class="tab-pane fade">
						<jsp:include page="/web/member_message.jsp" />
					</div>
					
					<!-- 紀錄與評價 -->
					<div id="member_feedback_content" class="tab-pane fade">
						<jsp:include page="/web/member_feedback.jsp" />
					</div>
                
                </article>
				
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
	
	
	
	
	<!-- 相關的js檔 -->
	<script src="${pageContext.request.contextPath}/dist/js/member_menu.js"></script>
	
	<script type="text/javascript">
	var javaRoot = "${pageContext.servletContext.contextPath}";
	
// 	修改會員資料__按下選單的按鈕，要求資料
	$('#member_menu_update_button').click(function(){
		var xhrMbData = new XMLHttpRequest();
		var servletPath = javaRoot + '/web/_03_updateMember/controller/FindMemberServlet';
		var responseMbData;
		
		var Update_img_ind = "";
		var Update_img_org = "";
		
		
		xhrMbData.open('GET', servletPath, true);
		xhrMbData.send();
		xhrMbData.onreadystatechange = function(){
			if(xhrMbData.status == 200 && xhrMbData.readyState == 4){
				responseMbData = JSON.parse(xhrMbData.responseText);
// 				console.log("responseMbData = ");
// 				console.log(responseMbData);
				// 產生會員資料
				showMbData(responseMbData, javaRoot);
				
				//修改會員密碼
// 				$( "#passsword_update_button" ).click(function() {
// 					console.log("#passsword_update_button click");
// // 					$("#passsword_update_content").slideToggle();						  
// 				});
				
//				預覽上傳照片
				$("#upload_img_goods").change(function(){
					if (this.files && this.files[0]) {
						Update_img_ind = new FileReader();
						reader.onload = function (e) {
							$("#upload_img_ind").attr("src", e.target.result);
						}
						reader.readAsDataURL(this.files[0]);
					}				
				});
				

				$("#upload_img_goods").change(function(){
					if (this.files && this.files[0]) {
						Update_img_org = new FileReader();
						reader.onload = function (e) {
							$("#upload_img_org").attr("src", e.target.result);
						}
						reader.readAsDataURL(this.files[0]);
					}				
				});
				
				
				
				
				
				
//			 	修改會員資料_點選"修改"按鈕，送出資料
				$(".member_update_submit_button").click(function() {
					alert("送出訊息");
					memberDataUpdate();
				});
				
				

				
			}
		}
	});
	
	
	
	






	
// 	我的物資箱__按下選單的按鈕，要求資料
	$('#member_menu_goodsCart_button').click(function(){
		var xhrGCData = new XMLHttpRequest();
		var servletPath = javaRoot + '/web/_04_productMaintain/controller/DisplayPageProducts';
		var responseGCData;
	
		xhrGCData.open('GET', servletPath, true);
		xhrGCData.send();
		xhrGCData.onreadystatechange = function(){
			if(xhrGCData.status == 200 && xhrGCData.readyState == 4){
				responseGCData = JSON.parse(xhrGCData.responseText);
// 				console.log("responseGCData = ");
// 				console.log(responseGCData);
				// 產生會員資料
				showGCData(responseGCData, javaRoot);
				
				
				
//				預覽上傳照片
				$("#upload_img_goods").change(function(){
					if (this.files && this.files[0]) {
						_Update_img = new FileReader();
						reader.onload = function (e) {
							$("#preview_img_goods").attr("src", e.target.result);
						}
						reader.readAsDataURL(this.files[0]);
					}				
				});
				
				
				
//	 			按下物資title滑出選單 
				$(".goods_item_title").click(function() {
					$(this).closest(".goods_item_caption").find(".goods_item_content").slideToggle();
				});
				
				
//		 		點選修改按鈕
				$(".goods_item_update_button").click(function() {
//	 				 送出按鈕出現，表單可以修改、背景變灰色，修改按鈕消失  
					$(this).closest(".goods_item_content_li").find(".goods_item_submit_button").show();
					$(this).closest(".goods_item_content").find("input").attr("disabled", false);
					$(this).closest(".goods_item_content").find("select").attr("disabled", false);
					$(this).closest(".goods_item_content").find(".goods_item_content_li_input").css("background-color", "#E0E0E0").css("border-radius", "8px");
					$(this).hide();																				
				});


//		 		點選送出按鈕
				$(".goods_item_submit_button").click(function() {
					var goodsno = $(this).val();
					goodsCartUpdate($(this), goodsno);
				});
				
				
//		 		點選刪除按鈕
				$('.goods_item_delete_button').click(function(){
					$(this).closest(".block_goods_item").hide();
				});				
			}
			
			
//			新增物資
			$("#goods_insert_form_submit_button").click(function() {
				console.log("goods_insert_form_submit_button");
				
// 				insertGoods();
			});
				
		}
	});
	
	
	
	
	
	
// 	我的站內信_顯示站內信
	$('#member_menu_message_button').click(function(){
		var xhrMSG_Data = new XMLHttpRequest();
		var servletPath = javaRoot + '/web/_06_MSG/controller/FindMSGByKey';
		var responseMSG_Data;

		xhrMSG_Data.open('GET', servletPath, true);
		xhrMSG_Data.send();
		xhrMSG_Data.onreadystatechange = function(){
			if(xhrMSG_Data.status == 200 && xhrMSG_Data.readyState == 4){
				responseMSG_Data = JSON.parse(xhrMSG_Data.responseText);
				
// 				console.log("responseMSG_Data = " + responseMSG_Data);
				
				// 產生會員資料
				showMSG_Data(responseMSG_Data, javaRoot);
			}
			
			
// 		撰寫站內信
// 		$("#message_insert_form_submit_button").click(function() {
// 			insertGoods();
// 		});
		
		}
	});

	
	</script>

</body>
</html>