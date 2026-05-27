<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.MemberDTO" %>
    
<%
	// Controller 가 setAttribute("dto", dto)로 담아준 데이터를 꺼낸다
	// Object 타입이므로 형변환 필요
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
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
   background-color: #fd7e14;
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
	<h2>회원 수정</h2>
	<%--
		hidden 필드 : 화면에는 보이지 않지만 서버로 전송되는 데이터
		수정할 회원 ID를 post 요청에 함께 담아 보내야 "누구를 수정할지" 알 수 있다
	 --%>
	<form action="memberUpdate" method="post">
		<input type="hidden" name="memberId" value="<%= dto.getMemberId() %>">
		
		<p>
			<label>ID : </label>
			<%-- Id는 변경하지 않으므로 --%>
			<input type="number" id="memberId" name="memberId" value="<%= dto.getMemberId() %>" readonly style="background-color: #f0f0f0;">			
		</p>
		
		<p>
			<label for="memberName">이름 : </label>
			<input type="text" id="memberName" name="memberName" value="<%= dto.getMemberName() %>" required>
		</p>
		
		<p>
			<label for="memberAge" >나이 :</label>
			<input type="text" id="memberAge" name="memberAge" value="<%= dto.getMemberAge() %>" min="1" required>
		</p>
		
		<p>
			<label for="memberName">비밀번호 : </label>
			<input type="password" id="memberPwd" name="memberPwd" value="<%= dto.getMemberPwd() %>" required>
		</p>
		
		<p>
			<input type="submit" value="수정완료" class="btn btn-submit">
			<%-- 취소 버튼 --%>
			<button type="button" class="btn btn-cancel" onclick="location.href='${pageContext.request.contextPath}/memberList'">취소</button>
		</p>
	</form>
	
	
	
</body>
</html>