package article;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/articleInsert")
public class ArticleInsertController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
//		전달할 데이터가 없으므로 setAttribute() 없이 바로 forward
		RequestDispatcher rd = request.getRequestDispatcher("/article/articleInsertForm.jsp");
		rd.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1) 한글 깨짐 방지 - post 방식은 인코딩 설정부터 꼭 해야함
		request.setCharacterEncoding("UTF-8");
		
//		2) 폼 데이터 읽기 - HTML input 태그의 title속성값으로 데이터를 가져온다
		String articleTitle = request.getParameter("articleTitle");
		String articleBody = request.getParameter("articleBody");

		
//		3) DTO에 데이터 담기 - DB에 넘겨줄 데이터를 MemberDTO 객체로 생성
		ArticleDTO dto = new ArticleDTO();
		dto.setArticleTitle(articleTitle);
		dto.setArticleBody(articleBody);
		// member_id는 auto_increment가 자동 생성
		
//		4) Model 호출 - DAO를 통해 DB에 INSERT를 실행
		ArticleDAO dao = new ArticleDAO();
		dao.insertArticle(dto);
		
//		5) 등록 완료 후 목록 화면으로 리다이렉트(PRG 패턴)
//		sendRedirect를 쓰는 이유 : 새로고침 시 insert가 중복 실행되는 것을 방지
//		request.getContextPath() : 프로젝트의 context root 경로를 가져온다
//		(ex : /03_mvc)
//		+ "/memberList" : 목록 서블릿의 URL 매핑 경로 
		
//		response.sendRedirect(request.getContextPath()+"/articleList");
		
				
	}

}
