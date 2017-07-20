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
			
			<!-- 修改會員資料送出按鈕 -->
			<button type="submit" name="" value="" id="member_update_submit_button" class="btn btn-block">										
				<b>修&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp改</b>														
			</button>
			`;
		
		$('#member_update_form_horizontal').append(result_Ob);
		
		// 會員身分
		$("#member_types input[value=" + data.mb.usertype + "]").attr("checked", true);

		//	社福類型
		$("#org_types option[value=" + data.ob.orgtypes + "]").attr("selected", true);
	
	}
}


// 我的物資箱資料顯示
function showGCData(data, path){
	var javaRoot = path;
	var result_goodsCart;
	
	//錯誤訊息
	if(data.Ans == "FALSE"){
		result_goodsCart = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			尚無物資，請點上方"新增物資"按鈕！
		</div>`;
		$('#member_goodsCart_content').append(result_goodsCart);
		return;
	}
	
	// 清除先前的表格
	$("#member_goodsCart_content").empty();
	
	// 產生物資箱資料
	for(var i = 0; i < data.cgb.length; i++){
		result_goodsCart =
			`<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 block_goods_item">	
				<div class="thumbnail goods_item">
					
					<!-- 物資圖片 -->
					<img src="${javaRoot}/_00_init/getImage?id=${data.cgb[i].goodsno}&type=GOODS" class="goods_item_image">
					
					<!-- 物資內容 -->
					<div class="caption goods_item_caption">
					
						<!-- 物資_title -->
						<h3 class="goods_item_title">
							<b>${data.cgb[i].goodsname}</b>
						</h3>
							
						<!-- 物資_content -->
						<ul class="goods_item_content">
							<!-- 需求名稱 -->
							<li class="input-group goods_item_content_li">		
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-tag"></i>															
								</span>
								<input type="text" name="goods_name" value="${data.cgb[i].goodsname}" id="" class="form-control goods_item_content_li_input goods_name" disabled>
							</li>
							
							<!-- 物品類別 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-th-list"></i>
								</span>
															
								<select name="goods_type" class="form-control goods_item_content_li_input goods_type" disabled>
									<option value="1">食品</option>
									<option value="2">服飾配件</option>
									<option value="3">生活用品</option>
									<option value="4">家電機器</option>
									<option value="5">其他</option>
								</select>
							</li>
							
							<!-- 需求類別 -->
							<li class="input-group goods_item_content_li goods_status">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-list-alt"></i>
								</span>
								<input type="radio" name="goods_status" value="1" id="" class="radio-inline goods_item_content_li_input" disabled>募資
								<input type="radio" name="goods_status" value="2" id="" class="radio-inline goods_item_content_li_input" disabled>捐贈
								<input type="radio" name="goods_status" value="3" id="" class="radio-inline goods_item_content_li_input" disabled>以物易物														
							</li>
							
							<!-- 需求地區 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-map-marker"></i>
								</span>
								<!-- <input type="text" name="goods_loc" value="" id="" class="form-control goods_item_content_li_input" disabled> -->
															
								<select name="goods_loc" class="form-control goods_item_content_li_input goods_loc" disabled>																	
									<option value="1">苗栗縣</option>
									<option value="2">桃園市</option>
									<option value="4">新北市</option>
									<option value="6">新竹縣</option>
									<option value="7">臺北市</option>
									<option value="13">臺中市</option>
									<option value="15">高雄市</option>
								</select>
							</li>
							
							<!-- 需求數量 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-hourglass"></i>
								</span>
								<input type="text" name="goods_qty" value="${data.cgb[i].qty}" id="" class="form-control goods_item_content_li_input goods_qty" disabled>
							</li>					

							<!-- 截止時間 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-calendar"></i>
								</span>
								<input type="date" name="deadline" value="${data.cgb[i].deadlinestring}" id="" class="form-control goods_item_content_li_input deadline" disabled>														
							</li>
							
							<!-- 需求說明 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-edit"></i>
								</span>
								<input type="text" name="goods_note" value="${data.cgb[i].goodsnote}" class="form-control goods_item_content_li_input goods_note" disabled>
							</li>
							
							<!-- 按鈕 -->
							<li class="input-group goods_item_content_li">
								
								<!-- 刪除按鈕 -->
								<button class="btn btn-default goods_item_delete_button" value="${data.cgb[i].goodsno}">
									<span class="glyphicon glyphicon-trash"></span>
									<b>刪除</b>
								</button>
								
								<!-- 修改按鈕 -->
								<button class="btn btn-default goods_item_update_button">
									<span class="glyphicon glyphicon-pencil"></span>
									<b>修改</b>															
								</button>
								
								<!-- 送出按鈕 -->
								<button type="submit" class="btn btn-default goods_item_submit_button" value="${data.cgb[i].goodsno}">
									<span class="glyphicon glyphicon-pencil"></span>
									<b>送出</b>															
								</button>
									
							</li>
							
						</ul>
					</div>
				
				</div>
			</div>`;
				
		$('#member_goodsCart_content').append(result_goodsCart);
	}
}


// 修改物資箱資料
function goodsCartUpdate(goal, e){
	var gno = e;
	var gstatus = "";
	var gtype = goal.closest(".goods_item_content").find('.goods_type').val();
	var gname = goal.closest(".goods_item_content").find('.goods_name').val();
	var gloc = goal.closest(".goods_item_content").find('.goods_type').val();
	var gnote = goal.closest(".goods_item_content").find('.goods_note').val();
	var gqty = goal.closest(".goods_item_content").find('.goods_qty').val();
	var gshipway = 3;
	var gdeadline = goal.closest(".goods_item_content").find('.deadline').val();
	var goodsCartUpdateServletPath = javaRoot + '/web/_04_productMaintain/controller/GoodsUpdate';
	
//	console.log("gstatus = " + gstatus);
	var goodsCartUpdateDataString = "?goodsno=" + gno 
					+ "&goodsstatus=" + gstatus 
					+ "&goodstype=" + gtype 
					+ "&goodsname=" + gname 
					+ "&goodsloc=" + gloc 
					+ "&goodsnote=" + gnote 
					+ "&qty=" + gqty
					+ "&goodsshipway=3&deadline=" + gdeadline;

	$.ajax({
		type: 'post',
		url: goodsCartUpdateServletPath + goodsCartUpdateDataString,
		data: "",
		dataType: 'json',
		success: function(response){
			// 出現錯誤訊息
			if(response.Ans == "TRUE"){
//				 修改按鈕出現，表單不可修改、背景變藍色，送出按鈕消失  
				$(this).closest(".goods_item_content_li").find(".goods_item_update_button").show();
				$(this).closest(".goods_item_content").find("input").attr("disabled", true);
				$(this).closest(".goods_item_content").find("select").attr("disabled", true);
				$(this).closest(".goods_item_content").find(".goods_item_content_li_input").css("background-color", "#A3DAFF").css("border-radius", "0px");
				$(this).hide();
				alert("資料已送出");
			} else {
				alert("發生了一點錯誤，請檢查資料是否正確，並重新送出，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}