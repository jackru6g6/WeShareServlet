<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="utf-8">
<jsp:include page="../../../fragment/refCss.jsp" />
<jsp:include page="../../../fragment/refJs.jsp" />
<title>WeShare 微分享</title>
</head>
<body>
	<header>
		<jsp:include page="../../../fragment/header.jsp" />
	</header>

	<section>
		<jsp:include page="../top.jsp" />
		<H1 class='center'>更新會員密碼</H1>
		<hr>
		<p>
		<form ENCTYPE="multipart/form-data" method="POST"
			action="<c:url value='/updateMemberPassword.do' />">
			<input type="hidden" name="indid" value="${LoginOK.indid}">
			<Table>
				<TR>
					<TD align="RIGHT">帳號：</TD>
					<TD align="LEFT">${LoginOK.indid}</TD>
				</TR>

				<TR>
					<TD align="RIGHT">請輸入舊密碼：</TD>
					<TD align="LEFT"><input type="password" name="indpassword"
						value="${param.indpassword}" size="30"> <font color='red'
						size='-3'>${MsgMap.LoginError}${MsgMap.PasswordEmptyError}</font></TD>
				</TR>
				<TR>
					<TD align="RIGHT">密碼：</TD>
					<TD align="LEFT"><input type="password" name="newindpassword"
						value="${param.newindpassword}" size="30"> <font
						color='red' size='-3'>${MsgMap.PasswordEmptyError1}${MsgMap.errorNewPasswordEmpty}</font>
					</TD>
				</TR>
				<TR>
					<TD align="RIGHT">密碼確認：</TD>
					<TD align="LEFT"><input type="password" name="newindpassword2"
						value="${param.newindpassword2}" size="30"> <font
						color='red' size='-3'>${MsgMap.PasswordEmptyError2}${MsgMap.errorNewPassword2Empty}</font>
					</TD>
				</TR>



				<TR>
					<TD colspan="2" align="center"><input type="submit" value="更新"
						name='updatePasswordBtn'></TD>
				</TR>
			</Table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
		</Form>
















	</section>

	<footer>
		<jsp:include page="../../../fragment/footer.jsp" />
	</footer>
</body>

</html>
