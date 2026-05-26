package a_class;

public class Person {
	
//	필드
	String name;
	int age;
	
//	생성자 : 단축키(alt + shift + s => o(영어))
	public Person(String name, int age) {
//		this : 객체 자기 자신(객체의 참조값)
//		매개변수와 필드를 구분하기 위해 사용
		this.name = name;
		this.age = age;
	}
	
//	메소드
	void walk() {
//		같은 클래스의 맴버 변수 (필드)는 매개변수로 받을 필요 없이 사용 가능 
		System.out.println(name + "은/는 걷는다.");
	}
	
	void printThis() {
		System.out.println(this);
	}
	
	
}
