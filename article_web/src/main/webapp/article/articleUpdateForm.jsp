<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="article.ArticleDTO" %>
    
<%
	// Controller 가 setAttribute("dto", dto)로 담아준 데이터를 꺼낸다
	// Object 타입이므로 형변환 필요
	ArticleDTO dto = (ArticleDTO)request.getAttribute("dto");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<style>
body {
   font-family: Arial, sans-serif;
   margin: 30px;
}

label {
   display: inline-block;
   width: 80px;
}

input[type="text"], textarea{
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
	<h2>게시글 수정</h2>
	<form action="articleUpdate" method="post">
		
		
		<p>
			<label for="articleId">ID : </label>
			<%-- Id는 변경하지 않으므로 --%>
			<input type="number" id="articleId" name="articleId" value="<%= dto.getArticleId() %>" readonly style="background-color: #f0f0f0;">			
		</p>
		
		<p>
			<label for="articleTitle">제목 : </label>
			<input type="text" id="articleTitle" name="articleTitle" value="<%= dto.getArticleTitle() %>" required>
		</p>
		
		<p>
			<label for="articleBody">내용 : </label>
			<textarea id="articleBody" name="articleBody" required rows="10" cols="30">
				<%= dto.getArticleBody() %>
			</textarea>
			
		</p>
		
		<p>
			<input type="submit" value="수정완료" class="btn btn-submit">
			<%-- 취소 버튼 --%>
			<button type="button" class="btn btn-cancel" onclick="location.href='${pageContext.request.contextPath}/articleList'">취소</button>
		</p>
	
	</form>
	
	
</body>
</html>