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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/register.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body>
	<div class="container">		

		<!-- 會員註冊視窗 -->
			<div class="modal-dialog modal-lg">
				<!-- 會員註冊視窗內容 -->
				<div class="modal-content">
					<!-- 註冊視窗header -->
					<div class="modal-header" id="modal_header">
						<!-- 標題及關閉符號(X) -->
						<button type="button" class="close" data-dismiss="modal" id="modal_header_close">&times;</button>
						<h4 class="modal-title">會員註冊</h4>
					</div>
						
					<!-- 註冊視窗body -->
					<div class="modal-body">
						<!-- 會員註冊表單 -->
						<form class="form-horizontal"  ENCTYPE="multipart/form-data" method="POST" action="<c:url value='/_01_register/registery.do' />"  id="register.do" >
							
							<!-- 姓名 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp姓&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp名&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="text" name="indname" value="${param.indname}" id="" class="form-control" placeholder="請輸入您的姓名 (必填欄位)" required>
									<!-- 顯示錯誤訊息 -->
<%-- 									<font color="red" size="-1">${MsgMap.errorName}</font> --%>
								</div>
							</div>
								
							<!-- 身分 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp身&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp分&nbsp &nbsp </span>
								</label>	
								<div class="col-sm-9">
									<input type="radio" name="usertype" value="1" id="member_types_ind" class="radio-inline" onclick="click_member_types_ind()" checked>個人
									<input type="radio" name="usertype" value="2" id="member_types_org" class="radio-inline" onclick="click_member_types_org()">社福團體
									<!-- 顯示錯誤訊息 -->
									
								</div>

									<!-- JavaScript_按下相對應選項，跳出個人/社福註冊頁面 -->
									<script>
										// 定義變數 
										var i, ind_table, org_table;
																			
										// 按下個人選項，跳出個人註冊頁面 
										function click_member_types_ind() {
											// 取得所有ClassName是"form_org"的項目
											ind_table = document.getElementsByClassName("form_org");
											for (i = 0; i < ind_table.length; i++) {
												// 讓所有ClassName是"form_org"的項目不要顯示 
												ind_table[i].style.display = "none";
											}
										}
																			
										// 按下社福選項，跳出社福註冊頁面 
										function click_member_types_org(){
											// 取得所有ClassName是"form_org"的項目
											org_table = document.getElementsByClassName("form_org");
											for(i = 0; i< org_table.length; i++){
												// 讓所有ClassName是"form_org"的項目顯示 
												org_table[i].style.display = "block"; 
											}
										}
									</script>
								
							</div>
								
							<!-- 會員帳號 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp會&nbsp員&nbsp帳&nbsp號&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="text" name="indid" value="${param.indid}" id="" class="form-control" placeholder="請輸入您的會員帳號 (必填欄位)" required>
									<!-- 顯示錯誤訊息 -->
