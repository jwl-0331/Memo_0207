package com.jwl.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@GetMapping("/list/view")
	public String listView() {
		return "post/list";
	}
	
	@GetMapping("/create/view")
	public String createView() {
		return "post/create";
	}
	
}


