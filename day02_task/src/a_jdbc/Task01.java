package a_jdbc;

import java.util.List;
import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MemberDAO memberDAO = new MemberDAO();

		System.out.print("조회할 회원 ID : ");
		int id = sc.nextInt();

		MemberDTO member = memberDAO.selectOne(id);
	
		if(member == null) {
			System.out.println("조회하신 아이디는 없습니다.");
		} else {
			System.out.println("=========" + member.getMemberName() + "==========");
			System.out.println("회원 ID : " + member.getMemberId());
			System.out.println("회원 name : " + member.getMemberName());
			System.out.println("회원 age : " + member.getMemberAge());

		}

	}
}
