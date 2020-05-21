package mvc.onlineAppointmentSys.srevice;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.onlineAppointmentSys.model.LoginUser;
import mvc.onlineAppointmentSys.repository.LoginRepo;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	public LoginRepo loginrepo;
	public LoginUser validateUser(LoginUser login) {
	    return loginrepo.validateUser(login);

}
	public int register(LoginUser loginuser) {
	    return loginrepo.register(loginuser);
	  }
	
	public LoginUser validateRegister(LoginUser login) {
	    return loginrepo.validateRegister(login);

	}
	
	public LoginUser validateEmail(LoginUser login) {
	    return loginrepo.validateEmail(login);

	}

}
