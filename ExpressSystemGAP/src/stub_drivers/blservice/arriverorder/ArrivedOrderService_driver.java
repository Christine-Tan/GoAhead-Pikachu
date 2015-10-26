package stub_drivers.blservice.arriverorder;

import util.ResultMessage;
import client.blservice.orderblservice.ArrivedOrderService;
import client.vo.ArrivedOrderVO;

public class ArrivedOrderService_driver {
	public void driver(ArrivedOrderService arrivedOrder) {
		ArrivedOrderVO orderInfo = new ArrivedOrderVO(null, "19700101",
				"00110011970010100001");
		ArrivedOrderVO comOrder = arrivedOrder.create(null, orderInfo);
		if (arrivedOrder.save(comOrder).equals(ResultMessage.SUCCEED))
			System.out.println("save succeed!");
		if (arrivedOrder.save(comOrder).equals(ResultMessage.EXITED))
			System.out.println("save failed,order exited");
		ArrivedOrderVO get = arrivedOrder.find("00110011970010100001");
		if (get != null)
			System.out.println("find:id=" + get.getId() + ",date="
					+ get.getTime());
		get = arrivedOrder.find("001100119700101000001");
		if (get == null)
			System.out.println("find failed,not found");
	}

	public static void main(String[] args) {
		ArrivedOrderService_driver driver = new ArrivedOrderService_driver();
		ArrivedOrderService arrivedOrder = new ArrivedOrderService_stub();
		driver.driver(arrivedOrder);
	}

}
