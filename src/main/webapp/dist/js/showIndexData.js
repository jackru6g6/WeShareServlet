function showWishData(responseWishData, javaRoot) {
	for (var i = 0; i < 4; i++) {
		var deadlineString = `${responseWishData[i].deadlinestring}`;
		var deadlineSplit = deadlineString.split('-');
		var dateNow = new Date();
		var dateDeadline = new Date(deadlineSplit[0], deadlineSplit[1], deadlineSplit[2]);
		var daysLeft = Math.floor((dateDeadline - dateNow) / (1000 * 60 * 60 * 24));
		var resultWishData =
			`<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
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
							<span>By <span>${responseWishData[i].indname_TEMP}</span></span>
							<h5>還剩 <span>` + daysLeft + `</span> 天</h5>
						</a>
					</div>
				</div>
			</div>`;
		$('#wishContent').append(resultWishData);		
	}
}

function showGiveData(responseGiveData, javaRoot) {
	for (var i = 0; i < 4; i++) {
		var deadlineString = `${responseGiveData[i].deadlinestring}`;
		var deadlineSplit = deadlineString.split('-');
		var dateNow = new Date();
		var dateDeadline = new Date(deadlineSplit[0], deadlineSplit[1], deadlineSplit[2]);
		var daysLeft = Math.floor((dateDeadline - dateNow) / (1000 * 60 * 60 * 24));
		var resultGiveData =
			`<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
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
							<span>By <span>${responseGiveData[i].indname_TEMP}</span></span>
							<h5>還剩 <span>` + daysLeft + `</span> 天</h5>
						</a>
					</div>
				</div>
			</div>`;

		$('#giveContent').append(resultGiveData);
	}
}

function showExchangeData(responseExchangeData, javaRoot) {
	for (var i = 0; i < 4; i++) {
		var deadlineString = `${responseExchangeData[i].deadlinestring}`;
		var deadlineSplit = deadlineString.split('-');
		var dateNow = new Date();
		var dateDeadline = new Date(deadlineSplit[0], deadlineSplit[1], deadlineSplit[2]);
		var daysLeft = Math.floor((dateDeadline - dateNow) / (1000 * 60 * 60 * 24));
		var resultExchangeData =
			`<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
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
							<span>By <span>${responseExchangeData[i].indname_TEMP}</span></span>
							<h5>還剩 <span>` + daysLeft + `</span> 天</h5>
						</a>
					</div>
				</div>
			</div>`;
			
		$('#exchangeContent').append(resultExchangeData);
	}
}