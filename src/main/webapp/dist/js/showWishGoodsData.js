function showData(data, path) {
	var javaRoot = path;
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#sectionWGoods').append(resultData);		
	}
	resultData =
		`<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">

						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

							<div id="wGoodsImgLayout" class="animated fadeInLeft">
								<img id="wGoodsImg" class="img-responsive" src="${javaRoot}/_00_init/getImage?id=${responseData[0].goodsno}&type=GOODS">
							</div>

							<div id="blockWGoodsOption" class="animated fadeInLeft">
								<ul type="none" class="row">
									<li class="col-xs-12 col-sm-12 col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1">
										<a href="wishTrans.jsp?goodsno=${data[0].goodsno}" class="btn btn-default wGoodsOption" >我要捐贈</a>
									</li>
									<li class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
										<a data-toggle="modal" data-target="#sendMsg" class="btn btn-default wGoodsOption" >留言詢問</a>
									</li>
								</ul>
							</div>

							<div id="sendMsg" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">

										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">留言詢問</h4>
										</div>

										<div class="modal-body">
											<textarea class="form-control" rows="5" required="required" maxlength="200" placeholder="留言最多200字" style="resize : none;"></textarea>
										</div>
										<!-- 關閉鈕 -->
										<div class="modal-footer">
											<a href="server" type="button" class="btn btn-default">傳送訊息</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

							<div id="wGoodsInfo" class="row animated fadeInRight">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											募集物品
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].goodsname}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											募集者
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].indname_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											募集數量
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].qty}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											募集類別
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].goodsname_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											募集地區
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].localname_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											發佈時間
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].updatetime_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsCol">
											截止時間
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 wGoodsVal">
											${data[0].deadlinestring}
										</div>
									</div>
								</div>
							</div>

							<div id="wGoodsOtherInfo" class="row animated fadeInRight" role="tabpanel">

								<ul id="wGoodsOtherInfoTabs" class="nav nav-tabs col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1" role="tablist">
									<li id="wGoodsDescTabs" role="presentation" class="active">
										<a href="#wGoodsDesc" aria-controls="wGoodsDesc" role="tab" data-toggle="tab">詳細說明</a>
									</li>
									<li id="wGoodsIntroTabs" role="presentation">
										<a href="#wGoodsIntro" aria-controls="wGoodsIntro" role="tab" data-toggle="tab">需求者簡介</a>
									</li>
								</ul>

								<div id="wGoodsOtherInfoContent" class="tab-content col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
									<div id="wGoodsDesc" role="tabpanel" class="tab-pane fade active in">
										<p>${data[0].goodsnote}</p>
									</div>
									<div id="wGoodsIntro" role="tabpanel" class="tab-pane fade">
										<p>${data[0].intro_TEMP}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>`;
	$('#sectionWGoods').append(resultData);
}