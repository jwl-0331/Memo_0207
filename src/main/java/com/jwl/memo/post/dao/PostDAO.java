package com.jwl.memo.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {
	
	public int insertPost(
			@Param("userId") int userId
			, @Param("title")String title
			, @Param("content") String content);
}
