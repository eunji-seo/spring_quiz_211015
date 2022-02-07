package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.Weatherhistory;

@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherhistoryBO;

	// request -> 서버 -> response
	//http:localhost/weather_history_view
	@RequestMapping("/weather_history_view") // get
	public String WeatherHistoryview(Model model) {
		List<Weatherhistory> Weatherhistorylist = weatherhistoryBO.getWeatherHistoryList();
		model.addAttribute("Weatherhistorylist", Weatherhistorylist);
		
		return "weather_history/weather_history";
	}
	
}
