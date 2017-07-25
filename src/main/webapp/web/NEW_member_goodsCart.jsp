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
<!-- member_goodsCart.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member_goodsCart.css">
<!-- JS -->
<jsp:include page="../fragment/refJs.jsp" />
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
					<div id="goods_insert_form_horizontal" class="form-horizontal">
						<!-- 需求名稱 -->
						<div class="form-group goods_insert_form_group">																			
							<label class="control-label col-sm-3 goods_insert_form_label">														
								<span class="glyphicon glyphicon-tag"></span>
								&nbsp需&nbsp求&nbsp名&nbsp稱&nbsp &nbsp													
							</label>						
							<div class="col-sm-9">
								<input type="text" id="GOODSNAME" class="form-control goods_insert_form_input goods_name">
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
								<input type="number" id="GOODSQTY" class="form-control goods_insert_form_input qty" min="1">
							</div>
						</div>
						
						<!-- 需求方式 -->
<!-- 						<div class="form-group goods_insert_form_group"> -->
<!-- 							<label class="control-label col-sm-3 goods_insert_form_label"> -->
<!-- 								<span class="glyphicon glyphicon-plane"></span> -->
<!-- 								&nbsp需&nbsp求&nbsp方&nbsp式&nbsp &nbsp -->
<!-- 							</label>						 -->
<!-- 							<div class="col-sm-9"> -->
<!-- 								<select class="form-control goods_insert_form_input goods_shipway"> -->
<!-- 									<option value="1">面交</option> -->
<!-- 									<option value="2">物流</option> -->
<!-- 									<option value="3">皆可</option> -->
<!-- 								</select> -->
<!-- 							</div> -->
<!-- 						</div> -->
						
						<!-- 截止時間 -->
						<div class="form-group goods_insert_form_group">
							<label class="control-label col-sm-3 goods_insert_form_label">
								<span class="glyphicon glyphicon-calendar"></span>
								&nbsp截&nbsp止&nbsp時&nbsp間&nbsp &nbsp 
							</label>							
							<div class="col-sm-9">
								<input type="date" id="GOODSDEADLINE" class="form-control goods_insert_form_input deadline">
							</div>
						</div>
						
						<!-- 需求說明 -->
						<div class="form-group goods_insert_form_group">
							<label class="control-label col-sm-3 goods_insert_form_label">
								<span class="glyphicon glyphicon-edit"></span>
								&nbsp需&nbsp求&nbsp說&nbsp明&nbsp &nbsp
							</label>						
							<div class="col-sm-9">
								<textarea class="form-control goods_insert_form_input goods_note" rows="5"  Wrap="physical" id="GOODSNOTE"></textarea>
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
								<input type="file" name="goods_image_upload" id="upload_img_goods" accept="image/jpeg, image/png">
								<img id="preview_img_goods">																		
							</div>			
						</div>
						
						<!-- 新增物資按鈕 -->
<!-- 					<button id="goods_insert_form_submit_button" class="btn btn-block"> -->
						<button id="goods_insert_form_submit_button" class="btn btn-block" data-dismiss="modal">
							<b>新&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp增</b>
						</button>
					</div>	
				</div>
				
				<!-- 新增物資視窗_footer -->
				<div class="modal-footer" id="goods_insert_modal_footer">
				<img src="../dist/img/Helper_InsertGoods.png" id="helper_goodsInsert" onclick="goodsInsert_onhelp()">
				</div>
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
						<div id="member_goodsCart_content_title" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_contnet_title">
							<h3>
								<b>我的物資箱</b>
							</h3>
						</div>
					</div>
					
					<!-- body -->
					<div class="row">
						<div id="member_goodsCart_content_body" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_body">
							<!-- 我的物資箱新增、查詢 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<!-- 我的物資車_新增按鈕 -->
									<button type="button" id="goods_insert_button" class="btn btn-block" data-toggle="modal" data-target="#goods_insert_modal">
										<span class="glyphicon glyphicon-plus-sign"></span>
										<b>新增物資</b>
									</button>				
								</div>
							</div>
							<!-- 我的物資箱內容 -->
							<div class="row" id="member_goodsCart_content">
								<!-- NEW_member_goodsCart.js 動產生內容 -->
							</div>
						</div>
					</div>
					
					<!-- footer -->
					<div class="row">
						<div id="goods_insert_modal_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">						
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
	<script src="${pageContext.request.contextPath}/dist/js/NEW_member_goodsCart.js"></script>
	<script>
		var javaRoot = "${pageContext.servletContext.contextPath}";
		// 我的物資箱__按下選單的按鈕，要求資料
