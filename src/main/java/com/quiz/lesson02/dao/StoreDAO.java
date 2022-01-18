package com.quiz.lesson02.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StoreDAO {

	public List<Store> selectStoreList();
}
