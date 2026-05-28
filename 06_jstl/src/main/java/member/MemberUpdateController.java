package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/memberUpdate")
public class MemberUpdateController extends HttpServlet {
	
//	doGet() : GET요청 => 기존 회원 정보를 조회하여 수정 폼에 채워 보여준다
	
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
		
//		1) URL 파라미터에서 수정할 회원의 ID를 읽는다
//		ex) /memberUpdate?memberId = 3 => "3"을 가져옴
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		System.out.println("수정할 회원 번호 : " + memberId);
		
//		2) DB에서 해당 회원 정보 조회( 수정 폼에 기존 값을 미리 채우기 위해)
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectOne(memberId);
		 
//		3) 조회한 dto를 request에 담아 JSP 로 전달
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberUpdateForm.jsp");
		rd.forward(request, response);
		
	}

//	doPost() : POST요청 => 수정된 데이터를 DB에 반영
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		----- 세션 체크(세션에 사용자 정보가 들어있을 경우) -----
//		getSession(false) : 세션이 없음ㄴ null을 반환(새로 만들지 않음)
		HttpSession session = request.getSession(false);
//		세션이 없거나, 세션에 loginMember 정보가 없으면 => 로그인 페이지로 이동
		if(session == null || session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		
//		1) 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
//		2) 폼에서 전달된 수정 데이터 읽기
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
		String memberPwd = request.getParameter("memberPwd");
		System.out.println(memberId);
		System.out.println(memberName);
		System.out.println(memberAge);
		System.out.println(memberPwd);
		
//		3) dto 값 수정
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(memberId);
		dto.setMemberName(memberName);
		dto.setMemberAge(memberAge);
		dto.setMemberPwd(memberPwd);
		
//		4) DB update 실행
		MemberDAO dao = new MemberDAO();
		dao.updateMember(dto);
		
//		5) 수정 완료 후 목록으로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/memberList");
	}

}
