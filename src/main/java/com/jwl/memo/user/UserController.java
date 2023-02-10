package com.jwl.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/signup/view")
	public String signupView() {
		
		return "user/signup";
	}
	
	@GetMapping("/signin/view")
	public String signinView() {
		return "user/signin";
	}
	
	@GetMapping("/signout")
	public String signout(HttpServletRequest request) {
		//로그아웃
		//로그인 저장된 세션값 제거
		//session을 사용하려면 객체가 필요 리퀘스트를 통해 객체 생성
		HttpSession session = request.getSession();
		
		//원하는 키를 기반으로 제거 - ("userId", "userName") 제거
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/signin/view";
	}
}
