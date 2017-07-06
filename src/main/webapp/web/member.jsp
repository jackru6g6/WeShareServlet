<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<!-- 自訂CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/member.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<!-- 自訂js -->
	<script src="${pageContext.request.contextPath}/dist/js/member.js"></script>
	
	<title>WeShare 微分享</title>
</head>

<body>

	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div class="container-fluid">
			<div class="row">
				<!-- 左側導覽列 -->
				<aside class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
					
					<!-- 左側導覽列title、會員圖片 -->
                    <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						    <h3 id="member_menu_title"><b>會員專區</b></h3>
							<img id="member_menu_img" src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER">
						</div>	
					</div>
					
					<!-- 左側導覽列選項按鈕 -->

                    <!-- 個人檔案 -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<button id="member_menu_button" class="btn btn-block member_menu_button" onclick="clickButton(event, 'member_home')">
								個人檔案
							</button>
						</div>	
					</div>
					
					<!-- 修改會員資料 -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<button id="member_menu_button" class="btn btn-block member_menu_button" onclick="clickButton(event, 'update')">
								修改會員資料
							</button>
						</div>	
					</div>
					
					<!-- 我的物資箱 -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">				
							<button id="member_menu_button" class="btn btn-block member_menu_button" onclick="clickButton(event, 'goodsCart')">
								我的物資箱
							</button>
						</div>	
					</div>
					
					<!-- 我的站內信 -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<button id="member_menu_button" class="btn btn-block member_menu_button" onclick="clickButton(event, 'message')">
								我的站內信
							</button>
						</div>	
					</div>
					
					<!-- 評價與紀錄 -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">	
							<button id="member_menu_button" class="btn btn-block member_menu_button" onclick="clickButton(event, 'feedback')">
								評價與紀錄
							</button>
						</div>	
					</div>	
					
				</aside>
				
				<!-- 頁面內容 -->
				<article class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
					
					<!-- 個人檔案 -->
                    <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content" id="member_home">
							
							<!-- 個人檔案title -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h3 id="member_content_title">
										<b>個人檔案</b>
									</h3>
									<hr id="member_content_hr">
								</div>
							</div>
							
							<!-- 個人檔案內容 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<jsp:include page="member_data.jsp" />
								</div>
							</div>
							
						</div>
					</div>
					
					<!-- 修改會員資料 -->
                    <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content" id="update">
							
							<!-- 修改會員資料title -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h3 id="member_content_title">
										<b>修改會員資料</b>
									</h3>
									<hr id="member_content_hr">
								</div>
							</div>
							
							<!-- 修改會員資料內容 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<jsp:include page="member_update.jsp"/>

<%-- 									<jsp:include page=" --%>
<%-- 									<c:url value='/web/_03_updateMember/controller/FindMemberServlet'/> --%>
<!-- 									" /> -->
<%-- 									<c:url value="/Demo/web/_03_updateMember/controller/FindMemberServlet " /> --%>
<!-- 									WeShare\src\main\java\web\_03_updateMember\controller\FindMemberServlet.java -->
<%-- 									<jsp:include page="\web\_03_updateMember\controller\FindMemberServlet" /> --%>
<%-- 									<c:url value="/web/_03_updateMember/controller/FindMemberServlet" /> --%>
<%-- 									<jsp:include page="test/_03_updateMembertest/updateMember.jsp" /> --%>
<%-- 									<jsp:include page="${pageContext.request.contextPath}/web/_03_updateMember/controller/FindMemberServlet" /> --%>
<!-- 									<a href="/Demo/web/_03_updateMember/controller/FindMemberServlet"> -->
									
								</div>
							</div>
							
						</div>
					</div>
					
					<!-- 我的物資箱 -->
                    <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content" id="goodsCart">
							
							<!-- 我的物資箱title -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h3 id="member_content_title">
										<b>我的物資箱</b>
									</h3>
									<hr id="member_content_hr">
								</div>
							</div>
							
							<!-- 我的物資箱內容 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<jsp:include page="test/_04_productMaintain/GoodsMaintainList.jsp" />
								</div>
							</div>
							
						</div>
					</div>
					
					<!-- 我的站內信 -->
                    <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content" id="message">
							
							<!-- 我的站內信title -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h3 id="member_content_title">
										<b>我的站內信</b>
									</h3>
									<hr id="member_content_hr">
								</div>
							</div>
							
							<!-- 我的站內信內容 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<jsp:include page="test/_06_MSG/DisplayMSG.jsp" />
								</div>
							</div>
							
						</div>
					</div>
					
					<!-- 評價與紀錄 -->
                    <div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content" id="feedback">
							
							<!-- 評價與紀錄title -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<h3 id="member_content_title">
										<b>評價與紀錄</b>
									</h3>
									<hr id="member_content_hr">
								</div>
							</div>
							
							<!-- 評價與紀錄內容 -->
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<jsp:include page="test/_05_deal/DisplayDeal.jsp" />
								</div>
							</div>
							
						</div>
					</div>									
					
				</article>			
			</div>
		</div>	
	</section>
	
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>

