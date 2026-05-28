<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 변수 선언 --%>
<c:set var="score" value="85" />
<c:set var="name" value="홍길동" />
<c:set var="isAdmin" value="false" />
<%--
	c:set의 value에 ,(콤마)로 구분된 문자열을 넣으면
	c:forEach에서 자동으로 항목 하나씩 분리해서 반복
 --%>
<c:set var="fruits" value="사과,바나나,딸기,포도,키위" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02 - jstl core 태그</title>
<style>
body {
   font-family: 'Malgun Gothic', sans-serif;
   margin: 30px;
}

.section {
   margin-bottom: 30px;
   padding: 16px;
   background: #f8f9fa;
   border-radius: 8px;
}

h3 {
   margin-top: 0;
   color: #2b6cb0;
}

table {
   border-collapse: collapse;
   width: auto;
}

th, td {
   border: 1px solid #ccc;
   padding: 8px 16px;
   text-align: center;
}

th {
   background: #2b6cb0;
   color: white;
}

.highlight {
   color: #e53e3e;
   font-weight: bold;
}
</style>




</head>
<body>
	<h2>ex02 - jstl core 태그</h2>

	<!-- 1. c:if -->
	<div class="section">
		<h3>1. c:if - 단순 조건문</h3>
		<!-- c:if test="${조건식}" => 조건식이 true 라면 내부 내용을 출력 
			else나 else if 가 필요하다면 c:choose를 사용
		-->
		<c:if test="${score >= 80}">
			<p>${name}님 - <span class="highlight">합격! (${score}점)</span></p>
		</c:if>
		
		<c:if test="${score < 80}">
			<p>${name}님 - 불합격! (${score}점)</p>
		</c:if>
			
		<!-- empty 연산자와 함께 자주 사용하는 패턴 -->
		<c:if test="${not empty name}">
			<!-- name 이 비어있지 않으면 화면 출력 -->
			<p>이름이 입력되었습니다! : ${name}</p>
		</c:if>	
		
	</div>
	
	<!-- 2. c:choose : if ~ else if ~ else -->
	<div class="section">
		<h3>2. c:choose - if ~ else if ~ else문</h3>
		<!-- 
			c:choose : 전체 조건문 블록의 시작과 끝 
			c:when : if / else if 조건 (여러개 작성 가능) 
			c:otherwise : else 
		 -->
		 <p>
		 	${score}점 ->
		 	<c:choose>
		 		<c:when test="${score >= 90 }">
		 			<span class="highlight">A학점 - 최우수</span>
		 		</c:when>
		 		<c:when test="${score >= 80 }">
		 			<span style="color:green">B학점 - 우수</span>
		 		</c:when>
		 		<c:when test="${score >= 70 }">
		 			<span style="color:orange">C학점 - 보통</span>
		 		</c:when>
		 		<c:otherwise>
		 			<span style="color:red">F학점 - 재수강 필요</span>
		 		</c:otherwise>
		 	</c:choose>
		 </p>
		 
	</div>
	<%-- 3. c:forEach => for문  --%>
	<div class="section">
		<h3>3. c:forEach - 숫자범위 반복</h3>
		<%--
			java의 반복문
			for(초기식; 조건식; 증감식){반복할 문장}
			
			- jstl의 forEach 
			begin : 시작 숫자, end : 마지막 숫자(포함), step : 증감(기본값 1) 
		 --%>
		 <p>1부어 5까지 : </p>
		 <c:forEach begin="1" end="5" var="i">
		 	<span style="margin-right:8px">${i}</span>
		 </c:forEach>
		 
		 <p style="margin-top:12px">2씩 증가(2~10) : </p>
		 <c:forEach begin="2" end="10" step="2" var="i">	
		 	<span style="margin-right:8px">${i}</span>
		 </c:forEach>
		 
	</div>
	<div class="section">
		<h3>4. c:forEach - 리스트 반복</h3>
		<table>
			<tr>
				<th>과일</th>
			</tr	>
			<c:forEach var="fruit" items="${fruits}">
				<tr>
					<td>${fruit}</td>
				</tr>
			 </c:forEach>
		</table>
	</div>
	
	<%-- 5. forEach : varStatus(순번정보) --%>
	<div class="section">
		<h3>5. c:forEach - varStatus</h3>
		<%-- varStatus : 반복 중 현재 상태
		 	.count : 현재 순번
		 	.index : 현재 인덱스
		 	.first : 첫번째
		 	.last : 마지막 항목이면 true
		 --%>
		 <table>
		 	<tr>
		 		<th>순번(count)</th>
		 		<th>인덱스(index)</th>
		 		<th>과일</th>
		 		<th>처음/마지막</th>
		 	</tr>
		 	<c:forEach var="fruit" items="${fruits}" varStatus="status">
		 		<tr>
		 			<td>${status.count}</td>
		 			<td>${status.index}</td>
		 			<td>${fruit}</td>
		 			<td>
						<c:if test="${status.first}">✨ 처음</c:if>		 			
						<c:if test="${status.last}">✨ 마지막</c:if>		 			
		 			</td>		 			
		 		</tr>
		 	</c:forEach>
		 	
		 	
		 </table>
		 
	</div>
	
	
	

</body>
</html>