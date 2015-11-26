package gap.server.initial;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.dataservice.transdataservice.CarDataService;
import gap.common.dataservice.transdataservice.DriverDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.server.data.expressorder.ExpressOrderDataServiceImpl;
import gap.server.data.logdata.LogDataServiceImpl;
import gap.server.data.order.ArrivedOrderDataServiceImpl;
import gap.server.data.order.DeliveryOrderDataServiceImpl;
import gap.server.data.order.LoadOrderDataServiceImpl;
import gap.server.data.strategydata.PriceDataServiceImpl;
import gap.server.data.transdata.CarDataServiceImpl;
import gap.server.data.transdata.DriverDataServiceImpl;
import gap.server.data.userdata.UserDataServiceImpl;
import gap.server.databaseutility.DataBaseLancher;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import static gap.server.initial.NetModule.*;

public class NetInitial {

	public static void initial() throws RemoteException {
		NetModule.excutor = DataBaseLancher.lanch();

		userdataservice = UserDataServiceImpl.getInstance();
		logdataservice = LogDataServiceImpl.getInstance();
		cardataservice = CarDataServiceImpl.getInstance();
		driverdataservice = DriverDataServiceImpl.getInstance();
		arrivedOrderdataservice = ArrivedOrderDataServiceImpl.getInstance();
		expressorderdataservice = ExpressOrderDataServiceImpl.getInstance();
		deliveryorderdataservice = DeliveryOrderDataServiceImpl.getInstance();
		loadorderdataservice = LoadOrderDataServiceImpl.getInstance();
		pricedataservice = new PriceDataServiceImpl();
	}

	public static void main(String[] args) {
		try {
			initial();
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
			Naming.bind(RMIConfig.url + ServiceName.EXPRESSORDER_DATA_SERVICE,
					expressorderdataservice);
			Naming.bind(
					RMIConfig.url + ServiceName.DELIVERYPORDER_DATA_SERVICE,
					deliveryorderdataservice);
			Naming.bind(RMIConfig.url + ServiceName.LOADORDER_DATA_SERVICE,
					loadorderdataservice);
			Naming.bind(RMIConfig.url + ServiceName.PRICE_DATA_SERVICE,
					pricedataservice);

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
