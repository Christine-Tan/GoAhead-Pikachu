package gap.server.data.userdata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.po.UserPO;
import gap.common.util.UserType;
import gap.server.initial.Config;
import gap.server.initial.NetInitial;

import org.junit.Before;
import org.junit.Test;

public class UserDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws RemoteException, MalformedURLException,
			NotBoundException {
		UserDataService userdata = (UserDataService) Naming.lookup(Config.url
				+ ServiceName.USER_DATA_SERVICE);
		UserPO po1 = new UserPO("000000001", UserType.ADMINISTRATOR, "yyf", 0,
				"0010001", "123456");
		UserPO po2 = new UserPO("000000002", UserType.ADMINISTRATOR, "txy", 0,
				"0010001", "123456");
		UserPO po3 = new UserPO("000000003", UserType.ADMINISTRATOR, "plw", 0,
				"0010001", "123456");
		System.out.println(userdata.add(po1).getMessage());
		System.out.println(userdata.add(po2).getMessage());
		System.out.println(userdata.add(po3).getMessage());
		for (UserPO get : userdata.getAll())
			System.out.println(get.getUserName() + "," + get.getType());
		po3.setName("plw");
		userdata.modify(po3);
		for (UserPO get : userdata.getAll())
			System.out.println(get.getUserName() + "," + get.getType());
	}
}
