<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL core taglib 선언 - c:set 사용하기 위해 필요 -->
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- c:set El에서 사용할 변수를 선언하고 값을 저장하는 태그
	서블릿(controller)이 request.setAttribute()로 이 역할을 한다
 --%>    
<c:set var="name" value="홍길동"/>
<c:set var="age" value="25"/>
<c:set var="score" value="85"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01 - 기본 출력</title>
<style>
body {
   font-family: 'Malgun Gothic', sans-serif;
   margin: 30px;
}

table {
   border-collapse: collapse;
   margin-top: 10px;
}

th, td {
   border: 1px solid #ccc;
   padding: 8px 20px;
}

th {
   background: #4a90d9;
   color: white;
}

.section {
   margin-bottom: 24px;
}
</style>
</head>
<body>
	<h2>ex01 - EL 기본 출력</h2>
	<%-- 1. 기본 변수 출력 --%>
	<div class="section">
		<h3>1. 기본 변수 출력</h3>
		<table>
			<tr>
				<th>표현식</th>
				<th>출력결과</th>
			</tr>
			<%-- %{} : c:set 또는 setAttribute로 저장한 값을 출력 --%>
			<tr>
				<td>${'${name}'}</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>${'${age}'}</td>
				<td>${age}</td>
			</tr>
			<tr>
				<td>${'${score}'}</td>
				<td>${score}</td>
			</tr>
		</table>
	</div>
	
	<!-- 산술 연산 -->
	<div class="section">
		<h3>2. 산술 연산자</h3>
		<table>
			<tr>
				<th>표현식</th>
				<th>출력결과</th>
			</tr>
			<!-- EL안에서 사칙연산을 바로 처리할 수 있다 -->
			<tr>
				<td>${'${age + 1}'}</td>
				<td>${age + 1}</td>
			</tr>	
			<tr>
				<td>${'${score * 2}'}</td>
				<td>${score * 2}</td>
			</tr>	
			<tr>	
				<td>${'${score % 10}'}</td>
				<td>${score mod 10}</td>
			<!-- %: 나머지 연산자는 mod 권장사항 -->
			</tr>
			
		</table>
	</div>
	<div class="section">
		<h3>3. 3관계 연산자</h3>
		<table>
			<tr>
				<th>표현식</th>
				<th>출력결과</th>
			</tr>
			<tr>
				<td>${'${age >= 20}'}</td>
				<td>${age >= 20}</td>
			</tr>	
			<tr>
				<td>${'${age ge 20}'}</td>
				<td>${age ge 20}</td>
			</tr>
			<tr>
				<%-- <td>${'${age ge 20? "성인" : "미성년자"}'}</td> --%>		
				<td>${age ge 20? "성인" : "미성년자"}</td>		
			</tr>
		</table>
	</div>
	
	<!-- empty 연산자 -->
	<div class="section">
			<h3>4. empty연산자</h3>
			<div>
			 	<%-- empty : null 이거나 빈 문자열("")이거나 빈 리스트이면 true
			 	nnot empty : empty와 반대
			 	주로 c:if 함께 사용 --%>
			 	<p>name이 비어있나? -> ${empty name}</p>
			 	<p>intro이 비어있나? -> ${empty intro}</p>
			</div>
	</div>
	
</body>
</html>