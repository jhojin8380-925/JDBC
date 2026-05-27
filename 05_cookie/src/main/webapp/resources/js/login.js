// 쿠키에 저장된 이름을 읽어 입력 폼에 자동으로 채운다

// window.onload : html 페이지가 완전히 로드된 후 실행되는 함수

window.onload = function() {
	// 쿠키에서 "saveName"값을 읽어온다
	// getCookie() 함수는 아래에 정의되어 있다
	let saveName = getCookie("saveName");

	// saveName 쿠키가 존재하면 폼 자동 입력 처리
	if (saveName) {
		//id가 memberName 인 input 요소를 가져옴
		document.getElementById("memberName").value = saveName;
		
		//아이디 저장 체크박스도 체크 상태로 바꾼다
		document.getElementById("saveId").checked = true;
	}
}

// getCookie(name) : 이름으로 쿠키 값을 찾아 반환하는 함수
// 없으면 null 반환 

function getCookie(name) {
	
	// document.cookie : 현재 페이지에서 사용 가능한 모든 쿠키를 문자열로 반환
	// e) "saveName=홍길동; theme=dark; lang=ko"
	// split(";") : ";" 기준으로 잘라 배열로 만듦
	let cookies = document.cookie.split(";")
	
	for(let i = 0; i < cookies.length; i++){
		//trim() : 앞뒤 공백 제거
		let cookie = cookies[i].trim();
		
		// "이름="으로 시작하는 쿠키를 찾는다
		if(cookie.startsWith(name+"=")){
			let encodedValue = cookie.substring(name.length+1);
			//console.log(encodedValue)
			
			//decodeURIComponent() : 서버에서 URLEncoder로 인코딩된 한글을 다시 원래글자로 복원
			//다시 원래 글자로 복원
			return decodeURIComponent(encodedValue);
		}
	}
	// 이름이 일치하는 쿠키가 없으면 null 반환
	return null;
	
	
	
}