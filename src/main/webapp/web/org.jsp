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
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<div id="blockKWSearch">
									<input id="searchInput" type="search" class="form-control" placeholder="搜尋">
									<span id="btKWSearch"><i class="fa fa-search" aria-hidden="true"></i></span>
								</div>
							</div>
							<!-- 社福團體類型搜尋 -->
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<div id="blockTypeSearch">
									<select id="searchType" value="orgtypes" class="form-control">
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
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
								<div id="blockLocSearch">
									<select id="searchLoc" value="indaddress" class="form-control">
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
					console.log(xhr.responseText);
					responseData = JSON.parse(xhr.responseText);
					console.log("-------------------");
					console.log("org符合的資料筆數:" + responseData.length);
					console.log("-------------------");
					// 產生社福資料
					showData(responseData, javaRoot);
					
					// 點下層固定列，翻轉上層翻轉列
					$(".rowLower").click(function () {
						turnPage($(this));
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
			console.log("keyWord = " + keyWord);
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
				}
			}
		}
		
		// 類別、地點查詢
// 		$('.opFilterType').click(function(){
// 			console.log("opFilterType click");
// 			servletPath = javaRoot + '/_08_query/OrgQuery.do';
// 			var col = $(this).closest('select').val();
// 			var val = $(this).val();
// 			console.log("col = " + col);
// 			console.log("val = " + val);
// 			servletPath += '?&type=' + col + '&value=' + val;
// 			xhr.open('GET', servletPath, true);
// 			xhr.send();
// 			xhr.onreadystatechange = function(){
// 				if(xhr.status == 200 && xhr.readyState == 4){
// 					responseData = JSON.parse(xhr.responseText);
// 					// 產生物資內容
// 					showData(responseData, javaRoot);
					
// 					// 點下層固定列，翻轉上層翻轉列
// 					$(".rowLower").click(function () {
// 						turnPage($(this));
// 					});
// 				}
// 			}
// 		});
	</script>
		
	
</body>

</html>