package mvc.onlineAppointmentSys.srevice;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.onlineAppointmentSys.model.LoginUser;
import mvc.onlineAppointmentSys.repository.LoginRepo;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	public LoginRepo loginRepo;
	public LoginUser validateUser(LoginUser login) {
	    return loginRepo.validateUser(login);

}
	public int register(LoginUser loginuser) {
	    return loginRepo.register(loginuser);
	  }
	
	public LoginUser validateRegister(LoginUser login) {
	    return loginRepo.validateRegister(login);

	}
	
	public LoginUser validateEmail(LoginUser login) {
	    return loginRepo.validateEmail(login);

	}

}
