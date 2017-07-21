// 產生等待回應中的訂單
function showStatus0Date(data, path){
	var javaRoot = path;
	var result_Status0;
	
	// 錯誤訊息
	if(data.Ans == "FALSE"){
		$('#dealContent').empty();
		result_Status0 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有等待回應中的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status0);
		return;
	}
	
	// 清除先前的表格
	$("#dealContent").empty();
	
	// 計算是否有資料
	var dataNum = 0;
	
	// 產生物資箱資料
	for(var i = 0; i < data.coll.length; i++){
		dataNum++;
		if(data.coll[i].DEALSTATUS == "0"){
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status0 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span class="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealImageLayout">
										<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].dealno}&type=DEAL" class="img-responsive dealImage">
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealOtherInfo">
										<ul type="none">
											<li>配送方式：
												<span>${data.coll[i].ENDSHIPWAYNAME}</span>
											</li>
											<li>備註說明：<br>
												<span>${data.coll[i].DEALNOTE}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li>
												<button value=${data.coll[i].DEALNO} class="btn btn-default btAgree">接受交易</button>
											</li>
											<li>
												<button value=${data.coll[i].DEALNO} class="btn btn-default btCancel">取消交易</button>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>								
				</div>`;
			$('#dealContent').append(result_Status0);
			// 顯示交易對象姓名
			var dealMbName = ".dealMb" + i;
//			if(`${data.coll[i].ENDID}` == indid){
//				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
//			}else {
//				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
//			}
			console.log(i);
			console.log("GOODSSTATUS = " + `${data.coll[i].GOODSSTATUS}`);
			console.log("SOURCEID = " + `${data.coll[i].SOURCEID}`);
			// 若是許願池的訂單且提出訂單者為自己，則看不到接受訂單按鈕，交易對象放ENDNAME
			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				$('.btAgree').hide();
				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
			}
			
			// 若是送愛心的訂單且提出訂單者為自己，則看不到接受訂單按鈕，交易對象放SOURCENAME
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				$('.btAgree').hide();
				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
			} else if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
			}
		}
	}
	// 若無符合的資料
	if (dataNum == "0"){
		$('#dealContent').empty();
		result_Status0 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有等待回應中的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status0);
	}
}


// 點接受交易
function dealAgree(e){
	var dealNo = e.val();
	var dealAgreeServletPath = javaRoot + '/web/_05_deal/controller/agreenByKey?key=' + dealNo;
	$.ajax({
		type: 'post',
		url: dealAgreeServletPath,
		data: "",
		dataType: 'json',
		success: function(response){
			// 出現錯誤訊息
			if(response.Ans == "TRUE"){
				// 此筆訂單隱藏  
				e.closest('.dealEach').closest('.row').hide();
				alert("資料已送出");
			} else {
				alert("發生了一點錯誤，請重新進入此頁面後再點選接受交易按鈕，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}


// 點取消交易
function dealCancel(e){
	var dealNo = e.val();
	var dealAgreeServletPath = javaRoot + '/web/_05_deal/controller/CancelByKey?key=' + dealNo;
	$.ajax({
		type: 'post',
		url: dealAgreeServletPath,
		data: "",
		dataType: 'json',
		success: function(response){
			// 出現錯誤訊息
			if(response.Ans == "TRUE"){
				// 此筆訂單隱藏  
				e.closest('.dealEach').closest('.row').hide();
				alert("訂單已取消");
			} else {
				alert("發生了一點錯誤，請重新進入此頁面後再點選接受交易按鈕，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}


// 產生已接受的訂單
function showStatus1Date(data, path){
	var javaRoot = path;
	var result_Status1;
	
	// 錯誤訊息
	if(data.Ans == "FALSE"){
		$('#dealContent').empty();
		result_Status1 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有已接受的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status1);
		return;
	}
	
	// 清除先前的表格
	$("#dealContent").empty();
	
	// 計算是否有資料
	var dataNum = 0;
	
	// 產生物資箱資料
	for(var i = 0; i < data.coll.length; i++){
		if(data.coll[i].DEALSTATUS == "1"){
			dataNum++;
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status1 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span class="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealImageLayout">
										<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].dealno}&type=DEAL" class="img-responsive dealImage">
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealOtherInfo">
										<ul type="none">
											<li>配送方式：
												<span>${data.coll[i].ENDSHIPWAYNAME}</span>
											</li>
											<li>備註說明：<br>
												<span>${data.coll[i].DEALNOTE}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li>
												<a data-toggle="modal" data-target="#dealMsg` + i +`" class="btn btn-default aDealMsg">結單</a>
											</li>
											<li class="waitText">
												等待對方寄出物資
											</li>
										</ul>
									</div>
								</div>
								
								<!-- 結單modal -->
								<div id="dealMsg` + i +`" class="modal fade" role="dialog">
									<div class="modal-dialog">
										<div class="modal-content">
											<!-- 標題 -->
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h3 id="dealMsgName` + i +`" class="modal-title"></h3>
											</div>
											<!-- 內容 -->
											<div class="modal-body dealMsgBody">
												<textarea class="form-control dealMsgText" rows="5" required="required" maxlength="200" placeholder="留言最多200字" style="resize : none;"></textarea>
											</div>
											<!-- 關閉鈕 -->
											<div class="modal-footer dealMsgFooter">
												<button type="button" id="btSendDealMsg` + i +`" class="btn btn-default btSendDealMsgClass" name=${data.coll[i].DEALNO}>傳送訊息</button>
												<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
											</div>
										</div>
									</div>
								</div>
								
							</div>
						</div>
					</div>								
				</div>`;
			$('#dealContent').append(result_Status1);
			var dealMb = ".dealMb" + i;
			var dealMsgName = "#dealMsgName" + i;
			var btSendDealMsg = "#btSendDealMsg" + i;
			if(`${data.coll[i].ENDID}` == indid){
//				$(dealMb).html(`${data.coll[i].SOURCENAME}`);
				$(dealMsgName).html("發送訊息給" + `${data.coll[i].SOURCENAME}`);
				$(btSendDealMsg).attr("value", `${data.coll[i].SOURCEID}`);
			}else {
//				$(dealMb).html(`${data.coll[i].ENDNAME}`);
				$(dealMsgName).html("發送訊息給" + `${data.coll[i].ENDNAME}`);
				$(btSendDealMsg).attr("value", `${data.coll[i].ENDID}`);
			}
			
			// 若是許願池的訂單且提出訂單者為自己，則可以看到結單按鈕，交易對象放ENDNAME
			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				$('.waitText').hide();
				$(dealMb).html(`${data.coll[i].ENDNAME}`);
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				$('.aDealMsg').hide();
				$(dealMb).html(`${data.coll[i].SOURCENAME}`);
			}
			
			// 若是送愛心的訂單且提出訂單者為自己，則看不到結單按鈕，交易對象放SOURCENAME
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				$('.aDealMsg').hide();
				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
			} else if(`v{data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				$('.waitText').hide();
				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
			}
		}
	}
	// 若無符合的資料
	if (dataNum == "0"){
		$('#dealContent').empty();
		result_Status1 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有已接受的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status1);
	}
}


// 點擊結單的傳送訊息
function sendDealMsg(e){
	var dealMsgEndId = e.val();
	var dealMsgText = e.closest('.modal-content').find('.dealMsgText').val();
	var dealMsgServletPath = javaRoot + '/web/_06_MSG/controller/AddNewMSG';

	// post傳資料(JSON格式)
	var dealMsgDataString = JSON.stringify({
		MSGENDID: dealMsgEndId,
		MSGTEXT : dealMsgText,
	});

	$.ajax({
		type: 'post',
		url: dealMsgServletPath,
		data: dealMsgDataString,
		dataType: 'json',
		success: function(response){
			console.log(response);
			// 出現錯誤訊息
			if(response.Ans == "TRUE"){
				// 交易訂單送出(1 to 2)
				var dealNo = e.attr("name");
				var dealSubmitServletPath = javaRoot + '/web/_05_deal/controller/SubmitByKey?key=' + dealNo;
				console.log(dealSubmitServletPath);
				$.ajax({
					type: 'post',
					url: dealSubmitServletPath,
					data: "",
					dataType: 'json',
					success: function(response){
						// 出現錯誤訊息
						if(response.Ans == "TRUE"){
							// 此筆訂單隱藏  
							alert("訊息已送出");
							e.closest('.modal').modal('hide');
							e.closest('.dealEach').closest('.row').hide();
						} else {
							alert("發生了一點錯誤，請重新進入此頁面後再點選結單按鈕，謝謝!");
						}
					},
					error: function(response){
						// 出現錯誤訊息
						alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
					}
				});
			} else {
				alert("發生了一點錯誤，請重新發送訊息，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}


// 產生已完成的訂單
function showStatus2Date(data, path){
	var javaRoot = path;
	var result_Status2;
	
	// 錯誤訊息
	if(data.Ans == "FALSE"){
		$('#dealContent').empty();
		result_Status2 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有已完成的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status2);
		return;
	}
	
	// 清除先前的表格
	$("#dealContent").empty();
	
	// 計算是否有資料
	var dataNum = 0;
	
	// 產生物資箱資料
	for(var i = 0; i < data.coll.length; i++){
		dataNum++;
		if(data.coll[i].DEALSTATUS == "2"){
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status2 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span class="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealImageLayout">
										<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].dealno}&type=DEAL" class="img-responsive dealImage">
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealOtherInfo">
										<ul type="none">
											<li>配送方式：
												<span>${data.coll[i].ENDSHIPWAYNAME}</span>
											</li>
											<li>備註說明：<br>
												<span>${data.coll[i].DEALNOTE}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li class="liFeedbackStatus">
												<span class="feedbackStatus">尚未收到評價</span>
											</li>
											<li class="liGiveScore">評分(1~10分)
												<input type="number" class="form-control giveScore" min="1" max="10" step="1" required="required">
											</li>
											<li class="liGiveFeedback">評語
												<textarea class="form-control giveFeedback" rows="5" maxlength="200" placeholder="評語最多200字"></textarea>
											</li>
											<li class="liBtGiveFeedback">
												<button id="btGiveFeedback` + i +`" value=${data.coll[i].DEALNO} class="btn btn-default btGiveFeedbackClass">送出評價</button>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>								
				</div>`;
			$('#dealContent').append(result_Status2);
			// 顯示交易對象姓名
			var dealMbName = ".dealMb" + i;
//			if(`${data.coll[i].ENDID}` == indid){
//				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
//			}else {
//				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
//			}
			
			// 若是許願池的訂單且提出訂單者為自己，則無法給評價，交易對象放ENDNAME
			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				$('.liGiveScore').hide();
				$('.liGiveFeedback').hide();
				$('.liBtGiveFeedback').hide();
				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				$('.liFeedbackStatus').hide();
				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
				$(btGiveFeedbackClass).attr("name", `${data.coll[i].SOURCEID}`);
			}
			
			// 若是送愛心的訂單且提出訂單者為自己，則看不到接受訂單按鈕，交易對象放SOURCENAME
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				$('.liFeedbackStatus').hide();
				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
				$(btGiveFeedbackClass).attr("name", `${data.coll[i].SOURCEID}`);
			} else if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				$('.liGiveScore').hide();
				$('.liGiveFeedback').hide();
				$('.liBtGiveFeedback').hide();
				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
			}
		}
	}
	// 若無符合的資料
	if (dataNum == "0"){
		$('#dealContent').empty();
		result_Status2 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有已完成的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status2);
	}
}


