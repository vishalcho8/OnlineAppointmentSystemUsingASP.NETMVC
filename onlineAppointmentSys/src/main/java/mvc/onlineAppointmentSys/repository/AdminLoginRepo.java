package mvc.onlineAppointmentSys.repository;

import mvc.onlineAppointmentSys.model.AdminLoginUser;

public interface AdminLoginRepo {
	AdminLoginUser validateAdmin(AdminLoginUser adminlogin);

}
