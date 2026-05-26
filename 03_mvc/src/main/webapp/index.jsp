<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 패턴</title>
<style>
	body{
		font-family : Arial, sans-serif;
		margin : 40pxx;	
	}
	
	h1{
		color:#2d3748;
	}
	a{
		color:#3182ce;
		font-size:18px;		
	}
	
</style>
</head>
<body>
	<h1>MVC패턴 - 회원 관리</h1>
	<p>
	<%-- href="memberList" : /memberList로 매핑된 서블릿을 호출 --%>
		<a href="memberList">회원목록으로 이동</a>
	</p>
</body>
</html>