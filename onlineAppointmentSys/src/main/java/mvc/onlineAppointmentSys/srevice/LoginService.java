package mvc.onlineAppointmentSys.srevice;

import mvc.onlineAppointmentSys.model.LoginUser;

public interface LoginService {
	int register(LoginUser login);
	LoginUser validateUser(LoginUser login);
	LoginUser validateRegister(LoginUser login);
	LoginUser validateEmail(LoginUser login);

}
