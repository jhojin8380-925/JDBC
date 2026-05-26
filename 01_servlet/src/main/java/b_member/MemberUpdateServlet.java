package b_member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		System.out.println("수정할 회원 ID" + memberId);
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO dto = memberDAO.selectOne(memberId);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>회원 정보 수정</h2>");
		
//		action = 'memberUpdate' => 이 폼을 post로 제출하면 doPost()가 실행된다
		out.println("<form action='memberUpdate' method = 'post'>");
		
//		memberId는 사용자에게 보이지 않는 hidden으로 넘긴다
		out.println("<input type='hidden' name='memberId' value ='"+dto.getMemberId()+"'>");
		
		out.println("이름 : <input type='text' name='memberName' value='"+dto.getMemberName()+"'><br><br>");
		out.println("나이 : <input type='text' name='memberAge' value='"+dto.getMemberAge()+"'><br><br>");
		out.println("<button type='submit'>수정 완료</button>");
		
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		POST 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
//		hidden 필드로 넘어온 memeberId(수정할 대상)
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
//		System.out.println("수정할 대상 ID : " + memberId);
//		System.out.println("수정할 대상 Name3 : " + memberName);
//		System.out.println("수정할 대상 Age : " + memberAge);
		
//		수정할 내용을 DTO 에 담아서 넘겨주면 됨
		MemberDTO dto = new MemberDTO(memberId, memberName, memberAge);
		
//		DAO 에 요청 수정 
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.updateMember(dto);
		
//		수정 완료 후, 전체 목록 페이지로 이동(redirect)
//		response.sendRedirect()는 브라우저에게 "이 주소로 다시 요청해!" 라고 명령
//		(out.println()으로 직접 HTML을 쓰는 대신, 목록페이지를 재사용하는 방법)
		response.sendRedirect("memberSelect");
		
		
	}

}
