package com.online.appointmentt.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.appointmentt.model.BookingDetail;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetail, Long> {

	BookingDetail save(BookingDetail bookingdetail);
	List<BookingDetail> findAll();
	void deleteById(long id);
	Optional < BookingDetail > findById(long id);
	
	@Query("SELECT b FROM BookingDetail b WHERE b.booking_date = ?1 and b.booking_time_from < ?3 and b.booking_time_to > ?2")
    public List<BookingDetail> getIdByBookingDate(Date booking_date, String booking_time_from, String booking_time_to); 
}
