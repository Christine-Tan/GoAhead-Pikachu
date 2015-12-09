package gap.client.blcontroller;

import gap.client.bl.login.Login;
import gap.client.vo.LogVO;

public class LoginController {
	public static Login login = new Login();

	public static LogVO login(String username, String password) {
		return login.login(username, password);
	}

}
