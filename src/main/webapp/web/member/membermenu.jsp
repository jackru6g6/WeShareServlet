<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 左側導覽列title、會員圖片 -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<h3 id="member_menu_title">
			<b>會員專區</b>
		</h3>
		<img id="member_menu_img"
			src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER">
	</div>
</div>

<!-- 左側導覽列選項按鈕 -->

<!-- 個人檔案 -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<button id="member_menu_button"	class="btn btn-block member_menu_button" onclick="location.href='/Demo/web/member.jsp';">個人檔案</button>
	</div>
</div>

<!-- 修改會員資料 -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<button id="member_menu_button"
			class="btn btn-block member_menu_button"onclick="location.href='/Demo/web/_03_updateMember/controller/FindMemberServlet';">修改會員資料</button>
	</div>
</div>

<!-- 我的物資箱 -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<button id="member_menu_button"
			class="btn btn-block member_menu_button"onclick="location.href='/Demo/web/member_goods.jsp';">我的物資箱</button>
	</div>
</div>

<!-- 我的站內信 -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<button id="member_menu_button"
			class="btn btn-block member_menu_button"onclick="location.href='/Demo/web/member_msg.jsp';">我的站內信</button>
	</div>
</div>

<!-- 評價與紀錄 -->
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<button id="member_menu_button"
			class="btn btn-block member_menu_button"onclick="location.href='/Demo/web/member_feedback.jsp';">評價與紀錄</button>
	</div>
</div>
