package mvc.onlineAppointmentSys.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import mvc.onlineAppointmentSys.model.BookingDetail;
import mvc.onlineAppointmentSys.model.LoginUser;
public class BookingRepoImpl implements BookingRepo {

	@Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  public int insertAppointment(BookingDetail bookingdetail) {
		  System.out.println("inside insertAppointmnet..");
		  System.out.println("booking id while inserting.." + bookingdetail.getBooking_id());
		  String sql = "insert into booking_details values(?,?,?,?,?,?,?,?)";
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		   Date lv_booked_on = new Date();
		   System.out.println("current time 111..." + formatter.format(lv_booked_on));
		    return jdbcTemplate.update(sql, new Object[] { bookingdetail.getBooking_id(), bookingdetail.getName(), 
		    		bookingdetail.getEmail(), 
		    		bookingdetail.getPhone(),
		    		lv_booked_on,
		    		bookingdetail.getBooking_date(),
		    		bookingdetail.getBooking_time_from(),
		    		bookingdetail.getBooking_time_to()});
		  }	  
	  
	  public BookingDetail validateAppt(BookingDetail bookingdetail) {
		  System.out.println("date in past getbookingdate..." + bookingdetail.getBooking_date());
		  System.out.println("date in past today..." + new Date());
		  float btf = Float.parseFloat(bookingdetail.getBooking_time_from());
		  float btt = Float.parseFloat(bookingdetail.getBooking_time_to());
		 if (bookingdetail.getBooking_date() == null) {
			 bookingdetail.setError_message("Date null");
			  return bookingdetail;
		 } else if (btf > btt || btt < btf || btf == btt) {
			  bookingdetail.setError_message("Time Error");
			  return bookingdetail;
		  } else if(bookingdetail.getBooking_date().compareTo(new Date()) < 0) {
			  bookingdetail.setError_message("Date in past");
			  return bookingdetail;
		  } else {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    String strbookingdate= formatter.format(bookingdetail.getBooking_date());  
		    System.out.println("strbookingdate..." + strbookingdate);    
		  System.out.println(bookingdetail.getBooking_date());
		  System.out.println(bookingdetail.getBooking_time_from());
		  System.out.println(bookingdetail.getBooking_time_to());
		    String sql = "select * from booking_details where booking_date='" + strbookingdate + "' and booking_time_from <'" + bookingdetail.getBooking_time_to()
		    + "' and booking_time_to >'" + bookingdetail.getBooking_time_from()   + "'";
		    List<BookingDetail> bd = jdbcTemplate.query(sql, new BookingMapper());
		    if (bd.size() > 0) {
		    	bookingdetail.setError_message("Already booked"); 
		    	} else {
		    		bookingdetail.setError_message("");
		    		}
		    return bookingdetail;  }
		  }	  
	  
}

class BookingMapper implements RowMapper<BookingDetail> {

	  public BookingDetail mapRow(ResultSet rs, int arg1) throws SQLException {
		  BookingDetail bookingdetail = new BookingDetail();

		  bookingdetail.setBooking_id(rs.getInt("booking_id"));
		  bookingdetail.setName(rs.getString("name"));
		  bookingdetail.setEmail(rs.getString("email"));
		  bookingdetail.setPhone(rs.getInt("phone"));
		  bookingdetail.setBooked_on(rs.getDate("booked_on"));
		  bookingdetail.setBooking_date(rs.getDate("booking_date"));
		  bookingdetail.setBooking_time_from(rs.getString("booking_time_from"));
		  bookingdetail.setBooking_time_to(rs.getString("booking_time_to"));
	    return bookingdetail;
	  }
	}