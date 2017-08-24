<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#login").click(function(event) {
		 if($("#mid").val()!="" &&  $("#mpass").val()==""){
				$("#noPass").css("display","block");
				event.preventDefault();
				return false;
			}else if($("#mid").val()=="" &&  $("#mpass").val()==""){
				$("#noId").css("display", "block");
				$("#noPass").css("display","block");
				event.preventDefault();
				return false;
			}
			else if($("#mid").val()=="" &&  $("#mpass").val()!=""){
				$("#mid").css("display","block");
				event.preventDefault();
				return false;
			}
		})
		
	})
</script>
<style type="text/css">
	#wrapper{
		width:960px;
		margin: 0 auto;
	}
	form{
		margin-top: 100px;
		margin-left: 100px;
	}
	label{
		width : 200px;
		float: left;
		font-size: 30px;
	}
	a{
		color: black;
		text-decoration: none;
		font-size:  30px;
	}
	#info{
		margin-left: 100px;
		color: rgba(0,0,0,0.7);
	}
	#login{
		background-color: rgba(0,84,255,0.7);
		color:white;
		width: 100px;
		height: 50px;
		font-weight: bold;
		font-size: 20px; 
		margin-top: 50px;
		margin-left: 630px;
	}
	.input{
		width: 500px;
		height: 50px;
		font-size: 25px;
		padding-left: 20px;
	}
	.p1{
		margin-top: 50px
	}
	h1{
		text-align: center;
		margin-top: 150px;
		font-size: 70px;
	}
	.error{
		color : red;
		margin-left:200px; 
		display: none;
	}
</style>
</head>
<body>
	<div id="wrapper">
	<h1>로 그 인</h1>
	<form action="loginPost" method="post">
		<p class="p1">
			<label>아이디</label><input type="text" name ="mid" id="mid" placeholder="아이디를 입력하세요" class="input"><br>
			<span class="error" id="noId">아이디를 입력하세요</span>
		</p>
	   	<p class="p1">
	 	  	<label>비밀번호</label><input type="password" name ="mpass" id="mpass"placeholder="비밀번호를 입력하세요" class="input"><br>
	 	  	<span class="error" id="noPass">비밀번호를 입력하세요</span>
	   	</p>	
	   	<input type="submit" value="로그인" id="login"> 
   	</form>
   	<p id="info">
   		<a href="loginInfo" id="info">회원가입</a>
   	</p>
	</div>
   
</body>
</html>