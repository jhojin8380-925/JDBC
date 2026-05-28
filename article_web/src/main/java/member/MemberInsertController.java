package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/memberInsert")
public class MemberInsertController extends HttpServlet {
	
//	doGet() : GET 요청 => 회원 등록 폼 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		----- 세션 체크(세션에 사용자 정보가 들어있을 경우) -----
//		getSession(false) : 세션이 없음ㄴ null을 반환(새로 만들지 않음)
		HttpSession session = request.getSession(false);
//		세션이 없거나, 세션에 loginMember 정보가 없으면 => 로그인 페이지로 이동
		if(session == null || session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		

		response.setContentType("text/html; charset=UTF-8");
		
//		전달할 데이터가 없으므로 setAttribute() 없이 바로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberInsertForm.jsp");
		rd.forward(request,response);
		
	}

//	doPost() : POST 요청 -> 폼에서 입력한 데이터를 DB에 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		----- 세션 체크(세션에 사용자 정보가 들어있을 경우) -----
//		getSession(false) : 세션이 없음ㄴ null을 반환(새로 만들지 않음)
		HttpSession session = request.getSession(false);
//		세션이 없거나, 세션에 loginMember 정보가 없으면 => 로그인 페이지로 이동
		if(session == null || session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		
//		1) 한글 깨짐 방지 - post 방식은 인코딩 설정부터 꼭 해야함
		request.setCharacterEncoding("UTF-8");
		
//		2) 폼 데이터 읽기 - HTML input 태그의 name속성값으로 데이터를 가져온다
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
		String memberPwd = request.getParameter("memberPwd");
//		System.out.println("추가할 이름 : " + memberName);
//		System.out.println("추가할 나이 : " + memberAge);
		
//		3) DTO에 데이터 담기 - DB에 넘겨줄 데이터를 MemberDTO 객체로 생성
		MemberDTO dto = new MemberDTO();
		dto.setMemberName(memberName);
		dto.setMemberAge(memberAge);
		dto.setMemberPwd(memberPwd);
		// member_id는 auto_increment가 자동 생성
		
//		4) Model 호출 - DAO를 통해 DB에 INSERT를 실행
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);
		
//		5) 등록 완료 후 목록 화면으로 리다이렉트(PRG 패턴)
//		sendRedirect를 쓰는 이유 : 새로고침 시 insert가 중복 실행되는 것을 방지
//		request.getContextPath() : 프로젝트의 context root 경로를 가져온다
//		(ex : /03_mvc)
//		+ "/memberList" : 목록 서블릿의 URL 매핑 경로 
		
		response.sendRedirect(request.getContextPath()+"/memberList");
		
		
	}

}
