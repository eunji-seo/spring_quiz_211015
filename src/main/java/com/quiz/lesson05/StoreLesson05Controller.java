package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.bo.StoreLesson05BO;
import com.quiz.lesson05.model.Store;

@Controller
public class StoreLesson05Controller {
	
	@Autowired
	private StoreLesson05BO storeBO;
	
	//http:localhost/store_view
	@RequestMapping("/store_view")
	public String storeView(Model model) {
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		
		return "store/store_view";
	}
	
}
