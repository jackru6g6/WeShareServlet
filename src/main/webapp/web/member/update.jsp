<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	<form class="form-horizontal" ENCTYPE="multipart/form-data"	method="POST" action="<c:url value='updateMember.do' />">
		<!-- 姓名 -->
		<div class="form-group">
			<label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp&nbsp姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名&nbsp&nbsp</span>
			</label>
			<div class="col-sm-9">
				<input type="text" name="indname"value="${ind.indname}${param.indname}" id="" class="form-control" required>
				<!-- 顯示錯誤訊息 -->
			    <font color="red" size="-1">${MsgMap.errorName}</font>
            </div>
		</div>
		<!-- 身分 -->
        <div class="form-group">
            <label class="control-label col-sm-3"> <span
				id="form_label_span">&nbsp&nbsp身&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp分&nbsp&nbsp</span>
			</label>
            <div class="col-sm-9">
                <c:choose>
                    <c:when test="${LoginOK.usertype==1}">
                        <input type="radio" name="usertype" value="1" id="member_types_ind" class="radio-inline" disabled checked>個人
                        <input type="radio" name="usertype" id="member_types_org" class="radio-inline" disabled>社福團體
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="usertype" id="member_types_ind" class="radio-inline" disabled>個人
                        <input type="radio" name="usertype" value="2" id="member_types_org" class="radio-inline" disabled checked>社福團體
                    </c:otherwise>
                </c:choose>
            </div>
            <input type="hidden" name="indid" value="${LoginOK.indid}"> 
            <input type="hidden" name="finalDecision" value="">            
            <input type="hidden" name="usertype" value="${LoginOK.usertype}">
        </div>
		<!-- 會員帳號 -->
		<div class="form-group">
			<label class="control-label col-sm-3">
                <span id="form_label_span">&nbsp&nbsp會&nbsp員&nbsp帳&nbsp號&nbsp&nbsp</span>
			</label>
			<div class="col-sm-9">
				<input type="text" name="indid" value="${ind.indid}" id="" class="form-control" disabled>
			</div>
		</div>
		<!-- 會員密碼 -->
		<div class="form-group">
			<label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp&nbsp會&nbsp員&nbsp密&nbsp碼&nbsp&nbsp</span>
			</label>
			<div class="col-sm-9">
				<input type="button" value="修改密碼" style="font-weight :bolder;" onclick="location.href='/Demo/_03_updateMember/updateMemberPassword.jsp';">
			</div>
		</div>
		<!-- 連絡電話 -->
		<div class="form-group">
			<label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp&nbsp連&nbsp絡&nbsp電&nbsp話&nbsp&nbsp</span>
			</label>
			<div class="col-sm-9">
				<input type="tel" name="indphone" value="${ind.indphone}${param.indphone}" id="" class="form-control">
				<!-- 顯示錯誤訊息 -->
				<font color="red" size="-1">${MsgMap.errorTel}</font>
			</div>
		</div>
		<!-- 電子信箱 -->
		<div class="form-group">
			<label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp&nbsp電&nbsp子&nbsp信&nbsp箱&nbsp&nbsp</span>
			</label>
			<div class="col-sm-9">
				<input type="email" name="indemail"	value="${ind.indemail}${param.indemail}" id="" class="form-control">
				<!-- 顯示錯誤訊息 -->
				<font color="red" size="-1">${MsgMap.errorEmail}</font>
			</div>
		</div>
		<!-- 地址 -->
		<div class="form-group">
			<label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp&nbsp地&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp址&nbsp&nbsp</span>
			</label>
			<div class="col-sm-9">
				<input type="text" name="indaddress" value="${ind.indaddress}${param.indaddress}" id="" class="form-control">
				<!-- 顯示錯誤訊息 -->
				<font color="red" size="-1">${MsgMap.errorAddr}</font>
			</div>
		</div>
		
        <c:if test="${LoginOK.usertype==2}">
            <!-- 社福團體需要多填的表格 -->
            <!-- 負責人 -->
            <div class="form-group form_org">
                <label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp&nbsp負&nbsp&nbsp責&nbsp&nbsp人&nbsp&nbsp</span>
			</label>
                <div class="col-sm-9">
                    <input type="text" name="leader" value="${org.leader}${param.leader}" id="" class="form-control">
                    <!-- 顯示錯誤訊息 -->
                    <font color="red" size="-1">${MsgMap.errorLeader}</font>
                </div>
            </div>
            <!-- 社福團體類型 -->
            <div class="form-group form_org">
                <label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp社福團體類型&nbsp</span>
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
                <span id="form_label_span">&nbsp核准立案字號&nbsp</span>
			</label>
                <div class="col-sm-9">
                    <input type="text" name="registerno" value="${org.registerno}${param.registerno}" id="" class="form-control">
                    <!-- 顯示錯誤訊息 -->
                    <font color="red" size="-1">${MsgMap.errorRegisterno}</font>
                </div>
            </div>
            <!-- 勸募許可文號 -->
            <div class="form-group form_org">
                <label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp勸募許可文號&nbsp</span>
			</label>
                <div class="col-sm-9">
                    <input type="text" name="raiseno" value="${org.raiseno}${param.raiseno}" id="" class="form-control">
                    <!-- 顯示錯誤訊息 -->
                    <font color="red" size="-1">${MsgMap.errorRaiseno}</font>
                </div>
            </div>
            <!-- 社福團體簡介 -->
            <div class="form-group form_org">
                <label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp社福團體簡介&nbsp</span>
			</label>
                <div class="col-sm-9">
                    <textarea name="intro" value="${param.intro}" id="" class="form-control" rows="10">${org.intro}</textarea>
                    <!-- 顯示錯誤訊息 -->
                    <font color="red" size="-1">${MsgMap.errorIntro}</font>
                </div>
            </div>
        </c:if>
		
