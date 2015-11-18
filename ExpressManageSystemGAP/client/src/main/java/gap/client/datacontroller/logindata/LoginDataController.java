package gap.client.datacontroller.logindata;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.UserPO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginDataController {
	private UserDataService userDataService;

	public LoginDataController() {
		try {
			userDataService = (UserDataService) Naming.lookup(RMIConfig.url
					+ ServiceName.USER_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public UserPO findByUsername(String username) {
		try {
			return userDataService.findByUsername(username);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	// static {
	// try {
	// userDataService = (UserDataService) Naming.lookup(RMIConfig.url
	// + ServiceName.USER_DATA_SERVICE);
	// } catch (MalformedURLException e) {
	// // TODO 自动生成的 catch 块
	// e.printStackTrace();
	// } catch (RemoteException e) {
	// // TODO 自动生成的 catch 块
	// e.printStackTrace();
	// } catch (NotBoundException e) {
	// // TODO 自动生成的 catch 块
	// e.printStackTrace();
	// }
	// }
	//
}
