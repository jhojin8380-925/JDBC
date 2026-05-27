package article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleDAO {
	
	
//	1. 게시글 등록(insert)
	public void insertArticle(ArticleDTO dto) {
		int result = 0;
		
//		sql문 작성
		String sql = "insert into article(article_title, article_body) values(?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			1단계 : 연결 통로
			conn = DBConnection.getConnection();
//			2단계 : SQL 구조 객체 생성
			pstmt = conn.prepareStatement(sql);
//			3단계 : ?(위치 홀더)에 실제 데이터 채우기
			pstmt.setString(1, dto.getArticleTitle());
			pstmt.setString(2, dto.getArticleBody());
		
//			4단계 : SQL실행 (insert 이므로 executeUpdat 사용)		
			result = pstmt.executeUpdate();
			
//			5단계 : 결과 확인
			if (result > 0) {
				System.out.println("게시글 등록 완료!");
			} else {
				System.out.println("게시글 등록 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//				6. 자원 해제
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	} // articleInsert
	
}
