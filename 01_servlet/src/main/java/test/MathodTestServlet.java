package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MathodTestServlet
 */
@WebServlet("/methodTest")
public class MathodTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>>> doGet 매서드가 호출되었습니다!");

//		한글깨짐 방지

//		[데이터 꺼내기]
//		html의 <input name = "menu"> 에서 정한 name 값을 key로 사용
		String menu = request.getParameter("menu");
		System.out.println("주문한 메뉴 : " + menu);

//		[결과 화면]
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head><style>body{font-family : sans-serif;" + "</style></head>");
//		out.println("<body>");
//		out.println("<h1>[get] 방식으로 들어온 주문입니다!</h1>");
//		out.println("<p>주문하신 메뉴 : " + "<strong>" + menu + "<strong>" + "</p>");
//		out.println("<br><button onclick='history.back()'>다시 주문하러 가기</button>");
//		out.println("</body>");
//		out.println("</html>");
		
//		display() 메소드 호출
		display(response, "GET", menu);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>>> doPost 메서드가 호출되었습니다.");

//		한글깨짐 방지
//		post방식은 데이터를 body에 숨겨오기 때문
//		꺼내기 전에 한글깨짐 방지를 해줘야함
		request.setCharacterEncoding("UTF-8");

//		데이터 꺼내오는 방식(get방식과 같다)
		String menu = request.getParameter("menu");
		System.out.println("주문한 메뉴 : " + menu);
		
//		PrintWriter out = response.getWriter();
		
//		포스트 한글깨짐 방지
		
		
//		결과화면
//		out.println("<html>");
//		out.println("<head><style>body{font-family : sans-serif;" + "</style></head>");
//		out.println("<body>");
//		out.println("<h1>[post] 방식으로 들어온 주문입니다!</h1>");
//		out.println("<p>주문하신 메뉴 : " + "<strong>" + menu + "<strong>" + "</p>");
//		out.println("<br><button onclick='history.back()'>다시 주문하러 가기</button>");
//		out.println("</body>");
//		out.println("</html>");
		
//		display() 메소드 호출
		display(response, "POST", menu);

	}
	
//	응답 화면 출력 메소드
//	get이든 post든 화면에 보여주는 방식이 같다면 메소드를 처리할 수 있다(코드 중복 방지)
	private void display(HttpServletResponse response, String method, String menu) 
	throws IOException{
		
//		html 화면 한글 깨짐 방지
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><style>body{font-family : sans-serif;" + "</style></head>");
		out.println("<body>");
		out.println("<h1>[" + method + "]방식으로 들어온 주문입니다!</h1>");
		out.println("<p>주문하신 메뉴 : " + "<strong>" + menu + "<strong>" + "</p>");
		out.println("<br><button onclick='history.back()'>다시 주문하러 가기</button>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
