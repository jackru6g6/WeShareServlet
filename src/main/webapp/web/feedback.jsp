<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/feedback.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>

	<section>
		<!--會員評價-->
		<div id="sectionFeedback" class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">
					<div id="blockFeedback">
						<!-- 回上一頁 -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<a href="javascript:history.back()" id="aBack" class="btn btn-default"><i class="fa fa-reply" aria-hidden="true"></i>回上一頁</a>
							</div>
						</div>
						<!-- 會員資料 -->
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div id="thisMember">
									<div class="row">
										<div class="col-xs-offset-2 col-xs-4 col-sm-offset-2 col-sm-4 col-md-offset-3 col-md-3 col-lg-offset-3 col-lg-3">
											<!-- 會員圖片 -->
											<div id="thisMemberImgLayout">
												<img id="thisMemberImg" class="img-responsive img-circle center-block">
											</div>
											<!-- 會員姓名 -->
											<div id="thisMemberName" class="text-center">

											</div>
										</div>
										<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<!-- 會員分數 -->
											<div id="thisMemberScore">
												<canvas id="blockCanvas" width="229" height="229"></canvas>
												<div id="score"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- 評價清單 -->
						<div class="row">
							<div class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
								<div class="otherMember">

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
	
	<script src="${pageContext.request.contextPath}/dist/js/feedback.js"></script>
	<script type="text/javascript">
		var mbId = location.search.slice(1);
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var xhr = new XMLHttpRequest();
		var xhrName = new XMLHttpRequest();
		var servletPath = javaRoot + '/web/_07_Feedback/controller/FindFeedback?key=' + mbId;
		var responseData;
		
		// 頁面載入時
		window.onload = function(){
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);

					// 產生評價資料
					showData(responseData, javaRoot);

				}
			}
			
			// 產生會員圖片
			$('#thisMemberImg').attr('src', javaRoot + '/_00_init/getImage?id=' + mbId + '&type=MEMBER');
			var imgWidth = $('#thisMemberImg').width();
	        $('#thisMemberImg').css('height', imgWidth);
			// 產生會員姓名
			xhrName.open('GET', javaRoot + '/web/_00_intit/getNameByKey?key=' + mbId, true);
			xhrName.send();
			xhrName.onreadystatechange = function(){
				if(xhrName.status == 200 && xhrName.readyState == 4){
					var responseNameData = JSON.parse(xhrName.responseText);
					var mbName = "<span>" + responseNameData.Message + "</span>"
					$('#thisMemberName').append(mbName);
				}
			}
		};
	</script>
		
	
</body>

</html>