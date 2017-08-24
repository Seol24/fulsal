<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
<link href="${pageContext.request.contextPath}/resources/css/board.css" rel="stylesheet" type="text/css"/>
<%@ include file="include/path.jsp"%>
<style type="text/css">
	
</style>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
		
		<h3>${board.btitle }</h3>
		<h4>작성자 : ${board.mid }</h4>
		
		<p id="context">${board.bcontext }</p>

		<form id="f1" role="form" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
		</form>

		<button id="back">돌아가기</button>
		<button id="delete">삭제</button>
		<button id="modify">수정</button>
		<div>
			<br><br><hr class="hr"><br><br>
			
			<p>
				<textarea name="brcontext"	id="brcontext" placeholder="댓글을 쓰세요" cols="150" rows="4"></textarea>
				<input type="hidden" value="${login }" name="mid" id="mid"> 
				<input type="hidden"value="${board.bno }" name="bno">
				<button id="btnAdd">댓글 작성</button>
			</p>
			<br>
			<ul class=timelines>
				<li id="repliesList"><span id="btnList">댓글 보기</span></li>
			</ul>
			
		</div>
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
	   		$(function(){
	   			$("#delete").click(function() {
	   				$("#f1").attr("action", "deleteBoard");
	   				$("#f1").submit();
	   			})
	   			$("#modify").click(function() {
	   				$("#f1").attr("action", "modifyBoard");
	   				$("#f1").attr("method","get");
	   				$("#f1").submit();
	   			})
	   			$("#back").click(function() {
	   				$("#f1").attr("action", "listBoard");
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
					<li class="replyLi" data-brno = {{brno}} data-mid={{mid}}>
						<div>
							<p class="writer">작성자 : {{mid}}</p>
							
							<div class="timelines-body">{{brcontext}}</div>
							<div class="btn-div">
								<span class="modify" data-toggle="modal" data-target="#modfyModal" data-brno={{brno}} data-mid={{mid}}>Modify</span>
								<span class="delete" data-brno={{brno}}>Delete</span>
							</div>
						</div>
						<hr class="hr" >
					</li>
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
				
		   	
		   		var bno = ${board.bno};
		   		console.log(bno);
		   		 function getAllList(){
		   			$.ajax({
		   				url: "${pageContext.request.contextPath}/replies/all/"+bno,
		   				type : "get",
		   				dataType : "json",
		   				success:function(data){
		   					console.log(data);
		   					
		   					var source = $("#temp").html();
		   					var template = Handlebars.compile(source);
		   					$(".replyLi").remove();
		   					$(".timelines").append(template(data));
		   				}
		   			})
		   		}
		   		$("#btnList").click(function() {
					getAllList();
				}) 
				$("#btnAdd").click(function(){
					var replycContext = $("#brcontext").val();
					var replymid = $("#mid").val();
					var sendData = {
							bno:bno,
							brcontext:replycContext,
							mid:replymid
					};
					
					$.ajax({
						url : "${pageContext.request.contextPath}/replies/add",
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
					var brno = $(this).attr("data-brno");
					$("#modal-title").html(brno);
					console.log(brno + "번 차례");
					
					$(".modal-body").find("#brcontext2").val($(this).parents("li.replyLi").find(".r_writer").html());
					$(".mdal-body").find("#brcontext2").val($(this).parents("li.replyLi").find(".timelines-body"));
				}else{
					alert("자신의 댓글만 수정 하실 수 있습니다.");
				}
				});
				
			$(".btn-modify").click(function() {
					var mid = $("#mid").val();
					var brno = $("#modal-title").html();
					var brcontext = $("#brcontext2").val();
					var sendData ={
							brno:brno,
							mid: mid,
							brcontext :brcontext
					};
				
				$.ajax({
					url : "${pageContext.request.contextPath}/replies/"+brno,
					type : "put",
					dataType : "text",
					data: JSON.stringify(sendData),
					headers :{"Content-Type":"application/json"},
					success: function(data) {
						console.log(brno + "수정하기 " +data);
						if(data =="SUCCESS"){
							// 수정이 누적됩니다??? 왜죠????
							alert(brno+"번 댓글 수정완료");
							//getAllList();
							getAllList();
							$("#modifyModal").hide();
						}
					}
				})
			})
				
			$(document).on("click", ".delete", function(event) {
				event.preventDefault(); // a tag 전송 막기
				var brno = $(this).attr("data-brno");
				if(confirm("정말로 삭제하시겠습니까?")){
					//글 지우기	
					$.ajax({
						url : "${pageContext.request.contextPath}/replies/"+brno,
						type : "delete",
						dataType : "text",
						data: "text",
						success: function(data) {
							console.log(brno + "삭제하기 " +data);
							if(data =="SUCCESS"){
								alert(brno+"번 댓글 삭제완료");
								
								//getAllList();
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
	</div><!-- 이건 wrapper 닫는 div 주의-->
	<div id="modifyModal" role="dialog">
		<div class="modal-body">
			<div class="p1">
				<span id="login">${login}</span>
				<span id="modal-title"></span>
				<br><br>
				<textarea placeholder="댓글을 쓰세요" id="brcontext2" class="form-control" cols="80" rows="4"></textarea>
				<div id="btn">
					<button type="button" class="btn-cancel" id="replyCancelBtn"data-dismiss="modal">취소</button>
					<button type="button" class="btn-modify" id="replyModBtn"data-dismiss="modal">수정</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>