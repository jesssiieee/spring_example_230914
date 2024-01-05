package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07")
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// url : http://localhost/lesson07/ex01/1
	@GetMapping("/ex01/1")
	public StudentEntity create() {
		
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "bada@naver.com";
		String dreamJob = "개발자";
		
		// 방금 insert 된 PK id도 바로 얻어낼 수 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
		
	}
	
}
