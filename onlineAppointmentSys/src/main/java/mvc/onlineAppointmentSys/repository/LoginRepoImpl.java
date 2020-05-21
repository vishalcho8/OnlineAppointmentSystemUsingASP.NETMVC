package mvc.onlineAppointmentSys.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mvc.onlineAppointmentSys.model.LoginUser;

public class LoginRepoImpl implements LoginRepo {

	@Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  public LoginUser validateRegister(LoginUser login) {
		  System.out.println("validateRegister loginimpl username..." + login.getUsername());
		  
		    String sql1 = "select * from users where username='" + login.getUsername() + "'";
		    List<LoginUser> users = jdbcTemplate.query(sql1, new UserMapper());
		    if (users.size() > 0) {
		    	login.setErr_message("user exist");
		    	
		    } else {
		    	login.setErr_message(null);
		    }
		    return login;
	 }
	  public LoginUser validateEmail(LoginUser login) {
		  System.out.println("validateEmail loginimpl. email.." + login.getEmail());
		  
		    String sql1 = "select * from users where email='" + login.getEmail() + "'";
		    List<LoginUser> users = jdbcTemplate.query(sql1, new UserMapper());
		    if (users.size() > 0) {
		    	login.setErr_message("email exist");
		    	
		    } else {
		    	login.setErr_message(null);
		    }
		    return login;
		  }	  
	  
	  public int register(LoginUser loginuser) {
		    String sql = "insert into users values(?,?,?,?,?,?,?)";

		    return jdbcTemplate.update(sql, new Object[] { loginuser.getUsername(), loginuser.getPassword(), loginuser.getFirstname(),
		    		loginuser.getLastname(), loginuser.getEmail(), loginuser.getAddress(), loginuser.getPhone() });
		  }
	  
	  public LoginUser validateUser(LoginUser login) {
		  System.out.println(login.getUsername());
		  System.out.println(login.getPassword());
		    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
		        + "'";
		    List<LoginUser> users = jdbcTemplate.query(sql, new UserMapper());

		    return users.size() > 0 ? users.get(0) : null;
		  }	  
	  
}

class UserMapper implements RowMapper<LoginUser> {

	  public LoginUser mapRow(ResultSet rs, int arg1) throws SQLException {
	    LoginUser loginuser = new LoginUser();

	    loginuser.setUsername(rs.getString("username"));
	    loginuser.setPassword(rs.getString("password"));
	    loginuser.setFirstname(rs.getString("firstname"));
	    loginuser.setLastname(rs.getString("lastname"));
	    loginuser.setEmail(rs.getString("email"));
	    loginuser.setAddress(rs.getString("address"));
	    loginuser.setPhone(rs.getInt("phone")); 

	    return loginuser;
	  }
}
