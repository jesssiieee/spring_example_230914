package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// url : http://localhost/lesson03/ex03?id=24&review=도미노피자는 역시 맛있어~
	// id가 24번인 행의 review를 수정 
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id")int id , 
			@RequestParam("review") String review) {
		
		int rowCount =  reviewBO.updateReviewById(id, review);
		return "변경완료 :  " + rowCount;
		
	}
	
}
