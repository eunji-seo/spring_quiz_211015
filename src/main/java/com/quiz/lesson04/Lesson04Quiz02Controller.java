package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.model.Realtor;

@Controller
public class Lesson04Quiz02Controller {
	
	//http://localhost/lesson04/quiz02/1
	@RequestMapping("/lesson04/quiz02/1")
	public String quiz02_1() {
		return "lesson04/addRealtor";
	}
	
	//http://localhost/lesson04/quiz02/add_realtor
	@GetMapping("/lesson04/quiz02/add_realtor")
	public String add_realtor(
			@ModelAttribute Realtor realtor
			) {
		
		// DB insert
		
		// DB select
		
		return ""; // 
	}
	
}