</body>
<script type="text/javascript">
	var javaRoot = "${pageContext.servletContext.contextPath}";
	var xhr = new XMLHttpRequest();
	var servletPath = javaRoot
			+ '/web/_03_updateMember/controller/FindMemberServlet?type=Json';
	var responseData;

	// 頁面載入時
	window.onload = function() {
		var changemember = document.getElementById("changemember");
		var showmember = document.getElementById("showmember");
		xhr.open('GET', servletPath, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			$('ShowMember').empty();
			if (xhr.status == 200 && xhr.readyState == 4) {
				responseData = JSON.parse(xhr.responseText);
				var changememberdata = "<table border='1'>";
				changememberdata += "我是修改頁面"+
					"<tr>" + "<td>帳號類別</td><td>" + responseData.usertype + "</td></tr>"+
					"<tr>" + "<td>時間</td><td>" + responseData.postdate + "</td></tr>"+
					"<tr>" + "<td>帳號</td><td>" + responseData.indid + "</td></tr>"+
					"<tr>" + "<td>名稱</td><td>" + responseData.indname + "</td></tr>"+
					"<tr>" + "<td>郵件</td><td>" + responseData.indemail + "</td></tr>"+
					"<tr>" + "<td>地址</td><td>" + responseData.indaddress + "</td></tr>"+
					"<tr>" + "<td>圖片名稱</td><td>" + responseData.indfilename + "</td></tr>"+
					"<tr>" + "<td>ORG時間</td><td>" + responseData.updatetime + "</td></tr>"+
					"<tr>" + "<td>ORG簡介</td><td>" + responseData.intro + "</td></tr>"+
					"<tr>" + "<td>ORG負責人</td><td>" + responseData.leader + "</td></tr>"+
					"<tr>" + "<td>ORG類別</td><td>" + responseData.orgtypes + "</td></tr>"+
					"<tr>" + "<td>ORG立案核准</td><td>" + responseData.registerno + "</td></tr>"+
					"<tr>" + "<td>ORG勸募許可</td><td>" + responseData.raiseno + "</td></tr>"+
					"<tr>" + "<td>ORG圖片名稱</td><td>" + responseData.orgfilename + "</td></tr>"+
					"</table>";	changemember.innerHTML = changememberdata;



					var showmemberdata = "<table border='1'>";
					showmemberdata += "我是個人頁面"+
						"<tr>" + "<td>帳號類別</td><td>" + responseData.usertype + "</td></tr>"+
						"<tr>" + "<td>時間</td><td>" + responseData.postdate + "</td></tr>"+
						"<tr>" + "<td>帳號</td><td>" + responseData.indid + "</td></tr>"+
						"<tr>" + "<td>名稱</td><td>" + responseData.indname + "</td></tr>"+
						"<tr>" + "<td>郵件</td><td>" + responseData.indemail + "</td></tr>"+
						"<tr>" + "<td>地址</td><td>" + responseData.indaddress + "</td></tr>"+
						"<tr>" + "<td>圖片名稱</td><td>" + responseData.indfilename + "</td></tr>"+
						"<tr>" + "<td>ORG時間</td><td>" + responseData.updatetime + "</td></tr>"+
						"<tr>" + "<td>ORG簡介</td><td>" + responseData.intro + "</td></tr>"+
						"<tr>" + "<td>ORG負責人</td><td>" + responseData.leader + "</td></tr>"+
						"<tr>" + "<td>ORG類別</td><td>" + responseData.orgtypes + "</td></tr>"+
						"<tr>" + "<td>ORG立案核准</td><td>" + responseData.registerno + "</td></tr>"+
						"<tr>" + "<td>ORG勸募許可</td><td>" + responseData.raiseno + "</td></tr>"+
						"<tr>" + "<td>ORG圖片名稱</td><td>" + responseData.orgfilename + "</td></tr>"+
						"</table>";	showmember.innerHTML = showmemberdata;
						

			}
		}
		
	}
</script>
</html>