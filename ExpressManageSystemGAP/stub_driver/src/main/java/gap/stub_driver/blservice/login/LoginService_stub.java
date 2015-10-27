package gap.stub_driver.blservice.login;

import gap.client.blservice.loginblservice.LoginService;
import gap.client.vo.LogVO;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.po.UserPO;
import gap.common.util.UserType;
import gap.stub_driver.dataservice.userdata.UserDataService_stub;

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
