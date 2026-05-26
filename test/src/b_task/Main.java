package b_task;

public class Main {
	
	public static void main(String[] args) {
		StudentMain student = new StudentMain("홍길동", 19, 70, 60, 90);
		System.out.println("===== 학생1 정보 =====");
		student.printInfo();
		student.getTotal();
		student.getAvg();
	}
}