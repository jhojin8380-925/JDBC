package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1) 현제 세션을 가져온다
		HttpSession session = request.getSession(false);
		
//		2) 세션이 존재하면 무효화(로그아웃 처리)
		if(session != null) {
//			invalidate() : 세션에 저장된 모든 데이터를 삭제하고 세션 자체를 종료
			session.invalidate();
		}
		
//		3) 로그아웃 되면 로그인페이지로 이동
		response.sendRedirect(request.getContextPath()+"/login");
		
		
		
	}



}
