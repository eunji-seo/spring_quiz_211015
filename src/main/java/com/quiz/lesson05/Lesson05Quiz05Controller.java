package com.quiz.lesson05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.Weatherhistory;

@Controller
public class Lesson05Quiz05Controller {
	
	@Autowired
	private WeatherHistoryBO whBO;

	//http:localhost/lesson05/quiz05
	@RequestMapping("/lesson05/quiz05")
	public String quiz05() {
		return "lesson05/quiz05";
	}
	//http:localhost/lesson05/quiz05
	@PostMapping("/lesson05/quiz05/info")
	public String quiz05Info(
			@ModelAttribute Weatherhistory weather,
			Model m) {
		//insert
		whBO.addWearherHistory(weather);
		
		
		//select
		Weatherhistory	result = whBO.getWearherHistory(weather.getId());
		m.addAttribute("result", result);
		
		return"lesson05/quiz05Info";
	}
}
