//會員資料修改_顯示會員資料
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
	
	//判斷是個人 or 社福，產生不同表格
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
					<input type="text" name="" value="${data.mb.indname}" class="form-control member_update_form_input ind_name" required>
				</div>
			</div>
			
			<!-- 身分 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
					&nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分
				</label>	
									
				<div class="col-sm-9" id="member_types">
					<select class="form-control member_update_form_input user_type">
						<option value="1">個人</option>
						<option value="2">社福團體</option>
					</select>
				</div>                                    
			</div>
			
			<!-- 會員帳號 -->
			<div class="form-group  member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
					&nbsp會&nbsp&nbsp員&nbsp帳&nbsp&nbsp號
				</label>
									
				<div class="col-sm-9">
					<input type="text" value="${data.mb.indid}" class="form-control member_update_form_input ind_id" disabled>
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
					<button class="btn btn-block" id="passsword_update_button" data-toggle="modal" data-target="#password_update_modal">
						<b>修改會員密碼</b>									
					</button>		
				</div>
			</div>
			
			
			<!-- 連絡電話 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
					&nbsp連&nbsp&nbsp絡&nbsp電&nbsp&nbsp話
				</label>
										
				<div class="col-sm-9">
					<input type="tel" value="${data.mb.indphone}" class="form-control member_update_form_input ind_phone">
				</div>
			</div>
			
			<!-- 電子信箱 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					&nbsp電&nbsp&nbsp子&nbsp信&nbsp&nbsp箱 
				</label>
									
				<div class="col-sm-9">
					<input type="email" value="${data.mb.indemail}" class="form-control member_update_form_input ind_email">
				</div>
			</div>
			
			<!-- 地址 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址
				</label>
										
				<div class="col-sm-9">
					<input type="text" value="${data.mb.indaddress}" class="form-control member_update_form_input ind_address">
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
					<input type="file" value="" id="upload_img_ind" class="upload_img" accept="image/jpeg, image/png">
					<img src="${javaRoot}/_00_init/getImage?id=${data.mb.indid}&type=MEMBER" id="preview_img_ind" class="preview_img">		
				</div>
			</div>`;
			
			$('#member_update_form_horizontal').append(result_Mb);
			
			// 會員身分
			$(".user_type option[value=" + data.mb.usertype + "]").attr("selected", true);
			$(".user_type").attr("disabled", true);
			
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
					<input type="text" name="" value="${data.mb.indname}" class="form-control member_update_form_input ind_name" required>
				</div>
			</div>
			
			<!-- 身分 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
					&nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分
				</label>	
									
				<div class="col-sm-9" id="member_types">
					<select class="form-control member_update_form_input user_type">
						<option value="1">個人</option>
						<option value="2">社福團體</option>
					</select>
				</div>                                    
			</div>
			
			<!-- 會員帳號 -->
			<div class="form-group  member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-ban-circle form_input_disabled_icon" aria-hidden="true"></span>
					&nbsp會&nbsp&nbsp員&nbsp帳&nbsp&nbsp號
				</label>
									
				<div class="col-sm-9">
					<input type="text" value="${data.mb.indid}" class="form-control member_update_form_input ind_id" disabled>
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
					<button class="btn btn-block" id="passsword_update_button" data-toggle="modal" data-target="#password_update_modal">
						<b>修改會員密碼</b>									
					</button>		
				</div>
			</div>
			
			
			<!-- 連絡電話 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
					&nbsp連&nbsp&nbsp絡&nbsp電&nbsp&nbsp話
				</label>
										
				<div class="col-sm-9">
					<input type="tel" value="${data.mb.indphone}" class="form-control member_update_form_input ind_phone">
				</div>
			</div>
			
			<!-- 電子信箱 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					&nbsp電&nbsp&nbsp子&nbsp信&nbsp&nbsp箱 
				</label>
									
				<div class="col-sm-9">
					<input type="email" value="${data.mb.indemail}" class="form-control member_update_form_input ind_email">
				</div>
			</div>
			
			<!-- 地址 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					&nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址
				</label>
										
				<div class="col-sm-9">
					<input type="text" value="${data.mb.indaddress}" class="form-control member_update_form_input ind_address">
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
					<input type="text" value="${data.ob.leader}" class="form-control member_update_form_input org_leader">
				</div>
			</div>
			
			<!-- 社福團體類型 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
					&nbsp社福團體類型
				</label>
									
				<div class="col-sm-9">
					<select id="org_types" class="form-control member_update_form_input org_types">
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
					<input type="text" value="${data.ob.registerno}" class="form-control member_update_form_input org_registerno">
				</div>
			</div>
			
			<!-- 勸募許可文號 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
					&nbsp勸募許可文號
				</label>
										
				<div class="col-sm-9">
					<input type="text" value="${data.ob.raiseno}" class="form-control member_update_form_input org_raiseno">
				</div>
			</div>
			
			<!-- 社福團體網站 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
					&nbsp社福團體網站
				</label>
										
				<div class="col-sm-9">
					<input type="text" value="${data.ob.website}" class="form-control member_update_form_input org_website">
				</div>
			</div>
			
			<!-- 社福團體簡介 -->
			<div class="form-group member_update_form_group">
				<label class="control-label col-sm-3 member_update_form_label">
					<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
					&nbsp社福團體簡介
				</label>
									
				<div class="col-sm-9">
					<textarea class="form-control member_update_form_input org_intro" rows="5" Wrap="physical">${data.ob.intro}</textarea>
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
					<input type="file" value="" id="upload_img_ind" class="upload_img" accept="image/jpeg, image/png">
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
					<img src="${javaRoot}/_00_init/getImage?id=${data.ob.indid}&type=ORG" id="preview_img_org" class="preview_img">									
				</div>
			</div>
			
			<!-- 修改會員資料送出按鈕 -->
			<button type="submit" id="member_update_submit_button" class="btn btn-block member_update_submit_button">										
				<b>修&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp改</b>														
			</button>
			`;
		
		$('#member_update_form_horizontal').append(result_Ob);
		// 會員身分
		$(".user_type option[value=" + data.mb.usertype + "]").attr("selected", true);
		$(".user_type").attr("disabled", true);

		//	社福類型
		$(".org_types option[value=" + data.ob.orgtypes + "]").attr("selected", true);
	}
}


