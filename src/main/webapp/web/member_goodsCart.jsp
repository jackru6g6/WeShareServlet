<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!-- title -->
	<div class="row">
		<div id="member_goodsCart_content_title" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_contnet_title">
			<h3>
				<b>我的物資箱</b>
			</h3>
		</div>
	</div>
	
	<!-- body -->
	<div class="row">
		<div id="member_goodsCart_content_body" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_body">
			<!-- 我的物資箱新增、查詢 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					
					<!-- 我的物資車_新增按鈕 -->
					<button type="button" id="goods_insert_button" class="btn btn-block" data-toggle="modal" data-target="#goods_insert_modal">
						<span class="glyphicon glyphicon-plus-sign"></span>
						<b>新增物資</b>
					</button>				
				</div>
			</div>
			
			<!-- 我的物資箱內容 -->
			<div class="row" id="member_goodsCart_content">
			
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<div class="row">
		<div id="goods_insert_modal_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">						
		</div>
	</div>
	
	
	<script>
//		預覽上傳照片
		$("#upload_img_goods").change(function(){
			if (this.files && this.files[0]) {
				var reader = new FileReader();
				reader.onload = function (e) {
					$("#preview_img_goods").attr("src", e.target.result);
				}
				reader.readAsDataURL(this.files[0]);
			}				
		});
	</script>
	
	