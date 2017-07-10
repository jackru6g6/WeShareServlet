// 載入Google Maps
function orgMap() {
	var area = document.querySelector('.orgMap');
	var geocoder= new google.maps.Geocoder();
	var orgAddress = "330桃園市桃園區復興路205號";
	console.log("orgAddress = " + orgAddress);
	geocoder.geocode({'address':orgAddress}, function(results, status){
		if(status == google.maps.GeocoderStatus.OK){
			var orgPosition = new google.maps.LatLng(results[0].geometry.location.lat(), results[0].geometry.location.lng());
			var map = new google.maps.Map(area, {
				zoom: 15,
				center: orgPosition,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			});

			var marker = new google.maps.Marker({
				position: orgPosition,
				map: map,
				icon: '../dist/img/WeShare_icon_s.png',
				title: '台灣展翅協會' //滑鼠游標移至position時顯示的文字
			});
		}
	});
}

// 點下層固定列，翻轉上層翻轉列
function turnPage(e) {
	// $(this).closest('.rowOrg').find('.rowUpper').toggleClass('rotate180');
	e.closest('.rowOrg').find('.rowUpper').toggleClass('rotate180');
	// $(this).closest('.rowOrg').find('.rowUpper').css('zIndex', 300);
}