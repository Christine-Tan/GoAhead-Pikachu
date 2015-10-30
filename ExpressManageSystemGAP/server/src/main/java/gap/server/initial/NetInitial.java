package gap.server.initial;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.server.data.logdata.LogDataServiceImpl;
import gap.server.data.userdata.UserDataServiceImpl;
import gap.server.databaseutility.Lancher;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class NetInitial {

	public static void initial() {
		NetModule.excutor = Lancher.lanch();
	}

	public static void main(String[] args) {
		initial();
		UserDataService userdataservice;
		LogDataService logdataservice;
		try {
			userdataservice = new UserDataServiceImpl();
			logdataservice = new LogDataServiceImpl();
			LocateRegistry.createRegistry(Config.RMI_port);
			Naming.bind(Config.url + ServiceName.USER_DATA_SERVICE,
					userdataservice);
			Naming.bind(Config.url + ServiceName.LOG_DATA_SERVICE,
					logdataservice);
			System.out.println("Service started");
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
