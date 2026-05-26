package abstract01;

public class Main {
	public static void main(String[] args) {
//		ClassA a = new ClassA(); 
		// 추상 클래스는 미완성된 클래스이기 때문에 객체 생성 x
		
		ClassB b = new ClassB();
		ClassA a = new ClassB(); // 업캐스팅
		
		
		
		
	}

}
