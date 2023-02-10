package com.jwl.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	//객체를 생성할 필요없이 사용한다 : static
	// 멤버 변수가 없다면 -> static을 통해 객체 생성없이 메소드 호출해서 사용
	//암호화 기능
	public static String md5(String message) {
		//만들어진 문자열을 이어붙일 변수
		String resultData="";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			//바이트 단위로 바꿈
			byte[] bytes = message.getBytes();
			//암호화 진행
			md.update(bytes);
			
			byte[] digest = md.digest();
			
			//16진수 형태의 문자열로 변환
			for(int i = 0 ; i < digest.length; i++){
				resultData += Integer.toHexString(digest[i] & 0xff);
				//비트연산
				//01011100
				//11111111
				//01011100
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultData;
	}
}
