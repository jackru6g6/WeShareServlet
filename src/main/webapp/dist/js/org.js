function showData(data) {
	for (var i = 0; i < data.length; i++) {
		var result =
		`<div class="rowOrg">
			<div class="rowUpper">

				<div class="orgImgLayout blockUpper">
					<img class="img-responsive orgImg" src="../dist/img/300x300/20170627_47.png">
				</div>

				<div class="orgMap blockUpper">
					<iframe class="iframeMap" frameborder='0' scrolling='no' marginheight='0' marginwidth='0' src='http://maps.google.com.tw/maps?f=q&hl=zh-TW&geocode=&q=${data[i].address}&z=15&output=embed&t='></iframe>
				</div>
			</div>

			<div class="rowLower">

				<div class="orgContact blockLower">
					<div class="orgContactList">
						<ul type="none">
							<li><i class="fa fa-phone" aria-hidden="true"></i>
								<span>03-3353545</span>
							</li>
							<li><i class="fa fa-envelope" aria-hidden="true"></i>
								<a href="mailto:winnie@ecpat.org.tw">winnie@ecpat.org.tw</a>
							</li>
							<li><i class="fa fa-home" aria-hidden="true"></i>
								<span>${data[i].address}</span>
							</li>
							<li><i class="fa fa-globe" aria-hidden="true"></i>
								<a href="http://www.ecpat.org.tw" target="_blank">http://www.ecpat.org.tw</a>
							</li>
						</ul>
						<a href="wish.jsp" type="button" class="orgGoods btn btn-default">查看募集物資</a>
					</div>
				</div>

				<div class="orgInfo blockLower">
					<div class="orgInfoList">
						<div class="orgName">${data[i].name}</div>
						<ul type="none">
							<li><i class="fa fa-heart" aria-hidden="true"></i>社福類別：
								<span>兒少福利</span>
							</li>
							<li><i class="fa fa-heart" aria-hidden="true"></i>社福負責人：
								<span>高亘瑩</span>
							</li>
							<li><i class="fa fa-heart" aria-hidden="true"></i>立案核准字號：
								<span>台內社字第8375183號</span>
							</li>
							<li><i class="fa fa-heart" aria-hidden="true"></i>勸募許可字號：
								<span>衛部救字第1051360904號</span>
							</li>
							<li>
								<span>提倡兒童人權、預防兒少商業性剝削、兒少上網安全與反人口販運，我們期望匯集眾人的力量，協助受傷的孩子擁有能力與機會，如鷹展翅高飛。</span>
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
	// $(this).closest('.rowOrg').find('.rowUpper').toggleClass('rotate180');
	e.closest('.rowOrg').find('.rowUpper').toggleClass('rotate180');
	// $(this).closest('.rowOrg').find('.rowUpper').css('zIndex', 300);
}