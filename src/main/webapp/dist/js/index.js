// 資料排序
function sortJSON(data, colName, way) {
	return data.sort(function(a, b){
		var x = a[colName];
		var y = b[colName];
		if (way == "asce"){
			return ( (x < y) ? -1 : ( (x > y) ? 1 : 0) );
		}
		if (way == "desc"){
			return ( (x > y) ? -1 : ( (x < y) ? 1 : 0) );
		}	
	});
}

// 許願池物資
function showWishData(data, path, colName, way) {
	sortJSON(data, colName, way);
	var javaRoot = path;
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
						<a href="wishGoods.jsp?goodsno=${responseWishData[i].goodsno}" class="itemA">
							<img class="img-responsive itemImg" src="${javaRoot}/_00_init/getImage?id=${responseWishData[i].goodsno}&type=GOODS">
							<span class="imgBackground"></span>
							<div class="itemOverlay">
								<p>${responseWishData[i].goodsnote}</p>
							</div>
						</a>
					</div>
					<div class="itemName itemContent"><a href="wishGoods.jsp?goodsno=${responseWishData[i].goodsno}">${responseWishData[i].goodsname}</a></div>
					<div class="itemBy itemContent">
						<a href="wish.jsp?${responseWishData[i].indname_TEMP}">
							<span>By <span>${responseWishData[i].indname_TEMP}</span></span>
							<h5>還剩 <span>` + daysLeft + `</span> 天</h5>
						</a>
					</div>
				</div>
			</div>`;
		$('#wishContent').append(resultWishData);		
	}
}

// 送愛心物資
function showGiveData(data, path, colName, way) {
	sortJSON(data, colName, way);
	var javaRoot = path;
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
						<a href="giveGoods.jsp?goodsno=${responseGiveData[i].goodsno}" class="itemA">
							<img class="img-responsive itemImg" src="${javaRoot}/_00_init/getImage?id=${responseGiveData[i].goodsno}&type=GOODS">
							<span class="imgBackground"></span>
							<div class="itemOverlay">
								<p>${responseGiveData[i].goodsnote}</p>
							</div>
						</a>
					</div>
					<div class="itemName itemContent"><a href="giveGoods.jsp?goodsno=${responseGiveData[i].goodsno}">${responseGiveData[i].goodsname}</a></div>
					<div class="itemBy itemContent">
						<a href="give.jsp?${responseGiveData[i].indname_TEMP}">
							<span>By <span>${responseGiveData[i].indname_TEMP}</span></span>
							<h5>還剩 <span>` + daysLeft + `</span> 天</h5>
						</a>
					</div>
				</div>
			</div>`;
		$('#giveContent').append(resultGiveData);
	}
}

// 以物易物物資
function showExchangeData(data, path, colName, way) {
	sortJSON(data, colName, way);
	var javaRoot = path;
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
						<a href="exchangeGoods.jsp?goodsno=${responseExchangeData[i].goodsno}" class="itemA">
							<img class="img-responsive itemImg" src="${javaRoot}/_00_init/getImage?id=${responseExchangeData[i].goodsno}&type=GOODS">
							<span class="imgBackground"></span>
							<div class="itemOverlay">
								<p>${responseExchangeData[i].goodsnote}</p>
							</div>
						</a>
					</div>
					<div class="itemName itemContent"><a href="exchangeGoods.jsp?goodsno=${responseExchangeData[i].goodsno}">${responseExchangeData[i].goodsname}</a></div>
					<div class="itemBy itemContent">
						<a href="exchange.jsp?${responseExchangeData[i].indname_TEMP}">
							<span>By <span>${responseExchangeData[i].indname_TEMP}</span></span>
							<h5>還剩 <span>` + daysLeft + `</span> 天</h5>
						</a>
					</div>
				</div>
			</div>`;
		$('#exchangeContent').append(resultExchangeData);
	}
}