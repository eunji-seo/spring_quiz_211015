package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private FavoriteBO favoriteBO;  
	// http://localhost/lesson06/quiz01
	@RequestMapping("/lesson06/quiz01")
	public String quiz01() {
		return"lesson06/view_favorite";
	}
	
	@RequestMapping("lesson06/add_favorite")
	public String addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url,
			Model model) {
		
		
		// insert
		 favoriteBO.addFavoriteList(name, url);
		// select
		 List<Favorite> favorite = favoriteBO.getFavoriteList();
		 model.addAttribute("favorite", favorite);
		return"lesson06/add_favorite"; 
	}
	
}
