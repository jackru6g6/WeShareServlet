<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!-- 左側導覽列title、會員圖片 -->
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<h3 id="member_menu_title"><b>會員專區</b></h3>
			<img id="member_menu_img" 
				src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER">
		</div>
	</div>
	
	<!-- 左側導覽列選項按鈕 -->
	<ul>					
		<!-- 修改會員資料 -->
		<li>
			<a href="${pageContext.request.contextPath}/web/NEW_member_update.jsp">
				<button id="member_menu_update_button" class="btn btn-block member_menu_button">
					<span class="glyphicon glyphicon-pencil">
						<b>修改會員資料</b>
					</span>
				</button>
			</a>
		</li>
									
		<!-- 我的物資箱 -->
		<li>
			<a href="${pageContext.request.contextPath}/web/NEW_member_goodsCart.jsp">	
				<button id="member_menu_goodsCart_button" class="btn btn-block member_menu_button">
					<span class="glyphicon glyphicon-gift">
						<b>我的物資箱</b>
					</span>
				</button>
			</a>
		</li>
									
		<!-- 我的站內信 -->
		<li>
			<a href="${pageContext.request.contextPath}/web/NEW_member_message.jsp">
				<button id="member_menu_message_button" class="btn btn-block member_menu_button">
					<span class="glyphicon glyphicon-envelope">
						<b>我的站內信</b>
					</span>
				</button>
			</a>
		</li>
									
		<!-- 紀錄與評價 -->
		<li>
			<a href="${pageContext.request.contextPath}/web/NEW_member_feedback.jsp">
				<button id="member_menu_feedback_button" class="btn btn-block member_menu_button">
					<span class="glyphicon glyphicon-star">	
						<b>紀錄與評價</b>
					</span>
				</button>
			</a>
		</li>				
	</ul>