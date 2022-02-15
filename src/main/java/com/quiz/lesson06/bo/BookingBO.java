package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.dao.BookingDAO;
import com.quiz.lesson06.model.Booking;

@Service
public class BookingBO {
	
	@Autowired
	private BookingDAO bookingDAO;
	
	public List<Booking> getBookingList() {
		return bookingDAO.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingDAO.deleteBookingById(id);
	}
	
	public int addBookingList(String name, String date, int day, int headcount, String phoneNumber) {
		return bookingDAO.insertBookingList(name, date, day, headcount, phoneNumber);
	}
	
	public Booking getBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingDAO.selectBookingByNameAndPhoneNumber(name, phoneNumber);
		Booking booking = null; //  없을때 null
		// 마지막 것 한나만 꺼내서 
		if(bookingList.isEmpty() == false) {// 데이터가 있을떄 booking 
			booking = bookingList.get(bookingList.size() - 1); // 리스트	
		}
		return booking;
	}
}
