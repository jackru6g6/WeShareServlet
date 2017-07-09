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
        <a href="${pageContext.request.contextPath}/index.jsp" id="navLogo" class="navbar-brand">
            <img src="${pageContext.request.contextPath}/dist/img/WeShare_logo.png" width="60" alt="WeShare">
        </a>
    </div>

    <div id="navMenu" class="collapse navbar-collapse">
        <!-- 左選單 -->
        <ul id="navMenuLeft" class="nav navbar-nav">
            <li>
                <a href="${pageContext.request.contextPath}/web/wish.jsp" id="navWish">
                    <span>許願池</span>
                    <span></span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/web/give.jsp" id="navGive">
                    <span>送愛心</span>
                    <span></span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/web/exchange.jsp" id="navExchange">
                    <span>以物易物</span>
                    <span></span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/web/org.jsp" id="navGroup">
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
<!--                     <li><a href="/Demo/web/_03_updateMember/controller/FindMemberServlet">個人檔案</a></li> -->
                    <li>
                    	<a href="${pageContext.request.contextPath}/web/_03_updateMember/controller/FindMemberServlet">
                    		(後端功能測試)
                    	</a>
                    </li>                
                    <li>
                    	<a href="${pageContext.request.contextPath}/web/member.jsp">
                    		會員專區
                    	</a>
                    </li>
                    
                    <li>
<%--                     	<a href="${pageContext.request.contextPath}/web/test/_03_updateMember/updateMember.jsp"> --%>
                    		<a href="/Demo/web/_03_updateMember/controller/FindMemberServlet">
                    		修改會員資料
                    	</a>
                    </li>
                    
                    <li>
                    	<a href="${pageContext.request.contextPath}/web/member_goods.jsp">
                    		我的物資箱
                    	</a>
                    </li>
                    
                    <li>
                    	<a href="${pageContext.request.contextPath}/web/member_msg.jsp">
                    		我的站內信
                    	</a>
                    </li>
                    
                    <li>
                    	<a href="${pageContext.request.contextPath}/web/member_feedback.jsp">
                    		 評價與紀錄
                    	</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/web/logout.jsp">登出</a></li>
                </ul>
            </li>
            <li class="afterLogin">
                <a>
                    <img id="navMemberImg" class="img-circle" src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER" width="40">
                    <!-- <img id="navMemberImg" class="img-circle" width="40"> -->
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
<!-- header END -->