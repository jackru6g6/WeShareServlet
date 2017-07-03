<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#column1 {
position:absolute;
left:50px;
top:80px;
}
#column2 {
position:absolute;
left:450px;
top:80px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>weshare</title>
</head>

<body>
${pageContext.session.id }
<h1>weshare</h1>
<div id='column1'>
<a href="<c:url value='_01_register/register.jsp'  />">註冊</a><p/>
<a href="<c:url value='_02_login/login.jsp'  />">登入</a><p/>
<a href="<c:url value='_02_login/logout.jsp'  />">登出</a><p/>
<a href="<c:url value='_04_productMaintain/GoodsInsert.jsp'  />">新增物資箱</a><p/>
<a href="<c:url value='DisplayPageProducts?pk=${ LoginOK.indid }'  />">查詢物資箱</a><p/>


會員資料管理:<a href='FindMemberServlet?pk=${ LoginOK.indid }'>${ LoginOK.indid }</a>
</div>

<div id='column2'> 
	<c:if test="${! empty LoginOK }">
	訪客${ LoginOK.indid }，感謝您使用本系統。<br>
<img height='40px' width='30px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER'>
	
			</c:if>
<%-- <a href="<c:url value='ch06_01/logout.jsp'  />">登出</a><p/> --%>
</div>

</body>
</html>