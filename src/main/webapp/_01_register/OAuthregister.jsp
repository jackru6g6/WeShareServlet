<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<!-- DECLARE JSTL -->

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
	<meta charset="utf-8">
	<jsp:include page="../fragment/refCss.jsp" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/dist/css/OAuthregister.css">
	<jsp:include page="../fragment/refJs.jsp" />
	<title>WeShare 微分享</title>
</head>

<body>
	<header>
		<jsp:include page="../fragment/header.jsp" />
	</header>
	
	<section>
		<div id="sectionOAuthregister" class="container">
			<div class="register_main">
				<form id="formOAuth" role="form" ENCTYPE="multipart/form-data" method="POST"
					action="<c:url value='Google_Register.do' />">
					<legend id="titleOAuth">首次使用Google帳號登入</legend>
					<div class="row">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3 col-lg-offset-2">
							<label>帳號型態:</label>
						</div>
						<c:if test="${empty RM}">
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
								<label>
									<input type="radio" name="INDIDTYPE" onchange="INDIDTYPEChange()" value="INDIDTYPE_IND" checked>一般會員
								</label>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
								<label>
									<input type="radio" name="INDIDTYPE" id="INDIDTYPE_2" onchange="INDIDTYPEChange()"
									value="INDIDTYPE_ORG">社福機構
								</label>
							</div>
						</c:if>
						<c:if test="${!empty RM}">
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
								<label>
									<input type="radio" name="INDIDTYPE" onchange="INDIDTYPEChange()" value="INDIDTYPE_IND"
										${RM.INDIDTYPE_IND}>一般會員
								</label>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
								<label>
									<input type="radio" name="INDIDTYPE" onchange="INDIDTYPEChange()" value="INDIDTYPE_ORG"
									${RM.INDIDTYPE_ORG}>社福機構
								</label>
							</div>
						</c:if>
					</div>
					
					<!-- style="display:none" div隱藏欄位 -->
					<div></div>
					<div class="row">
						<div id="orgtable" style="display: none" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			
							<table id="tableOAuth" class="table table-hover">
								<tr>
									<td>有*為必填欄位</td>
									<td>社福團體</td>
								</tr>
								<tr>
									<td><i class="fa fa-heart" aria-hidden="true"></i>簡介*:</td>
									<td>
										<input type="text" name="ORGINF" placeholder="請短述" value="${param.ORGINF}" class="form-control">
										<font color="red" size="-1">${MsgMap.errorORGINF}</font>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-heart" aria-hidden="true"></i>負責人*:</td>
									<td>
										<input type="text" name="ORGLEADER" placeholder="請輸入負責人" value="${param.ORGLEADER}" class="form-control">
										<font color="red" size="-1">${MsgMap.errorORGLEADER}</font>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-heart" aria-hidden="true"></i>類型*:</td>
									<td>
										<input type="text" name="ORGTYPES" placeholder="請輸入類型" value="${param.ORGTYPES}" class="form-control">
										<font color="red" size="-1">${MsgMap.errorORGTYPES}</font></td>
								</tr>
								<tr>
									<td><i class="fa fa-heart" aria-hidden="true"></i>立案核准:</td>
									<td>
										<input type="text" name="ORGREGISTERNO"
										placeholder="請輸入立案編號" value="${param.ORGREGISTERNO}" class="form-control">
										<font color="red" size="-1">${MsgMap.errorORGREGISTERNO}</font>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-heart" aria-hidden="true"></i>勸募許可:</td>
									<td>
										<input type="text" name="ORGRAISENO"
										placeholder="請輸入勸募許可" value="${param.ORGRAISENO}" class="form-control">
										<font color="red" size="-1">${MsgMap.errorORGRAISENO}</font>
									</td>
								</tr>
								<tr>
									<td><i class="fa fa-heart" aria-hidden="true"></i>機構照片:</td>
									<td><input Type="file" name="ORGIMAGE"></td>
								</tr>
							</table>
						</div>
					</div>
					
					
					<div id="blockSubmit" class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<input type="submit" id="submit" value="開始使用" class="btn btn-primary">
							<font color="red" size="-1">${MsgMap.errorRESULT}</font>
						</div>
					</div>
				</form>
			</div>
			<%
				// 顯示MsgOK.InsertOK後，就要立刻移除，以免每次回到首 頁都會顯示新增成功的訊息
				session.removeAttribute("MsgMap");
			%>
		</div>
	</section>
	<footer>
		<jsp:include page="../fragment/footer.jsp" />
	</footer>
	
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
</body>
</html>