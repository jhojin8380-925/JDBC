package b_member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	
//	회원 삭제 서블릿
//	목록에서 [삭제] 링크 클릭시 get방식으로 memberId가 전달된다
//	DB에서 해당 회원을 삭제한 뒤 목록 페이지로 이동한다
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		memberId 받아오기
		int memberId = Integer.parseInt(request.getParameter("memberId"));
//		받아온 Id 출력
		System.out.println("삭제할 회원 ID : " + memberId);
//		memberDAO 객체 생성(리모콘 받아오기)
		MemberDAO memberDAO = new MemberDAO();
//		deleteMember 메서드 호출
		memberDAO.deleteMember(memberId);
//		삭제하고 다시 memberSelect 로 돌아가기
		response.sendRedirect("memberSelect");
	}
}
