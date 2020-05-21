package mvc.onlineAppointmentSys.srevice;

import org.springframework.beans.factory.annotation.Autowired;

import mvc.onlineAppointmentSys.model.AdminLoginUser;
import mvc.onlineAppointmentSys.repository.AdminLoginRepo;


public class AdminLoginServiceImpl implements AdminLoginService{
	@Autowired
	public AdminLoginRepo adminLoginRepo;
	
	public AdminLoginUser validateAdmin(AdminLoginUser adminlogin) {
	    return adminLoginRepo.validateAdmin(adminlogin);

}

}
