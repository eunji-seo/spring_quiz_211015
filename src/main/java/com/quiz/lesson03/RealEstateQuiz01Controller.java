package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RestController
public class RealEstateQuiz01Controller {

	@Autowired
	private RealEstateBO realEstateBO;
	
	//http://localhost/lesson03/quiz01/1 
	//http://localhost/lesson03/quiz01/1?id=20
	//http://localhost/lesson03/quiz01/2?rentPrice=100
	//http://localhost/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/lesson03/quiz01/3")
	public List<RealEstate> quiz01_2(
			//@RequestParam("id") int id
			//@RequestParam(value="rentPrice",required=false) Integer rentPrice
			@RequestParam(value="area" ,required=true) int area ,// 필수 파라미터
			@RequestParam(value="price",required=true) int price
			){
		return realEstateBO.getRealEstateList(area, price); 
	}
}
