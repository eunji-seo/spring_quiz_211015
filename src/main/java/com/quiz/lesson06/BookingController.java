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

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	//http://localhost/lesson06/booking_list_view
	@RequestMapping("/lesson06/booking_list_view")
	public String bookingList(Model model) {
		
		List<Booking> booking= bookingBO.getBookingList(); 
		
		model.addAttribute("booking", booking);
		return "lesson06/booking_list";
	}
	
	@PostMapping("/lesson06/delete_booking")
	@ResponseBody
	public Map<String, String> bookingDelete(
			@RequestParam("id") int id
			){
		int bookingRowCut = bookingBO.deleteBookingById(id);
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		if(bookingRowCut < 1) {
			result.put("result", "fail");
		}
		return result;
		
	}
	//http://localhost/lesson06/add_booking_view
	@RequestMapping("/lesson06/add_booking_view")
	public String addBookingView() {
		return"lesson06/add_booking";
	}
	
	//http://localhost/lesson06/add_booking
	@PostMapping("/lesson06/add_booking")
	@ResponseBody
	public Map<String, String> addBooking(
			@RequestParam("name")String name,
			@RequestParam("date")String date,
			@RequestParam("day")int day,
			@RequestParam("headcount")int headcount,
			@RequestParam("phoneNumber")String phoneNumber
			){
		//insert
		
		bookingBO.addBookingList(name, date, day, headcount, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}

	//http://localhost/lesson06/lookup_booking_view
		@RequestMapping("/lesson06/lookup_booking_view")
		public String lookupBooking() {
			return"lesson06/lookup_booking";
		}
	
		@PostMapping("")
		@ResponseBody
		public List<Booking> lookupBookingList(){
			
		}

}
