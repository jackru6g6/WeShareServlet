function showWishData(responseWishData, javaRoot) {
	for (var i = 0; i < 4; i++) {
		var resultWishData =
			`<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
				<div class="wishItem">
					<div>
						<a href="#" class="itemA">
							<img class="img-responsive itemImg" src="${javaRoot}/_00_init/getImage?id=${responseWishData[i].goodsno}&type=GOODS">
							<div class="itemOverlay">
								<p>${responseWishData[i].goodsnote}</p>
							</div>
						</a>
					</div>
					<div class="itemName itemContent"><a href="#">${responseWishData[i].goodsname}</a></div>
					<div class="itemBy itemContent">
						<a href="#">
							<h6>By <span>${responseWishData[i].indname_TEMP}</span></h6>
							<h5><span>${responseWishData[i].updatetime}</span></h5>
						</a>
					</div>
				</div>
			</div>`;
		$('#wishContent').append(resultWishData);
	}
}

function showGiveData(responseGiveData, javaRoot) {
	for (var i = 0; i < 4; i++) {
		var resultGiveData =
			`<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
				<div class="giveItem">
					<div>
						<a href="#" class="itemA">
							<img class="img-responsive itemImg" src="${javaRoot}/_00_init/getImage?id=${responseGiveData[i].goodsno}&type=GOODS">
							<div class="itemOverlay">
								<p>${responseGiveData[i].goodsnote}</p>
							</div>
						</a>
					</div>
					<div class="itemName itemContent"><a href="#">${responseGiveData[i].goodsname}</a></div>
					<div class="itemBy itemContent">
						<a href="#">
							<h6>By <span>${responseGiveData[i].indname_TEMP}</span></h6>
							<h5><span>${responseGiveData[i].updatetime}</span></h5>
						</a>
					</div>
				</div>
			</div>`;

		$('#giveContent').append(resultGiveData);
	}
}

function showExchangeData(responseExchangeData, javaRoot) {
	for (var i = 0; i < 4; i++) {
		var resultExchangeData =
			`<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
				<div class="exchangeItem">
					<div>
						<a href="#" class="itemA">
							<img class="img-responsive itemImg" src="${javaRoot}/_00_init/getImage?id=${responseExchangeData[i].goodsno}&type=GOODS">
							<div class="itemOverlay">
								<p>${responseExchangeData[i].goodsnote}</p>
							</div>
						</a>
					</div>
					<div class="itemName itemContent"><a href="#">${responseExchangeData[i].goodsname}</a></div>
					<div class="itemBy itemContent">
						<a href="#">
							<h6>By <span>${responseExchangeData[i].indname_TEMP}</span></h6>
							<h5><span>${responseExchangeData[i].updatetime}</span></h5>
						</a>
					</div>
				</div>
			</div>`;
			
		$('#exchangeContent').append(resultExchangeData);
	}
}