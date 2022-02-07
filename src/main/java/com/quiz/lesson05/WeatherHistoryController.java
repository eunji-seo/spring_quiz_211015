package com.quiz.lesson05;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson05.bo.WeatherHistoryBO;
import com.quiz.lesson05.model.Weatherhistory;

@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherhistoryBO;

	// request -> 서버 -> response
	// 날씨 정보 목록
	//http:localhost/weather_history_view
	@RequestMapping("/weather_history_view") // get
	public String WeatherHistoryview(Model model) {
		List<Weatherhistory> Weatherhistorylist = weatherhistoryBO.getWeatherHistoryList();
		model.addAttribute("Weatherhistorylist", Weatherhistorylist);
		
		return "weather_history/weather_history";
	}
	
	// 날씨 정보 입력 화면
	//http:localhost/add_weather_history_view
	@RequestMapping("/add_weather_history_view")
	public String addWeatherHistoryView() {
		return"weather_history/add_weather_history";
	}
	
	// 날씨 입력 => 결과 : 날씨 정보 목록 화면으로 리다이렉트
	@PostMapping("/add_weather_history")
	public String addWeatherHistory(
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust, 
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed,
			HttpServletResponse response) {
		
		//DB insert
		weatherhistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		//날씨 정보 목록 화면으로 리다이렉트 
		//response.sendRedirect("/weather_history_view");
		return "redirect:/weather_history_view";
		
	}
	
}
