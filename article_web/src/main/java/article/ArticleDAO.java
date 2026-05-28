package article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

//	2. 게시글 리스트(select all)
	public List<ArticleDTO> selectAll() {
		List<ArticleDTO> list = new ArrayList<>(); // 회원 정보들을 저장할 리스트
		String sql = "select * from article order by article_id";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
//			select 이므로 executeQuery() 를 사용하여 결과 집합(ResultSet)을 받습니다
			rs = pstmt.executeQuery();

//			데이터가 있는 만큼 반복해서 한줄씩 읽는다
			while (rs.next()) {
//				현재 줄에서 데이터 추출
				int id = rs.getInt("article_id");
				String title = rs.getString("article_title");
				String body = rs.getString("article_body");

//				읽어온 데이터로 DTO 객체 생성
				ArticleDTO dto = new ArticleDTO(id, title, body);

//				바구니 (List)에 한명씩 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			자원해제
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return list;

	}

//  3. 게시글 수정(update)
	public void updateArticle(ArticleDTO dto) {
		int result = 0;

		String sql = "update article set article_title = ?, article_body = ? where article_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getArticleTitle());
			pstmt.setString(2, dto.getArticleBody());
			pstmt.setInt(3, dto.getArticleId());

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("게시글 수정 완료!");
			} else {
				System.out.println("해당 게시글을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			6. 자원 해제
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

	} // articleUpdate

//	4. 게시글 삭제(delete)
	public void deleteArticle(int articleId) {
		int result = 0;

		String sql = "delete from article where article_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			1단계 : 연결 통로
			conn = DBConnection.getConnection();
//			2단계 : SQL 구조 객체 생성
			pstmt = conn.prepareStatement(sql);
//			3단계 : ?(위치 홀더)에 실제 데이터 채우기
			pstmt.setInt(1, articleId); // 첫번째 ? : 삭제할 회원 아이디

//			4단계 : SQL실행 (update 이므로 executeUpdat 사용)
			result = pstmt.executeUpdate();

//			5단계 : 결과 확인
			if (result > 0) {
				System.out.println("게시글 삭제 완료!");
			} else {
				System.out.println("해당 게시글을 찾을 수 없습니다.");
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
	}

//	5. 한개의 게시글 조회(selectOne)
	public ArticleDTO selectOne(int articleId) {
		String sql = "select * from article where article_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArticleDTO list = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleId);
//				select 이므로 executeQuery() 를 사용하여 결과 집합(ResultSet)을 받습니다
			rs = pstmt.executeQuery();

//				데이터가 있는 만큼 반복해서 한줄씩 읽는다

//				현재 줄에서 데이터 추출 
			while (rs.next()) { // 첫번째 줄부터 커서를 잡아주는 반복문 (rs.next())
//					현재 줄에서 데이터 추출
				int id = rs.getInt("article_id");
				String title = rs.getString("article_title");
				String body = rs.getString("article_body");

//					읽어온 데이터로 DTO 객체 생성
				ArticleDTO dto = new ArticleDTO(id, title, body);

//					바구니 (List)에 한명씩 추가
				list = dto;
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//				자원해제
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return list;
	}

}
