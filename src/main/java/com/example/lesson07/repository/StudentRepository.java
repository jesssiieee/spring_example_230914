package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// @Transactional
public interface StudentRepository  extends JpaRepository<StudentEntity, Integer>{
	// JPA // Spring Data JPA
	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	// Spring data JPA

	
	
	// 기본 제공 메소드
	
	// Entity save(Entity) -> 1. insert(id가 null), 2. update(id가 있음)
	// Optional<Entity 객체> findById(id)
	// void delete(Entity)
	// List<Entity> findAll();

	
	
	// ex02/1 - JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	// limit 3 내림차순 
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	// where 이름
	public List<StudentEntity> findByName(String name);
	
	// (이름) 일치하는 값 모두 조회
	public List<StudentEntity> findByNameIn(List<String> names);
	
	// where and
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	// like
	public List<StudentEntity> findByEmailContaining(String email);
	
	// like%
	public List<StudentEntity> findByNameStartingWith(String name);
	
	// between
	public List<StudentEntity> findByIdBetween(int startid, int endid);
	
	

	
	
	
	
}
