<%-- 페이지 디렉티브 : 이 JSP 파일의 전반적인 설정을 선언 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- import 설정 : 자바 import문과 동일한 역할. 쓸 클래스를 미리 가져온다 -->    
<!-- - 방법1 : 클래스마다 한 줄 씩 작성 -->
<%-- <%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %> --%>
<!-- - 방법2 : 한줄에 ,(콤마)로 구분 -->
<%@ page import="java.util.ArrayList, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브</title>
</head>
<body>
	<h2>디렉티브 예제</h2>
	<p>page 디렉티브로 설정한 내용은 화면에 보이지 않는다</p>
	<p>하지만 위에서 import 한 List, ArrayList 는 아래 스크립트 에서 자유롭게 쓸 수 있다</p>
	<% 
		/* 자바 코드 작성 */
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("배");
		fruits.add("참외");
		fruits.add("수박");
	%>
	<p>과일목록 : <%= fruits %></p>
	<p>과일개수 : <%= fruits.size() %>개</p>
</body>
</html>









