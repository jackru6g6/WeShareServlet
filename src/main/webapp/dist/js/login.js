$(function(){
	// 取得會員資料
	if (indname == "" || indname == "${LoginOK.indname}"){
		$(".afterLogin").css("display", "none");
	} else {
		$(".beforeLogin").css("display", "none");
		$(".afterLogin").css("display", "block");
	}
	
	// 記得會員帳密
	if(rememberMe == "true") {
		$("#rememberMe").prop("checked", true);
	} else {
		$("#rememberMe").prop("checked", false);
	}
});