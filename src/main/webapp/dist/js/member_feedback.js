// 產生等待回應的訂單
function showStatus0Date(data, path){
	var javaRoot = path;
	var result_Status0;
	
	// 若無資料
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
	
	// 產生等待回應的訂單資料
	for(var i = 0; i < data.coll.length; i++){
		dataNum++;
		if(data.coll[i].DEALSTATUS == "0"){
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status0 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span id="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealImageLayout">
										<a href="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" data-lightbox="image${data.coll[i].DEALNO}">
											<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" class="img-responsive dealImage">
										</a>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
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
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li>
												<button id="btAgree` + i +`" value=${data.coll[i].DEALNO} class="btn btn-default btAgree">接受交易</button>
											</li>
											<li>
												<button id="btCancel` + i +`" value=${data.coll[i].DEALNO} class="btn btn-default btCancel">取消交易</button>
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
			var dealMbId = "#dealMb" + i;
			// 接受交易按鈕
			var btAgreeId = "#btAgree" + i;
			// 取消交易按鈕
			var btCancelId = "#btCancel" + i;
			

			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				// 若是許願池的訂單且提出訂單者為自己，則看不到接受訂單按鈕，交易對象放ENDNAME
				$(btAgreeId).hide();
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(募集者)");
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				// 若是許願池的訂單且提出訂單者不是自己，則看得到接受訂單按鈕，交易對象放SOURCENAME
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
			}
			
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				// 若是送愛心的訂單且提出訂單者為自己，則看不到接受訂單按鈕，交易對象放SOURCENAME
				$(btAgreeId).hide();
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
			} else if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				// 若是送愛心的訂單且提出訂單者不是自己，則看得到接受訂單按鈕，交易對象放ENDNAME
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(索取者)");
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
			}
		}
	}
	// 若無符合的資料
	if (dataNum == "0"){
		$('#dealContent').empty();
		result_Status0 = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前沒有等待回應的訂單唷~
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
			// 回應訊息
			if(response.Ans == "TRUE"){
				// 成功傳到資料庫，此筆訂單隱藏  
				e.closest('.dealEach').closest('.row').hide();
				alert("資料已送出");
			} else {
				alert("發生了一點錯誤，請重新進入此頁面後再點選接受交易按鈕，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息(無法送到server)
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
			// 回應訊息
			if(response.Ans == "TRUE"){
				// 成功傳到資料庫，此筆訂單隱藏  
				e.closest('.dealEach').closest('.row').hide();
				alert("訂單已取消");
			} else {
				alert("發生了一點錯誤，請重新進入此頁面後再點選接受交易按鈕，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息(無法送到server)
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}


// 產生已接受的訂單
function showStatus1Date(data, path){
	var javaRoot = path;
	var result_Status1;
	
	// 若無資料
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
	
	// 產生已接受的訂單資料
	for(var i = 0; i < data.coll.length; i++){
		if(data.coll[i].DEALSTATUS == "1"){
			dataNum++;
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status1 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span id="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealImageLayout">
										<a href="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" data-lightbox="image${data.coll[i].DEALNO}">
											<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" class="img-responsive dealImage">
										</a>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
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
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li id="dealMsg` + i + `">結單訊息
												<textarea class="form-control dealMsgText" rows="3" maxlength="200" placeholder="請填寫寄件資訊/面交資訊" style="resize : none;"></textarea>
											</li>
											<li id="dealBt` + i + `">
												<button id="btDealMsg` + i + `" class="btn btn-default btDealMsg" name=${data.coll[i].DEALNO}>結單</button>
											</li>
											<li id="waitMsg` + i + `" class="waitText">
												等待對方寄送物資
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>								
				</div>`;
			$('#dealContent').append(result_Status1);
			
			// 顯示交易對象姓名
			var dealMbId = "#dealMb" + i;
			// 結單訊息li
			var dealMsgId = "#dealMsg" + i;
			// 結單按鈕li
			var dealBtId = "#dealBt" + i;
			// 等待訊息li
			var waitMsgId = "#waitMsg" + i;
			// 結單按鈕
			var btDealMsgId = "#btDealMsg" + i;
			
			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				// 若是許願池的訂單且提出訂單者為自己，則可以看到結單訊息、結單按鈕，不可以看到等待訊息，交易對象放ENDNAME
				$(waitMsgId).hide();
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(募集者)");
				$(btDealMsgId).attr("value", `${data.coll[i].ENDID}`);
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				// 若是許願池的訂單且提出訂單者不是自己，則不可以看到結單訊息、結單按鈕，可以看到等待訊息，交易對象放SOURCENAME
				$(dealMsgId).hide();
				$(dealBtId).hide();
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
			}
			
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				// 若是送愛心的訂單且提出訂單者為自己，則不可以看到結單訊息、結單按鈕，可以看到等待訊息，交易對象放SOURCENAME
				$(dealMsgId).hide();
				$(dealBtId).hide();
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
			} else if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				// 若是送愛心的訂單且提出訂單者不是自己，則可以看到結單訊息、結單按鈕，不可以看到等待訊息，交易對象放SOURCENAME
				$(waitMsgId).hide();
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(索取者)");
				$(btDealMsgId).attr("value", `${data.coll[i].ENDID}`);
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
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


// 點擊結單
function sendDealMsg(e){
	var dealMsgEndId = e.val();
	var dealMsgText = e.closest('.dealConfirm').find('.dealMsgText').val();
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
			// 回應訊息
			if(response.Ans == "TRUE"){
				// 成功傳到資料庫，交易訂單送出(1 to 2)
				var dealNo = e.attr("name");
				var dealSubmitServletPath = javaRoot + '/web/_05_deal/controller/SubmitByKey?key=' + dealNo;

				$.ajax({
					type: 'post',
					url: dealSubmitServletPath,
					data: "",
					dataType: 'json',
					success: function(response){
						// 回應訊息
						if(response.Ans == "TRUE"){
							// 成功傳到資料庫，此筆訂單隱藏  
							alert("訊息已送出");
							e.closest('.dealEach').closest('.row').hide();
						} else {
							alert("發生了一點錯誤，請重新進入此頁面後再點選結單按鈕，謝謝!");
						}
					},
					error: function(response){
						// 出現錯誤訊息(無法送到server)
						alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
					}
				});
			} else {
				alert("發生了一點錯誤，請重新進入此頁面後再點選結單按鈕，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息(無法送到server)
			alert("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}


// 產生已完成的訂單
function showStatus2Date(data, path){
	var javaRoot = path;
	var result_Status2;
	
	// 若無資料
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
	
	// 產生已完成的訂單資料
	for(var i = 0; i < data.coll.length; i++){
		dataNum++;
		if(data.coll[i].DEALSTATUS == "2"){
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status2 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span id="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealImageLayout">
										<a href="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" data-lightbox="image${data.coll[i].DEALNO}">
											<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" class="img-responsive dealImage">
										</a>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
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
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealConfirm">
										<ul type="none">
											<li id="liFeedbackStatus` + i + `" class="liFeedbackStatus">
												<span id="getFeedbackStatus` + i + `" class="feedbackStatus">尚未收到評價</span>
											</li>
											<li id="liGiveScore` + i + `" class="liGiveScore">評分(1~10分)
												<input type="number" class="form-control giveScore" min="1" max="10" step="1" required="required">
											</li>
											<li id="liGiveFeedback` + i + `" class="liGiveFeedback">評語
												<textarea class="form-control giveFeedback" rows="3" maxlength="200" placeholder="評語最多200字"></textarea>
											</li>
											<li id="liBtGiveFeedback` + i + `" class="liBtGiveFeedback">
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
			var dealMbId = "#dealMb" + i;
			// 評價狀態li
			var liFeedbackStatusId = "#liFeedbackStatus" + i;
			// 給評分li
			var liGiveScoreId = "#liGiveScore" + i;
			// 給評語li
			var liGiveFeedbackId = "#liGiveFeedback" + i;
			// 送出評價li
			var liBtGiveFeedbackId = "#liBtGiveFeedback" + i;
			// 顯示已獲得/已送出的評價
			var getFeedbackStatusId = "#getFeedbackStatus" + i;
			// 送出評價name值
			var btGiveFeedbackId = "#btGiveFeedback" + i;
			
			
			
			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				// 若是許願池的訂單且提出訂單者為自己，則無法給評價，交易對象放ENDNAME
				$(liGiveScoreId).hide();
				$(liGiveFeedbackId).hide();
				$(liBtGiveFeedbackId).hide();
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(募集者)");
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
				
				// 如果已獲得評價，則顯示評價內容
				if(`${data.coll[i].FEEDBACKANS}` == "TRUE"){
					var fbAll = "得到評價：" + `${data.coll[i].fb.FBSCORE}` + "分<br>" + "評語：" + `${data.coll[i].fb.FBTEXT}`;
					$(getFeedbackStatusId).html(fbAll);
				}
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				// 若是許願池的訂單且提出訂單者不是自己，則可以給評價，交易對象放SOURCENAME
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(liFeedbackStatusId).hide();
				$(btGiveFeedbackId).attr("name", `${data.coll[i].SOURCEID}`);
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
				
				// 如果已給過評價，則顯示評價內容，且不能再給評價
				if(`${data.coll[i].FEEDBACKANS}` == "TRUE"){
					var fbAll = "已給評價：" + `${data.coll[i].fb.FBSCORE}` + "分<br>" + "評語：" + `${data.coll[i].fb.FBTEXT}`;
					$(getFeedbackStatusId).html(fbAll);
					$(liFeedbackStatusId).show();
					$(liGiveScoreId).hide();
					$(liGiveFeedbackId).hide();
					$(liBtGiveFeedbackId).hide();
				}
			}
			
			
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				// 若是送愛心的訂單且提出訂單者為自己，則可以給評價，交易對象放SOURCENAME
				$(liFeedbackStatusId).hide();
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(btGiveFeedbackId).attr("name", `${data.coll[i].SOURCEID}`);
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
				
				// 如果已給過評價，則顯示評價內容
				if(`${data.coll[i].FEEDBACKANS}` == "TRUE"){
					var fbAll = "已給評價：" + `${data.coll[i].fb.FBSCORE}` + "分<br>" + "評語：" + `${data.coll[i].fb.FBTEXT}`;
					$(getFeedbackStatusId).html(fbAll);
					$(liFeedbackStatusId).show();
					$(liGiveScoreId).hide();
					$(liGiveFeedbackId).hide();
					$(liBtGiveFeedbackId).hide();
				}
			} else if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				// 若是送愛心的訂單且提出訂單者不是自己，則無法給評價，交易對象放SOURCENAME
				$(liGiveScoreId).hide();
				$(liGiveFeedbackId).hide();
				$(liBtGiveFeedbackId).hide();
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(索取者)");
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
				
				// 如果已獲得評價，則顯示評價內容
				if(`${data.coll[i].FEEDBACKANS}` == "TRUE"){
					var fbAll = "得到評價：" + `${data.coll[i].fb.FBSCORE}` + "分<br>" + "評語：" + `${data.coll[i].fb.FBTEXT}`;
					$(getFeedbackStatusId).html(fbAll);
				}
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

	var fbAll = "已給評價：" + fbScore + "分<br>" + "評語：" + fbText;
		
	$.ajax({
		type: 'post',
		url: sendFeedbackServletPath + dataFeedbackString,
		data: "",
		dataType: 'json',
		success: function(response){
			console.log(response);
			// 回應訊息
			if(response.Ans == "TRUE"){
				// 成功傳到資料庫，顯示評價內容
				e.closest('.dealConfirm').find('.liGiveScore').hide();
				e.closest('.dealConfirm').find('.liGiveFeedback').hide();
				e.closest('.dealConfirm').find('.liBtGiveFeedback').hide();
				e.closest('.dealConfirm').find('.liFeedbackStatus').show();
				e.closest('.dealConfirm').find('.feedbackStatus').html(fbAll);
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
	
	// 若無資料
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
	
	// 產生已取消的訂單資料
	for(var i = 0; i < data.coll.length; i++){
		dataNum++;
		if(data.coll[i].DEALSTATUS == "3"){
			var postDate = new Date(`${data.coll[i].POSTDATE}`);
			result_Status3 = 
				`<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="dealEach">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealInfo">
										<ul type="none">
											<li>日期：
												<span>` + postDate.toLocaleDateString() + `</span>
											</li>
											<li>對象：
												<span id="dealMb` + i +`"></span>
											</li>
											<li>品名：
												<span>${data.coll[i].GOODSNAME}</span>
											</li>
										</ul>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
									<div class="dealImageLayout">
										<a href="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" data-lightbox="image${data.coll[i].DEALNO}">
											<img src="${javaRoot}/_00_init/getImage?id=${data.coll[i].DEALNO}&type=DEAL" class="img-responsive dealImage">
										</a>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
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
								<div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
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
			var dealMbId = "#dealMb" + i;
			
			if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].SOURCEID}` == indid){
				// 若是許願池的訂單且提出訂單者為自己，則交易對象放ENDNAME
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(募集者)");
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
			} else if(`${data.coll[i].GOODSSTATUS}` == "1" && `${data.coll[i].ENDID}` == indid) {
				// 若是許願池的訂單且提出訂單者不是自己，則交易對象放SOURCENAME
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(dealMbId).closest('.dealEach').css("background", "rgba(255, 151, 151, 0.12)");
			}
			
			if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].ENDID}` == indid){
				// 若是送愛心的訂單且提出訂單者為自己，則交易對象放SOURCENAME
				$(dealMbId).html(`${data.coll[i].SOURCENAME}` + "(贈送者)");
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
			} else if(`${data.coll[i].GOODSSTATUS}` == "2" && `${data.coll[i].SOURCEID}` == indid) {
				// 若是送愛心的訂單且提出訂單者不是自己，則交易對象放ENDNAME
				$(dealMbId).html(`${data.coll[i].ENDNAME}` + "(索取者)");
				$(dealMbId).closest('.dealEach').css("background", "#f7e3cf");
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