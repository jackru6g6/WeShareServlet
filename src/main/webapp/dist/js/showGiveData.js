function showData(responseData, javaRoot) {
	$('#divGiveGoods').empty();
	var resultData;
	if(responseData.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#divGiveGoods').append(resultData);
		return;
	}
	for (var i = 0; i < responseData.length; i++) {
		resultData =
			`<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<div class="giveGoods">
					<a href="giveGoods.jsp?goodsno=${responseData[i].goodsno}" class="giveGoodsA">

						<div class="giveGoodsImgLayout">
							<img class="img-responsive giveGoodsImg" src="${javaRoot}/_00_init/getImage?id=${responseData[i].goodsno}&type=GOODS">
						</div>

						<div class="giveGoodsOverlay">
							<div class="giveGoodsOverlayText">

								<div class="giveGoodsName giveGoodsContent">
									<span>${responseData[i].goodsname}</span>
								</div>

								<div class="giveGoodsBy giveGoodsContent">
									<span>By <span class="giveGoodsByAuthor">${responseData[i].indname_TEMP}</span></span>
								</div>

								<div class="giveGoodsDesc giveGoodsContent col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-4 col-lg-offset-1">
									<span>詳細資訊</span>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>`;
		$('#divGiveGoods').append(resultData);
	}
}