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
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
//	doGet() : 로그인 폼 화면으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
//		로그인 폼(login.jsp)으로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);
		
	}

//	doPost() : 로그인 처리 login.jsp에서 이름, 비밀번호를 받아 로그인 인증하고 
//			=> memberList화면으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1) 인코딩 설정 (한글 깨짐 방지)
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		2) 폼에서 입력한 이름과 비밀번호 가져오기
		String memberName = request.getParameter("memberName");
		String memberPwd = request.getParameter("memberPwd");
		
//		3) DAO를 통해 DB에서 이름 + 비밀번호가 일치하는 회원 조회
		MemberDAO dao = new MemberDAO();
		MemberDTO loginMember = dao.login(memberName, memberPwd);
		
//		4) 로그인 성공 여부 판단 
		if(loginMember != null) {
//			- 성공 : session에 회원 정보 저장 후 목록페이지로 이동
//			getSession() : 세션이 없으면 새로 만들고, 있으면 기존 세션을 가져온다
			HttpSession session = request.getSession();
			
//			setSession() : 회원 정보를 세션에 저장
//			=> 이 정보는 브라우저를 닫을 때 까지 서버가 기억한다
			session.setAttribute("loginMember", loginMember);
			
//			post 완료 후 redirect => 새로고침 시 중복 로그인 방지
			response.sendRedirect(request.getContextPath()+"/articleList");
		} else {
//			- 실패 : 오류 메시지를 담아 로그인 폼으로 돌아간다
			
			request.setAttribute("errorMsg", "이름 또는 비밀번호가 올바르지 않습니다.");
			
//			forward : request에 담은 errorMsg를 JSP에 전달
			RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	}

}
