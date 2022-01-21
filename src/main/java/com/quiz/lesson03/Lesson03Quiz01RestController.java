package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;
@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	//http://localhost/lesson03/quiz01/1 
	//http://localhost/lesson03/quiz01/1?id=20
	
	
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam(value="id") int idParam // 
			
			){
		return realEstateBO.getRealEstateById(idParam); // jackson라이브러리로 인해 json으로 변환
	}
	//http://localhost/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
				@RequestParam(value="rent_price") int rentPrice
				){
		return realEstateBO.getRealEstateListByRentPrince(rentPrice); // jackson라이브러리로 인해 json으로 변환
	}
	//http://localhost/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam(value="area" , required=true) int area ,// 필수 파라미터
			@RequestParam(value="price") int price 
			){
		 return realEstateBO.getRealEstateListByAreaAndPrice(area, price); // 순서 중요 , breakpoint는 실제 수행 되는 곳에 표시한다
		}
	
}
