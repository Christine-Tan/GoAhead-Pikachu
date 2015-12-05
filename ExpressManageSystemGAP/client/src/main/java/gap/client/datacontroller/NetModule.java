package gap.client.datacontroller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gap.common.dataservice.Contactor;
import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.dataservice.receiptdataservice.BillOrderDataService;
import gap.common.dataservice.receiptdataservice.PaymentdataService;
import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.dataservice.strategydataservice.PriceDataService;
import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.dataservice.transdataservice.CarDataService;
import gap.common.dataservice.transdataservice.DriverDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;

public class NetModule {

	private static Contactor contactor;

	static void connect() {
		int connect_time = 0;
		while (true) {
			try {
				contactor = (Contactor) Naming.lookup(RMIConfig.url
						+ ServiceName.CONTACTOR);
				System.out.println("连接成功");
				break;
			} catch (MalformedURLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("程序错误");
				break;
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				if (connect_time > 10) {
					System.out.println("程序已结束");
					break;
				} else {
					System.out.println("连接错误!!正在尝试重新连接，重连次数："
							+ (connect_time++) + "次");
				}
			} catch (NotBoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				System.out.println("服务器错误！！！");
				break;
			}
		}
	}

	public static void main(String[] args) {
		connect();
	}
}
