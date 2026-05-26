package b_member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/memberInsert")
public class MemberInsertServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
//		1) post로 넘어온 이름, 나이
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
		
//		2) 꺼낸 데이터를 DTO(그릇)에 담는다
		MemberDTO dto = new MemberDTO(0, memberName, memberAge);
		
//		3) DAO 에게 DB등록을 요청한다
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.insertMember(dto);
		
//		결과화면을 브라우저에 보낸다
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter	out	= response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>" + memberName + "회원이 등록되었습니다!</h2>");
		out.println("<a href = 'memberSelect'>전체 회원 목록 보기</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
