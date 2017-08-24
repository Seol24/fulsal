<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h3 class="h3">아이디 : ${members.mid }</h3>
			<h3 class="h3">연락처 : ${members.mphone }</h3>
			<h3 class="h3">이메일 : ${members.memail }</h3>
		<form id="f1">
			<input type="hidden" value="${reservation.rno }" name="rno" id="rno">
			<input type="hidden" value="${rdate }" name="rdate" id="rdate">
			<c:if test="${members.mid == login }">
				<button id="delete">예약 취소</button>
				<button id="modify">예약 마감</button>
			</c:if>
		</form>
		<div>
			<br><br><hr class="hr"><br><br>
			
			<label>댓글 내용</label>
			<input type="hidden" value="${reservation.rno }" name="rno" id="rno">
			<textarea rows="4" cols="150" name="mrcontext"	id="mrcontext" placeholder="댓글을 쓰세요"></textarea>
			<input type="hidden" value="${login }" name="mid" id="mid"> 
			<button id="btnAdd">댓글 추가</button>
			<ul id="pageList"></ul>
			<ul class="timelines">
				<li id="repliesList"><span id="btnList">댓글 보기</span></li>
			</ul>
			<ul id="pageList"></ul>
		</div>
		
		
		
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
		<script id="temp" type="text/x-handlevars-template">
		   		{{#list}}
					<li class="replyLi" data-mrno = {{mrno}}>
						<div>
							<p class="writer">작성자 : {{mid}}</p>
							<div class="timelines-body">{{mrcontext}}</div>
							<div class="btn-div">
								<span class="modify" data-toggle="modal" data-target="#modfyModal" data-mrno={{mrno}}>Modify</span>
								<span class="delete" data-mrno={{mrno}}>Delete</span>
							</div>
						</div>
						<hr class="hr">
					</li>
				{{/list}}
		   	</script>
		<script type="text/javascript">
			$(function(){
				$("#delete").click(function() {
	   				$("#f1").attr("action", "delete");
	   				$("#f1").submit();
	   			})
	   			$("#modify").click(function() {
	   				$("#f1").attr("action", "modify");
	   				$("#f1").submit();
	   			})
	   			var curPage = 1;
				Handlebars.registerHelper("tempdate", function(time) {
					var dateObj = new Date(time);
					var year = dateObj.getFullYear();
					var month = dateObj.getMonth()+1;
					var date = dateObj.getDate();
					
					return year + "/" + month + "/" + date;
					
				});
				$("#modifyModal").hide();
		   	
		   		var rno = ${reservation.rno};
		   		console.log(rno);
		   		 function getAllList(){
		   			$.ajax({
		   				url: "${pageContext.request.contextPath}/repliess/all/"+rno,
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
					var replycContext = $("#mrcontext").val();
					var rno =$("#rno").val();
					var replymid = $("#mid").val();
					var sendData = {
							rno:rno,
							mrcontext:replycContext,
							mid:replymid
					};
					
					$.ajax({
						url : "${pageContext.request.contextPath}/repliess/add",
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
				$("#modifyModal").show();
				var mrno = $(this).attr("data-mrno");
				$("#modal-title").html(mrno);
				console.log(mrno + "번 차례");
				
				$(".modal-body").find("#mrcontext2").val($(this).parents("li.replyLi").find(".r_writer").html());
				$(".mdal-body").find("#mrcontext2").val($(this).parents("li.replyLi").find(".timelines-body"));
			});
			$(".btn-modify").click(function() {
					var mid = $("#mid").val();
					var mrno = $("#modal-title").html();
					var mrcontext = $("#mrcontext2").val();
					var sendData ={
							mrno:mrno,
							mid: mid,
							mrcontext :mrcontext
					};
				
				$.ajax({
					url : "${pageContext.request.contextPath}/repliess/"+mrno,
					type : "put",
					dataType : "text",
					data: JSON.stringify(sendData),
					headers :{"Content-Type":"application/json"},
					success: function(data) {
						console.log(mrno + "수정하기 " +data);
						if(data =="SUCCESS"){
							alert(mrno+"번 댓글 수정완료");
							getAllList();
							$("#modifyModal").hide();
						}
					}
				})
			})
				
			$(document).on("click", ".delete", function(event) {
				event.preventDefault(); // a tag 전송 막기
				var mrno = $(this).attr("data-mrno");
				if(confirm("정말로 삭제하시겠습니까?")){
					//글 지우기	
					$.ajax({
						url : "${pageContext.request.contextPath}/repliess/"+mrno,
						type : "delete",
						dataType : "text",
						data: "text",
						success: function(data) {
							console.log(mrno + "삭제하기 " +data);
							if(data =="SUCCESS"){
								alert(mrno+"번 댓글 삭제완료");
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
		   	
		<!-- <div id="modifyModal" role="dialog">
			<div class="modal-body">
			<p class="p1">
				<label for="newReplyText">댓글 내용</label>
				<span id="modal-title"></span>
				<input type="text" placeholder="Reply Text" id="mrcontext2" class="form-control">
				<button type="button" class="btn-modify" id="replyModBtn"data-dismiss="modal">수정</button>
			</p>
			</div>
		</div> -->
		<div id="modifyModal" role="dialog">
		<div class="modal-body">
			<div class="p1">
				<span id="login">${login}</span>
				<span id="modal-title"></span>
				<br><br>
				<textarea rows="4" cols="150" placeholder="댓글을 쓰세요" id="mrcontext2" class="form-control"></textarea>
				<div id="btn">
					<button type="button" class="btn-cancel" id="replyCancelBtn"data-dismiss="modal">취소</button>
					<button type="button" class="btn-modify" id="replyModBtn"data-dismiss="modal">수정</button>
				</div>
			</div>
				
			
		</div>
	</div>
	</div>
</body>
</html>