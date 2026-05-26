<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="member.MemberDAO, member.MemberDTO, java.util.List"%>

<%-- 스크립틀릿 : DB에서 회원 목록을 가져오는 자바 코드 작성
	이 영역은 HTML이 그려지기 전에 먼저 실행
 --%>
<%
//MemberDAO 객체를 생성 전체 회원 목록을 DB에서 가져온다
MemberDAO dao = new MemberDAO();

// selectAll() : DB의 Member 테이블 전체를 조회해서 List에 담아서 반환 
List<MemberDTO> list = dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 30px;
}

table {
	border-collapse: collapse;
	width: 60%;
}

th, td {
	border: 1px solid #ccc;
	padding: 8px 16px;
	text-align: center;
}

th {
	background-color: #4a90d9;
	color: white;
}

a {
	color: #2c7be5;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h2>회원 목록</h2>

	<!-- 표현식으로 전체 회원 수 출력 -->
	<p>
		전체 회원 수 : <strong><%=list.size()%>명</strong>
	</p>

	<table>
		<thead>
			<!-- 제목 행 작성 -->
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>나이</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		<tbody>
			<!-- 회원 목록 출력 : for 문으로 회원 목록 한행씩 출력 -->
			<%
			for (MemberDTO dto : list) {
			%>
			<tr>
				<td><%=dto.getMemberId()%></td>
				<td><%=dto.getMemberName()%></td>
				<td><%=dto.getMemberAge()%></td>
				<%-- 수정 링크 : 클릭하면 memberId를 url에 수정 서블릿으로 이동 --%>
				<td><a href="../memberUpdate?memberId=<%=dto.getMemberId()%>">수정</a>
				</td>
				<td><a href="../memberDelete?memberId=<%=dto.getMemberId()%>"
					onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
</body>
</html>















