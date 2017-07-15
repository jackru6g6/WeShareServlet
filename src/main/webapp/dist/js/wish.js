// 產生物資內容
function showData(data, javaRoot) {
	$('#divWishGoods').empty();
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#divWishGoods').append(resultData);
		return;
	}
	// 將資料寫入
	for (var i = 0; i < data.length; i++) {
		resultData = 		
			`<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<div class="wishGoods">
					<a href="wishGoods.jsp?goodsno=${data[i].goodsno}" class="wishGoodsA">
						<!-- 需求物資圖片 -->
						<div class="wishGoodsImgLayout">
							<img class="img-responsive wishGoodsImg" src="${javaRoot}/_00_init/getImage?id=${data[i].goodsno}&type=GOODS">
						</div>
						<!-- 需求物資文字敘述 -->
						<div class="wishGoodsOverlay">
							<div class="wishGoodsOverlayText">
								<!-- 需求物資名稱 -->
								<div class="wishGoodsName wishGoodsContent">
									<span>${data[i].goodsname}</span>
								</div>
								<!-- 需求物資發佈者 -->
								<div class="wishGoodsBy wishGoodsContent">
									<span>By <span class="wishGoodsByAuthor">${data[i].indname_TEMP}</span></span>
								</div>
								<!-- 需求物資詳細資訊 -->
								<div class="wishGoodsDesc wishGoodsContent col-xs-10 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-4 col-lg-offset-1">
									<span>詳細資訊</span>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>`;
		$('#divWishGoods').append(resultData);
	}
	
	// 依序顯示物資動畫
	$('.wishGoods').each(function(e) {
		setTimeout(function() {
			$('.wishGoods').eq(e).animate({opacity:1},1000).addClass('animated fadeInUp');
		},200 * e);
	});
}

// 滑動選單的開閉按鈕設定, 點擊新增 .active 
$('#slideMenuTrigger').on('click', function() {
	$('#sectionFilter').toggleClass("active");
});