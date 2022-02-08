package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.model.Favorite;

public interface FavoriteDAO {

	public void insertFavoriteList(
			@Param("name") String name, 
			@Param("url") String url); 
	
	public List<Favorite> selectFavoriteList();
}
