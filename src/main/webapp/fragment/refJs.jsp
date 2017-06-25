<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 引進外部資源頁面 START-->

<!-- 登入參數 -->
<script>
	var loginOk = "${LoginOK}";
	var indname = "${LoginOK.indname}";
	var indid = "${LoginOK.indid}";
	var rememberMe = "${sessionScope.rememberMe}";
</script>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/dist/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap JavaScript -->
<script src="${pageContext.request.contextPath}/dist/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Holder Background -->
<script src="//cdn.jsdelivr.net/holder/2.9.4/holder.min.js"></script>
	
<!-- 個人化 -->
<script src="${pageContext.request.contextPath}/dist/js/bundle.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/login.js"></script>

<!-- 引進外部資源頁面 END-->