package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Quiz05Controller {

	//http:localhost/lesson05/quiz05
	@RequestMapping("/lesson05/quiz05")
	public String quiz05() {
		
		
		return "lesson05/quiz05";
	}
	
	
}
