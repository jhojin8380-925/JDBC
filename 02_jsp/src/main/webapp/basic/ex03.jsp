<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 선언문 : JSP 어디에서든 호출할 수 있는 공통 메서드를 선언하는 공간 --%>    
<%! 
	// 점수를 전달 받아, 점수에 해당하는 학점(문자열)을 반환하는 메서드 정의
	String getGrade(int score){
		if(score >= 90){
			return "A";
		} else if(score >= 80){
			return "B";
		} else if(score >= 70) {
			return "C";
		} else {
			return "F";
		}
	}
/* 삼항 연산자 */
	String getEvenOdd(int num){
		return (num % 2 == 0)?"짝수":"홀수";
	}
	
	/* String getEvenOdd(int num){
		if(num % 2 == 0){
			return "짝수";
		} else {
			return "홀수";
		}
	} */
	// 정수를 1개를 전달받아, 정수가 짝수라면 "짝수" 홀수라면 "홀수"라는
	// 문자열을 반환하는 getEvenOdd() 메서드 정의 후 호출

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 예제</title>
</head>
<body>
	<h2>선언문예제</h2>
	<%-- 위에서 선언한 메서드 호출 --%>
	<p>85점의 학점 : <%= getGrade(85) %></p>
	<p>75점의 학점 : <%= getGrade(75) %></p>
	<p>55점의 학점 : <%= getGrade(55) %></p>
	<hr>
	<p>44 숫자는 <%= getEvenOdd(44) %>입니다.</p>
	<p>21 숫자는 <%= getEvenOdd(21) %>입니다.</p>
	<p>15 숫자는 <%= getEvenOdd(15) %>입니다.</p>
	<p>16 숫자는 <%= getEvenOdd(16) %>입니다.</p>
</body>
</html>