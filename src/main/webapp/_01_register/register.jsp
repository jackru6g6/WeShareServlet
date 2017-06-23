<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加入會員</title>
<style type="text/css">
<!--
body {
	background-attachment: fixed;
	background-color: #EBFFEB;
	background-repeat: no-repeat;
	background-position: 20px 50px;
}
.myBorder {
	color:#FFFF99;
	border: thin dotted #FFFFFF;
}
h1 {
	font-family: "標楷體", "新細明體", sans-serif;
	font-size: 24px;
}
.formBkgnd {
	color: #FFFFFF;
	background-color: #666666;
}
label {
	float:left;
	width:8em;
	font-weight:bold;
	color:#000000;
	margin-top:10px;
	margin-bottom:2px;
	margin-right:10px;
	text-align: right;
}

br {
	clear:both;
}
.fieldWidth {
    margin-top:10px;
	margin-bottom: 2px;
	width: 200px;
	background:#F6E497;
	font-size:1.1em;
}
/* 設定字體大小 */
.fontSize {
	font-size:1.1em;
}

#main {
    position:relative;
	left:70px;
	width:600px;
	height:543px;	
	top: 0px;
	z-index:2;
	font-size:0.9em; 
}
/* 主要內容的區塊 */
#content {
  width: 700px ;
  margin-left: auto ;
  margin-right: auto ;
}
/* 設定傳送鈕的樣式 */
#submit {
	width:64px;
	height:30px;
	font-size:1.2em
	color:#FFFFFF;
	margin-right:1.5em;
	border-width:2px;
	border-color: #FFEDAF #B2A268 #B2A268 #FFEDAF;
	background:#A9A9A9;
}
/* 設定取消鈕的樣式 */
#cancel {
	width:64px;
	height:30px;
	font-size:1.2em
	color:#ffffff;
	border-width:2px;
	border-color: #FFEDAF #B2A268 #B2A268 #FFEDAF;
	background:#a9a9a9;
}

#errorMsg {
    position:relative;
    top:0px; 
    left:0px;    
	color:#FF0000;
	font-size:0.8em;
}
-->
</style>
<script type="text/javascript">
//由<body>的onLoad事件處理函數觸發此函數
function setFocusToUserId(){   
	 document.forms[0].mid.focus();   // 將游標放在mid欄位內
}

