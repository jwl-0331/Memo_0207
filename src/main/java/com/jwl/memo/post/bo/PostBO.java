package com.jwl.memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jwl.memo.common.FileManagerService;
import com.jwl.memo.post.dao.PostDAO;
import com.jwl.memo.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	public int addPost(int userId,String title, String content, MultipartFile file) {
		
		String imagePath = FileManagerService.saveFile(userId, file);
		
		//BO 입장에서도 id 못얻어온다 
		return postDAO.insertPost(userId, title, content, imagePath);
	}
	
	public List<Post> getPostList(int userId) {
		return postDAO.selectPostList(userId);
	}
	
	public Post getPost(int postId) {
		return postDAO.selectPost(postId);
	}
	
	public int updatePost(int postId, String title, String content) {
		return postDAO.updatePost(postId, title, content);
	}
	
	public int deletePost(int postId) {
		
		//이미지 경로 얻어와서 이미지도 삭제 - selectPost
		Post post = postDAO.selectPost(postId);
		
		if(post.getImagePath() != null) {
			FileManagerService.removeFile(post.getImagePath());
		}
		return postDAO.deletePost(postId);
	}
}
