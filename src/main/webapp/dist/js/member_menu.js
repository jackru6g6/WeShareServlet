//會員資料修改
function showMbData(data, path){
	var javaRoot = path;
	var result_Mb; //個人會員
	var result_Ob; //社福會員
	
	//錯誤訊息
	if(data.Ans == "FALSE"){
		result_Mb = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到資料唷~請重新進入此頁！
		</div>`;
		$('#member_update_form_horizontal').append(result_Mb);
		return;
	}
	
	// 清除先前的表格
	$("#member_update_form_horizontal").empty();
	
	
	//判斷是個人 or 社福
	if(data.mb.usertype == 1){
		// 個人會員表格	
		result_Mb =
			`<!-- 姓名 -->
			<div class="form-group member_update_form_group">
				<label id="" class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					&nbsp姓&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp名															
				</label>
									
				<div class="col-sm-9">
					<input type="text" name="" value="${data.mb.indname}" id="" class="form-control member_update_form_input" required>
				</div>
			</div>
			
			<!-- 身分 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
					&nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分
				</label>	
									
				<div id="member_types" class="col-sm-9">
					<input type="radio" name="usertypes" value="1" id="" class="radio-inline member_update_form_input" disabled>個人
					<input type="radio" name="usertypes" value="2" id="" class="radio-inline member_update_form_input" disabled>社福團體
				</div>                                    
			</div>
			
			<!-- 會員帳號 -->
			<div class="form-group  member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
					&nbsp會&nbsp&nbsp員&nbsp帳&nbsp&nbsp號
				</label>
									
				<div class="col-sm-9">
					<input type="text" name="" value="${data.mb.indid}" id="" class="form-control member_update_form_input" disabled>
				</div>
			</div>
			
			<!-- 會員密碼 -->
			<!-- 按下修改密碼按鈕滑出修改表單 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
					&nbsp會&nbsp&nbsp員&nbsp密&nbsp&nbsp碼
				</label>
									
				<div class="col-sm-9">
										
					<button class="btn btn-block" id="passsword_update_button">
						<b>修改會員密碼</b>
											
						<script>
						$(document).ready(function(){
																
							$( "#passsword_update_button" ).click(function() {
																
								$("#passsword_update_content").slideToggle();
																  
							});
																
						}) ;																
						</script>
																		
					</button>	
										
					<ul id="passsword_update_content">
						<li>
							<label class="control-label col-sm-3">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								請輸入舊密碼
							</label>
							<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">
						</li>
												
						<li>
							<label class="control-label col-sm-3">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								請輸入新密碼
							</label>
							<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">												
						</li>
												
						<li>
							<label class="control-label col-sm-3">
								<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								再次確認密碼
							</label>
							<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">											
						</li>													
					</ul>
										
				</div>
			</div>
			
			<!-- 連絡電話 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
					&nbsp連&nbsp&nbsp絡&nbsp電&nbsp&nbsp話
				</label>
										
				<div class="col-sm-9">
					<input type="tel" name="" value="${data.mb.indphone}" id="" class="form-control member_update_form_input">
				</div>
			</div>
			
			<!-- 電子信箱 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					&nbsp電&nbsp&nbsp子&nbsp信&nbsp&nbsp箱 
				</label>
									
				<div class="col-sm-9">
					<input type="email" name="" value="${data.mb.indemail}" id="" class="form-control member_update_form_input">
				</div>
			</div>
			
			<!-- 地址 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址
				</label>
										
				<div class="col-sm-9">
					<input type="text" name="" value="${data.mb.indaddress}" id="" class="form-control member_update_form_input">
				</div>
			</div>
			
			<!-- 會員照片 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
					&nbsp會&nbsp&nbsp員&nbsp照&nbsp&nbsp片
				</label>
									
				<!-- 上傳及預覽檔案 -->
				<div class="col-sm-9">
					<input type="file" name="" value="" id="upload_img_ind" class="upload_img" accept="image/jpeg, image/png">
					<img src="${javaRoot}/_00_init/getImage?id=${data.mb.indid}&type=MEMBER" id="preview_img_ind" class="preview_img">
										
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
										
				</div>
			</div>
			
			<!-- 修改會員資料送出按鈕 -->
			<button type="submit" name="" value="" id="member_update_submit_button" class="btn btn-block">										
				<b>修&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp改</b>														
			</button>
			`;
			
			$('#member_update_form_horizontal').append(result_Mb);
			// 會員身分
			$("#member_types input[value=" + data.mb.usertype + "]").attr("checked", true);
			return;
			
	} else {
	
	// 社福會員表格
	result_Ob = 
		`<!-- 姓名 -->
		<div class="form-group member_update_form_group">
			<label id="" class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				&nbsp姓&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp名															
			</label>
								
			<div class="col-sm-9">
				<input type="text" name="" value="${data.mb.indname}" id="" class="form-control member_update_form_input" required>
			</div>
		</div>
		
		<!-- 身分 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
				&nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分
			</label>	
								
			<div id="member_types" class="col-sm-9">
				<input type="radio" name="usertypes" value="1" id="" class="radio-inline member_update_form_input" disabled>個人
				<input type="radio" name="usertypes" value="2" id="" class="radio-inline member_update_form_input" disabled>社福團體
			</div>                                    
		</div>
		
		<!-- 會員帳號 -->
		<div class="form-group  member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
				&nbsp會&nbsp&nbsp員&nbsp帳&nbsp&nbsp號
			</label>
								
			<div class="col-sm-9">
				<input type="text" name="" value="${data.mb.indid}" id="" class="form-control member_update_form_input" disabled>
			</div>
		</div>
		
		<!-- 會員密碼 -->
		<!-- 按下修改密碼按鈕滑出修改表單 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
				&nbsp會&nbsp&nbsp員&nbsp密&nbsp&nbsp碼
			</label>
								
			<div class="col-sm-9">
									
				<button class="btn btn-block" id="passsword_update_button">
					<b>修改會員密碼</b>									
				</button>	
									
				<ul id="passsword_update_content">
					<li>
						<label class="control-label col-sm-3">
							<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
							請輸入舊密碼
						</label>
						<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">
					</li>
											
					<li>
						<label class="control-label col-sm-3">
							<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
							請輸入新密碼
						</label>
						<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">												
					</li>
											
					<li>
						<label class="control-label col-sm-3">
							<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
							再次確認密碼
						</label>
						<input type="password" name="ind_password" value="" id="" class="form-control member_update_form_input">											
					</li>													
				</ul>
									
			</div>
		</div>
		
		<!-- 連絡電話 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
				&nbsp連&nbsp&nbsp絡&nbsp電&nbsp&nbsp話
			</label>
									
			<div class="col-sm-9">
				<input type="tel" name="" value="${data.mb.indphone}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 電子信箱 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
				&nbsp電&nbsp&nbsp子&nbsp信&nbsp&nbsp箱 
			</label>
								
			<div class="col-sm-9">
				<input type="email" name="" value="${data.mb.indemail}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 地址 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
				&nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址
			</label>
									
			<div class="col-sm-9">
				<input type="text" name="" value="${data.mb.indaddress}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 社福團體需要多填的表格 -->
		
		<!-- 負責人 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
				&nbsp負&nbsp &nbsp &nbsp責&nbsp &nbsp &nbsp人
			</label>
									
			<div class="col-sm-9">
				<input  type="text" name="" value="${data.ob.leader}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 社福團體類型 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
				&nbsp社福團體類型
			</label>
								
			<div class="col-sm-9">
				<select name="" id="org_types" class="form-control member_update_form_input">
					<option value="1">兒少福利</option>
					<option value="2">偏鄉教育</option>
					<option value="3">老人福利</option>
					<option value="4">身障福利</option>
					<option value="5">其他</option>
				</select>
			</div>
		</div>
		
		<!-- 核准立案字號 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-saved" aria-hidden="true"></span>
				&nbsp核准立案字號 
			</label>
								
			<div class="col-sm-9">
				<input type="text" name="" value="${data.ob.registerno}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 勸募許可文號 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
				&nbsp勸募許可文號
			</label>
									
			<div class="col-sm-9">
				<input type="text" name="" value="${data.ob.raiseno}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 社福團體網站 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
				&nbsp社福團體網站
			</label>
									
			<div class="col-sm-9">
				<input type="text" name="" value="${data.ob.website}" id="" class="form-control member_update_form_input">
			</div>
		</div>
		
		<!-- 社福團體簡介 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				&nbsp社福團體簡介
			</label>
								
			<div class="col-sm-9">
				<textarea name="" value="${data.ob.intro}" id="" class="form-control member_update_form_input" rows="5" Wrap="physical"></textarea>
			</div>
		</div>
		
		<!-- 會員照片 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
				&nbsp會&nbsp&nbsp員&nbsp照&nbsp&nbsp片
			</label>
								
			<!-- 上傳及預覽檔案 -->
			<div class="col-sm-9">
				<input type="file" name="" value="" id="upload_img_ind" class="upload_img" accept="image/jpeg, image/png">
				<img src="${javaRoot}/_00_init/getImage?id=${data.mb.indid}&type=MEMBER" id="preview_img_ind" class="preview_img">		
			</div>
		</div>
		
		<!-- 社福簡介照片 -->
		<div class="form-group member_update_form_group">
			<label class="control-label col-sm-3 member_update_form_label">
				<span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
				&nbsp社福簡介照片
			</label>
								
			<!-- 上傳及預覽檔案 -->
			<div class="col-sm-9">
				<input type="file" name="" value="" id="upload_img_org" class="upload_img" accept="image/jpeg, image/png">
				<img src="${javaRoot}/_00_init/getImage?id=${data.ob.orgfilename}&type=ORG" id="preview_img_org" class="preview_img">									
			</div>
		</div>
		`;
	
	$('#member_update_form_horizontal').append(result_Ob);
	
	}
	
	// 會員身分
	$("#member_types input[value=" + data.mb.usertype + "]").attr("checked", true);

	//	社福類型
	$("#org_types option[value=" + data.ob.orgtypes + "]").attr("selected", true);
	
}