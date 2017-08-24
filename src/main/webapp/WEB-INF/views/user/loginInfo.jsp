<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrapper{
		width : 960px;
		margin: 0 auto;
		margin-top: 150px;
	}
	label{
		width : 200px;
		float: left;
		font-size: 30px;
	}
	.p1{
		margin-top: 50px;
		margin-left: 100px;
	}
	.input{
		width: 500px;
		height: 50px;
		font-size: 30px;
	}
	#info{
		background-color: rgba(0,255,127,0.7);
		color:white;
		width: 100px;
		height: 50px;
		font-weight: bold;
		font-size: 20px; 
		margin-top: 50px;
		margin-left: 700px;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<form action="loginInfo" method="post">
			<p class="p1">
				<label>아이디</label><input type="text" name ="mid" class="input" placeholder="아이디를 입력하세요">
			</p>
			<p class="p1">
				<label>비밀번호</label><input type="password" name ="mpass" class="input" placeholder="비밀번호를 입력하세요">
			</p>
			<p class="p1">
				<label>이름</label><input type="text" name ="mname" class="input" placeholder="이름을 입력하세요">
			</p>
			<p class="p1">
				<label>PHONE</label><input type="text" name ="mphone" class="input" placeholder="연락처를 입력하세요">
			</p>
			<p class="p1">
				<label>이메일</label><input type="text" name ="memail" class="input" placeholder="이메일을 입력하세요">
			</p>
			<input type="submit" value="회원가입" id="info"> 
		</form>
	</div>
		
   
</body>
</html>