// 		$('#member_menu_goodsCart_button').click(function(){
		window.onload = function(){
			var xhrGCData = new XMLHttpRequest();
// 			var javaRoot = "${pageContext.servletContext.contextPath}";
			var servletPath = javaRoot + '/web/_04_productMaintain/controller/DisplayPageProducts';
			var responseGCData;
			
			
			xhrGCData.open('GET', servletPath, true);
			xhrGCData.send();
			xhrGCData.onreadystatechange = function(){
				if(xhrGCData.status == 200 && xhrGCData.readyState == 4){
					responseGCData = JSON.parse(xhrGCData.responseText);
					// 產生會員資料
					showGCData(responseGCData, javaRoot);
					
					
		 			// 按下"物資title"，滑出選單 
					$(".goods_item_title").click(function() {
						$(this).closest(".goods_item_caption").find(".goods_item_content").slideToggle();
					});
					
					
			 		// 點選"修改"按鈕
					$(".goods_item_update_button").click(function() {
		 				// 送出按鈕出現，表單可以修改、背景變灰色，修改按鈕消失  
						$(this).closest(".goods_item_content_li").find(".goods_item_submit_button").show();
						$(this).closest(".goods_item_content").find("input").attr("disabled", false);
						$(this).closest(".goods_item_content").find("select").attr("disabled", false);
						$(this).closest(".goods_item_content").find(".goods_item_content_li_input").css("background-color", "#E0E0E0").css("border-radius", "8px");
						$(this).hide();																				
					});
	
	
			 		// 點選"送出"按鈕
					$(".goods_item_submit_button").click(function() {
						var goodsno = $(this).val();
						goodsCartUpdate($(this), goodsno);
						
						// 修改按鈕出現，表單不可修改、背景變藍色，送出按鈕消失  
						$(this).closest(".goods_item_content_li").find(".goods_item_update_button").show();
						$(this).closest(".goods_item_content").find("input").attr("disabled", true);
						$(this).closest(".goods_item_content").find("select").attr("disabled", true);
						$(this).closest(".goods_item_content").find(".goods_item_content_li_input").css("background-color", "#A3DAFF").css("border-radius", "0px");
						$(this).hide();
					});
					
					
			 		// 點選刪除按鈕
					$('.goods_item_delete_button').click(function(){
						$(this).closest(".block_goods_item").hide();
					});				
				}
			}
// 		});
		}
		
		
		
		// 新增物資_預覽上傳照片
		var insert_goods_img = "";  //新增物資_圖片
		$("#upload_img_goods").change(function(){
			if (this.files && this.files[0]) {
				insert_goods_img = new FileReader();
				insert_goods_img.onload = function (e) {
					$("#preview_img_goods").attr("src", this.result);
				}
				insert_goods_img.readAsDataURL(this.files[0]);
			}				
		});
		
		// 新增物資
		$("#goods_insert_form_submit_button").click(function() {
			insertGoods();
		});
		
		
		// 新增物資_小幫手
		function goodsInsert_onhelp() {
			document.getElementById("GOODSNAME").value = "滑鼠";
			document.getElementById("GOODSQTY").value = "3";
			document.getElementById("GOODSDEADLINE").value = "2017-08-26";
			document.getElementById("GOODSNOTE").value = "使用1年，五成新。等待有緣人。";
		}	
	</script>
</body>
</html>