package member;

// DTO : member테이블 한 행(row)을 자바 객체로 표현
public class MemberDTO {
	
// 필드	
	private int memberId;
	private String memberName;
	private int memberAge;
	private String memberPwd;
	
	public MemberDTO() {}
	
	public MemberDTO(int memberId, String memberName, int memberAge, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberPwd = memberPwd;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
