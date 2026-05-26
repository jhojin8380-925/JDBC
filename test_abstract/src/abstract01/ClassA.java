package abstract01;

public abstract class ClassA { // 추상 메서드가 1개라도 있는 클래스는 추상 클래스로 선언
	
	abstract void method1(); // 추상 메서드(미완성된 메서드)
	
	void method2() { // 일반 메서드(완성된 메서드)
		System.out.println("메서드2 실행~!");
	}

}
