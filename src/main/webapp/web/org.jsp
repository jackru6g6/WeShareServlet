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
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<div id="blockKWSearch">
									<input id="searchInput" type="search" class="form-control" placeholder="搜尋">
									<span id="btKWSearch"><i class="fa fa-search" aria-hidden="true"></i></span>
								</div>
							</div>
							<!-- 社福團體類型搜尋 -->
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<div id="blockTypeSearch">
									<select id="searchType" name="orgtypes" class="form-control selectSearch">
										<option selected style="display: none;">社福團體類型</option>
										<option value="1" class="opFilterType">兒少福利</option>
										<option value="2" class="opFilterType">偏鄉教育</option>
										<option value="3" class="opFilterType">老人福利</option>
										<option value="4" class="opFilterType">身障福利</option>
										<option value="5" class="opFilterType">其他類型</option>
									</select>
								</div>
							</div>
							<!-- 社福團體所在地搜尋 -->
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<div id="blockLocSearch">
									<select id="searchLoc" name="indaddress" class="form-control selectSearch">
										<option selected style="display: none;">社福團體所在地</option>
										<option value="台北市">臺北市</option>
										<option value="新北市">新北市</option>
										<option value="桃園市">桃園市</option>
										<option value="新竹縣">新竹縣</option>
										<option value="苗栗縣">苗栗縣</option>
										<option value="台中市">臺中市</option>
										<option value="高雄市">高雄市</option>
									</select>
								</div>
							</div>
							<!-- 清除搜尋條件 -->
							<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
								<div id="blockClearSearch">
									<span id="btClearSearch"><i class="fa fa-times" aria-hidden="true"></i>清除搜尋條件</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 社福團體簡介 -->
			<div id="sectionOrgAbout" class="container">
				
			</div>
			
			<!-- 回到頂端 -->
			<div id="toTop">
				<i class="fa fa-chevron-circle-up" aria-hidden="true"></i>
			</div>
		</div>
	</section>

	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
	<script src="${pageContext.request.contextPath}/dist/js/org.js"></script>
	<script type="text/javascript">
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var xhr = new XMLHttpRequest();
		var servletPath = javaRoot + '/_08_query/OrgQuery.do';
		var responseData;
		
		// 頁面載入時
		window.onload = function(){
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);

					// 產生社福資料
					showData(responseData, javaRoot);
					
					// 點下層固定列，翻轉上層翻轉列
					$(".rowLower").click(function () {
						turnPage($(this));
					});
					
					// 中止冒泡事件，當orgName、li、a被點選時不會翻轉
					$('.orgName').click(function (e) {
						e.stopPropagation();
					});
					$('li').click(function (e) {
						e.stopPropagation();
					});
					$('a').click(function (e) {
						e.stopPropagation();
					});
				}
			}
		};
		
		// 關鍵字查詢
		$('#searchInput').keydown(function(e){
			if(e.keyCode == 13){
				keyWordSearch();
			}
		});
		$('#btKWSearch').click(function(){
			keyWordSearch();
		});
		function keyWordSearch(){
			servletPath = javaRoot + '/_08_query/OrgQuery.do';
			var keyWord = $('#searchInput').val();
			servletPath += '?&type=keyword&value=' + keyWord;
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);
					
					// 產生社福資料
					showData(responseData, javaRoot);
					
					// 點下層固定列，翻轉上層翻轉列
					$(".rowLower").click(function () {
						turnPage($(this));
					});
					
					// 中止冒泡事件，當orgName、li、a被點選時不會翻轉
					$('.orgName').click(function (e) {
						e.stopPropagation();
					});
					$('li').click(function (e) {
						e.stopPropagation();
					});
					$('a').click(function (e) {
						e.stopPropagation();
					});
				}
			}
		}
		
		// 類別、地點查詢
		$('.selectSearch').change(function(){
			servletPath = javaRoot + '/_08_query/OrgQuery.do';
			var col = $(this).attr("name");
			var val = $(this).val();
			servletPath += '?&type=' + col + '&value=' + val;
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);
					
					// 產生社福資料
					showData(responseData, javaRoot);
					
					// 清空關鍵字內容
					$('#searchInput').val("");
					
					// 點下層固定列，翻轉上層翻轉列
					$(".rowLower").click(function () {
						turnPage($(this));
					});
					
					// 中止冒泡事件，當orgName、li、a被點選時不會翻轉
					$('.orgName').click(function (e) {
						e.stopPropagation();
					});
					$('li').click(function (e) {
						e.stopPropagation();
					});
					$('a').click(function (e) {
						e.stopPropagation();
					});
				}
			}
		});
		
		// 清除搜尋條件
		$('#btClearSearch').click(function(){
			servletPath = javaRoot + '/_08_query/OrgQuery.do';
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);
					
					// 產生社福資料
					showData(responseData, javaRoot);
					
					// 清空選項內容
					$('#searchInput').val("");
					$('#searchType option').attr("selected", false);
					$('#searchType option:eq(0)').attr("selected", true);
					$('#searchLoc option').attr("selected", false);
					$('#searchLoc option:eq(0)').attr("selected", true);
					
					// 點下層固定列，翻轉上層翻轉列
					$(".rowLower").click(function () {
						turnPage($(this));
					});
					
					// 中止冒泡事件，當orgName、li、a被點選時不會翻轉
					$('.orgName').click(function (e) {
						e.stopPropagation();
					});
					$('li').click(function (e) {
						e.stopPropagation();
					});
					$('a').click(function (e) {
						e.stopPropagation();
					});
				}
			}
		});
		
		// 捲軸距離頂端超過300px時，出現回到頂端圖示
		$(window).scroll(function(){
			if($(this).scrollTop() > 300){
				$('#toTop').css('right', '0px');
				$('#toTop').addClass('toTopRotate').removeClass('toTopLeave');
			} else {
				$('#toTop').css('right', '-50px');
				if($('#toTop').hasClass('toTopRotate')){
					$('#toTop').removeClass('toTopRotate').addClass('toTopLeave');
				}
			}
		});

		// 點回到頂端圖示
		$('#toTop').click(function(){
			$('body').animate({
				scrollTop: 0
			}, 1000, 'swing');
		});
	</script>
		
	
</body>

</html>