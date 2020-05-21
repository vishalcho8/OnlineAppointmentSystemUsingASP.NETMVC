package mvc.onlineAppointmentSys.repository;

import mvc.onlineAppointmentSys.model.BookingDetail;

public interface BookingRepo {
	BookingDetail validateAppt(BookingDetail bookingdetail);
	int insertAppointment(BookingDetail bookingdetail);
}
