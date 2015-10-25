package stub;

import po.CarPO;
import po.DriverPO;
import po.ExpressOrderPO;
import po.InstitutionPO;
import po.UserPO;
import util.ExpressType;

public class Data_stub {
	public static ExpressOrderPO[] ORDER;
	public static InstitutionPO[] INSTITUTIONS;
	public static UserPO[] USERS;
	public static DriverPO[] DRIVERS;
	public static CarPO[] CARS;
	static {
		ORDER = new ExpressOrderPO[2];
		ORDER[0] = new ExpressOrderPO("yyf", "nju", "software", "15520065137",
				"txy", "nju", "software", "110", ExpressType.STANDARD, null,
				false, "0000000001", "0011001", null, null, null, null, null,
				null);

		INSTITUTIONS = new InstitutionPO[2];
		INSTITUTIONS[0] = new InstitutionPO("0011001", "", "njuclerk", "南京", 1);
		INSTITUTIONS[1] = new InstitutionPO("0010001", "", "njucenter", "南京", 1);

		USERS = new UserPO[2];
	}
}
