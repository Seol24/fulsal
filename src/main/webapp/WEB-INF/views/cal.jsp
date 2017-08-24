<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
 <%@ include file="include/path.jsp"%>
<style type="text/css">
table {
	text-align: center;
}

table tr td {
	width: 280px;
	height: 135px;
	line-height: 65px;
}
table tr td a:hover{
	text-decoration: none;
}

table tr th {
	width: 150px;
	height: 45px;
	text-align:center;
	line-height: 45px;
}
th:hover{
	color:rgba(0,255,127,0.7);
}

/* button {
	width: 35px;
	height: 50px;
	margin-left: 25px;
	margin-right: 25px;
	background: black;
	color: white;
	font-weight: bold;
	text-align: center;
} */
#cal{
	width :1480px;
	margin: 0 auto;
	margin-top: 80px;
	font-size: 24px;
}
.btnPrev{
	margin-left: 580px;
}
.spanTag{
	text-align: center;
}
#h2{
	font-size: 60px;
	margin-bottom: 20px;
	color :rgba(0,0,0,0.8);
}
#h2 a{
	color :black;
	padding :20px;
	color :rgba(0,0,0,0.8);
}
#h2 a:hover{
	color :black;
	padding :20px;
	color:rgba(0,255,127,0.7);
}
.back{
		text-align:right;
		margin:30px;
		margin-right: 200px;
	}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>	
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
		<div id="cal">
			<h2 id="h2">
				<a class='btnPrev'>&lt;</a>
				<span class="spanTag"></span>
				<a class='btnNext'>&gt;</a>
			</h2>
		</div>
		 <p class="back"><a href="main">뒤로가기</a></p>
	</div>


	<script type="text/javascript">
	var today = new Date();
    var y = today.getFullYear();
    var m = today.getMonth();
    var todate = new Date().getDate();
	 $(function() {    
		 newCal();
		 
		  $(".btnPrev").click(function() {
	            if(m == 0){
	               y = y-1;
	               m = 11;
	            }else{
	               m = m-1;
	            }
	            changeCalendar();
	            $(".spanTag").html(y + "-" + m) ;
	            newCal();
	         });
	         
	         $(".btnNext").click(function() {
	           if(m == 11){
	              y = y+1;
	              m = 0;
	           }else{
	              m = m+1;
	           }
	           changeCalendar();
	           $(".spanTag").html(y + "-" + m) ;
	            newCal();
		  	});
		 
		 function newCal(){      
			    var theDate=new Date(y, m, 1); 
			    var theDay=theDate.getDay();
			
			
			    var last=[31,28,31,30,31,30,31,31,30,31,30,31];
			 
			    if(y%4 == 0 && y % 100 !=0 || y%400 == 0) lastDate=last[1]=29;
			
			    var lastDate=last[m]; //현재 월에 마지막이 몇일인지 구합니다.
			
			   
			    var row=Math.ceil((theDay+lastDate)/7); 
			    
			    var calendar="<table border='1' class='cal'>";
			    calendar+="<tr>";
			    calendar+="<th>Sun</th>";
			    calendar+="<th>Mon</th>";
			    calendar+="<th>Tue</th>";
			    calendar+="<th>Wed</th>";
			    calendar+="<th>Thd</th>";
			    calendar+="<th>Fri</th>";
			    calendar+="<th>Sat</th>";
			    calendar+="</tr>";
			
			    var dNum=1;
			   	
			    for(var i=1; i<=row; i++){//행 생성 (tr 태그 생성)
			    calendar+="<tr>";
			    for(var k=1; k<=7; k++){
			        if(i==1 && k<=theDay || dNum>lastDate){
			          calendar+="<td> &nbsp; </td>";
			         }else{
			       		var rdate = y+"-"+(m+1)+"-"+dNum
			       		if((m+1) < 10 && dNum > 10){
			       			rdate = y+"-"+"0"+(m+1)+"-"+dNum
			       		}else if((m+1) >10 && dNum <10){
			       			rdate = y +"-"+(m+1)+"-"+"0"+dNum
			       		}else if((m+1) < 10 && dNum < 10){
			       			rdate = y +"-"+"0"+(m+1)+"-"+"0"+dNum
			       		}
			          calendar+="<td><a href='schedule?rdate="+rdate+"'>"+dNum+"</a></td>";
			          console.log(rdate);
			           dNum++;
			         }
			   	 }
	//		    calendar+="<tr>";
			    }
			    $(".spanTag").html( y+"-"+(m+1));
			    $("#cal").append(calendar);
		}
		 function changeCalendar(){
			 $(".cal").remove();
		 }
		 
	 })
	       
	  	  
	 
	
</script>

</body>

</html>