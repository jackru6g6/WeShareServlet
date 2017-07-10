function showData(data, path) {
	var javaRoot = path;
	var resultData;
	if(data.length == 0){
		resultData = 
		`<div style="font-size:24px; color:#ff0000; text-align:center; margin-top:30px;">
			找不到物資唷~請重新查詢！
		</div>`;
		$('#sectionEGoods').append(resultData);		
	}
	resultData =
		`<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					
					<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
						
						<div id="eGoodsImgLayout" class="animated fadeInLeft">
							<img id="eGoodsImg" class="img-responsive" src="${javaRoot}/_00_init/getImage?id=${responseData[0].goodsno}&type=GOODS">
						</div>
						
						<div id="blockEGoodsOption" class="animated fadeInLeft">
							<ul type="none" class="row">
								<li class="col-xs-12 col-sm-12 col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1">
									<a href="exchangeTrans.jsp?goodsno=${data[0].goodsno}" class="btn btn-default eGoodsOption">我要交換</a>
								</li>
								<li class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
									<a data-toggle="modal" data-target="#sendMsg" class="btn btn-default eGoodsOption">留言詢問</a>
								</li>
							</ul>
						</div>
						
						<div id="sendMsg" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<!-- 標題 -->
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">留言詢問</h4>
									</div>
									<!-- 內容 -->
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
						
						<div id="eGoodsInfo" class="row animated fadeInRight">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										交換物品
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].goodsname}
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										交換者
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].indname_TEMP}
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										交換數量
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].qty}
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										交換類別
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].goodsname_TEMP}
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										交換地區
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].localname_TEMP}
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										發佈時間
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].updatetime_TEMP}
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="row eGoodsInfoRow">
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol">
										截止時間
									</div>
									<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal">
										${data[0].deadlinestring}
									</div>
								</div>
							</div>
						</div>
						
						<div id="eGoodsOtherInfo" class="row animated fadeInRight" role="tabpanel">
							
							<ul id="eGoodsOtherInfoTabs" class="nav nav-tabs col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1" role="tablist">
								<li id="eGoodsDescTabs" role="presentation" class="active">
									<a href="#eGoodsDesc" aria-controls="eGoodsDesc" role="tab" data-toggle="tab">詳細說明</a>
								</li>
								<li id="eGoodsIntroTabs" role="presentation">
									<a href="#eGoodsIntro" aria-controls="eGoodsIntro" role="tab" data-toggle="tab">交換者簡介</a>
								</li>
							</ul>
							
							<div id="eGoodsOtherInfoContent" class="tab-content col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
								<div id="eGoodsDesc" role="tabpanel" class="tab-pane fade active in">
									<p>${data[0].goodsnote}</p>
								</div>
								<div id="eGoodsIntro" role="tabpanel" class="tab-pane fade">
									<p>${data[0].intro_TEMP}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>`;

	$('#sectionEGoods').append(resultData);
}