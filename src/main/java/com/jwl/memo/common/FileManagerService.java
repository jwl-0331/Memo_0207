package com.jwl.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	
	//다른 곳에서 변수 명을 사용할 수있게 static 변수 (객체 생성없이 사용가능)
	//final : 값은 수정될 수없다
	public static final String fileUploadPath = "C:\\Users\\mm940\\Documents\\lecture\\webProjectMemo\\images";

	//파일을 저장하고, 클라이언트에서 접근 가능한 주소를 만들어서 리턴 하는 기능
	public static String saveFile(int userId,MultipartFile file) {
		
		//파일 저장		
		//사용자 별로 폴더를 구분한다.
		//사용자 별로 폴더를 새로 만든다.
		//폴더 이름 : userId_현재시간
		//UNIX TIME : 1970년 1월 1일부터 흐른 시간 (millisecond 1/1000)
		//C:\Users\mm940\Documents\lecture\webProjectMemo\images\\2_142485124\\asdf.png
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis() + "/";
		
		//디렉토리 생성
		String directoryPath = fileUploadPath + directoryName;
		
		//파일 객체 생성
		File directory = new File(directoryPath);
		
		if(directory.mkdir() == false) {
			//디렉토리 생성 실패
			return null;
		}
		
		//파일 다루기 까다롭다 문제 생길 가능성을 관리를 해주어야한다
		
		//파일 저장
		try {
			byte[] bytes = file.getBytes();
			
			String filePath = directoryPath + file.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
		//클라이언트에 접근 가능한 경로를 문자열로 리턴
		
		//규칙 정해주기 http://localhost:8090/images/~
		// /images/2_38239823/test.png
		return "/images" + directoryName + file.getOriginalFilename();
	}
	
	// 파일 삭제 메소드
	public static boolean removeFile(String filePath) {
		//삭제 경로 /images 를 제거하고
		// 실제 파일 저장 경로에 이어 붙여준다.
		// "C:\\Users\\mm940\\Documents\\lecture\\webProjectMemo\\images";
		// filePath 에서 /images 를 제거
		String realFilePath = fileUploadPath + filePath.replace("/images", "");
		Path path = Paths.get(realFilePath);
		
		//파일이 존재하는지 확인
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return false;
			}
		}
		
		// 디렉토리 삭제 (파일이름 빼고 파일이름은 파일마다 이름이 다르다)
		// 파일의 디렉토리 경로를 리턴
		Path dirPath = path.getParent();
		//디렉토리 존재하는지
		if(Files.exists(dirPath)) {
			try {
				Files.delete(dirPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return false;
			}
		}
		
		return true;
	}
}
