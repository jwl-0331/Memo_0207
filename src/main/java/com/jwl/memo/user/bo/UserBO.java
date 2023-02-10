package com.jwl.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.memo.common.EncryptUtils;
import com.jwl.memo.user.dao.UserDAO;
import com.jwl.memo.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public int addUser(
			String loginId
			,String password
			,String name
			,String email) {
		
		//암호화
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	// 사용자 정보로 할것이 있다  사용자 정보 통째로 가져온다
	public User getUser(
			String loginId
			, String password) {
		String encryptPassword = EncryptUtils.md5(password);
		return userDAO.selectUser(loginId, encryptPassword);
	}
}
