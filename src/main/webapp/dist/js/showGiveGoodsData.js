function showData(data, path) {
	var javaRoot = path;
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#sectionGGoods').append(resultData);		
	}
	resultData =
		`<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							
							<div id="gGoodsImgLayout" class="animated fadeInLeft">
								<img id="gGoodsImg" class="img-responsive" src="${javaRoot}/_00_init/getImage?id=${responseData[0].goodsno}&type=GOODS">
							</div>
							
							<div id="blockGGoodsOption" class="animated fadeInLeft">
								<ul type="none" class="row">
									<li class="col-xs-12 col-sm-12 col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1">
										<a href="giveTrans.jsp?goodsno=${data[0].goodsno}" class="btn btn-default gGoodsOption" >我要索取</a>
									</li>
									<li class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
										<a data-toggle="modal" data-target="#sendMsg" class="btn btn-default gGoodsOption" >留言詢問</a>
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
										
										<div class="modal-footer">
											<a href="server" type="button" class="btn btn-default">傳送訊息</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							
							<div id="gGoodsInfo" class="row animated fadeInRight">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											贈送物品
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].goodsname}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											贈送者
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].indname_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											贈送數量
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].qty}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											贈送類別
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].goodsname_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											贈送地區
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].localname_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											發佈時間
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].updatetime_TEMP}
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row gGoodsInfoRow">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsCol">
											截止時間
										</div>
										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 gGoodsVal">
											${data[0].deadlinestring}
										</div>
									</div>
								</div>
							</div>
							
							<div id="gGoodsOtherInfo" class="row animated fadeInRight" role="tabpanel">
								
								<ul id="gGoodsOtherInfoTabs" class="nav nav-tabs col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1" role="tablist">
									<li id="gGoodsDescTabs" role="presentation" class="active">
										<a href="#gGoodsDesc" aria-controls="gGoodsDesc" role="tab" data-toggle="tab">詳細說明</a>
									</li>
									<li id="gGoodsIntroTabs" role="presentation">
										<a href="#gGoodsIntro" aria-controls="gGoodsIntro" role="tab" data-toggle="tab">贈送者簡介</a>
									</li>
								</ul>
								
								<div id="gGoodsOtherInfoContent" class="tab-content col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
									<div id="gGoodsDesc" role="tabpanel" class="tab-pane fade active in">
										<p>${data[0].goodsnote}</p>
									</div>
									<div id="gGoodsIntro" role="tabpanel" class="tab-pane fade">
										<p>${data[0].intro_TEMP}</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>`;

	$('#sectionGGoods').append(resultData);
}