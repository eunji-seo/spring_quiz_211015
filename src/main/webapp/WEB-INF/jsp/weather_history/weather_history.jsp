<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨정보</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
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
			 	<table class="table">
			 		<thead>
			 			<tr>
			 				<th>날짜</th>
			 				<th>날씨</th>
			 				<th>기온</th>
			 				<th>강수량</th>
			 				<th>미세먼지</th>
			 				<th>풍속</th>
			 			</tr>
			 		</thead>
			 		<tbody>
			 		<c:forEach var="item" items="${Weatherhistorylist}">
			 			<tr>
			 				<td>
			 					<fmt:formatDate value="${item.date}" pattern="yyyy년 M월 d일"/>
			 				</td>
			 				<td>
			 					<c:choose>
			 						<c:when test="${item.weather == '맑음'}">
			 							<img src="/images/sunny.jpg" alt="날씨">
			 						</c:when>
			 						<c:when test="${item.weather == '구름조금'}">
			 							<img src="/images/partlyCloudy.jpg" alt="날씨">
			 						</c:when>
			 						<c:when test="${item.weather == '흐림'}">
			 							<img src="/images/cloudy.jpg" alt="날씨">
			 						</c:when>
			 						<c:when test="${item.weather == '비'}">
			 							<img src="/images/rainy.jpg" alt="날씨">
			 						</c:when>
			 					</c:choose>
			 				</td>
			 				<td>${item.temperatures}C</td>
			 				<td>${item.precipitation}mm</td>
			 				<td>${item.microDust}</td>
			 				<td>${item.windSpeed}km/h</td>
			 			</tr>
			 		</c:forEach>
			 		</tbody>
			 	</table>
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
</body>
</html>