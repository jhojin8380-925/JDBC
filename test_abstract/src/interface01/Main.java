package interface01;

public class Main {
	public static void main(String[] args) {
//		InterA a = new InterA();
//		인터페이스는 추상 메서드만 가지기 때문에 인스턴스화 불가
//		=> 그리고 인터페이스는 생성자가 존재하지 않는다
		
//		인터페이스도 타입
		InterA interA = new ClassA(); // 업캐스팅
		interA.method1();
		interA.method2();
		
	}

}
