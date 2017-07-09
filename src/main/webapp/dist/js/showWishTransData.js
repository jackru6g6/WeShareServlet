function showData(data, path) {
	var javaRoot = path;
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#wTransBlock').html(resultData);		
	}
	console.log(data[0].goodsname);	
	resultData =
		`<div class="col-xs-12 col-sm-6 col-md-5 col-lg-6">
			<div id="wTransImgLayout">
				<img id="wTransImg" class="img-responsive" src="${javaRoot}/_00_init/getImage?id=${responseData[0].goodsno}&type=GOODS">
			</div>
		</div>

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
								<input type="number" class="form-control" value="1" min="1" max="${data[0].qty}" step="1" required="required">
							</li>
							<li>寄送方式
								<select name="server" id="wValDel" class="form-control" required="required">
									<option value="server">郵寄</option>
									<option value="server">親送</option>
								</select>
							</li>
							<li>留言訊息
								<textarea class="form-control" rows="5" required="required"></textarea>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>`;
	$('#wTransBlock').prepend(resultData);
}