function showForm(){
	var span = document.getElementById("spandisplay");
	span.style.display = 'inline';
	var userType =  document.getElementById("userType");
	userType.value='2';
}
</script>
</head>
<body onLoad="setFocusToUserId()" >
<c:set var="funcName" value="REG" scope="session"/>
<!-- 引入共同的頁首 -->
<%-- <jsp:include page="/fragment/top.jsp" /> --%>
  <div id="content"> 
  <Table width="700" border='2' cellspacing="0" bgColor='#E7CDFF'>
     <TR height="60" >
         <TD>
         <TABLE cellspacing="1" >
         <TR>
             <TD width="680" colspan='3' align="center" >
                 <Font color="#006600" size='5' face="標楷體">${AppName}</Font>
             </TD>
         </TD>
         </TR>
         <TR>
             <TD width="240" ></TD>
             <TD width="200"  align="center">
                 <Font color="#006600" size='4' face="標楷體">加入會員</Font>
             </TD>
         <!-- 此區塊顯示程式執行後的訊息 -->
             <TD width="240" aligh="left"><font size="-1" color="#FF0000">
                 ${MsgMap.InsertNG}${MsgMap.errorSaveData}</font>
             </TD>
         </TR>         
         </TABLE>
         </TD>
     </TR>
     <TR><TD colspan="3">
  <form ENCTYPE="multipart/form-data" method="POST" action="<c:url value='registery.do' />"  id="register.do" >
      <label class="fontSize" >帳號：</label>
      <input type="text" name="indid" value="${param.indid}" class="fieldWidth" style="width: 180px;">
      <!-- 
         注意value屬性的內容以及顯示錯誤訊息的寫法
      -->
      <font size="-1" color="#FF0000">${MsgMap.errorIDEmpty}${MsgMap.errorIDDup}</font>
      <br/>
      <label class="fontSize" >密碼：</label>
      <input type="password" name="indpassword" value="${param.indpassword}" class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${MsgMap.errorPasswordEmpty}</font>      
      <br/>
      
      <label class="fontSize" >密碼確認：</label>
      <input type="password" name="indpassword2" value="${param.indpassword2}"   class="fieldWidth" style="width: 200px;">
      <font color="red" size="-1">${MsgMap.errorPassword2Empty}</font>            
      <br/>
      
      <label class="fontSize" >姓名：</label>
      <input type="text" name="indname" value="${param.indname}"  class="fieldWidth" style="width: 180px;">
      <font color="red" size="-1">${MsgMap.errorName}</font>
      <br/>
      
      <label class="fontSize" >地址：</label>
      <input type="text" name="indaddress" value="${param.indaddress}"  class="fieldWidth" style="width: 320px;">
      <font color="red" size="-1">${MsgMap.errorAddr}</font>
      <br/>
      
      <label class="fontSize" >電話：</label>
      <input type="text"  name="indphone" value="${param.indphone}"    class="fieldWidth" style="width: 120px;">
      <font color="red" size="-1">${MsgMap.errorTel}</font>
      <br/>
      
      <label class="fontSize" >電子郵件：</label>
          <input type="text"  name="indemail" value="${param.indemail}"   class="fieldWidth" style="width: 300px;">
          <font color="red" size="-1">${MsgMap.errorEmail}</font>
      <br/>
      

      <label class="fontSize" >照片：</label>
      <Input Type="file" size="40" class="fieldWidth" style="width: 480px;"  name="file1"><BR>
      <br/>
      
      <hr>
      <span style="display:block">
      <label class="fontSize" >會員型態：</label>
      <input type="text"  name="usertype" id="userType" value="1"    class="fieldWidth" style="width: 120px;">
      </span>
      
      <input type="button" name="orgsubmit" id="orgsubmit" value="社福團體" onclick="showForm()"/><br>      
      <span style="display:none" id="spandisplay">
			
      <label class="fontSize" >簡介：</label>
      <input type="text"  name="intro" value="${param.intro}"    class="fieldWidth" style="width: 120px;">
      <font color="red" size="-1">${MsgMap.errorIntro}</font>
      <br/>
      <label class="fontSize" >負責人：</label>
      <input type="text"  name="leader" value="${param.leader}"    class="fieldWidth" style="width: 120px;">
      <font color="red" size="-1">${MsgMap.errorLeader}</font>
      <br/>
      <label class="fontSize" >類型：</label>
      <input type="text"  name="orgtypes" value="${param.orgtypes}"    class="fieldWidth" style="width: 120px;">
      <font color="red" size="-1">${MsgMap.errorOrgtypes}</font>
      <br/>
      <label class="fontSize" >立案核准：</label>
      <input type="text"  name="registerno" value="${param.registerno}"    class="fieldWidth" style="width: 120px;">
      <font color="red" size="-1">${MsgMap.errorRegisterno}</font>
      <br/>
      <label class="fontSize" >勸募許可：</label>
      <input type="text"  name="raiseno" value="${param.raiseno}"    class="fieldWidth" style="width: 120px;">
      <font color="red" size="-1">${MsgMap.errorRaiseno}</font>
      <br/>
      <label class="fontSize" >照片：</label>
      <Input Type="file" size="40" class="fieldWidth" style="width: 480px;"  name="file2"><BR>
      <br/>
      
      </span>
      
      
      <div id="btnArea" align="center">
         <input type="submit" name="submit" id="submit" value="儲存"/>
         <input type="reset" name="cancel" id="cancel" value="重填">
      </div>
      <br/>
</form>
</TD>
</TR>
</Table>
</div>
</body>
</html>