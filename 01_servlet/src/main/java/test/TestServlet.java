package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
// 서블릿의 주소 정해주는 중요한 부분
// 브라우저 창에 <http://localhost:8900/프로젝트이름/test>라고 작성하면 
// 해당 서블릿이 호출된다.
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1. 응답 설정
//		"내가 보내는 건 html문서이고, 한글이 안깨지게 UTF-8 형식을 쓴다"
		response.setContentType("text/html; charset=UTF-8");
		
		
//		2. 스트림(통로) 생성
//		PrintWriter 는 브라우저에 화면을 그리는 펜 역할을 한다 
		PrintWriter out = response.getWriter();		
		
//		3. html 작성
//		out.println() 안에 적은 내용들이 실제로 웹 브라우저 화면에 그려진다
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>안녕하세요! 첫번째 서블릿입니다.</h1>");
		out.println("<p>현재 시간 : " + new java.util.Date() + "</p>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
	}


}
