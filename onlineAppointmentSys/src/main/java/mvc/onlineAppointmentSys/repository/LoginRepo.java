package mvc.onlineAppointmentSys.repository;

import mvc.onlineAppointmentSys.model.LoginUser;

public interface LoginRepo {
	LoginUser validateUser(LoginUser login);
	LoginUser validateRegister(LoginUser login);
	LoginUser validateEmail(LoginUser login);
	int register(LoginUser loginuser);
}
