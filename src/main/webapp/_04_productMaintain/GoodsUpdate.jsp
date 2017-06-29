<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>
<link href="../style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function setFocus()
{
  document.getElementById("title").focus();
}

function confirmDelete() {
	if (confirm("確定刪除此項物資資料(物資編號:${bean.goodsno})?") ) {
		document.forms[0].action="GoodsDelete.do?pk=${bean.goodsno}" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	}
}

function updateGoods() {
 document.forms[0].action="GoodsUpdate.do?pk=${bean.goodsno}" ;
	document.forms[0].method="POST";
	document.forms[0].submit();
}

</script>

</head>
<body onload="setFocus()"">

<div id='main'>
<center>


<div><a href="<c:url value='DisplayPageProducts?pk=${ LoginOK.indid }'  />">查詢物資箱</a></div>


<form  id="form1" name="form1" method="post" 
       action="GoodsUpdate.do"  enctype="multipart/form-data" >
       

    <input type="hidden" name="indid"     value="${LoginOK.indid}" >
    <input type="hidden" name="goodsno" value="${bean.goodsno}" >
    <input type="hidden" name="updatetime" value="" >     
    <input type="hidden" name="usertype"   value="${LoginOK.usertype}" >       
  
<table  class="table_color" width="680" border="2" align="center" 
cellpadding="2" cellspacing="2" bordercolorlight="#FFFFFF" bordercolordark="#330033">
   <tr height='40'>
       <td colspan="4" align="center" valign="bottom"> 
           <TABLE width="680" BORDER='0' style="background:#ffE4C4">
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
            <TR height='20' >
                <TD  align='center' >
                   <FONT color='#8000FA' size='+2' style="font-weight:900;" >
                      修改物資箱
                   </FONT>
                </TD>
            </TR>
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
         </TABLE>
           
       </td>
    </tr>
    <tr height='36'>
       <td width="100" align="right" class="title_font">需求類別</td>
       <td colspan="3"> 
           <input name="goodsstatus" class='InputClass' type="text" id="title" 
              value="${bean.goodsstatus}${param.goodsstatus}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errgoodsstatus}
           </font>
       </td>
    </tr>
     <tr height='36'>
       <td width="45" align="right" class="title_font">物品類別</td>
       <td colspan="3"> 
           <input name="goodstype" class='InputClass' type="text" id="title" 
              value="${bean.goodstype}${param.goodstype}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errgoodstype}
           </font>
       </td>
    </tr>
     <tr height='36'>
       <td width="45" align="right" class="title_font">需求名稱</td>
       <td colspan="3"> 
           <input name="goodsname" class='InputClass' type="text" id="title" 
              value="${bean.goodsname}${param.goodsname}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errgoodsname}
           </font>
       </td>
    </tr>
     <tr height='36'>
       <td width="45" align="right" class="title_font">需求地區</td>
       <td colspan="3"> 
           <input name="goodsloc" class='InputClass' type="text" id="title" 
              value="${bean.goodsloc}${param.goodsloc}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errgoodsloc}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">需求說明</td>
       <td colspan="3"> 
           <input name="goodsnote" class='InputClass' type="text" id="title" 
              value="${bean.goodsnote}${param.goodsnote}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errgoodsnote}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">需求數量</td>
       <td colspan="3"> 
           <input name="qty" class='InputClass' type="text" id="title" 
              value="${bean.qty}${param.qty}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errqty}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">需求方式</td>
       <td colspan="3"> 
           <input name="goodsshipway" class='InputClass' type="text" id="title" 
              value="${bean.goodsshipway}${param.goodsshipway}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errgoodsshipway}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">截止時間<br>(yyyy-MM-dd)</td>
       <td colspan="3"> 
           <input name="deadline" class='InputClass' type="text" id="title" 
              value="${bean.deadlinestring}${param.deadline}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errdeadline}
           </font>
       </td>
    </tr>
    <tr height='36'>
        <td width="45" align="right" class="title_font">圖片</td>
        
        <td>
<img height='40px' width='30px' src='${pageContext.servletContext.contextPath}/_00_init/getImage?id=${bean.goodsno}&type=GOODS'  />
        </td>
        
        <td colspan="3">
            <input style="background:#FFFFFF" class='InputClass'  type="file" 
            name="uploadFile" size="40" />
            <font color='red' size='-1'>${ErrMsg.errPicture}</font></td>
    </tr>


    
    <tr height="36" >
      <td height="61" colspan="6" align="center">
          
         
       
        <input type="button" name="update" value="修改" onclick='updateGoods()'/>
        <input type="button" name="delete" value="刪除" onclick="confirmDelete()" /> 
         <div id="deleteMsg">
         ${ErrMsg.errDBMessage}		 
        <input type="hidden" name="pageNo" value="${param.pageNo}" />
 		 </div>
        
        
        
      </td>
    </tr>
  </table>
</form>







<p>&nbsp;</p>
</center>
</div>
</body>
</html>