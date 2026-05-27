package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete")
public class MemberDeleteController extends HttpServlet {
	
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
		
//		<실습>
//		URL파라미터에서 받은 회원 ID로 DB에서 해당 회원 삭제 후
//		다시 목록페이지로 리다이렉트

//		1) 삭제할 회원 ID
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		
//		System.out.println("삭제할 회원 ID : " + memberId);
		
//		2) DB에서 해당 회원 삭제
		MemberDAO dao = new MemberDAO();
		dao.deleteMember(memberId);
		
//		3) 삭제 완료 후 목록 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/memberList");
		
		
		
	}


}
