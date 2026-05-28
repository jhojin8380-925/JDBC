package article;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/articleUpdate")
public class ArticleUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		System.out.println("수정할 회원 번호 : " + articleId);
		
//		2) DB에서 해당 회원 정보 조회( 수정 폼에 기존 값을 미리 채우기 위해)
		ArticleDAO dao = new ArticleDAO();
		ArticleDTO dto = dao.selectOne(articleId);
		 
//		3) 조회한 dto를 request에 담아 JSP 로 전달
		request.setAttribute("dto", dto);
		System.out.println(dto);
		RequestDispatcher rd = request.getRequestDispatcher("/article/articleUpdateForm.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		1) 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
//		2) 폼에서 전달된 수정 데이터 읽기
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		String articleTitle = request.getParameter("articleTitle");
		String articleBody = request.getParameter("articleBody");
		System.out.println(articleId);
		System.out.println(articleTitle);
		System.out.println(articleBody);
	
		
//		3) dto 값 수정
		ArticleDTO dto = new ArticleDTO();
		dto.setArticleId(articleId);
		dto.setArticleTitle(articleTitle);
		dto.setArticleBody(articleBody);

		
//		4) DB update 실행
		ArticleDAO dao = new ArticleDAO();
		dao.updateArticle(dto);
		
//		5) 수정 완료 후 목록으로 리다이렉트
		response.sendRedirect(request.getContextPath()+"/articleList");
	}

}
