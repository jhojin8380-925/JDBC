package article;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/articleList")
public class ArticleListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 한글 인코딩 설정 - 응답 결과가 한글로 깨지지 않게 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) Model 호출 => DAO를 통해 DB에서 전체 회원 목록 가져오기
		ArticleDAO dao = new ArticleDAO();
		List<ArticleDTO> list = dao.selectAll();
		
		// 3) 데이터 전달 준비 => JSP에서 꺼낼 수 있도록 request에 데이터를 담는다
//		setAttribute(키이름, 데이터) : "memberList" 라는 이름 (key)에 list를 저장
		request.setAttribute("articleList", list);
		
//		4) View로 위임 - JSP 파일 경로를 지정(webapp 폳더 기준으로 경로 작성
		RequestDispatcher rd = request.getRequestDispatcher("/article/articleList.jsp");

		
//		rd.forward(request, response); : request에 담긴 데이터와 함께 JSP로 처리를 넘긴다
		rd.forward(request, response);
		
	}

}
