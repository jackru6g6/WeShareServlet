<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
				<div class="col-xs-8 col-sm-6 col-md-6 col-lg-6">
					
					<!-- 我的物資車_新增按鈕 -->
					<button type="button" name="" value="" id="goods_insert_button" class="btn btn-block" data-toggle="modal" data-target="#goods_insert_modal">
						<span class="glyphicon glyphicon-plus-sign"></span>
						<b>新增物資</b>
					</button>
					
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
									<form id="goods_insert_form_horizontal" class="form-horizontal " action="">
										<!-- 需求名稱 -->
										<div class="form-group goods_insert_form_group">																			
											<label class="control-label col-sm-3 goods_insert_form_label">														
												<span class="glyphicon glyphicon-tag"></span>
												&nbsp需&nbsp求&nbsp名&nbsp稱&nbsp &nbsp													
											</label>
																		
											<div class="col-sm-9">
												<input type="text" name="goods_name" value="" id="" class="form-control goods_insert_form_input">
											</div>																
										</div>
										
										<!-- 物品類別 -->
										<div class="form-group goods_insert_form_group">
											<label class="control-label col-sm-3 goods_insert_form_label">
												<span class="glyphicon glyphicon-th-list"></span>
												&nbsp物&nbsp品&nbsp類&nbsp別&nbsp &nbsp
											</label>
																		
											<div class="col-sm-9">
												<select name="goods_type" id="" class="form-control goods_insert_form_input">
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
												<input type="radio" name="goods_status" value="1" id="goods_status" class="radio-inline">募資
												<input type="radio" name="goods_status" value="2" id="goods_status" class="radio-inline">捐贈
												<input type="radio" name="goods_status" value="3" id="goods_status" class="radio-inline">以物易物
											</div>
										</div>
										
										<!-- 需求地區 -->
										<div class="form-group goods_insert_form_group">
											<label class="control-label col-sm-3 goods_insert_form_label">
												<span class="glyphicon glyphicon-map-marker"></span>
												&nbsp需&nbsp求&nbsp地&nbsp區&nbsp &nbsp
											</label>
																										
											<div class="col-sm-9">
												<select name="goods_loc" id="" class="form-control goods_insert_form_input" required>																	
<!-- 													<option class="goods_loc_disabled_option" disabled>北部</option> -->
													<option value="1">苗栗縣</option>
													<option value="2">桃園市</option>
<!-- 													<option value="3">基隆市</option> -->
													<option value="4">新北市</option>
<!-- 													<option value="5">新竹市</option> -->
													<option value="6">新竹縣</option>
													<option value="7">臺北市</option>
																				
<!-- 													<option class="goods_loc_disabled_option" disabled>中部</option> -->
<!-- 													<option value="8">南投縣</option> -->
<!-- 													<option value="9">雲林縣</option> -->
<!-- 													<option value="10">嘉義市</option> -->
<!-- 													<option value="11">嘉義縣</option> -->
<!-- 													<option value="12">彰化縣</option> -->
													<option value="13">臺中市</option>
																				
<!-- 													<option class="goods_loc_disabled_option" disabled>南部</option> -->
<!-- 													<option value="14">屏東縣</option> -->
													<option value="15">高雄市</option>
<!-- 													<option value="16">臺南市</option> -->
																				
<!-- 													<option class="goods_loc_disabled_option" disabled>東部</option> -->
<!-- 													<option value="17">宜蘭縣</option> -->
<!-- 													<option value="18">花蓮縣</option> -->
<!-- 													<option value="19">臺東縣</option> -->
																				
<!-- 													<option class="goods_loc_disabled_option" disabled>離島</option> -->
<!-- 													<option value="20">金門縣</option> -->
<!-- 													<option value="21">連江縣</option> -->
<!-- 													<option value="22">澎湖縣</option> -->
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
												<input type="number" name="qty" value="" id="" class="form-control goods_insert_form_input" min="1">
											</div>
										</div>
										
										<!-- 需求方式 -->
										<div class="form-group goods_insert_form_group">
											<label class="control-label col-sm-3 goods_insert_form_label">
												<span class="glyphicon glyphicon-plane"></span>
												&nbsp需&nbsp求&nbsp方&nbsp式&nbsp &nbsp
											</label>
																		
											<div class="col-sm-9">
												<input type="radio" name="goods_shipway" value="1" id="goods_shipway" class="radio-inline">面交
												<input type="radio" name="goods_shipway" value="2" id="goods_shipway" class="radio-inline">物流
												<input type="radio" name="goods_shipway" value="3" id="goods_shipway" class="radio-inline">皆可
											</div>
										</div>
										
										<!-- 截止時間 -->
										<div class="form-group goods_insert_form_group">
											<label class="control-label col-sm-3 goods_insert_form_label">
												<span class="glyphicon glyphicon-calendar"></span>
												&nbsp截&nbsp止&nbsp時&nbsp間&nbsp &nbsp 
											</label>
																		
											<div class="col-sm-9">
												<input type="date" name="deadline" value="" id="" class="form-control goods_insert_form_input">
											</div>
										</div>
										
										<!-- 需求說明 -->
										<div class="form-group goods_insert_form_group">
											<label class="control-label col-sm-3 goods_insert_form_label">
												<span class="glyphicon glyphicon-edit"></span>
												&nbsp需&nbsp求&nbsp說&nbsp明&nbsp &nbsp
											</label>
																		
											<div class="col-sm-9">
												<textarea name="" value="" class="form-control goods_insert_form_input" rows="5"  Wrap="physical"></textarea>
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
										
										<!-- 新增物資按鈕 -->
										<button type="submit" name="" value="" id="goods_insert_form_submit_button" class="btn btn-block" data-dismiss="modal">
											<b>新&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp增</b>
										</button>															
<!-- 										</button> -->
										
									</form>
								</div>
								
								<!-- 新增物資視窗_footer -->
								<div class="modal-footer" id="goods_insert_modal_footer"></div>
								
							</div>
						</div>
					</div>					
				</div>
				
				<!-- 排序選項 -->
				<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2">
					<div class="dropdown">
						<button type="button" name="" value="" id="goods_priority_button" class="btn btn-block dropdown-toggle" data-toggle="dropdown">
							排序
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">依時間排序</a></li>
							<li><a href="#">依地區排序</a></li>
							<li><a href="#">依數量排序</a></li>
						</ul>
					</div>
				</div>
				
				<!-- 查詢欄位 -->
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
					<div class="input-group" id="goods_search_bar">
						<input type="search" name="" value="" class="form-control" id="goods_search_bar_input">
						<span class="input-group-btn">
							<button type="button" name="" value="" id="goods_search_button" class="btn btn-block">
								<span class="glyphicon glyphicon-search"></span>
								搜尋
							</button>
						</span>
					</div>	
				</div>
				
			</div>
			
			<!-- 我的物資箱內容 -->
			<div class="row" id="member_goodsCart_content">
			
			</div>
		</div>
	</div>
	
	
	<!-- footer -->
	<div class="row">
		<div id="goods_insert_modal_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">						
		</div>
	</div>