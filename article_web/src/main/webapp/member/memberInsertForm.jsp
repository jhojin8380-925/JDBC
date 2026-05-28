<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<style>
body {
   font-family: 'Malgun Gothic', sans-serif;
   padding: 40px;
   background: #f7f8fa;
}

.form-box {
   background: white;
   border-radius: 16px;
   padding: 36px;
   box-shadow: 0 2px 12px rgba(0, 0, 0, 0.08);
   max-width: 400px;
}

h2 {
   margin-bottom: 24px;
   color: #1a365d;
}

label {
   display: block;
   font-size: 0.88rem;
   color: #4a5568;
   margin-bottom: 4px;
}

input[type=text], input[type=number], input[type=password] {
   width: 100%;
   padding: 10px 14px;
   border: 1px solid #e2e8f0;
   border-radius: 8px;
   font-size: 0.95rem;
   box-sizing: border-box;
   margin-bottom: 16px;
}

.btn-submit {
   background: #38a169;
   color: white;
   border: none;
   padding: 11px 24px;
   border-radius: 8px;
   font-size: 0.95rem;
   cursor: pointer;
   font-family: 'Malgun Gothic', sans-serif;
   margin-right: 8px;
}

.btn-cancel {
   background: #718096;
   color: white;
   border: none;
   padding: 11px 20px;
   border-radius: 8px;
   font-size: 0.95rem;
   cursor: pointer;
   font-family: 'Malgun Gothic', sans-serif;
}
</style>
</head>
<body>
   <div class = "form-box">
      <h2>회원 등록</h2>
      <form action="memberInsert" method='post'>
         <label>이름</label>
         <input type="text" name ="memberName" placeholder="이름을 입력하세요">
         
         <label>나이</label>
         <input type="number" name="memberAge" placeholder="나이를 입력하세요">
         
         <label>비밀번호</label>
         <input type="password" name="memberPwd" placeholder="비밀번호를 입력하세요">
         
         <button type="submit" class="btn-submit">등록</button>
         <button type="button" class="btn-cancel"
         onclick="location.href='${pageContext.request.contextPath}/memberList'">취소</button>
      
      </form>
   </div>
</body>
</html>


















