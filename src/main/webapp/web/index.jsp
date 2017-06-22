<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">

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
							<li data-target="#carousel-id" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-id" data-slide-to="1" class=""></li>
							<li data-target="#carousel-id" data-slide-to="2" class=""></li>
						</ol>
						<!--幻燈片內容-->
						<div class="carousel-inner">
							<!--第一張圖-->
							<div class="item active">
								<img class="center-block img-responsive carouselImg" data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="First slide"
								    src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI5MDAiIGhlaWdodD0iNTAwIj48cmVjdCB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgZmlsbD0iIzc3NyI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjQ1MCIgeT0iMjUwIiBzdHlsZT0iZmlsbDojN2E3YTdhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjU2cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+Rmlyc3Qgc2xpZGU8L3RleHQ+PC9zdmc+">
								<div class="container">
									<div class="carousel-caption">
										<h1>第一張圖</h1>
										<p>第一張圖文字說明</p>
										<p><a class="btn btn-lg btn-primary" href="#" role="button">第一張圖連結</a></p>
									</div>
								</div>
							</div>
							<!--第二張圖-->
							<div class="item">
								<img class="center-block img-responsive carouselImg" data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Second slide"
								    src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI5MDAiIGhlaWdodD0iNTAwIj48cmVjdCB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgZmlsbD0iIzY2NiI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjQ1MCIgeT0iMjUwIiBzdHlsZT0iZmlsbDojNmE2YTZhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjU2cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+U2Vjb25kIHNsaWRlPC90ZXh0Pjwvc3ZnPg==">
								<div class="container">
									<div class="carousel-caption">
										<h1>第二張圖</h1>
										<p>第二張圖文字說明</p>
										<p><a class="btn btn-lg btn-primary" href="#" role="button">第二張圖連結</a></p>
									</div>
								</div>
							</div>
							<!--第三張圖-->
							<div class="item">
								<img class="center-block img-responsive carouselImg" data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide" alt="Third slide"
								    src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI5MDAiIGhlaWdodD0iNTAwIj48cmVjdCB3aWR0aD0iOTAwIiBoZWlnaHQ9IjUwMCIgZmlsbD0iIzU1NSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjQ1MCIgeT0iMjUwIiBzdHlsZT0iZmlsbDojNWE1YTVhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjU2cHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+VGhpcmQgc2xpZGU8L3RleHQ+PC9zdmc+">
								<div class="container">
									<div class="carousel-caption">
										<h1>第三張圖</h1>
										<p>第三張圖文字說明</p>
										<p><a class="btn btn-lg btn-primary" href="#" role="button">第三張圖連結</a></p>
									</div>
								</div>
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
						<div class="col-xs-4 col-sm-6 col-md-6 col-lg-6">
							<div class="text-left">
								<a href="#" class="titleLeft">許願池</a>
							</div>
						</div>
						<div class="col-xs-8 col-sm-6 col-md-6 col-lg-6">
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
			<div id="wishContent" class="row ">
				<!--<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<a href="#"><img class="img-responsive" src="../dist/img/WeShare_logo.png"></a>
						<div class="itemGroup itemContent"><a href="#">物資1社福團體</a></div>
						<div class="itemName itemContent"><a href="#">物資1名稱</a></div>
						<div class="itemText itemContent">物資1說明</div>
					</div>
				</div>-->
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資1發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資1名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資2發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資2名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資3發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資3名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="wishItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資4發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資4名稱</a></div>
					</div>
				</div>
			</div>

			<!--送愛心標題-->
			<div id="giveTitle" class="row sectionTitle">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<div class="col-xs-4 col-sm-6 col-md-6 col-lg-6">
							<div class="text-left">
								<a href="#" class="titleLeft">送愛心</a>
							</div>
						</div>
						<div class="col-xs-8 col-sm-6 col-md-6 col-lg-6">
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
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資1發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資1名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資2發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資2名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資3發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資3名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="giveItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資4發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資4名稱</a></div>
					</div>
				</div>
			</div>

			<!--以物易物標題-->
			<div id="exchangeTitle" class="row sectionTitle">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<div class="col-xs-4 col-sm-6 col-md-6 col-lg-6">
							<div class="text-left">
								<a href="#" class="titleLeft">以物易物</a>
							</div>
						</div>
						<div class="col-xs-8 col-sm-6 col-md-6 col-lg-6">
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
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資1發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資1名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資2發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資2名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資3發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資3名稱</a></div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<div class="exchangeItem">
						<div>
							<a href="#" class="itemA">
								<img class="img-responsive" src="../dist/img/WeShare_logo.png">
								<div class="itemOverlay">詳細說明</div>
							</a>
						</div>
						<div class="itemBy itemContent"><a href="#">物資4發佈者</a></div>
						<div class="itemName itemContent"><a href="#">物資4名稱</a></div>
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