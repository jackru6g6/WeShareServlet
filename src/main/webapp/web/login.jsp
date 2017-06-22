<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="">

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
		<div id="loginContent" class="container">
			<form action="<c:url value='/_02_login/login.do' />" method="POST" name="loginForm">
				<p><h3>登入</h3></p>
				<p><input type="text" name="indid" value="${sessionScope.user}" placeholder="請輸入帳號">
				&nbsp;<small><Font color='red' size="-3">${ErrorMsgKey.AccountEmptyError}</Font></small>
				</p>
				<p><input type="password" name="indpassword" value="${sessionScope.password}" placeholder="請輸入密碼">
				&nbsp;<small><Font color='red'  size="-3">${ErrorMsgKey.PasswordEmptyError}</Font></small>
				</p>
				<p>
				
				<TD width="180" align="right" >
             	<input type="checkbox" name="rememberMe" 
               <c:if test='${sessionScope.rememberMe==true}'>
                  checked='checked'
               </c:if> 
             	value="true">
         		</TD>         		
         		<TD width="180"  colspan='2' align="left"><small>記住密碼</small></TD>
             	<TD align="CENTER" colspan='2'>&nbsp;<Font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</Font></TD>
				</p>
				<p><button id="btLogin" class="btn btn-lg btn-primary btn-block" type="submit">Log in</button></p>
				<p><button class="btn btn-lg btn-primary btn-block" type="submit">使用Facebook帳號登入</button></p>
				<p><button class="btn btn-lg btn-primary btn-block" type="submit">使用Google帳號登入</button></p>
				<div class="row">
					<div id="forgot" class="col-lg-6">
						<div class="text-left">
							<a href="#">忘記密碼?</a>
						</div>
					</div>
					<div id="create" class="col-lg-6">
						<div class="text-right">
							還沒有帳號？
							<a href="#">立即註冊</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>

	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
</body>

</html>