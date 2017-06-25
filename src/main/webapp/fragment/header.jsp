<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
                <a href="#" id="navWish">
                        <span>許願池</span>
                        <span></span>
                    </a>
            </li>
            <li>
                <a href="#" id="navGive">
                        <span>送愛心</span>
                        <span></span>
                    </a>
            </li>
            <li>
                <a href="#" id="navExchange">
                        <span>以物易物</span>
                        <span></span>
                    </a>
            </li>
            <li>
                <a href="#" id="navGroup">
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
                <a href="#" id="navMember" class="dropdown-toggle" data-toggle="dropdown">
                        <span>會員姓名</span>
                        <span></span>
                    </a>
                <ul id="navMemberSub" class="dropdown-menu">
                    <li><a href="#">個人檔案</a></li>
                    <li><a href="#">評價</a></li>
                    <li><a href="#">物資箱</a></li>
                    <li><a href="#">站內信</a></li>
                </ul>
            </li>
            <li class="afterLogin">
                <a href="#" id="navMemberImg">
                        <img src="../dist/img/icon_member1.png" width="40" alt="MemberImg">
                        <!--Icons made by Freepik from Flaticon(http://www.freepik.com)-->
                    </a>
            </li>
            <li class="dropdown">
                <a href="#" id="navLanguage" class="dropdown-toggle" data-toggle="dropdown">
                        <span>語言</span>
                        <span></span>
                    </a>
                <ul id="navLanguageSub" class="dropdown-menu">
                    <li><a href="#">繁體中文</a></li>
                    <li><a href="#">English</a></li>
                </ul>
            </li>
            <li>
                <a href="#" id="navFBImg">
                        <img src="../dist/img/icon_facebook.png" width="40" alt="FBImg">
                        <!--Icons made by Freepik from Flaticon(http://www.freepik.com)-->
                    </a>
            </li>
        </ul>
    </div>
</nav>
<!-- header END -->