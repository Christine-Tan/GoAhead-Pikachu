package gap.stub_driver.blservice.login;

import java.rmi.RemoteException;

import gap.client.blservice.loginblservice.LoginService;
import gap.client.vo.LogVO;

public class LoginService_driver {
	public void driver(LoginService log) {
		LogVO result;
		result = log.login("txy", "0000000");
		if (!result.isSucceed())
			System.out.println("login failed");
		result = log.login("yyf", "000000");
		if (result.isSucceed())
			System.out.println("login succeed,user type:"
					+ result.getUserType());
	}

	public static void main(String[] args) throws RemoteException {
		LoginService log = new LoginService_stub();
		LoginService_driver driver = new LoginService_driver();
		driver.driver(log);
	}
}
