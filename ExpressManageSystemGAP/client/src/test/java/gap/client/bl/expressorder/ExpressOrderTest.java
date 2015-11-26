package gap.client.bl.expressorder;

import static org.junit.Assert.fail;

import java.util.List;

import gap.client.exception.InvalidInputException;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.Address;
import gap.common.util.CargoInfo;
import gap.common.util.ExpressType;
import gap.common.util.Gender;
import gap.common.util.PeopleInfo;
import gap.common.util.UserType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressOrderTest {
	ExpressOrder expressorder;

	@Before
	public void setUp() throws Exception {
		expressorder = new ExpressOrder();
		User user = new User(UserType.DELIVERY, "xiaoming", "000000005",
				Gender.MALE);
		LocalInfo.localuser = user;
	}

	@Test
	public void testSave() {
		Address add1 = new Address("江苏省", "南京市", "玄武区");
		Address add2 = new Address("北京市", "北京市", "东城区");
		PeopleInfo sender = new PeopleInfo("杨雁飞", add1, "南京大学", "15520065137");
		PeopleInfo receiver = new PeopleInfo("张家盛", add2, "北京大学", "119");
		CargoInfo cargo = new CargoInfo(2, 2.5, 3.5, "测试");
		ExpressOrderVO vo = new ExpressOrderVO(sender, receiver,
				ExpressType.EXPRESS, 20.5, cargo, false, "0000000003",
				"0010001", null);
		expressorder.save(vo);
	}

	@Test
	public void testExpressOrder() {
	}

	@Test
	public void testExpressOrderPriceCal() {
		fail("尚未实现");
	}

	@Test
	public void testGetState() throws InvalidInputException {
		List<String> states = expressorder.getState("0000000003");
		for (String state : states) {
			System.out.println(state);
		}
	}

	@Test
	public void testGetOrder() throws InvalidInputException {
		ExpressOrderVO vo = expressorder.getOrder("0000000002");
		System.out.println(vo.order_id + "," + vo.expressType + "," + vo.price);
	}

	@Test
	public void testModify() {
		fail("尚未实现");
	}

	@Test
	public void testGetArrivingOrders() {
		fail("尚未实现");
	}

	@Test
	public void testGetCurrentOrders() {
		fail("尚未实现");
	}

	@Test
	public void testSetArrivedOrders() {
		fail("尚未实现");
	}

	@Test
	public void testSetOffOders() {
		fail("尚未实现");
	}

	@Test
	public void testCreateOrder() {
		fail("尚未实现");
	}

	@Test
	public void testReceiveOrder() {
		fail("尚未实现");
	}

}
