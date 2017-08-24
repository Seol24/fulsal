<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
<%@ include file="include/path.jsp"%>
<style type="text/css">
	#wrapper{
		width : 1080px;
		margin: 0 auto;
		margin-top: 50px;
	}
	label {
		width: 150px;
		float: left;
		font-size: 25px;
		color: rgba(255,255,255,0.25);
		line-height: 50px;
		font-weight: normal;
	}
	input{
		margin-right: 30px;
	}
	.p1{
		margin-bottom: 40px;
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
	.input{
		width: 720px;
		height: 50px;
		font-size: 30px;
		padding-left:20px;
		border-radius: 15px;
		color:rgba(0,0,0,0.25); 
	}
	textarea {
		padding-left:20px;
		border-radius: 15px;
		color:rgba(0,0,0,0.25); 
}
</style>
</head>
<body>
	 <%@ include file="include/header.jsp"%>
   <div id="wrapper">
  
   	<form action="insertBoard" method="post">
   		<p class="p1">
   			<label>제목</label><input type="text" name="btitle" class="input" placeholder="제목을 입력하세요">
   		</p>
   		<p class="p1">
   			<label>내용</label><textarea rows="20" cols="113" name="bcontext" placeholder="작성자를 입력하세요"></textarea>
   		</p>
   		<p class="p1">
   			<label>작성자</label><input type="text" name ="mid" value="${login }" readonly="readonly" class="input">
   		</p>
   		<br><br>
   		<input type="submit" value="등록" id="sub"><input type="reset" value="취소" id="reset"><input type="button"value="돌아가기" id="back">
   	</form>
   </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script type="text/javascript">
   	$(function(){
   		$("#back").click(function() {
   			location.href ="listBoard";
   		})
   	})
   </script>
</body>
</html>