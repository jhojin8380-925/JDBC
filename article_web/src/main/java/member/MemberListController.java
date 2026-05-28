package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//브라우저가 /memberListt로 요청하면 이 서블릿이 실행
@WebServlet("/memberList")
public class MemberListController extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		----- 세션 체크(세션에 사용자 정보가 들어있을 경우) -----
//		getSession(false) : 세션이 없음ㄴ null을 반환(새로 만들지 않음)
		HttpSession session = request.getSession(false);
//		세션이 없거나, 세션에 loginMember 정보가 없으면 => 로그인 페이지로 이동
		if(session == null || session.getAttribute("loginMember") == null) { 
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		
		
		// 1) 한글 인코딩 설정 - 응답 결과가 한글로 깨지지 않게 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) Model 호출 => DAO를 통해 DB에서 전체 회원 목록 가져오기
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
		// 3) 데이터 전달 준비 => JSP에서 꺼낼 수 있도록 request에 데이터를 담는다
//		setAttribute(키이름, 데이터) : "memberList" 라는 이름 (key)에 list를 저장
		request.setAttribute("memberList", list);
		
//		4) View로 위임 - JSP 파일 경로를 지정(webapp 폳더 기준으로 경로 작성
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberList.jsp");

		
//		rd.forward(request, response); : request에 담긴 데이터와 함께 JSP로 처리를 넘긴다
		rd.forward(request, response);
		
		
	}
	

}
