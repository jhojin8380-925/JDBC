<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
body {
   font-family: 'Malgun Gothic', sans-serif;
   background: #f7f8fa;
   display: flex;
   justify-content: center;
   align-items: center;
   min-height: 100vh;
   margin: 0;
}

.login-box {
   background: white;
   border-radius: 16px;
   padding: 40px 36px;
   box-shadow: 0 4px 20px rgba(0, 0, 0, 0.9);
   width: 340px;
}

h2 {
   text-align: center;
   margin-bottom: 28px;
   color: #1a365d;
}

label {
   display: block;
   font-size: 0.88rem;
   color: #4a5568;
   margin-bottom: 4px;
}

input[type=text], input[type=password] {
   width: 100%;
   padding: 10px 14px;
   border: 1px solid #e2e8f0;
   border-radius: 8px;
   font-size: 0.95rem;
   box-sizing: border-box;
   margin-bottom: 16px;
}

input[type=text]:focus, input[type=password]:focus {
   outline: none;
   border-color: #3182ce;
}

.btn-login {
   width: 100%;
   padding: 12px;
   background: #3182ce;
   color: white;
   border: none;
   border-radius: 8px;
   font-size: 1rem;
   cursor: pointer;
   font-family: 'Malgun Gothic', sans-serif;
}

.btn-login:hover {
   background: #2b6cb0;
}

.error-msg {
   background: #fff5f5;
   border: 1px solid #fed7d7;
   color: #c53030;
   border-radius: 8px;
   padding: 10px 14px;
   font-size: 0.85rem;
   margin-bottom: 16px;
   text-align: center;
}
</style>
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
          
          <button type="submit" class="btn-login">로그인</button>
       </form>
    
    </div>
</body>
</html>







