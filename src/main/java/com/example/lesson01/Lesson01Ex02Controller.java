package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안된다.
public class Lesson01Ex02Controller {

	// url : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // Request path 주소
	public String ex02() {
		// return 되는 String은 jsp의 경로이다. (@Response Body가 없을 때)
		// return "/WEB-INF/jsp/lesson01/ex02.jsp"
		// application.properties에 추가된 경로를 제외하고 작성
		return "lesson01/ex02"; // Response view 경로
	}
	
}
