package a_class;

public class Main {
	public static void main(String[] args) {
//		클래스는 객체를 생성하기 위한 틀, 설계도
		
//		아래 코드는 다음과 같다
//		1. Person 타입의 변수 p1을 선언
//		2-1. new는 뒤에 나오는 Person()을 보고
//			Person 클래스와 똑같이 생긴 저장공간을 힙(Heap)영역에 만든다
//			=> 이렇게 클래스로 만든 저장공간을 객체 또는 인스턴스라고 부른다
//		2-2. new는 생성한 저장공간(객체)의 시작 주소를 가져온다
//		3. 대입연산자를 통해 객체의 주소를 p1에 저장
		Person p1 = new Person("짱구", 5);
		Person p2 = new Person("철수", 6);
		System.out.println(p1);
		System.out.println(p2);
//		실행했을 때 뜨는 값을 참조값(주소값) 이라고함
//		a_class.Person@48cf768c
//		생성한 객체들의 주소는 모두 다르다(서로 다른 저장공간)
		
//		객체를 통해 클래스의 멤버 사용 가능
		System.out.println("이름 : " + p1.name);
		System.out.println("이름 : " + p2.name);
		//		접근 연산자(.) : ~의, ~안에, 주소를 통해 특정 객체에 접근
		p1.walk();
		
		p1.printThis();
		
	}
}
