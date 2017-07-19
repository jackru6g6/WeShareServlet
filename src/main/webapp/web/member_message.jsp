<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
				<div class="col-xs-8 col-sm-6 col-md-6 col-lg-6">
					<button type="button" name="" value="" id="message_insert_button" class="btn btn-block" data-toggle="modal" data-target="#message_insert_modal">
						<span class="glyphicon glyphicon-edit"></span>
						<b>撰寫站內信</b>
					</button>										

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
													
													<script>
														$(document).ready(function(){
			
															$("#upload_img_message").change(function(){
																
																if (this.files && this.files[0]) {
																	var reader = new FileReader();
																	
																	reader.onload = function (e) {
																		$("#preview_img_message").attr("src", e.target.result);
																	}
																	
																	reader.readAsDataURL(this.files[0]);
																}
																
															});
			
														}) ;
													</script>
									
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
				</div>
				
				<!-- 排序選項 -->
				<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2">
					<div class="dropdown">
						<button type="button" name="" value="" id="message_priority_button" class="btn btn-block dropdown-toggle" data-toggle="dropdown">
							排序
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">依時間排序</a></li>
							<li><a href="#">依寄件人排序</a></li>
							<li><a href="#">依收件人排序</a></li>
						</ul>
					</div>
				</div>
				
				<!-- 查詢欄位 -->
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<div class="input-group" id="message_search_bar">
						<input type="search" name="" value="" class="form-control" id="message_search_bar_input">
						<span class="input-group-btn">
							<button type="button" name="" value="" id="message_search_button" class="btn btn-block">
								<span class="glyphicon glyphicon-search"></span>
								搜尋
							</button>
						</span>
					</div>	
				</div>
				
			</div> 
			
			<!-- 站內信_table -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				
				
				
				
				
				
				</div>								
			</div>
		
		</div>
	</div>
	
	<!-- footer -->
	<div class="row">
		<div id="member_message_content_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">	
		</div>
	</div>
		
	
	