package com.quiz.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.StoreLesson05DAO;
import com.quiz.lesson05.model.Store;

@Service
public class StoreLesson05BO {

	@Autowired
	private StoreLesson05DAO storeDAO;
	
	public List<Store> getStoreList(){
		return storeDAO.selectStoreList(); 
	}
}
