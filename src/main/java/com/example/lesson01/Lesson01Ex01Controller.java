package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드 위에 붙은 path보다 먼저 읽혀진다. 
@Controller // Spring bean(객체)으로 등록 
public class Lesson01Ex01Controller {

	// String을 브라우저에 출력
	// url : http://localhost/lesson01/ex01/1
	@ResponseBody // return 되는 값을 Response Body에 넣어 보낸다. => HTML
	@RequestMapping("/1")
	public String ex01_1() {
		return "<h2>예제 1번</h2>문자열을 Response Body로 보내는 예제";
	}
	
	// Map 출력 => JSON String 출력
	// url : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2(){
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("사과", 4);
		map.put("파인애플", 32);
		map.put("블루베리", 10);
		map.put("코코넛", 4);
		
		// map을 return하면 JSON으로 나타난다.
		// web starter에 jackson 라이브러리가 포함되어 있기 때문
		return map;
	}
	
}
