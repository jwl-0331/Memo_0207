package com.jwl.memo.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jwl.memo.post.bo.PostBO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
public class PostRestController {
	@Autowired
	private PostBO postBO;
	@PostMapping("/create" )
	public Map<String, String>postCreate(
			@RequestParam("title")String title
			,@RequestParam("content") String content
			,@RequestParam("file") MultipartFile file
			, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		//로그인된 사용자의 user 테이블의 id 컬럼값
		//setAttribute ->String , Object 로 저장된다 upcasting 을통해 파라미터를 전달 받는다
		//get 도 Object 로 리턴 따라서 int 로 형변환 downcasting (다형성)
		int userId = (int) session.getAttribute("userId");
		int count = postBO.addPost(userId, title, content, file);
		Map<String, String> map = new HashMap<>();
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@PostMapping("/update")
	public Map<String, String>modifyMemo(
			@RequestParam("postId")int postId
			,@RequestParam("title") String title
			,@RequestParam("conetent") String content) {
		
		int count = postBO.updatePost(postId, title, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/delete")
	public Map<String, String>deleteMemo(@RequestParam("postId")int postId) {
		
		int count = postBO.deletePost(postId);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
