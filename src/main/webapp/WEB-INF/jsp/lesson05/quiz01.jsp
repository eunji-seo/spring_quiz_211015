<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. JSTL core 변수</h2>
		<c:set var="number1" value="36"/>	
		<c:set var="number2" value="3"/>
		첫번째 숫자: ${number1}<br>
		두번째 숫자: ${number2}<br>
		
	<h2>2. JSTL core 연산</h2>
		더하기:${number1 + number2}<br>
		빼기:${number1 - number2}<br>
		곱하기:${number1 * number2}<br>
		나누기:${number1 / number2}<br>
		
	<h2>3. JSTL core out</h2>
	<c:out value="<title>core out</title>"/><br>
	
	<h2>4. JSTL core if</h2>
	<c:set var="avg" value="${(number1 + number2)/2}"/>
	<c:if test="${avg >= 10}">
		<h1>${avg}</h1><br>
	</c:if>		
	
	<c:if test="${avg < 10}">
		<h3>${avg}</h3><br>
	</c:if>	
	
	<h2>5. core if</h2>
	<c:set var="mul" value="${(number1 * number2)}"/>
	<c:if test="${mul > 100}" >
	 	<c:out value="<script>alert('너무 큰수입니다');</script>" escapeXml="false"/>
	</c:if>
</body>
</html>