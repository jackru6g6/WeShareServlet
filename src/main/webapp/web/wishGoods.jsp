<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
	<!-- 截圖插件 -->
	<script src="${pageContext.request.contextPath}/dist/js/html2canvas.js"></script>
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div id="sectionWGoods" class="container">

		</div>
		
<!-- 		<div class="row"> -->
<!-- 			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 				<div id="showImgCanvas" style="border:1px solid #87cefa;"></div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
	</section>
	
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
	
	<script src="${pageContext.request.contextPath}/dist/js/wishGoods.js"></script>
	<script type="text/javascript">
		var goodsno = location.search.slice(1);
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var xhr = new XMLHttpRequest();
		var servletPath = javaRoot + '/_08_query/GoodsQuery.do?' + goodsno;
		var responseData;
		var readImg;
		
		// 頁面載入時
		window.onload = function(){
			xhr.open('GET', servletPath, true);
			xhr.send();
			xhr.onreadystatechange = function(){
				if(xhr.status == 200 && xhr.readyState == 4){
					responseData = JSON.parse(xhr.responseText);
					// 產生網頁內容
					showData(responseData, javaRoot);

					
					// AJAX非同步產生網頁內容後，再執行以下方法，如果寫在外面可能無效
					
					// 點擊我要捐贈
					$('#aWishTrans').click(function(){
						aWishTrans();
					});
					
					// 點擊留言詢問
					$('#aMsgModal').click(function(){
						// 判斷是否已登入，未登入跳出提醒視窗，已登入顯示留言詢問modal
						if (loginOk  == ""){
							$('#msgBody').html("<div>您還沒登入唷~ 請先登入以進行後續步驟！</div>");
							$('#msgFooter').hide();
//								location.href = "login.jsp";
							return;
						}
					});
					
					// 判斷是否有輸入文字，有字才可以點傳送
					$('#msgText').keyup(function(){
						if($(this).val() !== ""){
							$('#btSendMsg').removeClass('disabled');
						} else {
							$('#btSendMsg').addClass('disabled');
						}
					});
					
					// 點擊選擇檔案
					$('#msgImg').change(function(){
						imgChange(this);
					});
					
					// 點擊傳送訊息
					$('#btSendMsg').click(function(){
						sendMsg();
					});
					// 若一定要寫在外面，建議加上setTimeout()
					// $(function(){
					// 	setTimeout(function(){
					// 		$('#btSendMsg').click(function(){
					// 			console.log("#btSendMsg click");
					// 		});
					// 	}, 網頁內容加載完的時間)
					// });
				}
			}
		}
	</script>
	

</body>
</html>