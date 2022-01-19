package com.quiz.lesson02.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;

@Repository
public interface StoreDAO {

	public List<Store> selectStoreList(); // 쿼리를 부르는 매핑 	
} 
