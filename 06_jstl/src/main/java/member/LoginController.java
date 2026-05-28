package member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

//		로그인 폼(login.jsp)으로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
		rd.forward(request, response);

	}

//	doPost() : 로그인 처리 login.jsp에서 이름, 비밀번호를 받아 로그인 인증하고
//			=> memberList화면으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		1) 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		2) 폼에서 입력한 이름과 비밀번호 가져오기
		String memberName = request.getParameter("memberName");
		String memberPwd = request.getParameter("memberPwd");

//		3) DAO를 통해 DB에서 이름 + 비밀번호가 일치하는 회원 조회
		MemberDAO dao = new MemberDAO();
		MemberDTO loginMember = dao.login(memberName, memberPwd);
		
		// "아이디 저장" 체크박스 값 : 체크하면 "on", 체크 안하면 null
		String saveId = request.getParameter("saveId");
		System.out.println(saveId);


//		4) 로그인 성공 여부 판단
		if (loginMember != null) {
//			-- 쿠키 처리 ----------------------------------
			if("on".equals(saveId)) {
				//  "아이디 저장" 체크 박스가 체크가 된 경우
//				     사용자 이름을 쿠키에 30일 저장
				Cookie saveNameCookie = new Cookie("saveName",
						URLEncoder.encode(memberName, "UTF-8"));
				saveNameCookie.setMaxAge(60*60*24*30); // 30일(초단위)
				response.addCookie(saveNameCookie);
			}else {
//				"아이디 저장" 체크박스가 체크되지 않은 경우 : 기존 쿠키 삭제
				Cookie deleteCookie = new Cookie("saveName","");
				deleteCookie.setMaxAge(0); // 유효기간 0초 => 즉시 만료
				response.addCookie(deleteCookie);
			}
			
//			-- 세션 처리
//			- 성공 : 세션에 회원 정보 저장 후 목록으로 이동

//			getSession() : 세션이 없으면 새로 만들고, 있으면 기존 세션을 가져온다
			HttpSession session = request.getSession();

//			setSession() : 회원 정보를 세션에 저장
//			=> 이 정보는 브라우저를 닫을 때까지 서버가 기억한다
			session.setAttribute("loginMember", loginMember);

//			post 완료 후 redirect => 새로고침 시 중복 로그인 방지
			response.sendRedirect(request.getContextPath() + "/memberList");
		} else {
//			- 실패 : 오류 메시지를 담아 로그인 폼으로 돌아간다

			request.setAttribute("errorMsg", "이름 또는 비밀번호가 올바르지 않습니다.");

//			forward : request에 담은 errorMsg를 JSP에 전달
			RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
			rd.forward(request, response);
		}

	}

}
