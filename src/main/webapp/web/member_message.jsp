<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!-- title -->
	<div class="row">
		<div id="member_message_content_title" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_contnet_title">
			<h3>
				<b>我的站內信</b>
			</h3>
		</div>
	</div>
	
	<!-- body -->
	<div class="row">
		<div id="member_message_content_body" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_body">
			<!-- 我的站內信_撰寫站內信按鈕 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<button type="button" name="" value="" id="message_insert_button" class="btn btn-block" data-toggle="modal" data-target="#message_insert_modal">
						<span class="glyphicon glyphicon-edit"></span>
						<b>撰寫站內信</b>
					</button>										
				</div>
			</div>
			
			<!-- 站內信_table -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
<!-- 					<div > -->
						<table class="table table-hover" id="member_message_table" rules="all">
							<thead>
								<tr>												
									<th><b>對象</b></th>													
									<th><b>最新消息</b></th>
									<th><b>內容</b></th>
								</tr>
							</thead>
							
							<tbody id="member_message">	
<!-- 								<tr>	 -->
<!-- 									<td> -->
<!-- 										<ul class="member_message_data"> -->
<!-- 											<li> -->
<!-- 												<img src="" class="message_end_img"> -->
<!-- 											</li> -->
<!-- 										</ul> -->
<!-- 									</td>													 -->
<!-- 									<td> -->
<!-- 										<ul> -->
<!-- 											<li> -->
<!-- 												<span class="member_message_span"><b>對象名稱</b></span> -->
<!-- 												~~~~~~~~~MSGENAME -->
<!-- 											</li> -->
<!-- 											<li> -->
<!-- 												<span class="member_message_span"><b>時&nbsp &nbsp &nbsp間</b></span> -->
<!-- 												~~~~~~~~~ -->
<!-- 											</li> -->
<!-- 											<li> -->
<!-- 												~最新消息~ -->
<!-- 											</li> -->
<!-- 										</ul>										 -->
<!-- 									</td> -->
<!-- 									<td>									 -->
<!-- 										<button class="btn btn-default member_message_content_button"> -->
<!-- 											<span class="glyphicon glyphicon-list-alt"></span> -->
<!-- 											內容 -->
<!-- 										</button>														 -->
											
<!-- 										<button class="btn btn-default member_message_close"> -->
<!-- 											<span class="glyphicon glyphicon-list-alt"></span> -->
<!-- 											收起 -->
<!-- 										</button>													 -->
<!-- 									</td>												 -->
<!-- 								</tr> -->
								
<!-- 								<tr> -->
<!-- 									<td colspan="4" class="member_message_all"> -->
<!-- 										<div class="member_message_show"></div>		 -->
<!-- 									</td> -->
<!-- 								</tr> -->
							</tbody>
								
						</table>
<!-- 					</div> -->
				</div>								
			</div>
		
		
		</div>
	</div>
	
	<!-- footer -->
	<div class="row">
		<div id="member_message_content_footer" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 member_content_footer">	
		</div>
	</div>
	
	
	
	
	<!-- 預覽新增站內信的上傳圖片 -->
	<script>
		$(document).ready(function(){

			$("#upload_img_message").change(function(){
				
				if (this.files && this.files[0]) {
					var reader = new FileReader();
					
					reader.onload = function (e) {
						$("#preview_img_message").attr("src", e.target.result);
					}
					
					reader.readAsDataURL(this.files[0]);
				}
				
			});

		}) ;
	</script>
	
	
	
	<!-- 按下內容圖樣，向下滑出內容，並可以回復信息-->
	<script>
		$(document).ready(function(){
			$(".member_message_content_button").click(function(){
				$(".member_message_all").show();
				$(".member_message_content_button").hide();
				$("member_message_close").show();
			});															
			
			$(".member_message_close").click(function(){
				$(".member_message_all").hide();
				$(".member_message_close").hide();
				$("member_message_content_button").show();
			});	
			
		});
	
	</script>
									
	
	
		
	
	