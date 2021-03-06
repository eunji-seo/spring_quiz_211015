package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		
		model.addAttribute("booking", booking); // 서버는 => 원본 data > 받아서 처리 => view
		return "lesson06/booking_list";
	}
	// 예약 삭제
	@DeleteMapping("/lesson06/delete_booking")
	@ResponseBody // data String ajax 
	public Map<String, String> deleteBooking(
			@RequestParam("id") int id
			){
		
		// delete query
		int count = bookingBO.deleteBookingById(id);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		if(count < 1) {
			result.put("result", "fail");
		}
		return result;
		
	}
	//http://localhost/lesson06/add_booking_view
	@RequestMapping("/lesson06/add_booking_view")
	public String addBookingView() {
		return"lesson06/add_booking";
	}
	// 예약하기 추가 - AJAX
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
		
		int count = bookingBO.addBookingList(name, date, day, headcount, phoneNumber);
		// state: 대기중 (Mapper)
		
		
		// result Map => json
		Map<String, String> result = new HashMap<>();
		result.put("result", "success"); 
		result.put("code", "1"); // 코드로 판별 가능 
		
		if(count < 1) {
			result.put("result", "fail");
			result.put("code", "500");
		}
		
		return result;
	}

	//http://localhost/lesson06/lookup_booking_view
		@RequestMapping("/lesson06/lookup_booking_view")
		public String lookupBooking() {
			return"lesson06/lookup_booking";
		}
	
		// 예약 조회 - AJAX
		@ResponseBody
		@PostMapping("/lesson06/look_up_booking")
		public Map<String, Object> lookUpBooking(
				@RequestParam("name") String name,
				@RequestParam("phoneNumber") String phoneNumber				
				){
			// DB select by name, phoneNumber
			
			Booking booking = bookingBO.getBookingByNameAndPhoneNumber(name, phoneNumber);
			// 결과 map -> json
			Map<String, Object> result = new HashMap<>();
			
			
			if(booking != null) {
				// 성공시 
				// {"result" : "success",
				//	"code" : "1",
				//  "booking" : {"name": 신보람, "phoneNumber": 010-1234-5678 }}
				result.put("result", "success");
				result.put("code", 1);
				result.put("booking", booking);
				
			} else {
				// 실패시 
				//{ "result" : "fail", "code":"500", "message": "에러 원인"}
				result.put("result", "fail");
				result.put("code", 500);
			}
			
			
			return result;
			
		}

}
