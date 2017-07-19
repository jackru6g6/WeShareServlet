<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


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
		
			<form id="member_update_form_horizontal" class="form-horizontal" action="">
				
<!-- 				姓名 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-user" aria-hidden="true"></span> -->
<!-- 						&nbsp姓&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp名															 -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="text" name="ind_name" value="" id="" class="form-control member_update_form_input" required> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				身分 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span> -->
<!-- 						&nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分 -->
<!-- 					</label>	 -->
										
<!-- 					<div id="member_types" class="col-sm-9"> -->
<!-- 						<input type="radio" name="member_types" value="ind" id="" class="radio-inline member_update_form_input" disabled>個人 -->
<!-- 						<input type="radio" name="member_types" value="org" id="" class="radio-inline member_update_form_input" disabled>社福團體 -->
<!-- 					</div>                                     -->
<!-- 				</div> -->
				
<!-- 				會員帳號 -->
<!-- 				<div class="form-group  member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span> -->
<!-- 						&nbsp會&nbsp&nbsp員&nbsp帳&nbsp&nbsp號 -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="text" name="ind_id" value="" id="" class="form-control member_update_form_input" disabled> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				會員密碼 -->
<!-- 				按下修改密碼按鈕滑出修改表單 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> -->
<!-- 						&nbsp會&nbsp&nbsp員&nbsp密&nbsp&nbsp碼 -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
											
<!-- 						<button class="btn btn-block" id="passsword_update_button"> -->
<!-- 							<b>修改會員密碼</b> -->
												

																			
<!-- 						</button>	 -->
											
<!-- 						<ul id="passsword_update_content"> -->
<!-- 							<li> -->
<!-- 								<label class="control-label col-sm-3"> -->
<!-- 									<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> -->
<!-- 									請輸入舊密碼 -->
<!-- 								</label> -->
<!-- 								<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input"> -->
<!-- 							</li> -->
													
<!-- 							<li> -->
<!-- 								<label class="control-label col-sm-3"> -->
<!-- 									<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> -->
<!-- 									請輸入新密碼 -->
<!-- 								</label> -->
<!-- 								<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">												 -->
<!-- 							</li> -->
													
<!-- 							<li> -->
<!-- 								<label class="control-label col-sm-3"> -->
<!-- 									<span class="glyphicon glyphicon-lock" aria-hidden="true"></span> -->
<!-- 									再次確認密碼 -->
<!-- 								</label> -->
<!-- 								<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">											 -->
<!-- 							</li>													 -->
<!-- 						</ul> -->
											
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				連絡電話 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> -->
<!-- 						&nbsp連&nbsp&nbsp絡&nbsp電&nbsp&nbsp話 -->
<!-- 					</label> -->
											
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="tel" name="ind_phone" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				電子信箱 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> -->
<!-- 						&nbsp電&nbsp&nbsp子&nbsp信&nbsp&nbsp箱  -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="email" name="ind_email" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				地址 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-home" aria-hidden="true"></span> -->
<!-- 						&nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址 -->
<!-- 					</label> -->
											
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="text" name="ind_address" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				社福團體需要多填的表格 -->
				
<!-- 				負責人 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> -->
<!-- 						&nbsp負&nbsp &nbsp &nbsp責&nbsp &nbsp &nbsp人 -->
<!-- 					</label> -->
											
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input  type="text" name="leader" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				社福團體類型 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-tag" aria-hidden="true"></span> -->
<!-- 						&nbsp社福團體類型 -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
<!-- 						<select name="org_types" id="" class="form-control member_update_form_input"> -->
<!-- 							<option value="1">兒少福利</option> -->
<!-- 							<option value="2">偏鄉教育</option> -->
<!-- 							<option value="3">老人福利</option> -->
<!-- 							<option value="4">身障福利</option> -->
<!-- 							<option value="5">其他</option> -->
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				核准立案字號 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-saved" aria-hidden="true"></span> -->
<!-- 						&nbsp核准立案字號  -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="text" name="register_no" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				勸募許可文號 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-heart" aria-hidden="true"></span> -->
<!-- 						&nbsp勸募許可文號 -->
<!-- 					</label> -->
											
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="text" name="raise_no" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				社福團體網站 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-globe" aria-hidden="true"></span> -->
<!-- 						&nbsp社福團體網站 -->
<!-- 					</label> -->
											
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="text" name="raise_no" value="" id="" class="form-control member_update_form_input"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				社福團體簡介 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> -->
<!-- 						&nbsp社福團體簡介 -->
<!-- 					</label> -->
										
<!-- 					<div class="col-sm-9"> -->
<!-- 						<textarea name="intro" value="" id="" class="form-control member_update_form_input" rows="5" Wrap="physical"></textarea> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				會員照片 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-picture" aria-hidden="true"></span> -->
<!-- 						&nbsp會&nbsp&nbsp員&nbsp照&nbsp&nbsp片 -->
<!-- 					</label> -->
										
<!-- 					上傳及預覽檔案 -->
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="file" name="file1" value="" id="upload_img_ind" class="upload_img" accept="image/jpeg, image/png"> -->
<!-- 						<img id="preview_img_ind" class="preview_img"> -->
											

											
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				社福簡介照片 -->
<!-- 				<div class="form-group member_update_form_group"> -->
<!-- 					<label class="control-label col-sm-3 member_update_form_label"> -->
<!-- 						<span class="glyphicon glyphicon-camera" aria-hidden="true"></span> -->
<!-- 						&nbsp社福簡介照片 -->
<!-- 					</label> -->
										
<!-- 					上傳及預覽檔案 -->
<!-- 					<div class="col-sm-9"> -->
<!-- 						<input type="file" name="file2" value="" id="upload_img_org" class="upload_img" accept="image/jpeg, image/png"> -->
<!-- 						<img id="preview_img_org" class="preview_img"> -->
											

											
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				修改會員資料送出按鈕 -->
<!-- 				<button type="submit" name="" value="" id="member_update_submit_button" class="btn btn-block">										 -->
<!-- 					<b>修&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp改</b>														 -->
<!-- 				</button> -->
				
			</form>
		
		</div>
	</div>
	
	<!-- footer -->
	<div class="row">
		<div id="member_update_content_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">
		</div>
	</div>
	
<!-- 按下修改密碼按鈕	 -->
<!-- <script> -->
<!-- $(document).ready(function(){ -->
									
<!-- 	$( "#passsword_update_button" ).click(function() { -->
									
<!-- 		$("#passsword_update_content").slideToggle(); -->
									  
<!-- 	}); -->
									
<!-- }) ;																 -->
<!-- </script> -->

<!-- 上傳及預覽社福圖片 -->
<script>
		$(document).ready(function(){

			$("#upload_img_org").change(function(){
								
				if (this.files && this.files[0]) {
					var reader = new FileReader();
									
					reader.onload = function (e) {
						$("#preview_img_org").attr("src", e.target.result);
					}
									
					reader.readAsDataURL(this.files[0]);
				}
								
			});

		}) ;
</script>

<!-- 上傳及預覽個人圖片 -->
<script>
		$(document).ready(function(){

			$("#upload_img_ind").change(function(){
								
				if (this.files && this.files[0]) {
					var reader = new FileReader();
									
					reader.onload = function (e) {
						$("#preview_img_ind").attr("src", e.target.result);
					}
									
					reader.readAsDataURL(this.files[0]);
				}
								
			});

		}) ;
</script>