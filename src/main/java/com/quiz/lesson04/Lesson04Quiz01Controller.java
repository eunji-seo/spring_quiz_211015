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
public class Lesson04Quiz01Controller {

	
	@Autowired
	private SellerBO sellerBO;
	
	
	// http://localhost/lesson04/quiz01/1 
	@RequestMapping(path ="/1", method = RequestMethod.GET) // view 화면은 get으로 주로 사용함  
	public String quiz01_1() {
		return "lesson04/addSeller"; // pre,suffix 가 있어서 / 생략가능함 
	}
	
	
	//http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String add_seller(  
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl,
			@RequestParam(value = "temperature" ) double temperature
			) {
		
		// DB insert 
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return"lesson04/afterAddSeller";  // String => @ResponseBody 가 없어 view 의 경로가 됨 
	}
	
	//http://localhost/lesson04/quiz01/seller_info?id=1
	//http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String seller_info(Model model ,     // Model 객체는 Controller 에서 생성된 데이터를 담아 View 로 전달할 때 사용하는 객체이다.
			@RequestParam(value = "id", required = false) Integer id
			) {
		
		
		if(id == null ) {
			Seller LastSeller = sellerBO.getLastSeller();
			model.addAttribute("result", LastSeller);
				
		} else {
			Seller SellerId = sellerBO.getSellerById(id);	
			model.addAttribute("result", SellerId);
			
		}
		
		return "lesson04/sellerInfo";
		
		
	}
	
	
	
}
