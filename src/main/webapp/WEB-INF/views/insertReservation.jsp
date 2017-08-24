<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
<%@ include file="include/path.jsp"%>
<style type="text/css">
	label{
		width:200px;
		float: left; 
	}
	#wrapper{
		width : 1080px;
		margin: 0 auto;
		margin-top: 150px;
	}
	#sub{
		margin-left: 570px;
		background-color: rgba(0,255,127,0.7);
		border-radius:5px 5px;
		font-size: 25px;
		color:white;
	}
	.input{
		width: 720px;
		height: 50px;
		font-size: 30px;
		padding-left: 30px;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
		
		<form action="insertReservation" method="post">
	   		<p>
	   			<label>예약 날짜</label><input type="text" name="rdate" value="${rdate }" class="input">
	   		</p>
	   		<p>
	   			<label>경기 시작 시간</label><input type="text" name="startdate" value="${today.todaytime-1 }" class="input">
	   		</p>
	   		<p>
	   			<label>경기 종료 시간</label><input type="text" name="enddate" value="${today.todaytime }" class="input">
	   		</p>
	   		<p>
	   			<label>구장 번호</label>
		   		<select name="kno">
		   		   	<option <c:if test="${kujang.kno eq '1' }">selected</c:if>>1</option>
		   			<option <c:if test="${kujang.kno eq '2' }">selected</c:if>>2</option>
		   			<option <c:if test="${kujang.kno eq '3' }">selected</c:if>>3</option>
		   		</select><br></br>
	   		</p>
	   		<p>
	   			<label>매칭 공개여부</label>공개  <input type="radio" name="rmatching" value="true">  비공개<input type="radio"name="rmatching" value="false"><br></br>
	   		</p>
	   		<input type="hidden" name="mid" value="${login }">
	   		<input type="submit" value="예약" id="sub">
   		</form>
	</div>

</body>
</html>