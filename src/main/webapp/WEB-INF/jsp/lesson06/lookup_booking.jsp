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
aside{background:brown;}
.benner{wdith:100%}
.nav-link{color:white}
.booking_lookup{background:orange;}
h1>.logo{color:black; text-decoration: none}
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
	<section class="w-100 h-100">
		<div class="banner">
			<img id="bannerImg" src="/images/banner1.jpg" alt="img"
			wdith="1110px" height="500px">
		</div>
		<aside class="d-flex">
			<h1 class="col-4 d-flex align-items-center text-white">실시간예약하기</h1>
			<div class="booking_lookup col-4 p-3 text-white">
				<p>예약 확인</p>
				<span>이름</span> 
				<input type="text" id="name" name="name" class="form-control">
				<span>전화번호</span> 
				<input type="text" id="phoneNumber" name="phoneNumber" class="form-control"><br>
				<button type="button" id="lookupBtn"class="btn btn-success">조회 하기</button>
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
<script>
$(document).ready(function(){
	
	// 예약조회
    $('#lookupBtn').on('click',function(){
    	//alert("조회하기");
    	let name = $('#name').val().trim();
    	let phoneNumber = $('#phoneNumber').val().trim();
    	
    	// validation check
    	if(name.length < 1){
    		alert("이름을 입력해주세요.")
    		return;
    	}
    	
    	if(phoneNumber.length < 1){
    		alert("전화번호를 입력해주세요.")
    		return;
    	}
    	
    	if(phoneNumber.startsWith("010") == false){ // 정규식으로 비밀번호 특수문자 유효성 체크 했다 
    		alert("010으로 시작하는 번호만 입력할수 있습니다.")
    	}

    	$.ajax({
    		type:"POST"
    		,url:"/lesson06/look_up_booking"
    		,data:{"name": name, "phoneNumber":phoneNumber}
    		,success: function(data){
    			// {"result" : "success",
				//	"code" : "1",
				//  "booking" : {"name": 신보람, "phoneNumber": 010-1234-5678 }}
    			if (data.code == 1){
    				// 성공
    				let booking = data.booking;
    				//2022-02-05 0, 10
    				let message = "이름:" + booking.name  + "\n날짜:" + booking.date.slice(0, 10)
    				+ "\n일수:" + booking.day + "\n인원:" + booking.headcount +"\n상태:" + booking.state; 
    				alert(message);
    			} else {
    				alert("예약 내역이 없습니다.")
    			}
    			
    		}
    		,error: function(e){
    			alert("서버 통신 실패");
    		}
    	});
    	
    });
    var bannerSrcArr = ['/images/banner1.jpg', '/images/banner2.jpg', '/images/banner3.jpg', '/images/banner4.jpg'];
    var currentIndex = 0;
    setInterval(function() {
        $('#bannerImg').attr('src', bannerSrcArr[currentIndex]);
        currentIndex++;

        if (currentIndex > bannerSrcArr.length) { // 인덱스 값이 배열의 크기를 넘으면 0으로(처음 이미지) 세팅
            currentIndex = 0;
        }
    }, 3000); // 3초에 한번씩 함수 실행
	
});
</script>	
</body>
</html>