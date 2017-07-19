function showData(data, path) {
	var javaRoot = path;
	var resultData;
	var score = Number(0);
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
			`<!-- 其他會員給的評價 -->
			<div class="media blockMedia">
				<div class="media-left">
					<!-- 給評者圖片 -->
					<div class="otherMemberImgLayout">
						<img class="media-object img-circle otherMemberImg" src="${javaRoot}/_00_init/getImage?id=${data[i].FBSOURCEID}&type=MEMBER">
					</div>
				</div>
				<div class="media-body">
					<!-- 給評者姓名 -->
					<h4 class="media-heading otherMemberName oMbName` + i +`"></h4>
					<!-- 給評者評分 -->
					<div class="star-ratings otherMemberScore showStars` + i +`">

					</div>
					<!-- 給評者評語 -->
					<p class="otherMemberFeedback">${data[i].FBTEXT}</p>
					<!-- 給評日期 -->
					<h5 class="feedbackDate">${data[i].POSTDATE}</h5>
				</div>
			</div>`;
		$('.otherMember').append(resultData);
		otherMbName(`${data[i].FBSOURCEID}`, i);
		showStars(`${data[i].FBSCORE}`, i);
		score += Number(`${data[i].FBSCORE}`);
	}
	scoreAvg = Math.round((score / (i)) * 10) / 10;
	scoreCircle(scoreAvg * 36);
	$('#score').append(scoreAvg + "分");
}

// 取得給評者姓名
function otherMbName(e, i){
	var xhrOMbName = new XMLHttpRequest();
	xhrOMbName.open('GET', javaRoot + '/web/_00_intit/getNameByKey?key=' + e, true);
	xhrOMbName.send();
	xhrOMbName.onreadystatechange = function(){
		if(xhrOMbName.status == 200 && xhrOMbName.readyState == 4){
			var responseONameData = JSON.parse(xhrOMbName.responseText);
			// 產生class名稱，將給評者姓名放到相對應的位置
			var oMbNameClass = ".oMbName" + i;
			$(oMbNameClass).append(responseONameData.Message);
		}
	}
}

// 產生星星
function showStars(e, i) {
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
	for (var x = 0; x < star; x++) {
		starString += `<span><i class="fa fa-star" aria-hidden="true"></i></span>`;
	}
	// 產生半星
	for (var x = 0; x < starHalf; x++) {
		starString += `<span><i class="fa fa-star-half-o" aria-hidden="true"></i></span>`;
	}
	// 產生空星
	for (var x = 0; x < starO; x++) {
		starString += `<span><i class="fa fa-star-o" aria-hidden="true"></i></span>`;
	}
	// 產生class名稱，將starString放到相對應的位置
	var showStarsClass = ".showStars" + i;
	$(showStarsClass).append(starString);
}

// 產生評價圓圈
//window.requestAnimationFrame()
(function() {
  var requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame ||
                              window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
  window.requestAnimationFrame = requestAnimationFrame;
})();

function scoreCircle(e) {
	var w = $('#blockCanvas').width();
	var h = $('#blockCanvas').height();
	// 取得繪圖環境
	var scoreCircle = $('#blockCanvas')[0].getContext('2d');
	// 起始數值
	var curPerc = 0;
	// 結束數值
	var endPercent = e;
	
	// 底部灰圈
	scoreCircle.strokeStyle = '#ececec';
    scoreCircle.lineWidth = 10;
    scoreCircle.beginPath();
    scoreCircle.arc(w / 2, h / 2, w / 4, 0, 2 * Math.PI, false);
    scoreCircle.stroke();
	
	function animate(x){
		// 設定顏色
		scoreCircle.strokeStyle = '#87cefa';
		// 設定線寬
		scoreCircle.lineWidth = 10;
		// 開始一條路徑或重製當前的路徑
		scoreCircle.beginPath();
		// 畫圓
		scoreCircle.arc(w / 2, h / 2, w / 4, 0, x * Math.PI / 180, false);
		// 結束
		scoreCircle.stroke();
		// curPerc每次加3
	    curPerc+=3;
	    // 若curPerc沒大於endPercent，繼續執行animate()
	    if (curPerc <= endPercent) {
	        requestAnimationFrame(function () {
	          animate(curPerc);
	        });
	    }
	}
	animate();
}