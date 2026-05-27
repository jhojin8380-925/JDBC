<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
body {
   font-family: Arial, sans-serif;
   margin: 30px;
}

label {
   display: inline-block;
   width: 80px;
}

input[type="text"]{
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
	<h2>게시글 작성</h2>
	
	<form action="articleInsert" method="post">
		<p>
			<label for="articleTitle">제목 :</label>
			<input type="text" id="articleTitle" name="articleTitle" placeholder="제목을 입력하세요" required>
		</p>
		<p>
			<label for="articleBody">내용 :</label>
			<input type="text" id="articleBody" name="articleBody" placeholder="내용을 입력하세요" required>
		</p>
		<p>
			<button type="submit" class="btn btn-submit">등록</button>
			<button type="button" class="btn btn-cancel"
			onclick="location.href='${pageContext.request.contextPath}/articleList'">취소</button>
		</p>
	</form>
	
</body>
</html>