<%-- 									<font size="-1" color="#FF0000">${MsgMap.errorIDEmpty}${MsgMap.errorIDDup}</font> --%>
								</div>
							</div>
								
							<!-- 會員密碼 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp會&nbsp員&nbsp密&nbsp碼&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="password" name="indpassword" value="${param.indpassword}" id="" class="form-control" placeholder="請輸入您的會員密碼 (必填欄位)" required>
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorPasswordEmpty}</font>
								</div>
							</div>
							
							<!-- 密碼確認 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp密&nbsp碼&nbsp確&nbsp認&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="password" name="indpassword2" value="${param.indpassword2}" id="" class="form-control" placeholder="請再次輸入您的會員密碼 (必填欄位)" required>
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorPassword2Empty}</font>
								</div>
							</div>
								
							<!-- 連絡電話 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp連&nbsp絡&nbsp電&nbsp話&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="tel" name="indphone" value="${param.indphone}" id="" class="form-control" placeholder="02-12345678">
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorTel}</font>
								</div>
							</div>
								
							<!-- 電子信箱 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp電&nbsp子&nbsp信&nbsp箱&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="email" name="indemail" value="${param.indemail}" id="" class="form-control" placeholder="example@email.com">
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorEmail}</font>
								</div>
							</div>
								
							<!-- 地址 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp地&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp址&nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="text" name="indaddress" value="${param.indaddress}" id="" class="form-control" placeholder="O縣O市O區O路O巷O號">
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorAddr}</font>
								</div>
							</div>
								
							<!-- 社福團體需要多填的表格 -->
								
							<!-- 負責人 -->
							<div class="form-group form_org">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp 負&nbsp &nbsp責&nbsp &nbsp人 &nbsp &nbsp </span>
								</label>
								<div class="col-sm-9">
									<input  type="text" name="leader" value="${param.leader}" id="" class="form-control" placeholder="請輸入負責人姓名  (必填欄位)">
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorLeader}</font>
								</div>
							</div>
								
							<!-- 社福團體類型 -->
							<div class="form-group form_org">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp社福團體類型&nbsp </span>
								</label>
								<div class="col-sm-9">
									<select name="orgtypes" id="" class="form-control">
										<option value="1">兒少福利</option>
										<option value="2">偏鄉教育</option>
										<option value="3">老人福利</option>
										<option value="4">身障福利</option>
										<option value="5">其他</option>
									</select>
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorOrgtypes}</font>
								</div>
							</div>
								
							<!-- 核准立案字號 -->
							<div class="form-group form_org">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp核准立案字號&nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="text" name="registerno" value="${param.registerno}" id="" class="form-control" placeholder="OO字第000000000號">
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorRegisterno}</font>
								</div>
							</div>
								
							<!-- 勸募許可文號 -->
							<div class="form-group form_org">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp勸募許可文號&nbsp </span>
								</label>
								<div class="col-sm-9">
									<input type="text" name="raiseno" value="${param.raiseno}" id="" class="form-control" placeholder="OO字第000000000號">
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorRaiseno}</font>
								</div>
							</div>
								
							<!-- 社福團體簡介 -->
							<div class="form-group form_org">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp社福團體簡介&nbsp </span>
								</label>
								<div class="col-sm-9">
									<textarea name="intro" value="${param.intro}" id="" class="form-control" rows="10" placeholder="請輸入社福團體簡介...(必填欄位)"></textarea>
									<!-- 顯示錯誤訊息 -->
									<font color="red" size="-1">${MsgMap.errorIntro}</font>
								</div>
							</div>
								
							<!-- 會員圖片 -->
							<div class="form-group">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp &nbsp會&nbsp員&nbsp圖&nbsp片&nbsp &nbsp </span>
								</label>
								<!-- 上傳及預覽檔案 -->
								<div class="col-sm-9">
									
									<!-- 上傳檔案 -->		
									<div class="row">
										<div class="col-sm-12">
											<input type="file" name="file1" id="upload_img" accept="image/jpeg, image/png">
										</div>
									</div>
									
									<!-- 預覽上傳檔案 -->		
									<div class="row">
										<div class="col-sm-12" id="preview_img">
											
											<!-- 預覽上傳的檔案--script -->
											<script>
													
												// 定義變數，取得圖片
												var result = document.getElementById("preview_img"); 
												var input = document.getElementById("upload_img"); 
												// 判斷瀏覽器是否支援 FileReader 
												if(typeof FileReader==='undefined'){ 
													result.innerHTML = "Sorry, 瀏覽器不支持 FileReader"; 
													input.setAttribute('disabled','disabled'); 
												}else{ 
													// 建立事件聆聽功能 
													input.addEventListener('change',readFile,false);
												}
												//讀入檔案
												function readFile(){ 
													var file = this.files[0]; 
													var reader = new FileReader(); 
													reader.readAsDataURL(file); 
													reader.onload = function(e){ 
														result.innerHTML = '<img src="'+this.result+'" id="show_img">' 
													} 
												}
													
											</script>
											
										</div>
									</div>
									
								</div>
									
							</div>	
							
							
							<!-- 社福簡介圖片 -->
							<div class="form-group form_org">
								<label class="control-label col-sm-3">
									<span id="form_label_span">&nbsp社福簡介圖片&nbsp </span>
								</label>
								<!-- 上傳及預覽檔案 -->
								<div class="col-sm-9">
										
									<div class="row">
										<div class="col-sm-12">
											<input type="file" name="file2" id="upload_img" accept="image/jpeg, image/png">
										</div>
									</div>
										
									<div class="row">
										<div class="col-sm-12" id="preview_img">
											
											<!-- 預覽上傳的檔案--script -->
											<script>
													
												// 定義變數，取得圖片
												var result = document.getElementById("preview_img"); 
												var input = document.getElementById("upload_img"); 
												// 判斷瀏覽器是否支援 FileReader 
												if(typeof FileReader==='undefined'){ 
													result.innerHTML = "Sorry, 瀏覽器不支持 FileReader"; 
													input.setAttribute('disabled','disabled'); 
												}else{ 
													// 建立事件聆聽功能 
													input.addEventListener('change',readFile,false);
												}
												//讀入檔案
												function readFile(){ 
													var file = this.files[0]; 
													var reader = new FileReader(); 
													reader.readAsDataURL(file); 
													reader.onload = function(e){ 
														result.innerHTML = '<img src="'+this.result+'" id="show_img">' 
													} 
												}
													
											</script>
											
										</div>
									</div>
									
								</div>
									
							</div>							
						
							
							<!-- 隱私權政策 -->
							<input type="checkbox" name="" value="" id="check_privacy" required> 
							<label>我已詳閱本站的<a href="#">隱私權政策</a></label>
							<br>
								
							<!-- 註冊按鈕 -->						
							<button type="submit" name="submit" value="" id="register_button" class="btn btn-default" >								
								<b>註 &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 冊</b>								
							</button>
						</form>
					</div>
				</div>
			</div>				  
	</div>
</body>
</html>