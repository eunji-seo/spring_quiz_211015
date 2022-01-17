package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Quiz02RestController {

	// http://localhost/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1 () {
		List<Map<String, Object>> movieInfo = new ArrayList<>();
		Map<String, Object> movie1 = new HashMap<>();
		movie1.put("rate", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");
		movieInfo.add(movie1);
		
		Map<String, Object> movie2 = new HashMap<>();
		movie2.put("rate", 0);
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		movieInfo.add(movie2);
		
		Map<String, Object> movie3 = new HashMap<>();
		movie3.put("rate", 12);
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		movieInfo.add(movie3);
		
		Map<String, Object> movie4 = new HashMap<>();
		movie4.put("rate", 19);
		movie4.put("director", "프란시스 로렌스");
		movie4.put("time", 137);
		movie4.put("title", "헝거게임");
		movieInfo.add(movie4);
		
		
		return movieInfo;
	}
		// http://localhost:8080/lesson01/quiz02/2
		@RequestMapping("/2")
		public List<Quiz02Json> quiz02_2(){
			List<Quiz02Json> list = new ArrayList<>();
			
			Quiz02Json quiz02json = new Quiz02Json();
			quiz02json.setTitle("안녕하세요 가입인사 드립니다.");
			quiz02json.setUser("hagulu");
			quiz02json.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
			list.add(quiz02json);
			
			quiz02json = new Quiz02Json();
			quiz02json.setTitle("헐대박");
			quiz02json.setUser("baba");
			quiz02json.setContent("오늘 목요일이 있어...금요일인증");
			list.add(quiz02json);
			
			quiz02json = new Quiz02Json();
			quiz02json.setTitle("오늘 데이트 한 이야기 해드릴게요.");
			quiz02json.setUser("dulumary");
			quiz02json.setContent("......");
			list.add(quiz02json);
			
			return list;
		}
	
		// http://localhost:8080/lesson01/quiz02/3
		@RequestMapping("/3")
		public  ResponseEntity<Quiz02Json> quiz02_3(){
			Quiz02Json quiz02json = new Quiz02Json();
			quiz02json.setTitle("안녕하세요 가입인사 드립니다.");
			quiz02json.setUser("hagulu");
			quiz02json.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
			
			
			return  new ResponseEntity<>(quiz02json, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
			
}
