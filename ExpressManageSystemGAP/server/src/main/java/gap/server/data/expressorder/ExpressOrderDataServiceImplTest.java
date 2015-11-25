package gap.server.data.expressorder;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.expressorderdataservice.ExpressOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.ExpressOrderModifyPO;
import gap.common.po.ExpressOrderPO;
import gap.common.util.ReceiveInfo;
import gap.server.initial.NetInitial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class ExpressOrderDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
		NetInitial.initial();
	}

	@Test
	public void testSaveCargoInfo() {
		// ExpressOrderDataServiceImpl expre = new
		// ExpressOrderDataServiceImpl();
		// CargoInfo info = new CargoInfo(2, 2.25, 5.35, "零食");
		// System.out.println(expre.saveCargoInfo(info));
	}

	@Test
	public void testSaveSenderInfo() {
		// ExpressOrderDataServiceImpl expre = new
		// ExpressOrderDataServiceImpl();
		// Address add = new Address();
		// add.setProvince_id(1);
		// add.setCity_id(1);
		// add.setDistrict_id(1);
		// PeopleInfo peo = new PeopleInfo("yyf", add, "nju", "15520065137");
		// System.out.println("peo_id:" + expre.saveSenderinfo(peo));
	}

	@Test
	public void testSaveAddress() {
		// ExpressOrderDataServiceImpl expre = new
		// ExpressOrderDataServiceImpl();
		// Address add = new Address();
		// add.setProvince_id(1);
		// add.setCity_id(1);
		// add.setDistrict_id(1);
		// System.out.println(expre.saveAddress(add));
	}

	@Test
	public void testAdd() {
		// ExpressOrderDataServiceImpl expre = new
		// ExpressOrderDataServiceImpl();
		// Address add = new Address("江苏省", "南京市", "栖霞区"), add1 = new Address(
		// "北京市", "北京市", "朝阳区");
		// PeopleInfo peo = new PeopleInfo("yyf", add, "nju", "15520065137");
		// PeopleInfo peo1 = new PeopleInfo("txy", add1, "nju", "119");
		// CargoInfo caro = new CargoInfo(3, 2.5, 3.5, "零食");
		// ExpressOrderPO order = new ExpressOrderPO(peo, peo1,
		// ExpressType.STANDARD, caro, "0000000001", 10.5);
		// order.setCurrentins_id("0010001");
		// try {
		// expre.add(order, "000000001");
		// } catch (RemoteException e) {
		// // TODO 自动生成的 catch 块
		// e.printStackTrace();
		// }
	}

	@Test
	public void testSetReceived() {
//		try {
//			ExpressOrderDataService expre = ExpressOrderDataServiceImpl
//					.getInstance();
//			ReceiveInfo info = new ReceiveInfo("小张", "2015-11-25", "000000005",
//					"测试");
//			expre.setRecieved("0000000003", info);
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
	}

	@Test
	public void testGetDeliveryMoney() {

//		 try {
//		 ExpressOrderDataService expre = ExpressOrderDataServiceImpl
//		 .getInstance();
//		 double money = expre.getDeliveryMoney("2015-11-25", "000000005");
//		 System.out.println(money);
//		 } catch (RemoteException e) {
//		 // TODO 自动生成的 catch 块
//		 e.printStackTrace();
//		 }
	}

	@Test
	public void testFind() {
		// try {
		// ExpressOrderDataService expre = ExpressOrderDataServiceImpl
		// .getInstance();
		// ExpressOrderPO po = expre.find("0000000001");
		// System.out.println("Found order!!");
		// System.out.println("sender_Name:" + po.getSenderInfo().getName()
		// + ",receicerName:" + po.getReceiverInfo().getName());
		// expre.addState("0000000001", "到达xxx营业厅");
		// expre.addState("0000000001", "到达xxx中转中心");
		// for (String str : expre.getState("0000000001"))
		// System.out.println(str);
		// ExpressOrderModifyPO modify = new ExpressOrderModifyPO(
		// "0000000001", "0010001", null, false, false, false);
		// expre.modify(modify);
		// expre.setArrived("0000000001", "0010002", "xx营业厅收件");
		// } catch (RemoteException e) {
		// // TODO 自动生成的 catch 块
		// e.printStackTrace();
		// }
	}

	@Test
	public void testSetPassed() throws MalformedURLException, RemoteException,
			NotBoundException {
		// ExpressOrderDataService express = (ExpressOrderDataService) Naming
		// .lookup(RMIConfig.url + ServiceName.EXPRESSORDER_DATA_SERVICE);
		// express.setPassed("0000000003", "南京栖霞营业厅已收入");
	}
}
