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
<body>
	<div class="container">
		<h1>즐거 찾기 추가하기</h1>
		<form method="post" action="view_favorite">
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" name="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<input type="text" id="url" name="url" class="form-control">
		</div>
		<input type="button" id="addBtn" class="btn btn-success btn-block" value="추가">
		</form>
	</div>
</body>
<script>
$(document).ready(function(){
	$('#addBtn').on('click',function(){
		let name= $('#name').val().trim();
		if(name.length < 1){
			alert("사이트명을 입력하세요");
			return;
		}
		let url = $('#url').val().trim();
		if(url == ""){
			alert("주소를 입력해주세요");
			return;
		}
		// http도 아니고, https도 아닐때 => alert을 띄워야 함
		
		if(url.startsWith("http") === false && url.startsWith("https") === false ){
			alert("주소 형식이 잘못되었습니다.");
			return;
		}
		
		// 서버로 호출
		$.ajax({ // request 
			type:"POST"
			,url:"/lesson06/add_favorite"
			,data:{"name": name, "url": url}  //  ajax jquery의 json 를 객체로 자동 변환 해줌 그래서 error{objact, objact} 
			,success: function(data){ // String return이 반드시 되어야함
				alert(data.result);
				location.href="http://localhost/lesson06/view_favorite";
			}
			,error: function(e){
				alert("error:");
			}
		});
		
	});	
});
</script>
</html>