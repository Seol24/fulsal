<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<%@ include file="include/path.jsp"%>
<style type="text/css">
	#wrapper{
		width : 1480px;
		margin: 0 auto;
	}
	table{
		overflow:hidden;
		margin-top:30px;
		border-top:1px solid black;
		border-collapse: collapse;
	}
	
	table tr td{
		width: 350px;
		height: 70px;
		text-align: center;
		border-bottom: 1px solid black;
		font-size: 25px;
		font-family: "Oxygen";
		color:rgba(0,0,0,0.7);
	}
	
	 table tr th{
	 	width : 300px;
	 	height: 70px;
	 	border-bottom: 1px solid black;
		text-align: center;
		font-size: 25px;
		font-family: "Oxygen";
		color:rgba(0,0,0,0.7);
	 }
	 #rdate {
		font-size: 40px;
		margin-bottom: 20px;
		text-align: center;
		color:rgba(0,0,0,0.7);
	}
	
	td a{
		font-size:20px;
		color: green;
		text-decoration: none;
		font-family: "Oxygen";
	}
	td a:hover{
		color:rgba(0,255,127,0.7);
		text-decoration: none;
	}
	.back{
		text-align:right;
		margin:30px;
		margin-right: 100px;
	}
	.red a{
		font-size:20px;
		color:rgb(255,108,108);
		font-family: "Oxygen";
	}
	.red{
		font-size:20px;
		color:rgb(255,108,108);
		font-family: "Oxygen";
	}
	.blue a{
		font-size:20px;
		color:rgb(139,188,255);
		font-family: "Oxygen";
	}
	.blue a:hover{
		color:rgba(139,188,255,0.5);
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".red a").click(function(event) {
			if(confirm("예약을 취소 하시겠습니까 ?")==true){
			}else{
				event.preventDefault();
				return false;
			}
		})
	})
</script>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
	<p class="back"><a href="cal">뒤로가기</a></p>
	<h1 id="rdate">${rdate } 예약현황</h1>
  	 <table>
  	 	
	   	<tr>
	   		<th>시간</th>
	   		<c:forEach var="kujang" items="${kujang }">
	   			<th>${kujang.kno }구장</th>
	   		</c:forEach>
	   	</tr>
	   		
	   		<c:forEach var="today" items="${today }">
	   			<tr>
	   				<td>${today.todaytime-1 }시 ~ ${today.todaytime }시 </td>
	   				<c:forEach var="kujang" items="${kujang }" varStatus="status">
		   				<c:set var="reservationCheck" value="false"/>
	   					<c:forEach var="reservation" items="${reservation }">
		   					<c:choose>
		   						<c:when test="${reservation.startdate == today.todaytime-1 && reservation.kno == kujang.kno && reservation.rmatching ==false}">
		   							<c:set var="reservationCheck" value="true"/>
		   							<c:if test="${reservation.mid==login }">
		   								<td class="red"><a href="delete?rno=${reservation.rno }&rdate=${rdate }" >예약중</a></td>
		   							</c:if>
		   							<c:if test="${reservation.mid!=login }">
		   								<td class="red">예약중</td>
		   							</c:if>
		   						</c:when>
		   						<c:when test="${reservation.startdate == today.todaytime-1 && reservation.kno == kujang.kno && reservation.rmatching ==true}">
		   							<c:set var="reservationCheck" value="true"/>
		   							<td class="blue"><a href="readReservation?rdate=${rdate }&kno=${kujang.kno}&todaytime=${today.todaytime}&mid=${reservation.mid}&rno=${reservation.rno}" data-kno=${kujang.kno } data-todaytime=${today.todaytime-1 } class="">예약중 매칭가능</a></td>
		   						</c:when>
		   					</c:choose>					
	   						
	   					</c:forEach>
	   					
	   					<c:if test="${reservationCheck == false}">
		   					<td class="green"><a href="insertReservation?rdate=${rdate }&kno=${kujang.kno}&todaytime=${today.todaytime}" data-kno=${kujang.kno } data-todaytime=${today.todaytime-1 } data-test="4"> 예약가능</a></td>
		   				</c:if>
	   						
	   				</c:forEach>
	   			</tr>
	   		</c:forEach>
	   </table>
	   <p class="back"><a href="cal">뒤로가기</a></p>
   </div>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script type="text/javascript">
   		
   </script>
   
</body>
</html>