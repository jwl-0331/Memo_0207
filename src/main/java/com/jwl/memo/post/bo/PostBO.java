package com.jwl.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.memo.post.dao.PostDAO;
import com.jwl.memo.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	public int addPost(int userId,String title, String content) {
		//BO 입장에서도 id 못얻어온다 
		return postDAO.insertPost(userId, title, content);
	}
	
	public List<Post> getPostList(int userId) {
		return postDAO.selectPostList(userId);
	}
	
	public Post getPost(int postId) {
		return postDAO.selectPost(postId);
	}
}
