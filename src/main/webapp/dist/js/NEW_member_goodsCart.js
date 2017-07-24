// 我的物資箱_顯示物資內容
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
															
								<select id="goods_type` + i + `" name="goods_type" class="form-control goods_item_content_li_input goods_type" disabled>
									<option value="1">食品</option>
									<option value="2">服飾配件</option>
									<option value="3">生活用品</option>
									<option value="4">家電機器</option>
									<option value="5">其他</option>
								</select>
							</li>
							
							<!-- 需求類別 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-list-alt"></i>
								</span>
								
								<select id="goods_status`+ i +`" class="form-control goods_item_content_li_input goods_status" disabled>
									<option value="1">募資</option>
									<option value="2">捐贈</option>
									<option value="3">以物易物</option>								
								</select>			
							</li>
							
							<!-- 需求地區 -->
							<li class="input-group goods_item_content_li">
								<span class="input-group-addon goods_item_content_li_span">
									<i class="glyphicon glyphicon-map-marker"></i>
								</span>
								<!-- <input type="text" name="goods_loc" value="" id="" class="form-control goods_item_content_li_input" disabled> -->
															
								<select id="goods_loc`+ i +`" name="goods_loc" class="form-control goods_item_content_li_input goods_loc" disabled>																	
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
		
		// 產生內容
		$('#member_goodsCart_content').append(result_goodsCart);
		
		// 判斷並顯示_需求類別
		var goods_status_id = "#goods_status" + i + " option";
		var status_n = `${data.cgb[i].goodsstatus}`;
		$(goods_status_id).attr("selected", false);
		$(goods_status_id + ":eq(" + (status_n - 1) + ")").attr("selected", true);
		
		// 判斷並顯示_需求地區
		var goods_loc_id = "#goods_loc" + i + " option";
		$(goods_loc_id).attr("selected", false);
		
		var loc_n = `${data.cgb[i].goodsloc}`;
		switch(loc_n) {
			case 1: 
				loc_n = 0;
			case 2: 
				loc_n = 1;
			case 4: 
				loc_n = 2;
			case 6: 
				loc_n = 3;
			case 7: 
				loc_n = 4;
			case 13: 
				loc_n = 5;
			case 15: 
				loc_n = 6;
		}
		
		$(goods_loc_id  + ":eq(" + (loc_n) + ")").attr("selected", true);
		
		
		// 判斷並顯示_物品類別
		var goods_type_id = "#goods_type" + i + " option";
		var type_n = `${data.cgb[i].goodstype}`;
		$(goods_type_id).attr("selected", false);
		$(goods_type_id + ":eq(" + (type_n - 1) + ")").attr("selected", true);
	}
}

//我的物資箱_修改物資箱資料，按下"送出"按鈕
function goodsCartUpdate(goal, e){
	var gno = e;
	var gstatus = goal.closest(".goods_item_content").find('.goods_status').val();
	var gtype = goal.closest(".goods_item_content").find('.goods_type').val();
	var gname = goal.closest(".goods_item_content").find('.goods_name').val();
	var gloc = goal.closest(".goods_item_content").find('.goods_loc').val();
	var gnote = goal.closest(".goods_item_content").find('.goods_note').val();
	var gqty = goal.closest(".goods_item_content").find('.goods_qty').val();
	var gshipway = 3;
	var gdeadline = goal.closest(".goods_item_content").find('.deadline').val();
	
	var goodsCartUpdateServletPath = javaRoot + '/web/_04_productMaintain/controller/GoodsUpdate';
	var goodsCartUpdateDataString = "?goodsno=" + gno 
								  + "&goodsstatus=" + gstatus 
								  + "&goodstype=" + gtype 
								  + "&goodsname=" + gname 
								  + "&goodsloc=" + gloc 
								  + "&goodsnote=" + gnote 
								  + "&qty=" + gqty
								  + "&goodsshipway=3&deadline=" + gdeadline;
	
	console.log("goods_type = " +  gtype);
	console.log("goodsstatus = " +  gstatus);
	console.log("goodsloc = " +  gloc);
	
	$.ajax({
		type: 'post',
		url: goodsCartUpdateServletPath + goodsCartUpdateDataString,
		data: "",
		dataType: 'json',
		success: function(response){
					if(response.Ans == "TRUE"){
						alert("資料已送出");
						location.reload();

					} else {
						// 出現錯誤訊息
						alert("發生了一點錯誤，請檢查資料是否正確，並重新送出，謝謝!");
					}
				},
		error: function(response){
				   // 出現錯誤訊息
				   alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
			   }
	});
}


//我的物資箱_新增物資
function insertGoods(){
	var GOODSSTATUS = $(".goods_status").val();
	var GOODSTYPE = $(".goods_type").val();
	var GOODSNAME = $(".goods_name").val();
	var GOODSLOC = $(".goods_loc").val();
	var GOODSNOTE= $(".goods_note").val();
	var QTY = $(".qty").val();
	var GOODSSHIPWAY = 3;  //不會出現，但預設為：3 皆可
	var DEADLINE = $(".deadline").val();
	var INSERT_GOODS_IMG = insert_goods_img.result; // 新增物資圖片
	
	var insertGoods_ServletPath = javaRoot + "/web/_04_productMaintain/controller/GoodsInsert";
	var insertGoods_String = JSON.stringify({
								goodsstatus : GOODSSTATUS,
								goodstype : GOODSTYPE,
								goodsname : GOODSNAME,
								goodsloc : GOODSLOC,
								goodsnote : GOODSNOTE,
								qty : QTY,
								goodsshipway : GOODSSHIPWAY,
								deadline : DEADLINE,
								MSGIMAGE : INSERT_GOODS_IMG
							});
	
//	console.log("insertGoods_String = " + insertGoods_String);
	
	$.ajax({
		type: 'post',
		url: insertGoods_ServletPath,
		data: insertGoods_String,
		dataType: 'json',
		success: function(response){
					if(response.Ans == "TRUE"){
						alert("資料已送出");
						location.reload();
					} else {
						// 出現錯誤訊息
						alert("發生了一點錯誤，請檢查資料是否正確，並重新送出，謝謝!");
					}
				},
		error: function(response){
				   // 出現錯誤訊息
				   alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
			   }
	});	 
}