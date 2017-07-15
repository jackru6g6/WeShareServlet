function showData(data) {
	$('#sectionOrgAbout').empty();
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#sectionOrgAbout').append(resultData);
		return;
	}
	for (var i = 0; i < data.length; i+=2) {
		var result =
		`<div class="rowOrg">
			<!-- 上層翻轉列 -->
			<div class="rowUpper">
				<!-- 上左_圖片 -->
				<div class="orgImgLayout blockUpper">
					<img class="img-responsive orgImg" src="${javaRoot}/_00_init/getImage?id=${data[i].orgfileName}&type=ORG">
				</div>
				<!-- 上右_地圖 -->
				<div class="orgMap blockUpper">
					<iframe class="iframeMap" frameborder='0' scrolling='no' marginheight='0' marginwidth='0' src='http://maps.google.com.tw/maps?f=q&hl=zh-TW&geocode=&q=${data[i].indaddress}&z=15&output=embed&t='></iframe>
				</div>
			</div>
			
			<!-- 下層固定列 -->
			<div class="rowLower">
				<!-- 底左_聯絡資訊 -->
				<div class="orgContact blockLower">
					<div class="orgContactList">
						<ul type="none">
							<li><i class="fa fa-phone" aria-hidden="true"></i>
								<span>${data[i].indphone}</span>
							</li>
							<li><i class="fa fa-envelope" aria-hidden="true"></i>
								<a href="mailto:${data[i].indemail}">${data[i].indemail}</a>
							</li>
							<li><i class="fa fa-home" aria-hidden="true"></i>
								<span>${data[i].indaddress}</span>
							</li>
							<li><i class="fa fa-globe" aria-hidden="true"></i>
								<a href="${data[i+1].website}" target="_blank">${data[i+1].website}</a>
							</li>
						</ul>
						<a href="wish.jsp?${data[i].indname}" type="button" class="orgGoods btn btn-default">查看募集物資</a>
					</div>
				</div>
				<!-- 底右_簡介 -->
				<div class="orgInfo blockLower">
					<div class="orgInfoList">
						<div class="orgName">${data[i].indname}</div>
						<ul type="none">
							<li><i class="fa fa-heart" aria-hidden="true"></i>社福類別：
								<span>${data[i+1].orgname_TEMP}</span>
							</li>
							<li><i class="fa fa-heart" aria-hidden="true"></i>社福負責人：
								<span>${data[i+1].leader}</span>
							</li>
							<li><i class="fa fa-heart" aria-hidden="true"></i>立案核准字號：
								<span>${data[i+1].registerno}</span>
							</li>
							<li><i class="fa fa-heart" aria-hidden="true"></i>勸募許可字號：
								<span>${data[i+1].raiseno}</span>
							</li>
							<li>
								<span>${data[i+1].intro}</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>`;
		$('#sectionOrgAbout').append(result);
	}
}

// 點下層固定列，翻轉上層翻轉列
function turnPage(e) {
	// $(this).closest('.rowOrg').find('.rowUpper').css('zIndex', 300);
	
	// 如果rowUpper的class有'rotate180'(地圖)，就加上'rotate0'(社福圖片)並移除'rotate180'
	if (e.closest('.rowOrg').find('.rowUpper').hasClass('rotate180')) {
		// $(this).closest('.rowOrg').find('.rowUpper').addClass('rotate0').removeClass('rotate180');
		e.closest('.rowOrg').find('.rowUpper').addClass('rotate0').removeClass('rotate180');
	} else {
		e.closest('.rowOrg').find('.rowUpper').addClass('rotate180').removeClass('rotate0');
	}
}