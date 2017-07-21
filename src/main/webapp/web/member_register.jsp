<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<div class="container">
		<div class="modal-dialog modal-lg">
			<!-- 會員註冊視窗內容 -->
			<div class="modal-content">
			
				<!-- 註冊視窗header -->
				<div class="modal-header" id="register_modal_header">
					<!-- 標題及關閉符號(X) -->
					<button type="button" class="close" data-dismiss="modal" id="modal_header_close">&times;</button>
					<h4 class="modal-title" id="register_modal_title">會員註冊</h4>
				</div>
				
				<!-- 註冊視窗body -->
				<div class="modal-body">
				
					<!-- 會員註冊表單 -->
					<form id="register_modal_form_horizontal" class="form-horizontal" ENCTYPE="multipart/form-data" method="POST" action="<c:url value='/_01_register/registery.do' />">
							
						<!-- 姓名 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
								&nbsp姓&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp名															
							</label>
							
							<div class="col-sm-9">
								<input type="text" name="indname" value="${param.indname}" id="" class="form-control register_form_input" placeholder="請輸入您的姓名 (必填欄位)" required>
							</div>
						</div>
						
						<!-- 身分 radio-->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
								&nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分
							</label>	
							
							<div id="member_types" class="col-sm-9">
								<input type="radio" name="usertype" value="1" id="register_member_type_ind" class="radio-inline" checked>個人
								<input type="radio" name="usertype" value="2" id="register_member_type_org" class="radio-inline">社福團體
							</div>                                    
						</div>
						
						<!-- 會員帳號 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
								&nbsp會&nbsp&nbsp員&nbsp帳&nbsp&nbsp號
							</label>
							
							<div class="col-sm-9">
								<input type="text" name="indid" value="${param.indid}" id="" class="form-control register_form_input" placeholder="請輸入您的會員帳號 (必填欄位)" required>
							</div>
						</div>
						
						<!-- 會員密碼 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								&nbsp會&nbsp員&nbsp密&nbsp碼&nbsp &nbsp
							</label>
							
							<div class="col-sm-9">
								<input type="password" name="indpassword" value="${param.indpassword}" id="" class="form-control register_form_input" placeholder="請輸入您的會員密碼 (必填欄位)" required>
							</div>
						</div>
						
						<!-- 密碼確認 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								&nbsp密&nbsp碼&nbsp確&nbsp認&nbsp &nbsp 
							</label>
							
							<div class="col-sm-9">
								<input type="password" name="indpassword2" value="${param.indpassword2}" id="" class="form-control register_form_input" placeholder="請再次輸入您的會員密碼 (必填欄位)" required>
							</div>
						</div>
						
						<!-- 連絡電話 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
								&nbsp連&nbsp&nbsp絡&nbsp電&nbsp&nbsp話
							</label>
								
							<div class="col-sm-9">
								<input type="tel" name="indphone" value="${param.indphone}" id="" class="form-control register_form_input" placeholder="02-12345678">
							</div>
						</div>
						
						<!-- 電子信箱 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
								&nbsp電&nbsp&nbsp子&nbsp信&nbsp&nbsp箱 
							</label>
							
							<div class="col-sm-9">
								<input type="email" name="indemail" value="${param.indemail}" id="" class="form-control register_form_input" placeholder="example@email.com">
							</div>
						</div>
						
						<!-- 地址 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
								&nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址
							</label>
								
							<div class="col-sm-9">
								<input type="text" name="indaddress" value="${param.indaddress}" id="" class="form-control register_form_input" placeholder="O縣O市O區O路O巷O號">
							</div>
						</div>
						
						<!-- 社福團體需要多填的表格 -->
								
						<!-- 負責人 -->
						<div class="form-group register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								&nbsp負&nbsp &nbsp &nbsp責&nbsp &nbsp &nbsp人
							</label>
								
							<div class="col-sm-9">
								<input  type="text" name="leader" value="${param.leader}" id="" class="form-control register_form_input" placeholder="請輸入負責人姓名  (必填欄位)">
							</div>
						</div>
						
						<!-- 社福團體類型 -->
						<div class="form-group register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
								&nbsp社福團體類型
							</label>
							
							<div class="col-sm-9">
								<select name="org_types" id="" class="form-control register_form_input">
									<option value="1">兒少福利</option>
									<option value="2">偏鄉教育</option>
									<option value="3">老人福利</option>
									<option value="4">身障福利</option>
									<option value="5">其他</option>
								</select>
							</div>
						</div>
						
						<!-- 核准立案字號 -->
						<div class="form-group register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>
								&nbsp核准立案字號 
							</label>
							
							<div class="col-sm-9">
								<input type="text" name="registerno" value="${param.registerno}" id="" class="form-control register_form_input" placeholder="OO字第000000000號">
							</div>
						</div>
						
						<!-- 勸募許可文號 -->
						<div class="form-group register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
								&nbsp勸募許可文號
							</label>
								
							<div class="col-sm-9">
								<input type="text" name="raiseno" value="${param.raiseno}" id="" class="form-control register_form_input" placeholder="OO字第000000000號">
							</div>
						</div>
						
						<!-- 社福團體網站 -->
						<div class="form-group register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								&nbsp社福團體網站
							</label>
								
							<div class="col-sm-9">
								<input type="text" name="website" value="${param.website}" id="" class="form-control register_form_input">
							</div>
						</div>
						
						<!-- 社福團體簡介 -->
						<div class="form-group  register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
								&nbsp社福團體簡介
							</label>
							
							<div class="col-sm-9">
								<textarea name="intro" value="${param.intro}" id="" class="form-control register_form_input" rows="5" Wrap="physical" placeholder="請輸入社福團體簡介...(必填欄位)"></textarea>
							</div>
						</div>
						
						
						
						
						
						
						
						
						<!-- 會員照片 -->
						<div class="form-group register_form_group ind">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
								&nbsp會&nbsp&nbsp員&nbsp照&nbsp&nbsp片
							</label>
							
							<div class="col-sm-9">
								<input type="file" name="file1" value="" id="register_upload_img_ind" class="upload_img" accept="image/jpeg, image/png">
								<img id="register_preview_img_ind" class="preview_img">
							</div>
						</div>
						
						<!-- 社福簡介照片 -->
						<div class="form-group register_form_group org">
							<label class="control-label col-sm-3 register_form_label">
								<span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
								&nbsp社福簡介照片
							</label>
							
							<div class="col-sm-9">
								<input type="file" name="file2" value="" id="register_upload_img_org" class="upload_img" accept="image/jpeg, image/png">
								<img id="register_preview_img_org" class="preview_img">
							</div>
						</div>
						
						
						
						
						
						
						<!-- 隱私權政策 -->
						<input type="checkbox" name="" value="" id="check_privacy" required> 
						<label>我已詳閱本站的<a href="#">隱私權政策</a></label>
						<br>
						
						<!-- 會員註冊按鈕 -->
						<button type="submit" name="" value="" id="register_submit_button" class="btn btn-block">										
							<b>註&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp冊</b>														
						</button>
						
					</form>								
				</div>
				
				<!-- 註冊視窗footer -->
				<div class="modal-footer" id="register_modal_footer"></div>
						
			</div>
		</div>
	</div>	




	<!-- 會員身分判斷  -->
	<script>
		$(document).ready(function(){
			// 點選org，出現隱藏的org表單
			$("#register_member_type_org").click(function(){
				$(".org").show();
			});
			
			// 點選ind，隱藏的org表單
			$("#register_member_type_ind").click(function(){
				$(".org").hide();
			});
			
		});
	</script>
	
	<!-- 會員圖片_上傳及預覽檔案 -->
	<script>
		$(document).ready(function(){

			$("#register_upload_img_ind").change(function(){
				
				if (this.files && this.files[0]) {
					var reader = new FileReader();
					
					reader.onload = function (e) {
						$("#register_preview_img_ind").attr("src", e.target.result);
					}
					
					reader.readAsDataURL(this.files[0]);
				}
				
			});

		}) ;
	</script>
	
	<!-- 社福圖片_上傳及預覽檔案 -->
	<script>
		$(document).ready(function(){

			$("#register_upload_img_org").change(function(){
				
				if (this.files && this.files[0]) {
					var reader = new FileReader();
					
					reader.onload = function (e) {
						$("#register_preview_img_org").attr("src", e.target.result);
					}
					
					reader.readAsDataURL(this.files[0]);
				}
				
			});

		}) ;
	</script>
