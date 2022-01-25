package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.SellerDAO;
import com.quiz.lesson04.model.Seller;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public void addSeller(String name, String profileImageUrl, double temperature) {
		sellerDAO.insertSeller(name, profileImageUrl, temperature);
	} // 몇행이 잘들어갔는지 확인시 int 
	
	public Seller getLastSeller() { // map 으로 가져올수 있으나, 컬럼의 객체를 가져오는게 좋음 
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSellerById(Integer id) {
		return sellerDAO.selectSellerById(id);
	}
}