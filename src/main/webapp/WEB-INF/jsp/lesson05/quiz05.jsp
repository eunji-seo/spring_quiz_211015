<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜 입력</title>
 <!-- jquery : bootstrap, datepicker -->
   <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>  

   <!-- bootstrap -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

   <!-- datepicker-->
   <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>

h1{width: 150px }
li{list-style: none;
  text-aling: right;}
a{color: white;}
</style>
</head>
<body>
	<div class="">
		<div class="d-flex">
			<header class="bg-primary">
				<h1>기상청</h1>
				<ul">
					<li><a href="#">날씨</a></li>
					<li><a href="#">날씨입력</a></li>
					<li><a href="#">테마날씨</a></li>
					<li><a href="#">관측기후</a></li>
				</ul>
			</header>
			<section>
				<h1>날씨 입력</h1>
				<form method="post" action="/lesson05/quiz05/info">
					<div class="d-flex">
						<div class="form-group d-flex">
							<label for="date">날짜</label>
							<input type="text" id="date" name="date" class="form-control col-3">
						</div>
						<div class="form-group d-flex">
							<label for="weather">날씨</label>
							<select class="col=3">
								<option></option>
								<option></option>
								<option></option>
								<option></option>
							</select>
						</div>
						<div class="form-group d-flex">
							<label for="microDust">미세먼지</label>
							<select class="col-3">
								<option></option>
								<option></option>
								<option></option>
								<option></option>
							</select>
						</div>
					</div>
					<div class="d-flex">
						<div class="form-group d-flex">
							<label for="temperatures">기온</label>
							<input type="text" id="temperatures" name="temperatures" class="form-control col-4">
						</div>
						<div class="form-group d-flex">
							<label for="precipitation">강수량</label>
							<input type="text" id="precipitation" name="precipitation" class="form-control col-4">
						</div>
						<div class="form-group d-flex">
							<label for="windSpeed">풍속</label>
							<input type="text" id="windSpeed" name="windSpeed" class="form-control col-4">
						</div>
					</div>
					<div class="d-flex justify-context-end">	
						<input type="submit" value="저장" class="btn btn-success col-2"/>
					</div>
				</form>
			</section>
		</div>
		<footer class="d-flex">
			<h1>기상청</h1>
			<div>
				<small>(07620) 서울시 동작구 여의대방로 16길 61</small><br>
				<small>Copyright©2021 KMA. All Rights RESERVED</small>
			</div>
		</footer>
	</div>
	<script>
	$(document).ready(function() {
       
        $.datepicker.setDefaults({
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'] // 요일을 한글로 변경
            , dateFormat: 'yy-mm-dd'
        });

        $.datepicker._gotoToday = function(id) {
            $(id).datepicker('setDate', new Date()).datepicker('hide').blur();
        };
		})
	</script>
</body>
</html>