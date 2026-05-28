<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%
request.setAttribute("notice", "오늘 점심은 비빔밥입니다.");
session.setAttribute("loginUser", "홍길동");
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el 스코프</title>
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
	<h2>ex04 - el 스코프</h2>
	
	<%-- request 스코프 --%>
	<div>
		<h3>1. request 스코프</h3>
		<p>
			<%-- request에 저장한 값을 꺼낸다 --%>
			스코프 자동 탐색 : ${notice}<br>
			<%-- requestScope를 명시해도 동일한 결과 --%>
			requestScope 명시 : ${requestScope.notice}
		</p>
	</div>
	
	<%-- session 스코프 --%>
	<div class="section">
		<h3>2. session 스코프</h3>
		<p>
			로그인 사용자 : ${loginUser}<br>
			sessionScope 명시 : ${sessionScope.loginUser}
		</p>
		
		
	</div>
	
	<%-- 스코프 자동 탐색 순서 확인  --%>
	<div class="section">
		<h3>3. 스코프 탐색 순서</h3>
		<%
			request.setAttribute("location", "request 스코프");
			session.setAttribute("location", "session 스코프");
			
		%>
		<%-- 
			${location} : page -> request -> session -> application 순으로 탐색
			request에서 먼저 발견하므로 request 스코프 값이 나옴
		 --%>
		<p>${location}에서 꺼냈습니다.</p>
		<p>session 스코프를 명시 -> ${seesionScope.location}</p>
	</div>
	
	<%-- 4. URL 파라미터 --%>
	<div class="section">
		<h3>4. URL 파라미터</h3>
			
		<p>
			검색어(keyword) : ${param.keyword}	
			페이지(page) : ${param.page}
			
		</p>
		
	</div>
	
	
	<%-- pageContext --%>
	<div>
		<h3>5. pageContext</h3>
		<p>
			<%--
				request.getContextPath()와 동일
				JSP에서 링크나 폼 action 작성할때 컨텍스트 경로를 붙이는데 사용
			 --%>
		
			컨텍스트 경로 :${pageContext.request.contextPath}
		</p>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>