// 點送出評價
function sendFeedback(e){
	var dealNo = e.val();
	var fbEndId = e.attr("name");
	var fbScore = e.closest('.dealConfirm').find('.giveScore').val();;
	var fbText = e.closest('.dealConfirm').find('.giveFeedback').val();;
	
	var sendFeedbackServletPath = javaRoot + '/web/_07_Feedback/controller/InsertFeedback?';
	var dataFeedbackString = "dealno=" + dealNo + "&fbendid=" + fbEndId + "&fbscore=" + fbScore + "&fbtext=" + fbText;

	var fbAll = "已給評價：" + fbScore + "分\n" + "評語：" + fbText;
		
	$.ajax({
		type: 'post',
		url: sendFeedbackServletPath + dataFeedbackString,
		data: "",
		dataType: 'json',
		success: function(response){
			console.log(response);
			// 出現錯誤訊息
			if(response.Ans == "TRUE"){
				e.closest('.dealConfirm').find('.liGiveScore').hide();
				e.closest('.dealConfirm').find('.liGiveFeedback').hide();
				e.closest('.dealConfirm').find('.liBtGiveFeedback').hide();
				e.closest('.dealConfirm').find('.feedbackStatus').html(fbAll).show();
			} else {
				alert("發生了一點錯誤，請重新發送評價，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}

// 產生已取消的訂單
function showStatus3Date(data, path){
	var javaRoot = path;
	var result_Status3;
	
	// 錯誤訊息
	if(data.Ans == "FALSE"){
		$('#dealContent').empty();
		result_Status3 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有已取消的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status3);
		return;
	}
	
	// 清除先前的表格
	$("#dealContent").empty();
	
	// 計算是否有資料
	var dataNum = 0;
	
	// 產生物資箱資料
	for(var i = 0; i < data.coll.length; i++){
		dataNum++;
		if(data.coll[i].DEALSTATUS == "3"){
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status3 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span class="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealImageLayout">
										<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].dealno}&type=DEAL" class="img-responsive dealImage">
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealOtherInfo">
										<ul type="none">
											<li>配送方式：
												<span>${data.coll[i].ENDSHIPWAYNAME}</span>
											</li>
											<li>備註說明：<br>
												<span>${data.coll[i].DEALNOTE}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li>
												此筆訂單已取消
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>								
				</div>`;
			$('#dealContent').append(result_Status3);
			// 顯示交易對象姓名
			var dealMbName = ".dealMb" + i;
			if(`${data.coll[i].ENDID}` == indid){
				$(dealMbName).html(`${data.coll[i].SOURCENAME}`);
			}else {
				$(dealMbName).html(`${data.coll[i].ENDNAME}`);
			}
		}
	}
	// 若無符合的資料
	if (dataNum == "0"){
		$('#dealContent').empty();
		result_Status3 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有已取消的訂單唷~
		</div>`;
		$('#dealContent').append(result_Status3);
	}
}