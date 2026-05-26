<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<style>
body {
   font-family: Arial, sans-serif;
   margin: 30px;
}

label {
   display: inline-block;
   width: 80px;
}

input[type="text"], input[type="number"] {
   padding: 6px;
   margin: 6px 0;
   border: 1px solid #ccc;
   border-radius: 4px;
}

.btn {
   padding: 8px 20px;
   margin-top: 10px;
   cursor: pointer;
}

.btn-submit {
   background-color: #007bff;
   color: white;
   border: none;
   border-radius: 4px;
}

.btn-cancel {
   background-color: #6c757d;
   color: white;
   border: none;
   border-radius: 4px;
}
</style>
</head>
<body>

	<h2>회원 등록</h2>
	
	<%-- 
		action = "memberInsert" : 이 폼의 데잍터를 /memberInsert 서블릿으로 이동
		method = "Post" : POST 방식으로 전송(데이터가 URL에 노출되지 않음)  
	 --%>
	
	<form action="memberInsert" method = "post">
	<p>
		<label for="memberName">이름 : </label>
		<%-- name="memberName" : 서블릿에서 request.getParameter("memberName") --%>
		<input type='text' id="memberName" name="memberName" placeholder="이름을 입력하세요" required>
	</p>
	
	<p>
		<label for="memberAge">나이 : </label>
		<input type='number' id="memberAge" name="memberAge" placeholder="나이를 입력하세요" min="1" required>
	</p>
	
	<%-- submit 버튼 --%>
	<p>
		<input type="submit" value="등록" class="btn btn-submit">
		<!-- 취소 버튼 : 회원 목록으로 다시 돌아간다  -->	
		<button type="button" class="btn btn-cancel"
		onclick="location.href='${pageContext.request.contextPath}/memberList'">취소</button>	
	</p>
	
	
	</form>

</body>
</html>