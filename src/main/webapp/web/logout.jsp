<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-Hant">
<head>
	<meta charset="utf-8">
	<script type="text/javascript" src="https://mail.google.com/mail/u/0/?logout&hl=en"></script>
</head>

<body>
	<!-- 移除放在session物件內的屬性物件 -->
	<c:remove var="LoginOK" scope="session" />
	
	<%
	  session.invalidate();
	%>
	
	<jsp:forward page="index.jsp"/>
</body>
</html>




