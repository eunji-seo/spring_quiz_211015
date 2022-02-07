package com.quiz.lesson05.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.model.Weatherhistory;
@Repository
public interface WeatherHistoryDAO {

	public void insertWearherHistory(Weatherhistory weather);
	
	
	public Weatherhistory selectWearherHistory(int id);
}
