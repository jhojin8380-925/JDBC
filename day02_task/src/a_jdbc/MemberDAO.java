package a_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// MemberDAO : DB의 member 테이블에서 접근해서
// 데이터를 DTO 단위로 넣거나 빼오는 역할을 담당  
public class MemberDAO {

//	1. 회원등록(insert)
//	Member DTO(회원 한명의 정보)를 전달받아, DB에 저장
	public void insertMember(MemberDTO dto) {
		int result = 0; // 실행 결과를 담을 변수

//			sql문 작성
		String sql = "insert into member(member_name, member_age) values(?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//				1단계 : 연결 통로
			conn = DBConnection.getConnection();
//				2단계 : SQL 구조 객체 생성
			pstmt = conn.prepareStatement(sql);
//				3단계 : ?(위치 홀더)에 실제 데이터 채우기
			pstmt.setString(1, dto.getMemberName());
			pstmt.setInt(2, dto.getMemberAge());

//				4단계 : SQL실행 (insert 이므로 executeUpdat 사용)
			result = pstmt.executeUpdate();

//				5단계 : 결과 확인
			if (result > 0) {
				System.out.println("회원 등록 완료!");
			} else {
				System.out.println("회원 등록 실패!");
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
	} // insertMember

//	2. 전체 회원 조회(select all)
//	DB에 있는 모든 회원 정보를 List에 담아서 반환
	public List<MemberDTO> selectAll() {

		List<MemberDTO> list = new ArrayList<>(); // 회원 정보들을 저장할 리스트
		String sql = "select * from member order by member_id";

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
				int id = rs.getInt("member_id");
				String name = rs.getString("member_name");
				int age = rs.getInt("member_age");

//				읽어온 데이터로 DTO 객체 생성
				MemberDTO dto = new MemberDTO(id, name, age);

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

	}// selectAll()

//	3. 회원수정(update)
//	MemberDTO를 전달받아, 해당 MEMBER_ID의 이름과 나이를 변경
	public void updateMember(MemberDTO dto) {
		int result = 0; // 실행 결과를 담을 변수

//		update문 : where 조건(member_id) 으로 수정할 행을 찾고, set로 바꿀 값을 지정
		String sql = "update member set member_name = ?, member_age = ? where member_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			1단계 : 연결 통로
			conn = DBConnection.getConnection();
//			2단계 : SQL 구조 객체 생성
			pstmt = conn.prepareStatement(sql);
//			3단계 : ?(위치 홀더)에 실제 데이터 채우기
			pstmt.setString(1, dto.getMemberName()); // 첫번째 ? : 새로운 이름
			pstmt.setInt(2, dto.getMemberAge()); // 두번째 ? : 새로운 나이
			pstmt.setInt(3, dto.getMemberId()); // 세번째 ? : 수정할 회원의 ID 번호

//			4단계 : SQL실행 (update 이므로 executeUpdat 사용)
			result = pstmt.executeUpdate();

//			5단계 : 결과 확인
			if (result > 0) {
				System.out.println("회원정보 수정 완료!");
			} else {
				System.out.println("해당 회원을 찾을 수 없습니다.");
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
	} // updateMember

	// 4. 회원삭제(delete)
	// MemberDto를 전달받아, 해당 MEMBER_ID의 데이터를 삭제
	public void deleteMember(int memberId) {
		int result = 0;
//			delete문 : where 조건에 맞는 행을 삭제(조건을 빠트리면 전체 삭제됨 주의!)
		String sql = "delete from member where member_id = ?";

		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//				1단계 : 연결 통로
			conn = DBConnection.getConnection();
//				2단계 : SQL 구조 객체 생성
			pstmt = conn.prepareStatement(sql);
//				3단계 : ?(위치 홀더)에 실제 데이터 채우기
			pstmt.setInt(1, memberId); // 첫번째 ? : 삭제할 회원 아이디

//				4단계 : SQL실행 (update 이므로 executeUpdat 사용)
			result = pstmt.executeUpdate();

//				5단계 : 결과 확인
			if (result > 0) {
				System.out.println("회원 삭제 완료!");
			} else {
				System.out.println("해당 회원을 찾을 수 없습니다.");
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
	} // deleteMember

	// 5. ID로 회원 1명 조회
	public MemberDTO selectOne(int memberId) {
		 // 회원 정보들을 저장할 리스트
		String sql = "select * from member where member_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberDTO list = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberId);
//			select 이므로 executeQuery() 를 사용하여 결과 집합(ResultSet)을 받습니다
			rs = pstmt.executeQuery();

//			데이터가 있는 만큼 반복해서 한줄씩 읽는다

//			현재 줄에서 데이터 추출 
			while (rs.next()) { // 첫번째 줄부터 커서를 잡아주는 반복문 (rs.next())
//				현재 줄에서 데이터 추출
				int id = rs.getInt("member_id");
				String name = rs.getString("member_name");
				int age = rs.getInt("member_age");

//				읽어온 데이터로 DTO 객체 생성
				MemberDTO dto = new MemberDTO(id, name, age);

//				바구니 (List)에 한명씩 추가
				list = dto;
				return list;
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
	} // selectOne


}
