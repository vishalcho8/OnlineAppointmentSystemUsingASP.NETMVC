package mvc.onlineAppointmentSys.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mvc.onlineAppointmentSys.model.AdminLoginUser;

public class AdminLoginRepoImpl implements AdminLoginRepo{
	
	@Autowired
	  DataSource dataSource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  public AdminLoginUser validateAdmin(AdminLoginUser adminlogin) {
		  System.out.println(adminlogin.getUsername());
		  System.out.println(adminlogin.getPassword());
		    String sql = "select * from admin where username='" + adminlogin.getUsername() + "' and password='" + adminlogin.getPassword()
		        + "'";
		    List<AdminLoginUser> users = jdbcTemplate.query(sql, new UserMapper());

		    return users.size() > 0 ? users.get(0) : null;
		  }	  
	  

}

class UserMapper implements RowMapper<AdminLoginUser> {

	  public AdminLoginUser mapRow(ResultSet rs, int arg1) throws SQLException {
		  AdminLoginUser adminlogin = new AdminLoginUser();

		  adminlogin.setUsername(rs.getString("username"));
		  adminlogin.setPassword(rs.getString("password"));
		  adminlogin.setFirstname(rs.getString("firstname"));
		  adminlogin.setLastname(rs.getString("lastname"));
		  adminlogin.setEmail(rs.getString("email"));
		  adminlogin.setAddress(rs.getString("address"));
		  adminlogin.setPhone(rs.getInt("phone")); 

	    return adminlogin;
	  }
}
