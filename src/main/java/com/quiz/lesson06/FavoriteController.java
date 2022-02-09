package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@Controller
public class FavoriteController {

	@Autowired
	private FavoriteBO favoriteBO;
	
	//http://localhost/lesson06/add_favorite_view
	@RequestMapping("/lesson06/add_favorite_view")
	public String quiz01() { // view의 경로가 되는 String 
		return"lesson06/add_favorite";
	}
	
	// 즐겨찾기 추가 기능 - AJAX 호출로 들어오는 요청
	@PostMapping("lesson06/add_favorite")
	@ResponseBody	// Model 사용 불가 (view 에서만 사용가능)
	public Map<String, String> addFavorite(  // map으로 return => json때문에 
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		
		// insert
		 favoriteBO.addFavoriteList(name, url);
		// select
		favoriteBO.getFavoriteList();
		
		
		// return map => return json string 
		Map<String,String> result = new HashMap();
		result.put("result", "success");
		result.put("code", "1");
		
		return result;
	}
	
}