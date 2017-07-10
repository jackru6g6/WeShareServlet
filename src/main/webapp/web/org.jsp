<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/org.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<script src="../dist/js/org.js"></script>
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>

	<section>
		<div id="sectionOrg">
			<!-- 篩選器 -->
			<div id="sectionOrgFilter" class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="row">
							<!-- 關鍵字搜尋 -->
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<div id="blockKWSearch">
									<input id="searchInput" type="search" class="form-control" placeholder="搜尋">
									<span id="btKWSearch"><i class="fa fa-search" aria-hidden="true"></i></span>
								</div>
							</div>
							<!-- 社福團體類型搜尋 -->
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<div id="blockTypeSearch">
									<select id="searchType" name="server" class="form-control">
										<option selected style="display: none;">社福團體類型</option>
										<option value="server">兒少福利</option>
										<option value="server">偏鄉教育</option>
										<option value="server">老人福利</option>
										<option value="server">身障福利</option>
										<option value="server">其他</option>
									</select>
								</div>
							</div>
							<!-- 社福團體所在地搜尋 -->
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<div id="blockLocSearch">
									<select id="searchLoc" name="server" class="form-control">
										<option selected style="display: none;">社福團體所在地</option>
										<option value="server">北部(基隆市、臺北市、新北市、桃園市、新竹市、新竹縣)</option>
										<option value="server">中部(苗栗縣、臺中市、南投縣、彰化縣、雲林縣)</option>
										<option value="server">南部(嘉義市、嘉義縣、臺南市、高雄市、屏東縣)</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 社福團體簡介 -->
			<div id="sectionOrgAbout" class="container">
				<!-- 社福團體簡介第一筆 -->
				<div class="rowOrg">
					<!-- 上層翻轉列 -->
					<div class="rowUpper">
						<!-- 上左_圖片 -->
						<div class="orgImgLayout blockUpper">
							<img class="img-responsive orgImg" src="../dist/img/300x300/20170627_47.png">
						</div>
						<!-- 上右_地圖 -->
						<div class="orgMap blockUpper">
						</div>
					</div>

					<!-- 下層固定列 -->
					<div class="rowLower">
						<!-- 底左_聯絡資訊 -->
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
										<span>330桃園市桃園區復興路205號15樓-4</span>
									</li>
									<li><i class="fa fa-globe" aria-hidden="true"></i>
										<a href="http://www.ecpat.org.tw" target="_blank">http://www.ecpat.org.tw</a>
									</li>
								</ul>
								<a href="wish.jsp" type="button" class="orgGoods btn btn-default">查看募集物資</a>
							</div>
						</div>

						<!-- 底右_放簡介 -->
						<div class="orgInfo blockLower">
							<div class="orgInfoList">
								<div class="orgName">台灣展翅協會</div>
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
				</div>
				
				<!-- 社福團體簡介第二筆 -->
				<div class="rowOrg">
					<!-- 上層翻轉列 -->
					<div class="rowUpper">
						<!-- 上左_圖片 -->
						<div class="orgImgLayout blockUpper">
							<img class="img-responsive orgImg" src="../dist/img/300x300/20170627_47.png">
						</div>
						<!-- 上右_地圖 -->
						<div class="orgMap blockUpper">
						</div>
					</div>

					<!-- 下層固定列 -->
					<div class="rowLower">
						<!-- 底左_聯絡資訊 -->
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
										<span>330桃園市桃園區復興路205號15樓-4</span>
									</li>
									<li><i class="fa fa-globe" aria-hidden="true"></i>
										<a href="http://www.ecpat.org.tw" target="_blank">http://www.ecpat.org.tw</a>
									</li>
								</ul>
								<a href="wish.jsp" type="button" class="orgGoods btn btn-default">查看募集物資</a>
							</div>
						</div>

						<!-- 底右_放簡介 -->
						<div class="orgInfo blockLower">
							<div class="orgInfoList">
								<div class="orgName">台灣展翅協會</div>
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
				</div>
				
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
	
<%-- 	<script src="${pageContext.request.contextPath}/dist/js/showIndexData.js?t=2"></script> --%>
<!-- 	<script type="text/javascript"> -->
<%-- 		var javaRoot = "${pageContext.servletContext.contextPath}"; --%>
<!-- 		var xhrWish = new XMLHttpRequest(); -->
<!-- 		var xhrGive = new XMLHttpRequest(); -->
<!-- 		var xhrExchange = new XMLHttpRequest(); -->
<!-- 		var servletPath = javaRoot + '/_08_query/Query.do?goodsstatus='; -->
<!-- 		var responseWishData; -->
<!-- 		var responseGiveData; -->
<!-- 		var responseExchangeData; -->
		
<!-- 		// 頁面載入時 -->
<!-- 		window.onload = function(){ -->
<!-- 			xhrWish.open('GET', servletPath + '1', true); -->
<!-- 			xhrWish.send(); -->
<!-- 			xhrWish.onreadystatechange = function(){ -->
<!-- 				if(xhrWish.status == 200 && xhrWish.readyState == 4){ -->
<!-- 					responseWishData = JSON.parse(xhrWish.responseText); -->
<!-- 					console.log("-------------------"); -->
<!-- 					console.log("首頁許願池符合的資料筆數:" + responseWishData.length); -->
<!-- 					console.log("-------------------"); -->
<!-- 					showWishData(responseWishData, javaRoot, "updatetime", "desc"); -->
<!-- 				} -->
<!-- 			} -->
<!-- 		}; -->
<!-- 	</script> -->
		
	<!-- Google Maps Api -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBm5pII1q2w0d3GQLjGIdrCKFHB_WL6qvc&callback=orgMap" async defer></script>

	<script>
		// 點下層固定列，翻轉上層翻轉列
		$(function(){
			$(".rowLower").click(function () {
				turnPage($(this));
			});
		});
	</script>
	
</body>

</html>