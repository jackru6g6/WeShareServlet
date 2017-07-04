<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>

	<section>
		<!--carousel幻燈片輪播-->
		<div id="sectionSlider" class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div id="carousel-id" class="carousel slide" data-ride="carousel" data-interval="4000" data-wrap="true" data-keyboard="true"
					    data-pause="hover">
						<!--幻燈片圓點-->
						<ol class="carousel-indicators">
							<!--<li data-target="#carousel-id" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-id" data-slide-to="1" class=""></li>
							<li data-target="#carousel-id" data-slide-to="2" class=""></li>-->
						</ol>
						<!--幻燈片內容-->
						<div class="carousel-inner">
							<!--第一張圖-->
							<div class="item active">
								<img class="center-block img-responsive carouselImg" src="../dist/img/carousel1.png" alt="First slide">
							</div>
							<!--第二張圖-->
							<div class="item">
								<img class="center-block img-responsive carouselImg" src="../dist/img/carousel2.png" alt="Second slide">
							</div>
							<!--第三張圖-->
							<div class="item">
								<img class="center-block img-responsive carouselImg" src="../dist/img/carousel3.png" alt="Third slide">
							</div>
						</div>
						<!--幻燈片左箭頭-->
						<a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
						<!--幻燈片右箭頭-->
						<a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
				</div>
			</div>
		</div>
		<!--物資內容-->
		<div id="sectionContent" class="container">

			<!--許願池標題-->
			<div id="wishTitle" class="row sectionTitle">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="text-left">
								<a href="wish.html" class="titleLeft">
									<i class="fa fa-tencent-weibo" aria-hidden="true"></i>
									<span class="titleLeftText">許願池</span>
								</a>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="text-right">
								<a href="#" class="titleRight">最新刊登</a>
								<span class="titleRight">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
								<a href="#" class="titleRight">即將結束</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--許願池物資清單-->
			<div id="wishContent" class="row">
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_1.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_2.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_3.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_4.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
			</div>

			<!--送愛心標題-->
			<div id="giveTitle" class="row sectionTitle">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="text-left">
								<a href="give.html" class="titleLeft">
									<i class="fa fa-heart" aria-hidden="true"></i>
									<span class="titleLeftText">送愛心</span>
								</a>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="text-right">
								<a href="#" class="titleRight">最新刊登</a>
								<span class="titleRight">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
								<a href="#" class="titleRight">即將結束</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--送愛心物資清單-->
			<div id="giveContent" class="row">
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_5.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_6.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_7.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_8.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
			</div>

			<!--以物易物標題-->
			<div id="exchangeTitle" class="row sectionTitle">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="text-left">
								<a href="exchange.html" class="titleLeft">
									<i class="fa fa-heart" aria-hidden="true"></i>
									<span class="titleLeftText">以物易物</span>
								</a>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
							<div class="text-right">
								<a href="#" class="titleRight">最新刊登</a>
								<span class="titleRight">&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span>
								<a href="#" class="titleRight">即將結束</a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--以物易物物資清單-->
			<div id="exchangeContent" class="row">
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_9.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_10.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_11.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive itemImg" src="../dist/img/300x300/20170627_12.png">
								<div class="itemOverlay">
									<p>Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.Labore aliqua ex amet mollit mollit culpa Lorem cillum magna ea cupidatat ea.</p>
								</div>
							</a>
						</div>
						<div class="itemName itemContent"><a href="#">Lepa Vida</a></div>
						<div class="itemBy itemContent">
							<a href="#">
								<h6>By <span>Matter</span> Of Mind from France</h6>
								<h5>June 21, 2017 in <span>Nominees</span></h5>
							</a>
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