package gap.server.initial;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.transdataservice.CarDataService;
import gap.common.dataservice.transdataservice.DriverDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.server.data.logdata.LogDataServiceImpl;
import gap.server.data.order.ArrivedOrderDataServiceImpl;
import gap.server.data.transdata.CarDataServiceImpl;
import gap.server.data.transdata.DriverDataServiceImpl;
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
		CarDataService cardataservice;
		DriverDataService driverdataservice;
		ArrivedOrderDataService arrivedOrderdataservice;
		try {
			userdataservice = new UserDataServiceImpl();
			logdataservice = new LogDataServiceImpl();
			cardataservice = new CarDataServiceImpl();
			driverdataservice = new DriverDataServiceImpl();
			arrivedOrderdataservice = new ArrivedOrderDataServiceImpl();
			LocateRegistry.createRegistry(RMIConfig.RMI_port);
			Naming.bind(RMIConfig.url + ServiceName.USER_DATA_SERVICE,
					userdataservice);
			Naming.bind(RMIConfig.url + ServiceName.LOG_DATA_SERVICE,
					logdataservice);
			Naming.bind(RMIConfig.url + ServiceName.CAR_DATA_SERVICE,
					cardataservice);
			Naming.bind(RMIConfig.url + ServiceName.DRIVER_DATA_SERVICE,
					driverdataservice);
			Naming.bind(RMIConfig.url + ServiceName.ARRIVEDORDER_DATA_SERVICE,
					arrivedOrderdataservice);
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
