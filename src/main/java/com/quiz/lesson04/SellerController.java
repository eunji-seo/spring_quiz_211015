package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;
@RequestMapping("/lesson04/quiz01")
@Controller
public class SellerController {

	
	@Autowired
	private SellerBO sellerBO;
	
	
	// http://localhost/lesson04/quiz01/1
	@RequestMapping(path ="/1", method = RequestMethod.GET) 
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	
	//http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String add_seller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl,
			@RequestParam(value = "temperature" , required = false ) Double temperature
			) {
		

		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return"lesson04/afterAddSeller";
	}
	
	// http://localhost/lesson04/quiz01/seller_info?id=1
	//http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String seller_info(Model model ,
			@RequestParam(value = "id", required = false) Integer id
			) {
		
		
		if(id == null) {
			Seller LastSeller = sellerBO.getLastSeller();
			model.addAttribute("result", LastSeller);
				
		} else {
			Seller SellerId = sellerBO.getSeller(id);	
			model.addAttribute("result2", SellerId);
			
		}
		
		return "lesson04/addInfo";
		
		
	}
	
	
	
}
