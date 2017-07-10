function showData(data, path) {
	var javaRoot = path;
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#eTransBlock').html(resultData);
		$('#blockETransOption').empty();
	}
	resultData =
		`<div class="col-xs-12 col-sm-6 col-md-5 col-lg-6">
			
			<div id="eTransImgLayout">
				<img id="eTransImg" class="img-responsive" src="${javaRoot}/_00_init/getImage?id=${responseData[0].goodsno}&type=GOODS">
			</div>
		</div>
		
		<div class="col-xs-12 col-sm-6 col-md-5 col-lg-5">
			<div id="eTransInfo" class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row eTransInfoRow">
						<ul type="none">
							<li>交換物品
								<span>${data[0].goodsname}</span>
							</li>
							<li>交換對象
								<span>${data[0].indname_TEMP}</span>
							</li>
							<li>交換數量
								<input type="number" class="form-control" value="1" min="1" max="${data[0].qty}" step="1" required="required">
							</li>
							<li>交換方式
								<select name="" id="ship" class="form-control" required="required">
									<option value="">郵寄</option>
									<option value="">面交</option>
								</select>
							</li>
							<li>留言訊息
								<textarea class="form-control" rows="5" maxlength="200" placeholder="留言最多200字"></textarea>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>`;

	$('#eTransBlock').prepend(resultData);
}