package com.online.appointmentt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.online.appointmentt.model.BookingDetail;

public interface BookingService {
	
	BookingDetail save(BookingDetail bookingdetail);
	List <BookingDetail> findAll();
	void deleteById(long id);
	Optional < BookingDetail > findById(long id);
	//List<BookingDetail> getIdByBookingDate(Date booking_date);
}
