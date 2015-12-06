package gap.client.blcontroller;

import java.util.List;

import gap.client.bl.strategy.RentManage;
import gap.client.vo.RentVO;
import gap.common.util.ResultMessage;

public class RentController {
	private static RentManage rentManage = new RentManage();

	public static List<RentVO> getAll() {
		return rentManage.getAll();
	}

	public static void addRent(RentVO vo) {
		rentManage.addRent(vo);
	}

	public static void modifyRent(RentVO vo) {
		rentManage.modifyRent(vo);
	}

	public static ResultMessage flush() {
		return rentManage.flush();
	}

}
