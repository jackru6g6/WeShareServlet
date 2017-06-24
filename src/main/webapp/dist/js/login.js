$(function(){
	console.log("loginOk = " + loginOk, "indname = " + indname, "indid = " + indid);
	if (indname == "" || indname == "${LoginOK.indname}"){
		$(".afterLogin").css("display", "none");
	} else {
		$(".beforeLogin").css("display", "none");
		$(".afterLogin").css("display", "block");
	}
});