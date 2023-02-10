<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
				<input type="text" placeholder="아이디" class="form-control mt-2" id="idInput">
				<input type="password" placeholder="비밀번호" class="form-control mt-2" id="passwordInput">
				<button type="button" class="btn btn-primary btn-block mt-2" id="loginBtn">로그인</button>
				<div class="text-center mt-4"><a href="/user/signup/view">회원가입</a></div>
			</div>				
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>
	<script>
		$(document).ready(function(){
			
			$("#loginBtn").on("click",function(){
				let id = $("#idInput").val();
				let password = $("#passwordInput").val();
				
 				if(id == "" ){
					alert("id를 입력하세요");
					return;
				}
				if(password == "" ){
					alert("비밀번호를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/user/signin"
					, data:{"loginId":id, "password":password}
					, success:function(data){
						if(data.result == "success"){
							location.href="/post/list/view";
						} else{
							alert("아이디 또는 비밀번호를 확인해 주세요");
						}
					}
					, error:function(){
						alert("로그인 에러발생");
					}
				});
			});
		});
	</script>
</body>
</html>