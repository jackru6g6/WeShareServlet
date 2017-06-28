<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- header START -->
<nav id="navLayout" class="navbar-default navbar-fixed-top">
    <div id="navLeft" class="navbar-header">
        <!-- 手機選單 -->
        <button type="button" id="navButton" class="navbar-toggle" data-toggle="collapse" data-target="#navMenu">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- Logo -->
        <a href="index.jsp" id="navLogo" class="navbar-brand">
            <img src="../dist/img/WeShare_logo.png" width="60" alt="WeShare">
        </a>
    </div>

    <div id="navMenu" class="collapse navbar-collapse">
        <!-- 左選單 -->
        <ul id="navMenuLeft" class="nav navbar-nav">
            <li>
                <a href="wish.jsp" id="navWish">
                    <span>許願池</span>
                    <span></span>
                </a>
            </li>
            <li>
                <a href="give.jsp" id="navGive">
                    <span>送愛心</span>
                    <span></span>
                </a>
            </li>
            <li>
                <a href="exchange.jsp" id="navExchange">
                    <span>以物易物</span>
                    <span></span>
                </a>
            </li>
            <li>
                <a href="org.jsp" id="navGroup">
                    <span>社福團體</span>
                    <span></span>
                </a>
            </li>
        </ul>

        <!-- 右選單-->
        <ul id="navMenuRight" class="nav navbar-nav navbar-right">
            <li class="beforeLogin">
                <a href="login.jsp" id="navLogin">
                    <span>登入 / 註冊</span>
                    <span></span>
                </a>
            </li>
            <li class="afterLogin dropdown">
                <a id="navMember" class="dropdown-toggle" data-toggle="dropdown">
                    <span>${ LoginOK.indname }</span>
                    <span></span>
                </a>
                <ul id="navMemberSub" class="dropdown-menu">
                    <li><a href="#">個人檔案</a></li>
                    <li><a href="#">評價</a></li>
                    <li><a href="#">物資箱</a></li>
                    <li><a href="#">站內信</a></li>
                    <li class="divider"></li>
                    <li><a data-toggle="modal" data-target="#logoutMsg">登出</a></li>
                </ul>
            </li>
            <li class="afterLogin">
                <a id="navMemberImg">
                    <img class="img-circle" src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER" width="40" alt="MemberImg">
                    <!--Icons made by Freepik from Flaticon(http://www.freepik.com)-->
                </a>
            </li>
            <li class="dropdown">
                <a id="navLanguage" class="dropdown-toggle" data-toggle="dropdown">
                    <span>語言</span>
                    <span></span>
                </a>
                <ul id="navLanguageSub" class="dropdown-menu">
                    <li><a>繁體中文</a></li>
                    <li><a>English</a></li>
                </ul>
            </li>
            <li>
                <a href="https://www.facebook.com" id="navFBImg">
                	<i class="fa fa-facebook-official" aria-hidden="true"></i>
                </a>
            </li>
        </ul>
    </div>
</nav>

<!-- 登出後跳出訊息 -->
<div id="logoutMsg" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- 標題 -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">登出WeShare</h4>
			</div>
			<!-- 內容(導入logout.jsp) -->
			<div class="modal-body">
				<jsp:include page="../web/logout.jsp" />
			</div>
			<!-- 關閉鈕 -->
			<div class="modal-footer">
				<a href="../index.jsp" type="button" class="btn btn-default" data-dismiss="modal">關閉視窗</a>
			</div>
		</div>      
	</div>
</div>
<!-- header END -->