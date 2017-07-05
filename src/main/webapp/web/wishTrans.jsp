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
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body> 
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div id="sectionWTrans" class="container-fluid">
			<div class="row">
				<div id="wTransTitle" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					捐贈物資確認頁面
				</div>
				
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="row">
						<!-- 左邊物資圖片 -->
						<div class="col-xs-12 col-sm-6 col-md-5 col-lg-4 col-lg-offset-2">
							<!-- 物資圖片 -->
							<div id="wTransImgLayout">
								<img id="wTransImg" class="img-responsive" src="../dist/img/300x300/20170627_66.png">
							</div>
						</div>

						<!-- 右邊物資資訊 -->
						<div class="col-xs-12 col-sm-6 col-md-5 col-lg-4">
							<div id="wTransInfo" class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wTransInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransCol">
											捐贈物品
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransVal">
											繪本、青少年文學、休閒類書籍
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wTransInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransCol">
											捐贈對象
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransVal">
											愛閱社
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wTransInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransCol">
											捐贈數量
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1  wTransVal">
											<input type="number" class="form-control" value="" min="1" max="10" step="1" required="required">
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wTransInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransCol">
											寄送方式
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransVal">
											<select name="" id="wValDel" class="form-control" required="required">
												<option value="">郵寄</option>
												<option value="">親送</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="row wTransInfoRow">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransCol">
											備註
										</div>
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 col-lg-offset-1 wTransVal">
											<textarea class="form-control" rows="5" required="required"></textarea>
										</div>
									</div>
								</div>
								<!-- 取消&確定按鈕 -->
								<div id="blockWTransOption" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<ul type="none" class="row">
										<li class="col-xs-5 col-xs-offset-1 col-sm-5 col-sm-offset-1 col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1">
											<a href="#" class="btn btn-default wTransOption" >取消捐贈</a>
										</li>
										<li class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
											<a href="#" class="btn btn-default wTransOption" >確定送出</a>
										</li>
									</ul>
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