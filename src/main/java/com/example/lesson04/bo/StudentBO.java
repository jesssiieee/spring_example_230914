package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;

	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(
			String name, String phoneNumber, 
			String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면, 생략가능
				.build();
		
		return studentRepository.save(student);
		
	}
	
	// MyBatis로 insert
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// JPA로 업데이트
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		
		// select
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// update - save()
		if (student != null){
			student = student.toBuilder() // 기존 필드값들은 유지하고, 일부 필드만 변경
				.dreamJob(dreamJob)
				.build(); // ★★★ 반드시 다시 저장한다!! ★★★
			
			// update
			student = studentRepository.save(student);
		}
		
		return student; // student or null
		
	}
	
	// JPA로 delete
	public void deleteStudentById(int id) {
		
		// 삭제할 대상 select
		// 방법 1)
//		StudentEntity student =  studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// delete 방법 2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
		
	}

	
	// Mybatis
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}
