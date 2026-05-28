<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 스크립틀릿 : DB에서 회원 목록을 가져오는 자바 코드 작성
	이 영역은 HTML이 그려지기 전에 먼저 실행
 --%>
<%-- 
	- getAttribute로 Controller 가 담아준 데이터를 꺼냄
	- getAttribute()는 Object 타입으로 반환하므로 원래 타입인 List(MemberDTO)로 
	- 형변환 (다운 캐스팅) 필요
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>

body {
   font-family: 'Malgun Gothic', sans-serif;
   padding: 30px;
   background: #f7f8fa;
}

.header-bar {
   display: flex;
   justify-content: space-between;
   align-items: center;
   background: white;
   padding: 14px 20px;
   border-radius: 12px;
   box-shadow: 0 2px 8px rgba(0, 0, 0, 0.07);
   margin-bottom: 24px;
}

.welcome-msg {
   font-size: 0.95rem;
   color: #2d3748;
}

.welcome-msg strong {
   color: #3182ce;
}

.btn-logout {
   background: #e53e3e;
   color: white;
   border: none;
   padding: 8px 16px;
   border-radius: 8px;
   cursor: pointer;
   font-size: 0.85rem;
   font-family: 'Malgun Gothic', sans-serif;
   text-decoration: none;
}

.btn-logout:hover {
   background: #c53030;
}

h2 {
   margin-bottom: 16px;
   color: #1a365d;
}

table {
   width: 100%;
   border-collapse: collapse;
   background: white;
   border-radius: 12px;
   overflow: hidden;
   box-shadow: 0 2px 8px rgba(0, 0, 0, 0.07);
}

th {
   background: #2b6cb0;
   color: white;
   padding: 12px 16px;
   font-size: 0.9rem;
}

td {
   padding: 12px 16px;
   border-bottom: 1px solid #e2e8f0;
   font-size: 0.9rem;
   text-align :center;
}

tr:last-child td {
   border-bottom: none;
}

.btn {
   padding: 5px 12px;
   border-radius: 6px;
   border: none;
   cursor: pointer;
   font-size: 0.82rem;
   font-family: 'Malgun Gothic', sans-serif;
   margin-right: 4px;
}

.btn-edit {
   background: #ed8936;
   color: white;
}

.btn-delete {
   background: #e53e3e;
   color: white;
}

.btn-insert {
   background: #38a169;
   color: white;
   padding: 8px 18px;
   border-radius: 8px;
   border: none;
   cursor: pointer;
   font-size: 0.9rem;
   font-family: 'Malgun Gothic', sans-serif;
   margin-bottom: 14px;
   display: inline-block;
}
</style>
</head>
<body>

	<!-- 상단 메시지 + 로그아웃 버튼 -->
	<div class='header-bar'>
		<!-- 세션에 있는 회원의 이름을 화면에 출력 -->
		<span class='welcome-msg'> 
			<%-- <strong><%= loginMember.getMemberName() %></strong>님 환영합니다! --%>
			<%-- 세션에서 loginMembber를 꺼내고 getMemberName()자동 호출 --%>
			<strong>${loginMember.memberName}</strong>님 환영합니다!
		</span>
		<!-- 로그아웃 : /logout 서블릿으로 이동 -> 세션 invalidate -> /login으로 redirect -->
		<a href="logout" class="btn-logout">로그아웃</a>
	</div>

	<h2>회원 목록</h2>

	<!-- 표현식으로 전체 회원 수 출력 -->
	
	<%-- El에서 가져온 memberList를 사용할 수 있다 --%>
	<p>
		<%-- 전체 회원 수 : <strong><%=memberList.size()%>명</strong> --%>
		전체 회원수 : <strong>${memberList.size()}</strong>명
	</p>

	<%-- 회원 등록 페이지로 이동하는 링크 --%>
	<a href="memberInsert" class="btn-insert">회원 등록</a>

	<table>
		<thead>
			<!-- 제목 행 작성 -->
			<tr>
				<th>카운트</th>
				<th>ID</th>
				<th>이름</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<%-- 기존 : <%for(MemberDTO dto : memberList){%>...<%} %> 
			변경 : c:forEach
				- var = "dto" : 반복 변수 이름
				- items = ${memberList} : Controller가 setAttribute("memberList", list)
				- varStatus="status" : 순번정보(status.count = 1붜 시작)				
			--%>
			<c:forEach var="dto" items="${memberList }" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<%-- 자동 순번 --%>
					<%-- 기존 : <%dto.getMemberI%>--%>
					<td>${dto.memberId}</td>
					<td>${dto.memberName}</td>
					<td>${dto.memberAge}</td>
					<td>
						<button class="btn btn-edit"
						onclick="location.href=${pageContext.request.contextPath}/memberUpdate?memberId=${dto.memberId}">수정</button>
					</td>
					<td>
						<button class="btn btn-delete"
						onclick="location.href=${pageContext.request.contextPath}/memberDelete?memberId=${dto.memberId}">삭제	</button>
						</td>
				</tr>	
			</c:forEach>
			
			<%-- 회원이 한명도 없는 경우 --%>
			<c:if test="${empty memberList}">
				<tr>
					<td colspan="5">등록된 회원이 없습니다.</td>
				</tr>
			</c:if>
			
		</tbody>

	</table>
</body>
</html>















