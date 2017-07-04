<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!-- DECLARE JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
	<a href="<c:url value='/web/_05_deal/controller/FindDEALByKey.do' />">訂單查詢</a>
	<a href="<c:url value='/web/test/_05_deal/addDEAL.jsp' />"> 新增訂單 </a>
	<a href="<c:url value='/web/_06_MSG/controller/FindMSGByKey.do' />">訊息查詢</a>
	<a href="<c:url value='/web/test/_06_MSG/AddNewMSG.jsp' />"> 新增訊息 </a>
	
</table>
