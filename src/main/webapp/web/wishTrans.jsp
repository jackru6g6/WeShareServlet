<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/wishTrans.css">
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
		<div id="sectionWTrans" class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div id="wTransBlock" class="row animated zoomIn">
<!-- 						左邊物資圖片 -->
<!-- 						<div class="col-xs-12 col-sm-6 col-md-5 col-lg-6"> -->
<!-- 							物資圖片 -->
<!-- 							<div id="wTransImgLayout"> -->
<!-- 								<img id="wTransImg" class="img-responsive" src="../dist/img/300x300/20170627_66.png"> -->
<!-- 							</div> -->
<!-- 						</div> -->

<!-- 						右邊物資資訊 -->
<!-- 						<div class="col-xs-12 col-sm-6 col-md-5 col-lg-5"> -->
<!-- 							<div id="wTransInfo" class="row"> -->
<!-- 								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"> -->
<!-- 									<div class="row wTransInfoRow"> -->
<!-- 										<ul type="none"> -->
<!-- 											<li>捐贈物品 -->
<!-- 												<span>繪本、青少年文學、休閒類書籍</span> -->
<!-- 											</li> -->
<!-- 											<li>捐贈對象 -->
<!-- 												<span>愛閱社</span> -->
<!-- 											</li> -->
<!-- 											<li>捐贈數量 -->
<!-- 												<input type="number" class="form-control" value="1" min="1" max="server" step="1" required="required"> -->
<!-- 											</li> -->
<!-- 											<li>寄送方式 -->
<!-- 												<select name="server" id="wValDel" class="form-control" required="required"> -->
<!-- 													<option value="server">郵寄</option> -->
<!-- 													<option value="server">親送</option> -->
<!-- 												</select> -->
<!-- 											</li> -->
<!-- 											<li>留言訊息 -->
<!-- 												<textarea class="form-control" rows="5" required="required"></textarea> -->
<!-- 											</li> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

						<!-- 取消&確定按鈕 -->
						<div id="blockWTransOption" class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1">
							<ul type="none" class="row">
								<li class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-4 col-lg-pull-1">
									<a href="javascript:history.back()" class="btn btn-default wTransOption">取消捐贈</a>
								</li>
								<li class="col-xs-5 col-sm-5 col-md-5 col-lg-4  col-lg-push-3">
									<a data-toggle="modal" data-target="#TransMsg" class="btn btn-default wTransOption">確定送出</a>
								</li>
							</ul>
						</div>
						<!-- 留言詢問 -->
						<div id="TransMsg" class="modal fade" role="dialog">
							<div class="modal-dialog">
								<div class="modal-content">
									<!-- 標題 -->
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">交易資訊</h4>
									</div>
									<!-- 內容 -->
									<div class="modal-body">
										<div>資料已送出，詳細資訊請至會員專區瀏覽</div>
									</div>
									<!-- 關閉鈕 -->
									<div class="modal-footer">
										<a href="javascript:history.back()" type="button" class="btn btn-default">關閉視窗</a>
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


	<script src="${pageContext.request.contextPath}/dist/js/showWishTransData.js"></script>
	<script type="text/javascript">
		var goodsno = location.search.slice(1);
		var javaRoot = "${pageContext.servletContext.contextPath}";
		var xhr = new XMLHttpRequest();
		var servletPath = javaRoot + '/_08_query/GoodsQuery.do?' + goodsno;
		var responseData;	
		
		// 頁面載入時
		window.onload = function(){
// 			if (indname == "" || indname == "${LoginOK.indname}"){
// 				alert("請先登入帳號！")
// 				location.href = "login.jsp";
// 				return;
// 			}
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