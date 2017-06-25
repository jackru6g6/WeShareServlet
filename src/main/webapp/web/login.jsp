<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<!-- -----------------------------------------------
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script type="text/javascript"
	src="https://mail.google.com/mail/u/0/?logout&hl=en"></script>
<meta name="google-signin-scope" content="profile email">
<jsp:useBean id="abc" class="web._00_init.GlobalService"
	scope="application" />
<meta name="google-signin-client_id"
	content="${abc.getGoogleClientId()}">
<script>
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		var redirectUrl = '/Demo/web/_02_login/controller/GoogleLogin.do';
		var form = $('<form action="' + redirectUrl + '" method="post">'
				+ '<input type="text" name="id_token" value="'
				+ googleUser.getAuthResponse().id_token + '" />' + '</form>');
		$('body').append(form);
		form.submit();
	}
</script>
------------------------------------------- -->
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
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-2 col-md-8 col-lg-offset-2 col-lg-8">
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
										<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<h4 class="leftText">使用以下服務登入</h4>
												</div>
											</div>
											<!--Facebook-->
											<div class="row">
												<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
													<h4>
														<button class="btn btn-lg btn-default btn-block" type="submit">
															<i class="fa fa-facebook" aria-hidden="true"></i>
															<span>Facebook</span>
														</button>
													</h4>
												</div>
											</div>
											<!--Google-->
											<div class="row">
												<div class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-1 col-md-10 col-lg-offset-1 col-lg-10">
													<h4>
														<button class="btn btn-lg btn-default btn-block" type="submit">
															<i class="fa fa-google" aria-hidden="true"></i>
															<span>Google</span>
														</button>
													</h4>
												</div>
											</div>
										</div>
										<!--使用自行註冊的帳號登入-->
										<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<h4 class="rightText">使用帳號登入</h4>
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
												<!--保持登入-->
												<div class="row">
													<div class="col-xs-12 col-sm-offset-2 col-sm-3 col-md-offset-2 col-md-3 col-lg-offset-2 col-lg-3">
														<p><input id="rememberMe" type="checkbox" name="rememberMe"><span>保持登入</span></p>
													</div>
													<div class="col-xs-12 col-sm-5 col-md-5 col-lg-5">
														<button id="btLogin" class="btn btn-default btn-block" type="submit">登入</button>
													</div>
												</div>
											</form>
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
													<div class="row">
														<!--忘記密碼-->
														<div class="col-xs-12 col-sm-offset-2 col-sm-3 col-md-offset-2 col-md-3 col-lg-offset-2 col-lg-3">
															<p><a href="#">忘記密碼？</a></p>
														</div>
														<!--註冊帳號-->
														<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
															<p>還沒有帳號？<a href="#">註冊帳號</a></p>
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
	<!--  ------------------------------------------------ -->
	<div class="g-signin2 " data-onsuccess="onSignIn"></div>
	<!-- ------------------------------------------- -->
</body>

</html>