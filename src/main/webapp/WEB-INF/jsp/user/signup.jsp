<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		<section class="contents d-flex justify-content-center">
			<!--  위아래 동시 마진 my -->
			<div class="join-box my-5">
				<h2 class="text-center">회원가입</h2>
				<input type="text" placeholder="아이디" class="form-control mt-2" id="idInput">
				<input type="password" placeholder="비밀번호" class="form-control mt-2" id="passwordInput">
				<input type="password" placeholder="비밀번호 확인" class="form-control mt-2" id="passwordChkInput">
				<input type="text" placeholder="이름" class="form-control mt-2" id="nameInput">
				<input type="text" placeholder="이메일" class="form-control mt-2" id="emailInput">
				<button type="button" class="btn btn-primary btn-block mt-2" id="joinBtn">가입</button>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	<script>
		$(document).ready(function(){
			$("#joinBtn").on("click",function(){
				let id = $("#idInput").val();
				let password = $("#passwordInput").val();
				let passwordChk = $("#passwordChkInput").val();
				let name = $("#nameInput").val();
				let email = $("#emailInput").val();
				let urlAddress = [".co.kr",".com",".net",".or.kr","go.kr"];
				let check1 = false;
				let check2 = false;
				if(id == "" ){
					alert("id를 입력하세요");
					return;
				}
				if(password == "" ){
					alert("비밀번호를 입력하세요");
					return;
				}
				if(password != passwordChk){
					alert("비밀번호가 일치하지 않습니다.")
					return;
				}
				if(name == "" ){
					alert("이름을 입력하세요");
					return;
				}
				if(email == "" ){
					alert("email을 입력하세요");
					return;
				}
				if(email.indexOf("@") > 0){
					check1 = true;
				}
				for(var i = 0; i < urlAddress.length; i++){
					if(email.indexOf(urlAddress[i]) > 0){
						check2 = true;
					}	
				}
				if(!(check1 && check2)){
					alert("email을 확인하세요");
					return;
				}
				
			});
		});
	</script>
</body>
</html>