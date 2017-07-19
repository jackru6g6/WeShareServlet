function showData(data, path) {
	var javaRoot = path;
	var resultData;
	var score = 0;
	var scoreAvg = 0;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			目前仍未有評價！
		</div>`;
		$('.otherMember').html(resultData);
		return;
	}
	for(var i = 0; i < data.length; i++){
		resultData =
			`<!-- 其他會員評價 -->
			<div class="media">
				<div class="media-left">
					<!-- 給評者圖片 -->
					<div class="otherMemberImgLayout">
						<img class="media-object img-circle otherMemberImg" src="${javaRoot}/_00_init/getImage?id=${data[i].FBSOURCEID}&type=MEMBER">
					</div>
				</div>
				<div class="media-body">
					<!-- 給評者姓名 -->
					<h4 class="media-heading otherMemberName">${data[i].FBSOURCEID}</h4>
					<!-- 給評者評分 -->
					<div class="star-ratings otherMemberScore">

					</div>
					<!-- 給評者評語 -->
					<p class="otherMemberFeedback">${data[i].FBTEXT}</p>
					<!-- 給評日期 -->
					<h5 class="feedbackDate">${data[i].POSTDATE}</h5>
				</div>
			</div>`;
		$('.otherMember').append(resultData);
		showStars(`${data[i].FBSCORE}`);
		score += `${data[i].FBSCORE}`;
		scoreAvg = score / (i+1);
	}
	scoreCircle(score * 36);
	$('#score').append(scoreAvg);
}

// 產生星星
function showStars(e) {
	starString = "";
	// 計算全星的數量
	var star = Math.floor(e / 2);
	// 計算半星的數量
	// var starHalf = Math.ceil(e % 2);
	var starHalf = 0;
	if ((e % 2) !== 0) {
		starHalf = 1;
	}
	// 計算空星的數量
	var starO = 5 - star - starHalf;

	var starString = "";
	// 產生全星
	for (var i = 0; i < star; i++) {
		starString += `<span><i class="fa fa-star" aria-hidden="true"></i></span>`;
	}
	// 產生半星
	for (var i = 0; i < starHalf; i++) {
		starString += `<span><i class="fa fa-star-half-o" aria-hidden="true"></i></span>`;
	}
	// 產生空星
	for (var i = 0; i < starO; i++) {
		starString += `<span><i class="fa fa-star-o" aria-hidden="true"></i></span>`;
	}
	$('.otherMemberScore').append(starString);
}

// 產生評價圓圈
function scoreCircle(e) {
	var w = $('#blockCanvas').width();
	var h = $('#blockCanvas').height();
	console.log("w = " + w + ", h = " + h);
	console.log("w/2 = " + (w / 2) + ", h/2 = " + (h / 2));
	// 取得繪圖環境
	var scoreCircle = $('#blockCanvas')[0].getContext('2d');
	// 清空繪圖環境
	// scoreCircle.clearRect(0, 0, w, h)
	// 設定顏色
	scoreCircle.strokeStyle = '#87cefa';
	// 設定線寬跟兩端樣式
	scoreCircle.lineWidth = 10;
	scoreCircle.lineCap = "round";
	// 開始一條路徑或重製當前的路徑
	scoreCircle.beginPath();
	// 畫圓
	scoreCircle.arc(w / 2, h / 2, w / 4, 0, e * Math.PI / 180, false);
	// 結束
	scoreCircle.stroke();
}