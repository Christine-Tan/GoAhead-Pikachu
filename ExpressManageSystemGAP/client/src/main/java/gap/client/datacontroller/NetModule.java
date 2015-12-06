package gap.client.datacontroller;

import gap.client.ui.gapcomponents.GAPDialog;
import gap.common.dataservice.Contactor;
import gap.common.dataservice.ServiceName;
import gap.common.dataservice.accountdataservice.AccountDataService;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.dataservice.inventorydataservice.InventoryDataService;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.dataservice.orderdataservice.ArrivedOrderDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.dataservice.orderdataservice.LoadOrderDataService;
import gap.common.dataservice.orderdataservice.StockinOrderDataService;
import gap.common.dataservice.orderdataservice.StockoutOrderDataService;
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

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class NetModule {

	protected static AccountDataService accountDataService;
	protected static UserDataService userdataservice;
	protected static LogDataService logdataservice;
	protected static CarDataService cardataservice;
	protected static DriverDataService driverdataservice;
	protected static ArrivedOrderDataService arrivedOrderdataservice;
	protected static ExpressOrderDataService expressorderdataservice;
	protected static DeliveryOrderDataService deliveryorderdataservice;
	protected static LoadOrderDataService loadorderdataservice;
	protected static PriceDataService pricedataservice;
	protected static RentDataService rentdataservice;
	protected static SalaryDataService salarydataservice;
	protected static CityDataService citydataservice;
	protected static InstitutionDataService institutiondataservice;
	protected static BillOrderDataService billorderdataservice;
	protected static PaymentdataService paymentdataService;
	protected static InventoryDataService inventorydataservice;
	protected static StockinOrderDataService stockinorderdataservice;
	protected static StockoutOrderDataService stockoutorderdataservice;

	private static Contactor contactor;

	public static GAPDialog dialog;

	public static Map<String, Object> ServiceMap = new HashMap<>(
			ServiceName.serviceNumber + 10);

	public static void initial(JFrame jf) {
		dialog = new GAPDialog(jf, "错误提示", false);
		ServiceMap.put(ServiceName.ACCOUNT_DATA_SERVICE, accountDataService);
		ServiceMap.put(ServiceName.ARRIVEDORDER_DATA_SERVICE,
				arrivedOrderdataservice);
		ServiceMap
				.put(ServiceName.BILLORDER_DATA_SERVICE, billorderdataservice);
		ServiceMap.put(ServiceName.CAR_DATA_SERVICE, cardataservice);
		ServiceMap.put(ServiceName.CITY_DATA_SERVICE, citydataservice);
		ServiceMap.put(ServiceName.DELIVERYPORDER_DATA_SERVICE,
				deliveryorderdataservice);
		ServiceMap.put(ServiceName.DRIVER_DATA_SERVICE, driverdataservice);
		ServiceMap.put(ServiceName.EXPRESSORDER_DATA_SERVICE,
				expressorderdataservice);
		ServiceMap.put(ServiceName.INSTITUTION_DATA_SERVICE,
				institutiondataservice);
		ServiceMap
				.put(ServiceName.INVENTORY_DATA_SERVICE, inventorydataservice);
		ServiceMap
				.put(ServiceName.LOADORDER_DATA_SERVICE, loadorderdataservice);
		ServiceMap.put(ServiceName.LOG_DATA_SERVICE, logdataservice);
		ServiceMap.put(ServiceName.PAYMENT_DATA_SERVICE, paymentdataService);
		ServiceMap.put(ServiceName.PRICE_DATA_SERVICE, pricedataservice);
		ServiceMap.put(ServiceName.RENT_DATA_SERVICE, rentdataservice);
		ServiceMap.put(ServiceName.SALARY_DATA_SERVICE, salarydataservice);
		ServiceMap.put(ServiceName.STOCKINORDER_DATA_SERVICE,
				stockinorderdataservice);
		ServiceMap.put(ServiceName.STOCKOUTORDER_DATA_SERVICE,
				stockoutorderdataservice);
		ServiceMap.put(ServiceName.USER_DATA_SERVICE, userdataservice);
	}

	static void connect() {
		int connect_time = 0;
		boolean reconnect = false;
		while (true) {
			try {
				if (!reconnect)
					showMessage("连接中");

				contactor = (Contactor) Naming.lookup(RMIConfig.url
						+ ServiceName.CONTACTOR);
				for (Map.Entry<String, Object> entry : ServiceMap.entrySet()) {
				}

				showMessage("连接成功");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				// hideMessage();
				new Thread(new CheckRunnable()).start();
				break;
			} catch (MalformedURLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				showMessage("连接错误");
				break;
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				reconnect = true;
				if (connect_time > 10) {
					showMessage("程序已结束");
					break;
				} else {
					showMessage("连接错误!!正在尝试重新连接，重连次数：" + (connect_time++) + "次");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			} catch (NotBoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				showMessage("服务器错误！！！");
				break;
			}
		}
	}

	private static void showMessage(String message) {
		dialog.showMessage(message);
	}

	private static void hideMessage() {
		dialog.setVisible(false);
	}

	static class CheckRunnable implements Runnable {

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try {
				while (contactor.getInfo())
					Thread.sleep(5000);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				showMessage("网络连接错误！！");
				connect();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setBounds(500, 500, 200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		initial(jf);
		connect();
	}
}
