package interface01;

public class ClassA implements InterA{
	// 인터페이스가 가진 메서드는 기본적으로 추상 메서드이기 때문에
//	반드시 재정의 해야 한다(강제성)
	@Override
	public void method1() {
		System.out.println("자식에서 재정의");
		
	}

	@Override
	public void method2() {
		System.out.println("자식에서 재정의");
	}
	
	

}
