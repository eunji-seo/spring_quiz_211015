package com.quiz.lesson03.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;

@Repository
public interface RealEstateDAO {

	public List<RealEstate> selectRealEstateList();
}
