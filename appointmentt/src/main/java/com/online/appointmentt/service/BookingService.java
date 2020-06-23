package com.online.appointmentt.service;

import java.util.List;
import com.online.appointmentt.model.BookingDetail;

public interface BookingService {
	
	BookingDetail save(BookingDetail bookingdetail);
	List <BookingDetail> findAll();
	void deleteById(long id);
	//BookingDetail validateBooking();
}
