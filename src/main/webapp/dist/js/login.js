$(function(){
	// 取得會員資料
	console.log("loginOk = " + loginOk, "；indname = " + indname, "；indid = " + indid);
	if (indname == "" || indname == "${LoginOK.indname}"){
		$(".afterLogin").css("display", "none");
	} else {
		$(".beforeLogin").css("display", "none");
		$(".afterLogin").css("display", "block");
	}
	
	// 記得會員帳密
	console.log("rememberMe = " + rememberMe);
	console.log("checked = " + $("#rememberMe").prop("checked"));
	if(rememberMe == "true") {
		$("#rememberMe").prop("checked", true);
	} else {
		$("#rememberMe").prop("checked", false);
	}
});