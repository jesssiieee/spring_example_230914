package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString 					// 객체 출력 시, 필드 값이 보여진다.
@AllArgsConstructor 		// 파라미터가 모두 있는 생성자
@NoArgsConstructor  		// 파라미터가 없는 생성자
@Builder(toBuilder = true) 	// setter 대신 사용, toBuilder=true 필드값 변경 허용
@Getter
@Table(name = "student") 	// student_entity라는 테이블 명이 아니다라고 지정해줘야한다.
@Entity 					// 이 객체는 entity다. (JPA - DB)
public class StudentEntity { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 	// MYSQL auto_increment
	private int id;
	
	private String name;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createdAt이 null 이어도, 현재시간으로 저장
	@Column(name="createdAt", updatable = false) // insert때의 최초 시간만 넣고 update시 시간 수정이 안되도록 수정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp // .. 
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
	
	
}
