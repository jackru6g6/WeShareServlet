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
  function confirmDelete(userId){
	  var result = confirm("確定刪除此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "DELETE";
	      return true;
	  }
	  return false;
  }
  function confirmUpdate(userId){
	  var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "UPDATE";
	      return true;
	  }
	  return false;
  }

  
</script>
</head>
<body>


<H1 class='center'>更新會員資料(JDBC版)</H1>
<hr>
<p> 
<form ENCTYPE="multipart/form-data" method="POST" action="<c:url value='/updateMember.do' />" class='center' id="register.do" >

    

    <input type="hidden" name="indid"     value="${LoginOK.indid}" >
    <input type="hidden" name="finalDecision" value="" > 
    
    <input type="hidden" name="usertype"   value="${LoginOK.usertype}" >

               
  
    
    ${LoginOK.usertype}<br>
    ${ind.indfilename}<br>
    ${ind.indimage}<br>
    ${LoginOK.indimage }<br>
	
    
    <Table>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT">${LoginOK.indid}</TD>
         </TR>
         
<!--          <TR> -->
<!--              <TD align="RIGHT">密碼：</TD> -->
<!--              <TD align="LEFT" > -->
<%--                 <input type="password" name="indpassword" value="${ind.indpassword}${param.indpassword}"  size="30"> --%>
<%--                 <font color='red' size='-3'>${MsgMap.errorPasswordEmpty}</font> --%>
<!--              </TD> -->
<!--          </TR>   -->
<!--          <TR> -->
<!--              <TD align="RIGHT">密碼確認：</TD> -->
<!--              <TD align="LEFT" > -->
<%--                 <input type="password" name="indpassword2" value="${ind.indpassword}${param.indpassword2}"  size="30"> --%>
<%--                 <font color='red' size='-3'>${MsgMap.errorPassword2Empty}</font>                --%>
<!--              </TD> -->
<!--          </TR>    -->
          
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" >
                <input type="text" name="indname" value="${ind.indname}${param.indname}"  size="30">
                <font color='red' size='-3'>${MsgMap.errorName}</font>
             </TD>
         </TR>   
         <TR>
             <TD align="RIGHT">電話：</TD>
             <TD align="LEFT" >
                <input type="text" name="indphone" value="${ind.indphone}${param.indphone}"  size="30">
                <font color='red' size='-3'>${MsgMap.errorTel}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">信箱：</TD>
             <TD align="LEFT" >
                <input type="text" name="indemail" value="${ind.indemail}${param.indemail}" size="40">
                <font color='red' size='-3'>${MsgMap.errorEmail}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">地址：</TD>
             <TD align="LEFT" > 
               <input type="text" name="indaddress" value="${ind.indaddress}${param.indaddress}">
               <font color='red' size='-3'>${MsgMap.errorAddr}</font>
             </TD>
         </TR> 
         
         <TR>
             <TD align="RIGHT">照片：</TD>
             
              <td>
<%-- <img height='40px' width='30px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=MEMBER'  /> --%>
             </td>
             <TD align="LEFT" >                
               <input type="file"  name="file1" size="40"/>
               <font color='red' size='-3'>${MsgMap.errorPasswordEmpty}</font>
             </TD>
         </TR>
         
         
         

         
         <TR class="org">
             <TD align="RIGHT">簡介：</TD>
             <TD align="LEFT" > 
               <input type="text" name="intro" value="${org.intro}${param.intro}">
               <font color='red' size='-3'>${MsgMap.errorIntro}</font>
             </TD>
         </TR> 
         <TR class="org">
             <TD align="RIGHT">負責人：</TD>
             <TD align="LEFT" > 
               <input type="text" name="leader" value="${org.leader}${param.leader}">
               <font color='red' size='-3'>${MsgMap.errorLeader}</font>
             </TD>
         </TR> 
         <TR class="org">
             <TD align="RIGHT">類型：</TD>
             <TD align="LEFT" > 
               <input type="text" name="orgtypes" value="${org.orgtypes}${param.orgtypes}">
               <font color='red' size='-3'>${MsgMap.errorOrgtypes}</font>
             </TD>
         </TR> 
         <TR class="org">
             <TD align="RIGHT">立案核准：</TD>
             <TD align="LEFT" > 
               <input type="text" name="registerno" value="${org.registerno}${param.registerno}">
               <font color='red' size='-3'>${MsgMap.errorRegisterno}</font>
             </TD>
         </TR> 
         <TR class="org">
             <TD align="RIGHT">勸募許可：</TD>
             <TD align="LEFT" > 
               <input type="text" name="raiseno" value="${org.raiseno}${param.raiseno}">
               <font color='red' size='-3'>${MsgMap.errorRaiseno}</font>
             </TD>
         </TR> 
         
         <TR>
             <TD align="RIGHT">照片：</TD>
             
              <td>
<%-- <img height='40px' width='30px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${LoginOK.indid}&type=ORG'  /> --%>
             </td>
             <TD align="LEFT" >                
               <input type="file"  name="file2" size="40"/>
               <font color='red' size='-3'>${MsgMap.errorPasswordEmpty}</font>
             </TD>
         </TR>
         






        <TR>
            <TD colspan="2" align="center">     
            <input type="submit" value="更新" name='updateBtn' onclick="return confirmUpdate('${member.userId}');"> 
            
            </TD>
            </TR>
         </Table>
         <c:if test="${not empty requestScope.modify}">   
           <c:remove var="member" scope="request" />       
         </c:if>
</Form>

</body>
<small>&lt;&lt;<a href="index.jsp">回上一頁</a>&gt;&gt;</small>
<!-- <small>&lt;&lt;<a href="queryAllMembers.do">回上一頁</a>&gt;&gt;</small> -->
</html>