<!-- 圖片 -->
<div class="form-group">
    <!-- 會員圖片 -->
			<div id="mem_img">
				<label class="control-label col-sm-3"> <span
					id="form_label_span">&nbsp&nbsp會&nbsp員&nbsp圖&nbsp片&nbsp&nbsp
				</span>
				</label>
				<!-- 上傳及預覽檔案 -->
				<div class="col-sm-9">
					<!-- 上傳檔案 -->
					<div class="row">
						<div class="col-sm-12">
							<input type="file" name="file1" id="upload_img"	accept="image/jpeg, image/png">
						</div>
					</div>
					<!-- 預覽上傳檔案 -->
					<div class="row">
						<div class="col-sm-12" id="preview_img"></div>
					</div>
				</div>
			</div>
			<c:if test="${LoginOK.usertype==2}">
        <div id="mem_org">
            <label class="control-label col-sm-3"> 
                <span id="form_label_span">&nbsp社福簡介圖片&nbsp</span>
			</label>
            <!-- 上傳及預覽檔案 -->
            <div class="col-sm-9">
                <!-- 上傳檔案 -->
                <div class="row">
                    <div class="col-sm-12">
                        <input type="file" name="file1" id="upload_org_img" accept="image/jpeg, image/png">
                    </div>
                </div>
                <!-- 預覽上傳檔案 -->
                <div class="row">
                    <div class="col-sm-12" id="preview_org_img">
                        <!-- 原先的圖檔 -->
                        <img src="${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=ORG" id="show_img">
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>

		<!-- 修改按鈕 -->
		<button type="submit" name="submit" value="" id="member_update_button" class="btn btn-block" onclick="return confirmUpdate('${member.userId}');">
			<b>修&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp改</b>
		</button>
	</form>
</div>


<script type="text/javascript">
	function confirmDelete(userId) {
		var result = confirm("確定刪除此筆記錄(帳號:" + userId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "DELETE";
			return true;
		}
		return false;
	}
	function confirmUpdate(userId) {
		var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "UPDATE";
			return true;
		}
		return false;
	}
	
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
