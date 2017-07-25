//我的站內信_顯示站內信
function showMSG_Data(data, path){
	var javaRoot = path;
	var result_message;
	//錯誤訊息
	if(data.Ans == "FALSE"){
		result_message = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			尚未有站內信內容。
		</div>`;
		$('#member_message').append(result_message);
		return;
	}
	
	// 清除先前的表格
	$("#member_message").empty();
	
	// 顯示站內信資料
	for(var i = 0; i < data.coll.length; i++){
			result_message = 
				`<tbody class="member_message">
					<tr class="message_data">	
						<td>
							<ul>
								<li>
									<img id="message_end_img${data.coll[i].ROOMNO}" class="message_end_img">
								</li>
							</ul>
						</td>													
						<td>
							<ul>
								<li id="member_message_data${data.coll[i].ROOMNO}" class="member_message_data">
									
								</li>
								<li class="member_message_data">
									${data.coll[i].POSTDATE}
								</li>
								<li class="member_message_data">
									${data.coll[i].MSGTEXT}
								</li>
							</ul>										
						</td>
						<td class="button_row">									
							<button class="btn btn-default member_message_show_button" value="${data.coll[i].ROOMNO}">
								<span class="glyphicon glyphicon-list-alt"></span>
								內容
							</button>														
						</td>												
					</tr>
					<tr>
						<td colspan="4" class="member_message_all">
							<div id="member_message_all_content${data.coll[i].ROOMNO}" class="member_message_all_content">
								
							</div>
							<textarea class="member_message_sendBack" rows="3" wrap="physical" placeholder="請輸入信息內容" required></textarea>
							<input type="file" class="member_message_img" accept="image/jpeg, image/png">
							<img class="member_message_show_img">
							<button id="member_message_sendBack_button${data.coll[i].ROOMNO}" class="btn member_message_sendBack_button">送出</button>
						</td>
					</tr>
				</tbody>`;
			
			
			$('#member_message_table').append(result_message);
			
			var member_message_data_id = "#member_message_data" + `${data.coll[i].ROOMNO}`;
			var member_message_sendBack_button_id = "#member_message_sendBack_button" + `${data.coll[i].ROOMNO}`;
			var message_end_img_id = "#message_end_img" + `${data.coll[i].ROOMNO}`;
			
			if(`${data.coll[i].MSGSOURCEID}` == indid){
				// 若是訊息來源者為自己，則聊天室名稱放MSGENDNAME，送出按鈕的value=MSGENDID
				$(member_message_data_id).html(`${data.coll[i].MSGENDNAME}`);
				$(member_message_sendBack_button_id).val(`${data.coll[i].MSGENDID}`);
				$(message_end_img_id).attr("src", `${javaRoot}` + "/_00_init/getImage?id=" + `${data.coll[i].MSGENDID}` + "&type=MEMBER");
			} else if(`${data.coll[i].MSGENDID}` == indid) {
				// 若是訊息來源者不是自己，則聊天室名稱放MSGSOURCENAME，送出按鈕的value=MSGSOURCEID
				$(member_message_data_id).html(`${data.coll[i].MSGSOURCENAME}`);
				$(member_message_sendBack_button_id).val(`${data.coll[i].MSGSOURCEID}`);
				$(message_end_img_id).attr("src", `${javaRoot}` + "/_00_init/getImage?id=" + `${data.coll[i].MSGSOURCEID}` + "&type=MEMBER");
			}
			
	}
}


// 顯示詳細的站內信信息
function showDetail_MSG_Data(data, path){
	var javaRoot = path;
	var result_Detail_message;
	var member_message_all_content_id = "#member_message_all_content" + `${data.coll[0].ROOMNO}`;

	//錯誤訊息
	if(data.Ans == "FALSE"){
		result_Detail_message = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			沒有內容。
		</div>`;
		$('.member_message_all_content').append(result_Detail_message);
		return;
	}
	
	// 清除先前的內容
	$(".member_message_all_content").empty();
	
	// 顯示站內信資料
	for(var i = 0; i < data.coll.length; i++){
		result_Detail_message = 
			`<div class="row detail_message">
				<div class="col-xs-6 col-sm-6 col-md-4 col-lg-4" style="text-align: left;">
					<div>發送者：${data.coll[i].MSGSOURCENAME}</div>
					<div>接收者：${data.coll[i].MSGENDNAME}</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-2 col-lg-2">${data.coll[i].POSTDATE}</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">${data.coll[i].MSGTEXT}</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3"><img id="message_detail_img` + i + `" class="message_detail_img" style="max-width:100px;"></div>
			</div>`;
		// 內容
		$(member_message_all_content_id).append(result_Detail_message);
		
		var msg_detail_img_id = "#message_detail_img" + i;
		
		if(`${data.coll[i].MSGFILENAME}` !== "undefined"){
			$(msg_detail_img_id).attr("src", `${javaRoot}` + "/_00_init/getImage?id=" + `${data.coll[i].MSGNO}` + "&type=MSG");
		}
	}
}


// 在會員專區中直接送出訊息
function secndBackMessage(e){
	var message_endid = e.val();
	var message_text = e.closest(".member_message_all").find(".member_message_sendBack").val();
	
	var secndBackMessage_ServletPath = javaRoot + "/web/_06_MSG/controller/AddNewMSG";
	var secndBackMessage_String = JSON.stringify({
									MSGENDID : message_endid,
									MSGTEXT : message_text,
									MSGIMAGE : messageImg.result
								});
	
	console.log("secndBackMessage_String = " + secndBackMessage_String);
	
	$.ajax({
		type: 'post',
		url: secndBackMessage_ServletPath,
		data: secndBackMessage_String,
		dataType: 'json',
		success: function(response){
					if(response.Ans == "TRUE"){
						alert("訊息已送出");
						e.closest(".member_message_all").css("display", "none");
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


// 新增站內信
function insertMessage(){
	var message_endid = $(".msgendId").val();
	var message_text = $(".msgText").val();
	var messgage_img = insertMessage_img.result; //新增訊息圖片
	
	var insertMessage_ServletPath = javaRoot + "/web/_06_MSG/controller/AddNewMSG";
	var insertMessage_String = JSON.stringify({
									MSGENDID : message_endid,
									MSGTEXT : message_text,
									MSGIMAGE : messgage_img
								});
	
	console.log("insertMessage_String = " + insertMessage_String);
	
	$.ajax({
		type: 'post',
		url: insertMessage_ServletPath,
		data: insertMessage_String,
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