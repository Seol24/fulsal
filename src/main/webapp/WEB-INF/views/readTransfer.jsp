<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>FutSal</title>
<%@ include file="include/path.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" type="text/css"/>
<style type="text/css">

</style>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
		
		<h3>제목 : ${transfer.ttitle }</h3>
		<h4>작성자 : ${transfer.mid }</h4>

		<p id="context">${transfer.tcontext }</p>

		<form id="f1" role="form" method="post">
			<input type="hidden" name="tno" value="${transfer.tno }">
		</form>

		<button id="modify">수정</button>
		<button id="delete">삭제</button>
		<button id="back">돌아가기</button>

		<div>
			<br><br><hr class="hr"><br><br>
			<p>
				<textarea name="trcontext"	id="trcontext" rows="4" cols="150" placeholder="댓글을 쓰세요"></textarea>
				<input type="hidden" value="${login }"name="mid" id="mid"> 
				<input type="hidden" value="${transfer.tno }" name="tno">
				<button id="btnAdd">댓글 작성</button>
			</p>
			<ul class=timelines>
				<li id="repliesList"><span id="btnList">댓글 보기</span></li>
			</ul>
			<ul id="pageList"></ul>
		</div>
		
		
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
	   		$(function(){
	   			$("#delete").click(function() {
	   				$("#f1").attr("action", "deleteTransfer");
	   				$("#f1").submit();
	   			})
	   			$("#modify").click(function() {
	   				$("#f1").attr("action", "modifyTransfer");
	   				$("#f1").attr("method","get");
	   				$("#f1").submit();
	   			})
	   			$("#back").click(function() {
	   				$("#f1").attr("action", "listTransfer");
	   				$("#f1").attr("method","get");
	   				$("#f1").submit();
	   			})
	   			$("#modifyModal").hide();
	   		})
	   	</script>


		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
		<script id="temp" type="text/x-handlevars-template">
		   		{{#list}}
					<li class="replyLi" data-trno = {{trno}} data-mid={{mid}}>
						<div>
							<p class="writer">작성자 : {{mid}}</p>
							<div class="timelines-body">{{trcontext}}</div>
							<div class="btn-div">
								<span class="modify" data-toggle="modal" data-target="#modfyModal" data-trno={{trno}} data-mid={{mid}}>Modify</span>
								<span class="delete" data-trno={{trno}}>Delete</span>
							</div>
						</div>
					</li>
					<hr class="hr" >
				{{/list}}
		   	</script>
		<script type="text/javascript">
			$(function(){
				var curPage = 1;
				Handlebars.registerHelper("tempdate", function(time) {
					var dateObj = new Date(time);
					var year = dateObj.getFullYear();
					var month = dateObj.getMonth()+1;
					var date = dateObj.getDate();
					
					return year + "/" + month + "/" + date;
					
				});
				
		   	
		   		var tno = ${transfer.tno};
		   		console.log(tno);
		   		function getAllList(){
		   			$.ajax({
		   				url: "${pageContext.request.contextPath}/replie/all/"+tno,
		   				type : "get",
		   				dataType : "json",
		   				success:function(data){
		   					console.log(data);
		   					
		   					var source = $("#temp").html();
		   					var template = Handlebars.compile(source);
		   					$(".replyLi").remove();
		   					$(".timelines").append(template(data));
		   					/* $(".replyLi").toggle(".mystyle"); */
		   				}
		   			})
		   		}
		   		
		   	/* 	function getPageList(page){
		   			$.ajax({
		   				url : "${pageContext.request.contextPath}/replies/all/"+bno,
		   				type : "get",
		   				dataType: "json",
		   				success:function(data){
		   					console.log(data);
		   					var source = $("temp2").html();
		   					var template = Handlebars.compile(source);
		   					$(".replyLi").remove();
		   					$(".timeline").append(template(date));
		   					
		   					var str2 = "";
		   				 	for(var i = data.pageMaker.startPage; i <=data.pageMaker.endPage; i++){
		   						if(i == page){
		   							str2 += "<li><a href='"+i+"'>"+i+"</a></li>";
		   						}else{
		   							str2 += "<li><a href='"+i+"'>"+i+"</a></li>";
		   						}
		   					} 
		   					$("#pageList").html(str2);
		   				}
		   			})
		   		} */
		   		$("#btnList").click(function() {
					getAllList();
				})
				$("#btnAdd").click(function(){
					var replycContext = $("#trcontext").val();
					var replymid = $("#mid").val();
					var sendData = {
							tno:tno,
							trcontext:replycContext,
							mid:replymid
					};
					$.ajax({
						url : "${pageContext.request.contextPath}/replie/add",
						type:"post",
						dataType:"text",
						data: JSON.stringify(sendData),
						headers :{"Content-Type":"application/json"},
						success: function(data) {
							console.log(data);
							//getPageList(curPage);
							getAllList();
						}
					})
					
				})
			$(document).on("click",".modify", function(event) {
				var idCheck = $(this).attr("data-mid");
				console.log(idCheck);
				var mid = $("#mid").val();
				console.log(mid);
				if(idCheck == mid){
					$("#modifyModal").show();
					var trno = $(this).attr("data-trno");
					$("#modal-title").html(trno);
					console.log(trno + "번 차례");
					$("#trno").html(trno);
					$(".modal-body").find("#trcontext2").val($(this).parents("li.replyLi").find(".r_writer").html());
					$(".mdal-body").find("#trcontext2").val($(this).parents("li.replyLi").find(".timelines-body"));
				}else{
					alert("자신의 댓글만 수정 하실 수 있습니다.");
				}
			})
			
			$(".btn-modify").click(function() {
					var mid = $("#mid").val();
					var trno = $("#modal-title").html();
					var trcontext = $("#trcontext2").val();
					var sendData ={
							trno:trno,
							mid: mid,
							trcontext :trcontext
					};
				
				$.ajax({
					url : "${pageContext.request.contextPath}/replie/"+trno,
					type : "put",
					dataType : "text",
					data: JSON.stringify(sendData),
					headers :{"Content-Type":"application/json"},
					success: function(data) {
						console.log(trno + "수정하기 " +data);
						if(data =="SUCCESS"){
							alert(trno+"번 댓글 수정완료");
							getAllList();
							$("#modifyModal").hide();
						}
					}
				})
			})
				
			$(document).on("click", ".delete", function(event) {
				event.preventDefault(); // a tag 전송 막기
				var trno = $(this).attr("data-trno");
				if(confirm("정말로 삭제하시겠습니까?")){
					$.ajax({
						url : "${pageContext.request.contextPath}/replie/"+trno,
						type : "delete",
						dataType : "text",
						data: "text",
						success: function(data) {
							console.log(trno + "삭제하기 " +data);
							if(data =="SUCCESS"){
								alert(trno+"번 댓글 삭제완료");
								getAllList();
							}
						}
						
					})
				}
				
			})
			$(".btn-cancel").click(function() {
				$("#modifyModal").hide();
			})
		})
		   	</script>
	</div><!-- wrapper 닫는거 주의 -->
	
	<div id="modifyModal" role="dialog">
		<div class="modal-body">
			<div class="p1">
				<span id="login">${login}</span>
				<span id="modal-title"></span>
				<br><br>
				<textarea rows="4" cols="80" placeholder="댓글을 쓰세요" id="trcontext2" class="form-control"></textarea>
				<div id="btn">
					<button type="button" class="btn-cancel" id="replyDelBtn"data-dismiss="modal">취소</button>
					<button type="button" class="btn-modify" id="replyModBtn"data-dismiss="modal">수정</button>
				</div>
			</div>
		</div>
	</div> 
		
		
	

</body>
</html>