//修改會員資料_送出修改資料
function memberDataUpdate(){
	var update_ServletPath = javaRoot + '/web/_03_updateMember/controller/updateMember';
	var INDNAME = $(".ind_name").val();
	var USERTYPE = $(".user_type").val();
	var INDID = $(".ind_id").val();
	var INDPHONE = $(".ind_phone").val();
	var INDEMAIL = $(".ind_email").val();
	var INDADDRESS = $(".ind_address").val();
	var LEADER = $(".org_leader").val();
	var ORGTYPES = $(".org_types").val();
	var REGISTERNO = $(".org_registerno").val();
	var RAISENO = $(".org_raiseno").val();
	var WEBSITE = $(".org_website").val();
	var INTRO = $(".org_intro").val();

	
	// post傳資料(JSON格式)
	var memberDataUpdate_String = JSON.stringify({
		indName : INDNAME,
		usertype : USERTYPE,
		indid : INDID,
		indPhone : INDPHONE,
		indEmail : INDEMAIL,
		indAddress : INDADDRESS,
		leader : LEADER,
		orgtypes : ORGTYPES,
		registerno : REGISTERNO,
		raiseno : RAISENO,
		website : WEBSITE,
		intro : INTRO,
		indimage : Update_img_ind.result,
		orgimage : Update_img_org.result
	});
	
	console.log(" memberDataUpdate_String = " + memberDataUpdate_String);
	
	$.ajax({
		type: 'post',
		url: update_ServletPath,
		data: memberDataUpdate_String,
		dataType: 'json',
		success: function(response){
		//			console.log(response);
					// 出現錯誤訊息
					if(response.Ans == "TRUE"){
						alert("修改已送出，詳細資訊請至會員專區瀏覽");
						location.reload();
					} else {
						alert("發生了一點錯誤，請檢查您的傳送資料，謝謝!");
					}
				 },
		error: function(response){
					// 出現錯誤訊息
					alert("發生了一點錯誤，請重新載入頁面，謝謝!");
				}
	});	
}


//修改會員資料_修改密碼資料送出
function passwordUpdate(){
	var OLD_PASSWORD = $("#old_password_form_input").val();
	var NEW_PASSWORD = $("#new_password_form_input").val();
	var CHECK_NEWPASSWORD = $("#check_password_form_input").val();
	
	var passwordUpdate_ServletPath = javaRoot + '/web/_03_updateMember/controller/updateMemberPassword';
	var passwordUpdate_String = "?oldpassword=" + OLD_PASSWORD
							  + "&newpassword=" + NEW_PASSWORD
							  + "&checknewpassword=" + CHECK_NEWPASSWORD;
	
//	console.log(" passwordUpdate_String = " + passwordUpdate_String);
	
	$.ajax({
		type: 'post',
		url: passwordUpdate_ServletPath + passwordUpdate_String,
		data: "",
		dataType: 'json',
		success: function(response){
					if(response.Ans == "TRUE"){
						alert("密碼修改已送出");
						location.reload();
					} else {
						// 出現錯誤訊息
						alert("發生了一點錯誤，請檢查您的密碼是否正確，謝謝!");
					}
				 },
		error: function(response){
				  // 出現錯誤訊息
				  alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
			   }
	});	 
}