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


	<!-- Google Login -->
	<meta name="google-signin-scope" content="profile email">
	<meta name="google-signin-client_id" content="${abc.getGoogleClientId()}">
	<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
<!-- 	<script type="text/javascript" src="https://mail.google.com/mail/u/0/?logout&hl=en"></script> -->
	<script>
		var GoogleClientId = "${abc.getGoogleClientId()}";
// 		console.log("getGoogleClientId = " + GoogleClientId);
		function onSignIn(googleUser) {
			var redirectUrl = '/Demo/web/_02_login/controller/GoogleLogin.do';
			var form = $('<form action="' + redirectUrl + '" method="post">'
					+ '<input type="text" name="id_token" value="'
					+ googleUser.getAuthResponse().id_token + '" />' + '</form>');
			$('body').append(form);
			form.submit();
		}
		
		function renderButton() {
			gapi.signin2.render('btGoogle', {
			  'scope': 'profile email',
			  'width': 297,
			  'height': 46,
			  'longtitle': true,
			  'theme': 'white',
			  'onsuccess': onSignIn
			});
	    }
	</script>
	<jsp:useBean id="abc" class="web._00_init.GlobalService" scope="application" />

	<title>WeShare 微分享</title>
</head>

<body>
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>

	<section>
		<div id="sectionLogin" class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">
					<div id="loginContent">
						<div class="row">
							<!--logo圖-->
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="text-center loginLogo">
									<img src="../dist/img/WeShare_logo.png" width="60" alt="WeShare">
								</div>
							</div>
							<!--登入區塊-->
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div id="loginLayout">
									<div class="row">
										<!--使用Facebook或Google帳號登入-->
										<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
											<div id="loginLayoutLeft">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
														<h4 id="leftText">使用以下服務登入</h4>
													</div>
												</div>
												<!--Facebook-->
												<div class="row">
													<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
														<h4>
															<button id="btFB" class="btn btn-lg btn-default btn-block">
																<i class="fa fa-facebook" aria-hidden="true"></i>
																<span>Facebook</span>
															</button>
														</h4>
													</div>
												</div>
												<!--Google-->
												<div class="row">
													<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
														<div id="btGoogle" data-onsuccess="onSignIn"></div>
													</div>
												</div>
											</div>
										</div>
										<!--使用自行註冊的帳號登入-->
										<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
											<div id="loginLayoutRight">
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
														<h4 id="rightText">使用帳號登入</h4>
													</div>
												</div>
												<form action="<c:url value='/_02_login/login.do' />" method="POST" name="loginForm">
													<!--輸入帳號-->
													<div class="row">
														<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
															<h4><input type="text" class="form-control" id="loginId" placeholder="帳號" name="indid" value="${sessionScope.user}"></h4>
														</div>
													</div>
													<!--輸入密碼-->
													<div class="row">
														<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
															<h4><input type="password" class="form-control" id="loginPW" placeholder="密碼" name="indpassword" value="${sessionScope.password}"></h4>
														</div>
													</div>
													<!--顯示錯誤訊息-->
													<div class="row">
														<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
															<h4 class="loginErrorMsg">${ErrorMsgKey.AccountEmptyError}</h4>
															<h4 class="loginErrorMsg">${ErrorMsgKey.PasswordEmptyError}</h4>
															<h4 class="loginErrorMsg">${ErrorMsgKey.LoginError}</h4>
														</div>
													</div>
													<div class="row">
														<!--保持登入-->
														<div class="col-xs-12 col-sm-12 col-md-offset-1 col-md-5 col-lg-offset-1 col-lg-5">
															<h5 id="keepLogin"><input id="rememberMe" type="checkbox" name="rememberMe"><span>保持登入</span></h5>
														</div>
														<!--登入按鈕-->
														<div class="col-xs-12 col-sm-12 col-md-6 col-lg-5">
															<button id="btLogin" class="btn btn-default btn-block" type="submit">登入</button>
														</div>
													</div>
												</form>
												<div class="row">
													<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
														<div class="row">
															<!--忘記密碼-->
															<div class="col-xs-12 col-sm-12 col-md-offset-1 col-md-5 col-lg-offset-1 col-lg-5">
																<h5><a href="#">忘記密碼？</a></h5>
															</div>
															<!--註冊帳號-->
															<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
																<h5>還沒有帳號？<a href="../_01_register/register.jsp">註冊帳號</a></h5>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
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
</body>

</html>