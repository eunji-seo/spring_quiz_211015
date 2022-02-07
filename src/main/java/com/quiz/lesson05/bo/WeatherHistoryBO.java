package com.quiz.lesson05.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.WeatherHistoryDAO;
import com.quiz.lesson05.model.Weatherhistory;
@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryDAO whDAO;
	
	public void addWearherHistory(Weatherhistory weather) {
		whDAO.insertWearherHistory(weather);
	}
	
	public Weatherhistory getWearherHistory(int id) {
		return whDAO.selectWearherHistory(id);
	}
}
