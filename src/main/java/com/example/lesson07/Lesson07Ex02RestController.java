package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;


@RestController
@RequestMapping("/lesson07/ex02")
public class Lesson07Ex02RestController {

	// !!! 이 예제의 경우에만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	
	// url : http://localhost/lesson07/ex02/1
	// 조회하는 여러가지 방법
	@GetMapping("/1")
	public List<StudentEntity> getstudentList() {
		// 1. 전체 조회 (기본 제공 메소드)
		// return studentRepository.findAll();
		
		// 2. id 기준 내림차순 전체조회
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3. id 기준 내림차순 limit 3
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4. where 조건 - 이름이 '김바다' 조회
		// return studentRepository.findByName("유재석");
		
		// 5. in문으로 일치하는 값 모두 조회(이름)
		// return studentRepository.findByNameIn(Arrays.asList("유재석", "조세호", "김바다"));
		
		// 6. where and => 여러 컬럼값과 일치하는 데이터 조회(이름, 장래희망)
		// return studentRepository.findByNameAndDreamJob("유재석", "래퍼");
		
		// 7. like => 이메일 도메인 => email 컬럼에 naver 키워드가 포함된 데이터 조회 (%naver%)
		// return studentRepository.findByEmailContaining("naver");
		
		// 8. like% => 이름이 '홍'으로 시작하는 데이터 조회
		// return studentRepository.findByNameStartingWith("홍");
		
		// 9. (where &) between => id가 1번 ~ 5번
		return studentRepository.findByIdBetween(1, 5);
		
		
	}
	
}
