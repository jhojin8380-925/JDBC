package b_member;

public class MemberDTO {
	private int memberId;
	private String memberName;
	private int memberAge;
	
//	기본 생성자
	public MemberDTO() {}

	
//	생성자
	public MemberDTO(int memberId, String memberName, int memberAge) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}


//	getter & setter 단축키 : Alt + shift + s => r
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
