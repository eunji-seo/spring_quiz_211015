<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
nav{background:orange;}
a{color:white}
aside{background:brown;}
.benner{wdith:100%}
.booking_lookup{background:orange;}
</style>
<body>
	<div class="container">
	<header>
		<h1 class="text-center">통나무 팬션</h1>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link">팬션소개</a></li> 
				<li class="nav-item"><a href="#" class="nav-link">객실보기</a></li> 
				<li class="nav-item"><a href="#" class="nav-link">예약하기</a></li> 
				<li class="nav-item"><a href="#" class="nav-link">예약목록</a></li> 
			</ul>
		</nav>
	</header>
	<section class="w-100 h-100">
		<div class="benner">
			<img src="/images/test06_banner1.jpg" alt="img">
		</div>
		<aside class="d-flex">
			<h1 class="col-4 d-flex align-items-center text-white">실시간예약하기</h1>
			<div class="booking_lookup col-4 p-3 text-white">
				<p>예약 확인</p>
				이름 <input type="text" id="name" name="name" class="form-control">
				전화번호 <input type="text" id="phoneNumber" name="phoneNumber" class="form-control"><br>
				<button type="button" class="btn btn-success">조회 하기</button>
			</div>
			<h2 class="col-4 d-flex align-items-center text-white">예약문의:010-0000-1111</h2>
		</aside>
	</section>
	<footer>
		<small>제주특별자치도 제주시 애월읍</small><br>
		<small>사업자등록번호:111-22-255222/농어촌민박사업장지정/대표:김통목</small><br>
		<small>Copyright 2025 tongnamu All rigth reserved</small><br>
	</footer>
	</div>
</body>
</html>