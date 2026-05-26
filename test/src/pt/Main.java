package pt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		문제 1
//		System.out.print("숫자를 입력해주세요 : ");
//		int num = sc.nextInt();
//		System.out.println("입력 : " + num);
//		if(num % 2 == 0) {
//			System.out.println("출력 : 짝수");
//		} else { 
//			System.out.println("출력 : 홀수");
//		}
		
//		문제 2
//		System.out.print("문자를 입력해주세요 : ");
//		String text = sc.nextLine();
//		
//		System.out.println("입력 : " + text);
//		System.out.println("길이 : " + text.length());
		
//		문제 3
//		int[] arr = {3, 7, 2, 9, 5};
//		
//		int max = arr[0];
//		int min = arr[0];
//		
//		for(int i = 0; i < arr.length; i++) {
//			if(max < arr[i]) {
//				max = arr[i];
//			}
//			if(min > arr[i]) {
//				min = arr[i];
//			}
//		}
//		
//		System.out.println("최대값 : " + max);
//		System.out.println("최소값 : " + min);
		
//		문제 4
//		int sum = 0;
//		
//		for(int i = 1; i <= 100; i++) {
//			sum += i;
//		}
//		
//		System.out.println("총 합 : " + sum);
//		
		
//		문제 5
//		ArrayList<Integer> li = new ArrayList<>(5);
//		
//		li.add(2);
//		li.add(6);
//		li.add(9);
//		li.add(5);
//		li.add(7);
//		
//		System.out.println(li);
//		
////		문제 6
////	 	문제 5랑 연동
//		for(int i = 0; i < li.size(); i++) {
//			if(li.get(i) % 2 == 0) {
//				System.out.println(li.get(i));
//			}
//		}
//		문제 7
//		Person p1 = new Person("홍길동", 19);
//		Person p2 = new Person("김철수", 20);
//		p1.print();
//		p2.print();
//		
//		문제 8
//		Student student1 = new Student("홍길동", 70);
//		Student student2 = new Student("김철수", 80);
//		Student student3 = new Student("이영희", 90);
//		int avg = (student1.score + student2.score + student3.score) / 3;
//		
//		System.out.println("평균 : " + avg);
		
//		문제 9
//		1 ~ 100 까지 랜덤숫자 생성
//		int randNum = (int) (Math.random() * 100) + 1;
//		
//		for(;;) {
//			System.out.print("숫자를 입력하세요 :");
//			int num = sc.nextInt();
//			if(num < randNum) {
//				System.out.println("UP");
//			} else if(num > randNum) {
//				System.out.println("DOWN");
//			} else if(num == randNum) {
//				System.out.println("정답!");
//				break;
//			} else {
//				System.out.println("잘못된 입력값입니다.");
//			}
//			
//		}
//		sc.close();
		
//		문제 10
		
	}
}

//문제 7	class

//class Person{
//	String name;
//	int age;
//	
//	public Person(String name, int age) {
//		super();
//		this.name = name;
//		this.age = age;
//	}
//	
//	void print() {
//		System.out.println("이름 : " + name);
//		System.out.println("나이 : " + age);
//	}
//	
//}

// 문제 8 class
//class Student{
//	String name;
//	int score;
//	
//	public Student(String name, int score) {
//		super();
//		this.name = name;
//		this.score = score;
//	}
//}
