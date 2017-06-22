<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Members</title>
</head>
<body>
<p/>
<H1 class='center'>會員資料</H1>
<H3 class='center'>JDBC版</H3>
<hr>
<p> 
<div align="center">
		    <c:forEach var="mem"  varStatus="statusX" items="${AllMembers}">
                   <c:if test="${statusX.first}" >
                        <c:out value="<table border='1' cellspacing='5' cellpadding='5' >" escapeXml="false"/>
      		          	    <tr bgcolor="CCCC00">
			                    <td  colspan='5' ALIGN='CENTER'>會員基本資料</td>
			                </tr>
			                <tr  bgcolor="CCCC00">
			                    <th>帳 號</th><th>姓 名</th><th>eMail</th><th>電話</th><th>Java經驗</th>
			                </tr>
                    </c:if>		         
                    <c:choose>
                             <c:when test="${statusX.count % 2 == 0}">
                                  <c:set var="colorVar" value="99ddff" />
                             </c:when>
                             <c:otherwise>
                                  <c:set var="colorVar" value="88dd00" />
                             </c:otherwise>
                   </c:choose>
                    
                    <tr bgcolor="${colorVar}">
                         <td><a href='FindMemberServlet?pk=${mem.pk}'>${mem.userId}</a></td>
                         <td>${mem.name} </td>
                         <td>${mem.email}</td>
                         <td>${mem.tel} </td>
                         <td>${mem.experience}</td>
                    </tr>
                     <c:if test="${statusX.last}" >
                        <c:out value="</table>" escapeXml="flase" />
                    </c:if>		                      
		    </c:forEach>

<p>
<c:if test="${not empty sessionScope.modify}">   
   ${sessionScope.modify}<br>
   <c:remove var="modify" scope="session" />       
</c:if>
<c:if test="${not empty sessionScope.error}">   
   <c:remove var="error" scope="session" />       
</c:if>
<a href="${pageContext.request.contextPath}/ch04" >回本章首頁</a>
</div>
</body>
</html>