// 產生網頁內容
function showData(data, path) {
	var javaRoot = path;
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#wTransBlock').html(resultData);
		$('#blockWTransOption').empty();
	}
	resultData =
		`<!-- 左邊物資圖片 -->
		<div class="col-xs-12 col-sm-6 col-md-5 col-lg-6">
			<!-- 物資圖片 -->
			<div id="wTransImgLayout">
				<img id="wTransImg" class="img-responsive" src="${javaRoot}/_00_init/getImage?id=${responseData[0].goodsno}&type=GOODS">
			</div>
		</div>
		<!-- 右邊物資資訊 -->
		<div class="col-xs-12 col-sm-6 col-md-5 col-lg-5">
			<div id="wTransInfo" class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row wTransInfoRow">
						<ul type="none">
							<li>捐贈物品
								<span>${data[0].goodsname}</span>
							</li>
							<li>捐贈對象
								<span>${data[0].indname_TEMP}</span>
							</li>
							<li>捐贈數量
								<input id="dealQty" type="number" class="form-control" value="1" min="1" max="${data[0].qty}" step="1" required="required">
							</li>
							<li>寄送方式
								<select id="endShipway" class="form-control" required="required">
									<option value="1">郵寄</option>
									<option value="0">面交</option>
								</select>
							</li>
							<li>留言訊息
								<textarea id="dealNote" class="form-control" rows="5" maxlength="200" placeholder="留言最多200字"></textarea>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>`;
	$('#wTransBlock').prepend(resultData);
}

// 點擊確定送出
function sendTrans(){
	var goodsNo = `${responseData[0].goodsno}`;
	var dealQty = $('#dealQty').val();
	var endShipway = $('#endShipway').val();
	var dealNote = $('#dealNote').val();
	var transImg = localStorage.getItem('transImg');
	var transServletPath = javaRoot + '/web/_05_deal/controller/InsertDEAL';
	
	// get傳字串，會出現Request header is too large
//	$.ajax({
//		type: 'get',
//		url: transServletPath,
//		data: {
//			GOODSNO : goodsNo,
//			DEALQTY : dealQty,
//			ENDSHIPWAY : endShipway,
//			DEALNOTE : dealNote,
//			transImg : transImg
//		},
	
	
	// post傳資料
	
	// JSON格式
//	var transDataJSON = [{
//		GOODSNO: goodsNo,
//		DEALQTY : dealQty,
//		ENDSHIPWAY : endShipway,
//		DEALNOTE : dealNote,
//		transImg : transImg
//	}];
//	console.log(transDataJSON);
//	data: JSON.stringify({transDataString : transDataJSON}),
	
	$.ajax({
		type: 'post',
		url: transServletPath,
		data: {
			GOODSNO : goodsNo,
			DEALQTY : dealQty,
			ENDSHIPWAY : endShipway,
			DEALNOTE : dealNote,
			transImg : transImg
		},
		dataType: 'json',
		success: function(response){
			console.log("response = " + response);
			console.log("responseAns = " + response.Ans);
			// 出現錯誤訊息
			if(response.Ans == "TRUE"){
				$('#msgText').html("資料已送出，詳細資訊請至會員專區瀏覽");
			} else {
				$('#msgText').html("發生了一點錯誤，請確認是否已登入，並重新進入此頁面，謝謝!");
			}
		},
		error: function(response){
			// 出現錯誤訊息
			$('#msgText').html("發生了一點錯誤，請重新進入此頁面，謝謝!");
		}
	});
}