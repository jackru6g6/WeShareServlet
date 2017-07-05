<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/wishGoods.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div id="sectionWGoods" class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<!-- 左邊物資圖片及按鈕區 -->
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<!-- 物資圖片 -->
							<div id="wGoodsImgLayout">
								<img id="wGoodsImg" class="img-responsive" src="../dist/img/300x300/20170627_66.png">
							</div>
							<!-- 捐贈&詢問按鈕區 -->
							<div id="blockWGoodsOption">
								<ul type="none" class="row">
									<li class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1">
										<a href="wishTrans.jsp" class="btn btn-default wGoodsOption" >我要捐贈</a>
									</li>
									<li class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
										<a href="#" class="btn btn-default wGoodsOption" >留言詢問</a>
									</li>
								</ul>
							</div>
						</div>

						<!-- 中間物資資訊 -->
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div id="wGoodsInfo" class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											需求物品
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											繪本、青少年文學、休閒類書籍
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											需求者
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											愛閱社
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											需求數量
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											不限
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											需求類別
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											書籍
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											需求地區
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											新北市
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											需求方式
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											不限
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wGoodsInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsCol">
											截止時間
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wGoodsVal">
											長期徵求
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- 右邊詳細說明及簡介 -->
						<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
							<div id="wGoodsOtherInfo" class="row" role="tabpanel">
								<!-- 項目 -->
								<ul id="wGoodsOtherInfoTabs" class="nav nav-tabs col-xs-11 col-sm-11 col-md-10 col-lg-10" role="tablist">
									<li id="wGoodsDescTabs" role="presentation" class="active">
										<a href="#wGoodsDesc" aria-controls="wGoodsDesc" role="tab" data-toggle="tab">詳細說明</a>
									</li>
									<li id="wGoodsIntroTabs" role="presentation">
										<a href="#wGoodsIntro" aria-controls="wGoodsIntro" role="tab" data-toggle="tab">需求者簡介</a>
									</li>
								</ul>
								<!-- 內容 -->
								<div id="wGoodsOtherInfoContent" class="tab-content col-xs-11 col-sm-11 col-md-10 col-lg-10">
									<div id="wGoodsDesc" role="tabpanel" class="tab-pane fade active in">
										<p>募集到的書籍將由志工帶至偏遠地區，提供給當地學童閱讀，培養閱讀習慣及興趣。</p>
									</div>
									<div id="wGoodsIntro" role="tabpanel" class="tab-pane fade">
										<p>一群愛閱讀、熱衷於宣揚閱讀的美好的無名小卒們。</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>

</body>
</html>