package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	//http://localhost/lesson06/booking_list_view
	@RequestMapping("/lesson06/booking_list_view")
	public String bookingList(Model model) {
		
		List<Booking> result= bookingBO.getbookingList(); 
		
		model.addAttribute("result", result);
		return "booking/booking_list";
	}
	


}
