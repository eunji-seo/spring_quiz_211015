package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Booking;


@Repository
public interface BookingDAO {

	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public int insertBookingList(
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public Booking getBookingBy(String name, String phoneNumber);
}

