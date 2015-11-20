package gap.server.data.expressorder;

import gap.common.util.Address;
import gap.common.util.CargoInfo;
import gap.common.util.PeopleInfo;
import gap.server.initial.NetInitial;

import org.junit.Before;
import org.junit.Test;

public class ExpressOrderDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
		NetInitial.initial();
	}

	@Test
	public void testSaveCargoInfo() {
		ExpressOrderDataServiceImpl expre = new ExpressOrderDataServiceImpl();
		CargoInfo info = new CargoInfo(2, 2.25, 5.35, "零食");
		System.out.println(expre.saveCargoInfo(info));
	}

	@Test
	public void testSaveSenderInfo() {
		ExpressOrderDataServiceImpl expre = new ExpressOrderDataServiceImpl();
		Address add = new Address();
		add.setProvince_id(1);
		add.setCity_id(1);
		add.setDistrict_id(1);
		PeopleInfo peo = new PeopleInfo("yyf", add, "nju", "15520065137");
		System.out.println("peo_id:" + expre.saveSenderinfo(peo));
	}

	@Test
	public void testSaveAddress() {
		ExpressOrderDataServiceImpl expre = new ExpressOrderDataServiceImpl();
		Address add = new Address();
		add.setProvince_id(1);
		add.setCity_id(1);
		add.setDistrict_id(1);
		System.out.println(expre.saveAddress(add));
	}

}
