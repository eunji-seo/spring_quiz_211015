package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class RealEstateQuiz02RestControllet {
	
	@Autowired
	private RealEstateBO realEstateBO;
 	//http://localhost/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		realEstate.setRentPrice(null);
		
		int rowCount = realEstateBO.addRealEstate(realEstate);
		return "입력성공:" + rowCount;
	}
}