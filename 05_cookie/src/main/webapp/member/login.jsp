<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	 <div class = "login-box">
	 	<h2>🔐 로그인</h2>
	 	<!-- LoginController에서 로그인 실패 시 errorMsg를 request에 담아 forward -->
	 	<!-- getAttribute()가 null이 아니면(=로그인 오류) 오류 메시지를 화면에 출력 -->
	 	<%
	 	if(request.getAttribute("errorMsg") != null){ 
	 	%>
	 	<div class="error-msg"><%=request.getAttribute("errorMsg") %></div>
	 	<%} %>
	 	
	 	<form action="login" method="post">
	 		<label for="memberName">이름</label>
	 		<input type="text" id="memberName" name="memberName"
	 		placeholder="이름을 입력하세요">
	 		
	 		<label for="memberPwd">비밀번호</label>
	 		<input type="password" id="memberPwd" name="memberPwd"
	 		placeholder="비밀번호를 입력하세요">
	 		
	 		<!-- 아이디 저장 체크박스
	 		name="saveId" : LoginController에서 읽으면
	 		체크하면 "on", 체크 안하면 null이 서버에 전달된다 -->
	 		<div class="save-id">
				<input type="checkbox" id="saveId" name="saveId">
				<label for='saveId'>아이디 저장</label>
			</div>	 		
	 		<button type="submit" class="btn-login">로그인</button>
	 	</form>
	 
	 </div>
	 <!-- js파일 연결
	 html요소가 모두 그려진 다음에 js가 실행되어야 요소를 가져올 수 있음 -->
	 <script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
</body>
</html>







