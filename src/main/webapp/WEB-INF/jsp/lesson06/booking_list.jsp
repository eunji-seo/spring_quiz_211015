<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록 보기</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
nav{background:orange;}
.nav-link{color:white}
.booking_lookup{background:orange;}
.logo{color:black
</style>
<body>
	<div class="container">
	<header>
		<h1 class="text-center"><a class="logo" href="http://localhost/lesson06/lookup_booking">통나무 팬션</a></h1>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link">팬션소개</a></li> 
				<li class="nav-item"><a href="#" class="nav-link">객실보기</a></li> 
				<li class="nav-item"><a href="http://localhost/lesson06/add_booking_view" class="nav-link">예약하기</a></li> 
				<li class="nav-item"><a href="http://localhost/lesson06/booking_list_view" class="nav-link">예약목록</a></li> 
			</ul>
		</nav>
	</header>
	<section>
		<h3 class="text-center">예약 목록 보기</h3>
		<table class="table text-center">
			<thead>
				<tr>
					<th>이름</th>
					<th>예약날짜</th>
					<th>숙박일수</th>
					<th>숙박인원</th>
					<th>전화번호</th>
					<th>예약상태</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${booking}">
				<tr>
					<td>${item.name}</td>
					<td>
						<fmt:formatDate value="${item.date}" pattern="yyyy년 M월 d일"/>
					</td>
					<td>${item.day}</td>
					<td>${item.headcount}</td>
					<td>${item.phoneNumber}</td>
					<td>
						<c:choose>
							<c:when test="${item.state eq '확정'}">
								<spen class="text-success">${item.state}</spen>
							</c:when>
							<c:when test="${item.state eq '대기중'}">
								<spen class="text-primary">${item.state}</spen>
							</c:when>
							<c:otherwise>
								<spen class="text-danger">${item.state}</spen>
							</c:otherwise>
						</c:choose>
						
					</td>
					<td>
						<button type="button" class="del-btn btn btn-danger" data-booking-id="${item.id}">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<footer>
		<small>제주특별자치도 제주시 애월읍</small><br>
		<small>사업자등록번호:111-22-255222/농어촌민박사업장지정/대표:김통목</small><br>
		<small>Copyright 2025 tongnamu All rigth reserved</small><br>
	</footer>
	</div>
<script>
$(document).ready(function(){
		$('.del-btn').on('click',function(){
			let id = $(this).data('booking-id');
			
			$.ajax({
				type:"POST"
				,url:"/lesson06/delete_booking"
				,data:{"id":id}
				,success: function(data){
					if(data.result == 'success'){
						location.reload();
					} else{
						alert("관리자에게 문의해주세요");
					}
					
				}
				,error: function(e){
					alert("에러");
				}
			});
		});
});
</script>	
</body>
</html>