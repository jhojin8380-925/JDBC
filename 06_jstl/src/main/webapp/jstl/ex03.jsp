<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- fmt 태그를 사용하기 위한 taglib --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
//실제에서는 서블릿이 한다
request.setAttribute("today", new java.util.Date());
request.setAttribute("price", 1250000);
request.setAttribute("rating", 4.756);
request.setAttribute("month", 6);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt tag</title>
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
}

th, td {
   border: 1px solid #ccc;
   padding: 8px 20px;
}

th {
   background: #2b6cb0;
   color: white;
}
</style>
</head>
<body>
	<h2>ex03 - jstl fmt 태그</h2>
	
	<%-- 1. fmt:formatDate -날짜 형식 지정 --%>
	<div class="section">
		<h3>1. fmt:formatDate - 날짜 형식</h3>
		
		<%--
			fmt:formatDate 
			- value : 출력할 날짜(java.util.Date 또는 java.sql.Date)
			- pattern : 출력 형식
					yyyy = 연도(4자리)		MM = 월(2자리)	dd = 일(2자리)
					HH = 시(24시간)	mm = 분		ss = 초
		 --%>
		 <%-- <p>${today}</p> --%>
		 <table>
		 	<tr>
		 		<th>패턴</th>
		 		<th>출력결과</th>
		 	</tr>
		 	
		 	<tr>
		 		<td>yyyy-MM-dd</td>
		 		<td>
		 			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>
		 		</td>
		 	</tr>
		 	
		 	<tr>
		 		<td>yyyy년 MM월 dd일</td>
		 		<td>
		 			<fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일"/>
		 		</td>
		 	</tr>
		 	
		 	<tr>
		 		<td>yyyy-MM-dd HH:mm:ss</td>
		 		<td>
		 			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss"/>
		 		</td>
		 	</tr>
		 	
		 	<tr>
		 		<td>yyyy/MM/dd (HH시 mm분)</td>
		 		<td>
		 			<fmt:formatDate value="${today}" pattern="yyyy/MM/dd (HH시 mm분)	"/>
		 		</td>
		 	</tr>		 	
		 	
		 </table>
	</div>
	
	<%-- 2. fmt:formatNumber --%>
	<div class="section">
		<h3>2. fmt:formatNumber - 숫자 형식</h3>
		
		<%-- 
			fmt:formatNumber
			- value : 출력할 숫자
			- pattern : 출력 형식
					# = 유효 숫자만 표시
					0 = 자리수 유지(빈 자리는 0으로 채움)
					, = 천 단위 구분 기호
					. = 소수점 단위 구분
		 --%>
		 <table>
		 	<tr>
		 		<th>용도</th>
		 		<th>패턴</th>
		 		<th>출력결과</th>
		 	</tr>
		 	
		 	<tr>
		 		<td>가격 (천 단위 콤마)</td>
		 		<td>#,###</td>
		 		<td>
		 			<fmt:formatNumber value="${price}" pattern="#,###">
		 			</fmt:formatNumber>원	
		 		</td>
		 	</tr>
		 	
		 	<tr>
		 		<td>평점 (소수점 둘째 자리)</td>
		 		<td>#.##</td>
		 		<td>
		 			<fmt:formatNumber value="${rating}" pattern="#.##">
		 			</fmt:formatNumber>점	
		 		</td>
		 	</tr>
		 	
			<tr>
		 		<td>월 (두 자리 유지)</td>
		 		<td>00</td>
		 		<td>
		 			<fmt:formatNumber value="${moth}" pattern="00">
		 			</fmt:formatNumber>월	
		 		</td>
		 	</tr>
		 </table>
		 
		
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>