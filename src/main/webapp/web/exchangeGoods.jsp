<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/exchangeGoods.css">
	<!-- Animate CSS-->
	<link rel="stylesheet" type="text/css" href="../dist/bower_components/animate.css/animate.min.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div id="sectionEGoods" class="container">
<!-- 			<div class="row"> -->
<!-- 				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 					<div class="row"> -->
<!-- 						物資圖片及按鈕區 -->
<!-- 						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6"> -->
<!-- 							物資圖片 -->
<!-- 							<div id="eGoodsImgLayout" class="animated fadeInLeft"> -->
<!-- 								<img id="eGoodsImg" class="img-responsive" src="../dist/img/300x300/20170627_49.png"> -->
<!-- 							</div> -->
<!-- 							交換&詢問按鈕區 -->
<!-- 							<div id="blockEGoodsOption" class="animated fadeInLeft"> -->
<!-- 								<ul type="none" class="row"> -->
<!-- 									<li class="col-xs-12 col-sm-12 col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1"> -->
<!-- 										<a href="exchangeTrans.html" class="btn btn-default eGoodsOption">我要交換</a> -->
<!-- 									</li> -->
<!-- 									<li class="col-xs-12 col-sm-12 col-md-5 col-lg-5"> -->
<!-- 										<a data-toggle="modal" data-target="#sendMsg" class="btn btn-default eGoodsOption">留言詢問</a> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</div> -->
<!-- 							留言詢問 -->
<!-- 							<div id="sendMsg" class="modal fade" role="dialog"> -->
<!-- 								<div class="modal-dialog"> -->
<!-- 									<div class="modal-content"> -->
<!-- 										標題 -->
<!-- 										<div class="modal-header"> -->
<!-- 											<button type="button" class="close" data-dismiss="modal">&times;</button> -->
<!-- 											<h4 class="modal-title">留言詢問</h4> -->
<!-- 										</div> -->
<!-- 										內容 -->
<!-- 										<div class="modal-body"> -->
<!-- 											<textarea class="form-control" rows="5" required="required" maxlength="200" placeholder="留言最多200字" style="resize : none;"></textarea> -->
<!-- 										</div> -->
<!-- 										關閉鈕 -->
<!-- 										<div class="modal-footer"> -->
<!-- 											<a href="server" type="button" class="btn btn-default">傳送訊息</a> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6"> -->
<!-- 							物資資訊 -->
<!-- 							<div id="eGoodsInfo" class="row animated fadeInRight"> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											交換物品 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											繪本、青少年文學、休閒類書籍 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											交換者 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											愛閱社 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											交換數量 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											不限 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											交換類別 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											書籍 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											交換地區 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											新北市 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											發佈時間 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											2017-07-01 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row eGoodsInfoRow"> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsCol"> -->
<!-- 											截止時間 -->
<!-- 										</div> -->
<!-- 										<div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 eGoodsVal"> -->
<!-- 											長期徵求 -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							詳細說明及簡介 -->
<!-- 							<div id="eGoodsOtherInfo" class="row animated fadeInRight" role="tabpanel"> -->
<!-- 								項目 -->
<!-- 								<ul id="eGoodsOtherInfoTabs" class="nav nav-tabs col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1" role="tablist"> -->
<!-- 									<li id="eGoodsDescTabs" role="presentation" class="active"> -->
<!-- 										<a href="#eGoodsDesc" aria-controls="eGoodsDesc" role="tab" data-toggle="tab">詳細說明</a> -->
<!-- 									</li> -->
<!-- 									<li id="eGoodsIntroTabs" role="presentation"> -->
<!-- 										<a href="#eGoodsIntro" aria-controls="eGoodsIntro" role="tab" data-toggle="tab">交換者簡介</a> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 								內容 -->
<!-- 								<div id="eGoodsOtherInfoContent" class="tab-content col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1"> -->
<!-- 									<div id="eGoodsDesc" role="tabpanel" class="tab-pane fade active in"> -->
<!-- 										<p>募集到的書籍將由志工帶至偏遠地區，提供給當地學童閱讀，培養閱讀習慣及興趣。</p> -->
<!-- 									</div> -->
<!-- 									<div id="eGoodsIntro" role="tabpanel" class="tab-pane fade"> -->
<!-- 										<p>一群愛閱讀、熱衷於宣揚閱讀的美好的無名小卒們。</p> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
	</section>
	
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
	
	<script src="${pageContext.request.contextPath}/dist/js/showExchangeGoodsData.js"></script>
	<script type="text/javascript">
		var goodsno = location.search.slice(1);
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var xhr = new XMLHttpRequest();
		var servletPath = javaRoot + '/_08_query/GoodsQuery.do?' + goodsno;
		var responseData;
		
		// 頁面載入時
		window.onload = function(){					
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);					
					showData(responseData, javaRoot);
				}
			}
		}
	</script>
	

</body>
</html>