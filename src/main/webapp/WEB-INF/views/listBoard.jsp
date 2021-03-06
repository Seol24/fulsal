<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FutSal</title>
<%@ include file="include/path.jsp"%>
<style type="text/css">
	#wrapper{
		width: 1080px;
		margin: 0 auto;
	}
	table {
	
		border-collapse: collapse;
		margin-bottom: 20px;
	}
	table tr td{
		text-align: center;
		padding: 20px;
		border-top: 1px solid black;
		font-size: 18px;
	}
	table tr td a{
		color: black;
		text-decoration: none;
		font-size: 18px;
	}
	table tr td a:hover{
		color: black;
		text-decoration: none;
	}

	table tr th{
		text-align :center;
		width: 300px;
		padding: 20px;
		border-top: 1px solid black;
		font-size: 20px;
	}
	#insert{
		margin-top:30px;
		text-align: right;
	}
	
	#main{
		text-align: right;
	}
	a{
		color:white;
		text-decoration: none;
	}
	#insert a{
		color: blue;
	}
	#pageing{
		margin-left: 300px;
	}
	.pagination li{
		padding: 10px;
		margin: 1px;
	}
	.pagination a{
		color: black;
		font-size: 17px;
	}
	.pagination a:hover{
		color: blue;
		text-decoration: none;
	}

</style>
</head>
<body>
	<%@ include file="include/header.jsp"%>
	<div id="wrapper">
	
		<div>
			<p id="insert"><a href="insertBoard">새 게시물 추가하기</a></p>
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성 시간</th>
				</tr>
				<c:forEach var="board" items="${list }"> 
					<tr>
						<td>${board.bno }</td>
						<td class="titleTD"><a href="readBoard?bno=${board.bno }&fromlist=true&page=${pageMaker.cri.page}">${board.btitle }</a></td>
						<td>${board.mid }</td>
						<td><fmt:formatDate value="${board.bdate }" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="pageing">
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li><a href ="listBoard?page=${pageMaker.startPage-1 }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var ="idx" >
					<li ${pageMaker.cri.page == idx? 'class=active' : '' }>
						<a href="listBoard?page=${idx }" class="pageNum">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next }">
					<li><a href="listBoard?page=${pageMaker.endPage+1 }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
		<p  id="main">
			<a href="main">메인으로가기</a>
		</p>	
   </div>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script type="text/javascript">
   	
   </script>
</body>
</html>












