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
	
    <a href="<c:url value='/web/_03_updateMember/controller/FindMemberServlet'/>">個人資料</a>
	<a href="<c:url value='/web/test/_04_productMaintain/GoodsInsert.jsp' />">新增物資 </a>
	<a href="<c:url value='/web/_04_productMaintain/controller/DisplayPageProducts' />">物資箱</a>
	
</table>
