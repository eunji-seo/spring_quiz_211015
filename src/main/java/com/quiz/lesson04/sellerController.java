package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
@RequestMapping("/lesson04")
@Controller
public class sellerController {

	
	@Autowired
	private SellerBO sellerBO;
	
	
	// http://localhost/lesson04/add_seller_view
	@RequestMapping(path ="/add_seller_view", method = RequestMethod.GET) 
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	
	//http://localhost/lesson04/quiz01/1
	@PostMapping("/lesson04/quiz01/1")
	public String quiz01_1(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl,
			@RequestParam(value = "temperature" , required = false ) Double temperature
			) {
		

		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return"lesson04/afterAddSeller";
	}
}
