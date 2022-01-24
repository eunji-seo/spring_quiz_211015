package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
@RequestMapping("/lesson04/quiz01")
@Controller
public class sellerController {

	
	@Autowired
	private SellerBO sellerBO;
	
	
	// http://localhost/lesson04/quiz01/1
	@RequestMapping(path ="/1", method = RequestMethod.GET) 
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	
	//http://localhost/lesson04/quiz01/1
	@PostMapping("/add_seller")
	public String quiz01_1(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl,
			@RequestParam(value = "temperature" , required = false ) Double temperature
			) {
		

		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return"lesson04/afterAddSeller";
	}
}
