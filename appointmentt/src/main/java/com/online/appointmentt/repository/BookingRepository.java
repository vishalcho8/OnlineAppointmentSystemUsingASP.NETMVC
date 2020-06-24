package com.online.appointmentt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.online.appointmentt.model.BookingDetail;

public interface BookingRepository extends JpaRepository<BookingDetail, Long> {

	BookingDetail save(BookingDetail bookingdetail);
	List<BookingDetail> findAll();
	void deleteById(long id);
	Optional < BookingDetail > findById(long id);
}
