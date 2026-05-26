package b_task;

public class StudentMain {
	String name;
	int age;
	int kor;
	int eng;
	int math;
	
	public StudentMain(String name, int age, int kor, int eng, int math) {
		super();
		this.name = name;
		this.age = age;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
	void getTotal() {
		System.out.println("총점 : " + (kor + eng + math));
	}
	
	void getAvg() {
		System.out.println("평균 : " + ((kor + eng + math) / 3));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
