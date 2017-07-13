function showData(responseData, javaRoot) {
	$('#divExchangeGoods').empty();
	var resultData;
	if(responseData.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#divExchangeGoods').append(resultData);
		return;
	}
	// 將資料寫入
	for (var i = 0; i < responseData.length; i++) {
		resultData =
			`<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="exchangeGoods">
					<a href="exchangeGoods.jsp?goodsno=${responseData[i].goodsno}" class="exchangeGoodsA">

						<div class="exchangeGoodsImgLayout">
							<img class="img-responsive exchangeGoodsImg" src="${javaRoot}/_00_init/getImage?id=${responseData[i].goodsno}&type=GOODS">
						</div>

						<div class="exchangeGoodsOverlay">
							<div class="exchangeGoodsOverlayText">

								<div class="exchangeGoodsName exchangeGoodsContent">
									<span>${responseData[i].goodsname}</span>
								</div>

								<div class="exchangeGoodsBy exchangeGoodsContent">
									<span>By <span class="exchangeGoodsByAuthor">${responseData[i].indname_TEMP}</span></span>
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
	
	// 依序顯示物資
	$('.exchangeGoods').each(function(e) {
		setTimeout(function() {
			$('.exchangeGoods').eq(e).animate({opacity:1},1000).addClass('animated fadeInUp');
		},200 * e);
	});
}