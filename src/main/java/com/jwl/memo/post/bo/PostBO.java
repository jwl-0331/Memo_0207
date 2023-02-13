package com.jwl.memo.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostBO {
	
	@Autowired
	private PostBO postBO;
	public int addPost(int userId,String title, String content) {
		//BO 입장에서도 id 못얻어온다 
		return postBO.addPost(userId, title, content);
	}
}
