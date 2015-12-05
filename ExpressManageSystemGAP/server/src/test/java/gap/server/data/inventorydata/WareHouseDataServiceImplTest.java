package gap.server.data.inventorydata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import gap.server.initial.NetInitial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WareHouseDataServiceImplTest {
	WareHouseDataServiceImpl wareHouse;
	@Before
	public void setUp() throws Exception {
		NetInitial.initial();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		try {
			wareHouse.add("0000001", "00000010");
			wareHouse.add("0000001", "00000011");
			wareHouse.add("0000001", "00000012");
			wareHouse.add("0000001", "00000013");
			wareHouse.add("0000002", "00000020");
			wareHouse.add("0000002", "00000021");
			wareHouse.add("0000002", "00000022");
			wareHouse.add("0000002", "00000023");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
