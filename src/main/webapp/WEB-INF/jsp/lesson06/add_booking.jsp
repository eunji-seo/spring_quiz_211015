<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 하기</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!-- datepicker-->
   <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	
</head>
<style>
nav{background:orange;}
.nav-link{color:white}
.booking_lookup{background:orange;}
h1>.logo{color:black; text-decoration: none}
</style>
<body>
	<div class="container">
	<header>
		<h1 class="text-center"><a class="logo" href="/lesson06/lookup_booking_view">통나무 팬션</a></h1>
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
		<h3 class="text-center">예약 하기</h3>
		<div class="wrap d-flex justify-content-center">
			<div>
				
				<div class="form-group">
					<label for="name">이름</label>
					<input type="text" id="name" name="name" class="form-control">
				</div>
				<div class="form-group">
					<label for="date">예약날짜</label>
					<input type="text" id="date" name="date" class="form-control">
				</div>
				<div class="form-group">
					<label for="day">숙박일수</label>
					<input type="text" id="day" name="day" class="form-control">
				</div>
				<div class="form-group">
					<label for="headcount">숙박인원</label>
					<input type="text" id="headcount" name="headcount" class="form-control">
				</div>
				<div class="form-group">
					<label for="phoneNumber">전화번호</label>
					<input type="text" id="phoneNumber" name="phoneNumber" class="form-control">
				</div>
				<button type="button" id="addBtn" class="btn btn-warning w-100">예약하기</button>
			</div>
		</div>
	</section>
	<footer>
		<small>제주특별자치도 제주시 애월읍</small><br>
		<small>사업자등록번호:111-22-255222/농어촌민박사업장지정/대표:김통목</small><br>
		<small>Copyright 2025 tongnamu All rigth reserved</small><br>
	</footer>
	</div>
<script>

$(document).ready(function(){
	
	
	// 날짜 
	 $('input[name=date]').datepicker({
		dateFormat : "yy-mm-dd" // 표시 포멧
		,minDate : 0 // 오늘부터 클릭가능
	}); 
	// 예약버튼
	$('#addBtn').on('click', function(e){
	
		//alert("클릭");
		let name = $('input[name=name]').val().trim();
		if(name.length < 1){
			alert("이름을 입력해주세요.");
			return;
		}
		let date = $('input[name=date]').val().trim();
		
		if(date == ""){
			alert("날짜를 입력해주세요.");
			return;
		}
		
		let day = $('input[name=day]').val().trim();
		if(day == ""){
			alert("숙박일수를 입력해주세요.");
			return;
		}
		
		if (isNaN(day)){ // 숫자가 아닌경우 
			alert("숙박일은 숫자만 입력 가능합니다.");
			return;
		}
		
		let headcount = $('input[name=headcount]').val().trim();
		if(headcount == ""){
			alert("인원을 입력해주세요.");
			return;
		}

		if (isNaN(headcount)){ // 숫자가 아닌경우 
			alert("숙박인원은 숫자만 입력 가능합니다.");
			return;
		}

		let phoneNumber = $('input[name=phoneNumber]').val().trim();
		if(phoneNumber == ""){
			alert("전화번호를 입력해주세요.");
			return;
		}
		
		
		$.ajax({
			type:"POST"
			,url:"/lesson06/add_booking"
			,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
			,success: function(data){
		
				if(data.code == "1"){
					alert("예약되었습니다.");
					location.href="/lesson06/booking_list_view";
				} else {
					alert("예약 처리에 실패하였습니다");
				}
				
			}
			,error: function(e){
				alert("에러"); // 진짜로 나면 안됨 
			}
			
		});
		
	});
	
	
});
</script>
</body>
</html>