<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, java.util.List" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿</title>
</head>



<body>
	<h2>스크립틀릿 예제</h2>
	<%-- 1. 변수 선언 및 기본 연산 --%>
	<% 
		String name = "홍길동";
		int age = 25;
		int nextYear = age + 1;
			
	%>
	
	<p>이름 : <%= name %>, 나이 : <%= age %>, 내년 나이 : <%= nextYear %> </p>
	<%-- 2. 제어문(조건문)  --%>
	<%
		int score = 75;
	%>
	
	<p>점수 : <%= score %>점 -
		<% if(score >= 90) {%>
			<strong>A학점</strong>		
		<%} else if(score >= 80){%>
			<strong>B학점</strong>
		<%} else if(score >= 70){%>
			<strong>C학점</strong>
		<%} else if(score >= 60){%>
			<strong>D학점</strong>
		<%} else {%>
			<strong>F학점</strong>
		<%} %>
	</p>
	<hr>
	<%--3. 제어문(반복문) - 스클립틀릿의 {} 사이에 HTML을 끼워 넣는 패턴 --%>
	<%
		List<String> members = new ArrayList<>();
		members.add("짱구");
		members.add("철수");
		members.add("유리");
		
	%>	
	<p>회원수 : <%= members.size() %></p>
	
	<ul>
		<% for(String member : members){%>
			<li><%= member %></li>	
		<%} %>
	</ul>
	
</body>
</html>