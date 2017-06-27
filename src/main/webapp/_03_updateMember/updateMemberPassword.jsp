<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE HTML>
<html>
<head>
<style>

</style>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
<script type="text/javascript">
 
</script>
</head>
<body>




<H1 class='center'>更新會員密碼</H1>
<hr>
<p> 
<form ENCTYPE="multipart/form-data" method="POST" action="<c:url value='/updateMemberPassword.do' />">
    <input type="hidden" name="indid"     value="${LoginOK.indid}" >
    <Table>
      <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT">${LoginOK.indid}</TD>
         </TR>

         <TR>
             <TD align="RIGHT">請輸入舊密碼：</TD>
             <TD align="LEFT" >
                <input type="password" name="indpassword" value="${param.indpassword}"  size="30">
                <font color='red' size='-3'>${MsgMap.LoginError}${MsgMap.PasswordEmptyError}</font>
             </TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" >
                <input type="password" name="newindpassword" value="${param.newindpassword}"  size="30">
                <font color='red' size='-3'>${MsgMap.PasswordEmptyError1}${MsgMap.errorNewPasswordEmpty}</font>
             </TD>
         </TR>  
         <TR>
             <TD align="RIGHT">密碼確認：</TD>
             <TD align="LEFT" >
                <input type="password" name="newindpassword2" value="${param.newindpassword2}"  size="30">
                <font color='red' size='-3'>${MsgMap.PasswordEmptyError2}${MsgMap.errorNewPassword2Empty}</font>               
             </TD>
         </TR>   
          


        <TR>
            <TD colspan="2" align="center">     
            <input type="submit" value="更新" name='updatePasswordBtn'> 
            
            </TD>
            </TR>
         </Table>
         <c:if test="${not empty requestScope.modify}">   
           <c:remove var="member" scope="request" />       
         </c:if>
</Form>
















</body>
<small>&lt;&lt;<a href="${pageContext.request.contextPath}/index.jsp">回上一頁</a>&gt;&gt;</small>
</html>
