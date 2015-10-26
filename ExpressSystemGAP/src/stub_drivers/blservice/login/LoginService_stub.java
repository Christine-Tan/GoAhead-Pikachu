package stub_drivers.blservice.login;

import po.UserPO;
import stub_drivers.dataservice.userdata.UserDataService_stub;
import util.UserType;
import client.blservice.loginblservice.LoginService;
import client.vo.LogVO;
import dataservice.userdataservice.UserDataService;

public class LoginService_stub implements LoginService {
	UserDataService user;

	public LoginService_stub() {
		user = new UserDataService_stub();
		UserPO po = new UserPO("001", UserType.BUSSINESSCLERK, "yyf", 0,
				"0010001", "000000");
		user.add(po);
	}

	@Override
	public LogVO login(String username, String password) {
		// TODO 自动生成的方法存根
		LogVO log = new LogVO();
		log.setSucceed(false);
		for (UserPO po : user.getAll()) {
			if (po.getUserName().equals(username)
					&& po.getPassword().equals(password)) {
				log.setSucceed(true);
				log.setUserType(po.getType());
			}
		}
		return log;
	}
}
