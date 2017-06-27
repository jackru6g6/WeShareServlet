<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!-- DECLARE JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OAuthregister(註冊)</title>
</head>
<script type="text/javascript">
	function INDIDTYPEChange() {
		if (document.getElementById('INDIDTYPE_2').checked) {
			document.getElementById("orgtable").style.display = "block";
			document.getElementById("submit").value = "送出";

		} else {
			document.getElementById("orgtable").style.display = "none";
			document.getElementById("submit").value = "開始使用";
		}
	}
</script>
<body>
	<div class="register_main">
		<form ENCTYPE="multipart/form-data" method="POST"
			action="<c:url value='Google_Register.do' />">
			<h1>第三方首次使用</h1>
			<td>帳號型態:</td>
			<c:if test="${empty RM}">
				<td><label><input type="radio" name="INDIDTYPE"
						onchange="INDIDTYPEChange()" value="INDIDTYPE_IND" checked>一般會員</label></td>
				<td><label><input type="radio" name="INDIDTYPE"
						id="INDIDTYPE_2" onchange="INDIDTYPEChange()"
						value="INDIDTYPE_ORG">社福機構</label></td>
			</c:if>
			<c:if test="${!empty RM}">
				<td><label><input type="radio" name="INDIDTYPE"
						onchange="INDIDTYPEChange()" value="INDIDTYPE_IND"
						${RM.INDIDTYPE_IND}>一般會員</label></td>
				<td><label><input type="radio" name="INDIDTYPE"
						onchange="INDIDTYPEChange()" value="INDIDTYPE_ORG"
						${RM.INDIDTYPE_ORG}>社福機構</label></td>
			</c:if>
			<!-- style="display:none" div隱藏欄位 -->
			<div></div>
			<div id="orgtable" style="display: none">


				<table border="1" bordercolor="#f00">
					<tr>
						<td>有*為必填欄位</td>
						<td>社福團體</td>
					</tr>
					<tr>
						<td>*簡介:</td>
						<td><input type="text" name="ORGINF" placeholder="請短述"
							value="${param.ORGINF}"><font color="red" size="-1">${MsgMap.errorORGINF}</font></td>
					</tr>
					<tr>
						<td>*負責人:</td>
						<td><input type="text" name="ORGLEADER" placeholder="請輸入負責人"
							value="${param.ORGLEADER}"><font color="red" size="-1">${MsgMap.errorORGLEADER}</font></td>
					</tr>
					<tr>
						<td>*類型:</td>
						<td><input type="text" name="ORGTYPES" placeholder="請輸入類型"
							value="${param.ORGTYPES}"><font color="red" size="-1">${MsgMap.errorORGTYPES}</font></td>
					</tr>
					<tr>
						<td>立案核准:</td>
						<td><input type="text" name="ORGREGISTERNO"
							placeholder="請輸入立案編號" value="${param.ORGREGISTERNO}"><font
							color="red" size="-1">${MsgMap.errorORGREGISTERNO}</font></td>
					</tr>
					<tr>
						<td>勸募許可:</td>
						<td><input type="text" name="ORGRAISENO"
							placeholder="請輸入勸募許可" value="${param.ORGRAISENO}"><font
							color="red" size="-1">${MsgMap.errorORGRAISENO}</font></td>
					</tr>
					<tr>
						<td>機構照片:</td>
						<td><input Type="file" name="ORGIMAGE"></td>
					</tr>
				</table>
			</div>
			<input type="submit" id="submit" value="開始使用"><font
				color="red" size="-1">${MsgMap.errorRESULT}</font>


		</form>
	</div>
	<%
		// 顯示MsgOK.InsertOK後，就要立刻移除，以免每次回到首 頁都會顯示新增成功的訊息
		session.removeAttribute("MsgMap");
	%>

</body>
</html>