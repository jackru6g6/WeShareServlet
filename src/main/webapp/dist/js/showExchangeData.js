function showData(responseData, javaRoot) {
	var resultData;
	for (var i = 0; i < responseData.length; i++) {
		resultData =
			`<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
				<div class="exchangeGoods">
					<a href="#" class="exchangeGoodsA">

						<div class="exchangeGoodsImgLayout">
							<img class="img-responsive exchangeGoodsImg" src="${javaRoot}/_00_init/getImage?id=${responseData[i].goodsno}&type=GOODS">
						</div>

						<div class="exchangeGoodsOverlay">
							<div class="exchangeGoodsOverlayText">

								<div class="exchangeGoodsName exchangeGoodsContent">
									<span>${responseData[i].goodsname}</span>
								</div>

								<div class="exchangeGoodsBy exchangeGoodsContent">
									<span>By <span class="month">${responseData[i].indname_TEMP}</span></span>
								</div>

								<div class="exchangeGoodsDesc exchangeGoodsContent col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-4 col-lg-offset-1">
									<span>詳細資訊</span>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>`;

		$('#divExchangeGoods').append(resultData);
	}
}