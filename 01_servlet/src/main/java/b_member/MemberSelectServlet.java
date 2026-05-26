package b_member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSelectServlet
 */
@WebServlet("/memberSelect")
public class MemberSelectServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

//      DAO를 통해 DB에서 전체 회원 목록을 가져온다
      MemberDAO memberDAO = new MemberDAO();
      List<MemberDTO> list = memberDAO.selectAll();

//      브라우저에게 보낼 응답 형식 설정
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<html>");
      out.println("<head><style>");
      out.println("table { border-collapse: collapse; width: 60%; }");
      out.println("th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }");
      out.println("th { background-color: #4CAF50; color: white; }");
      out.println("</style></head>");
      out.println("<body>");
      out.println("<h2>전체 회원 목록 (" + list.size() + "명)</h2>");

      out.println("<table>");
      out.println("<tr><th>ID</th><th>이름</th><th>나이</th><th>수정</th><th>삭제</th>" + "</tr>");
      for (MemberDTO dto : list) {
         out.println("<tr>");
         out.println("<td>" + dto.getMemberId() + "</td>");
         out.println("<td>" + dto.getMemberName() + "</td>");
         out.println("<td>" + dto.getMemberAge() + "</td>");
//         [수정] 클릭 => GET방식으로 memberId를  query string에 담아 
//         MemberUpdateServlet으로 이동
         out.println("<td><a href = 'memberUpdate?memberId=" + dto.getMemberId() + "'>수정</a></td>");
//         [삭제] 클릭 => 삭제하고 다시 돌아오는 방식
         out.println("<td><a href = 'memberDelete?memberId=" + dto.getMemberId() + "' " + "onclick=\"return confirm('정말 삭제하시겠습니까?')\">삭제</a></td>");

         out.println("</tr>");
      }

      out.println("</table>");
      out.println("<br><a href='member_insert.html'>회원 등록하러 가기</a>");
      out.println("</body>");
      out.println("</html>");

   }

}
