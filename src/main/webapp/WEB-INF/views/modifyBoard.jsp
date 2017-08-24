<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
<%@ include file="include/path.jsp"%>
<style type="text/css">
	#wrapper{
		width:960px;
		margin: 0 auto;
		margin-top: 150px;
	}
	label {
		width: 150px;
		float: left;
		font-size: 25px;
	}
	input{
		margin-right: 30px;
	}
	.input{
		width: 720px;
		height: 50px;
		font-size: 30px;
		border-radius:10px;
	}
	textarea{
		border-radius:10px;
	}
	#sub{
		margin-left: 570px;
		background-color: rgba(0,255,127,0.7);
		border-radius:5px 5px;
		font-size: 25px;
		color:white;
	}
	#reset{
		background-color: rgba(255,108,108,0.9);
		border-radius:5px 5px;
		font-size: 25px;
		color:white;
	}
	#back{
		background-color: rgba(255,255,54,0.9);
		border-radius:5px 5px;
		font-size: 25px;
		color:white;
	}
	
</style>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
		<form action="modifyBoard" method="post" id="f1">
			
			<p class="p1">
	   			<label>제목</label><input type="text" name="btitle" value="${board.btitle }" class="input">
	   		</p>
	   		<p class="p1">
	   			<label>내용</label><textarea rows="20" cols="116" name="bcontext" >${board.bcontext }</textarea>
	   		</p>
	   		<p class="p1">
	   			<label>작성자</label><input type="text" name ="mid" value="${board.mid }"  class="input">
	   		</p>
	   		<input type="hidden" name ="bno"value="${board.bno }">
	   		<br><br>
	   		<input type="submit" value="수정" id="sub">
	   		<input type="reset" value="취소" id="reset">
	   		<input type="button"value="돌아가기" id="back">
   		</form>
	</div>
   	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   	<script type="text/javascript">
   		$(function(){
   			$("#back").click(function() {
   				location.href = "readBoard?bno=${board.bno}";
   			})
   		})
   	</script>
</body>
</html>