<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/exchangeTrans.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body>
	<!-- 確定送出modal -->
	<div id="transMsg" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- 標題 -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title">交易資訊</h3>
				</div>
				<!-- 內容 -->
				<div class="modal-body">
					<div id="msgText" class="modalFont"></div>
				</div>
				<!-- 關閉鈕 -->
				<div class="modal-footer">
					<a id="aMsgClose" type="button" class="btn btn-default modalFont">關閉視窗</a>
				</div>
			</div>
		</div>
	</div>

	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div id="sectionETrans" class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div id="eTransBlock" class="row animated zoomIn">

						<!-- 取消&確定按鈕 -->
						<div id="blockETransOption" class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1">
							<ul type="none" class="row">
								<li class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-4 col-lg-pull-1">
									<a href="javascript:history.back()" class="btn btn-default eTransOption">取消交換</a>
								</li>
								<li class="col-xs-5 col-sm-5 col-md-5 col-lg-4 col-lg-push-3">
									<a id="aSendTrans" data-toggle="modal" data-target="#transMsg" class="btn btn-default eTransOption">確定送出</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>


	<script src="${pageContext.request.contextPath}/dist/js/exchangeTrans.js"></script>
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
					// 產生網頁內容
					showData(responseData, javaRoot);
				}
			}
		}

		// 點擊確定送出
		$('#aSendTrans').click(function(){
			// 判斷是否已登入，未登入跳出提醒視窗，已登入顯示留言詢問modal
			if (loginOk  == ""){
				$('#msgText').html("您還沒登入唷~ 請先登入以進行後續步驟！");
				return;
			} else {
				sendTrans();
			}
		});
	</script>
	
	
</body>
</html>