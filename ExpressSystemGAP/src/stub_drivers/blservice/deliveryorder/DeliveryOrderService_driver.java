package stub_drivers.blservice.deliveryorder;

import util.ResultMessage;
import client.blservice.orderblservice.DeliveryOrderService;
import client.vo.DeliveryOrderVO;

public class DeliveryOrderService_driver {
	public void driver(DeliveryOrderService arrivedOrder) {
		DeliveryOrderVO orderInfo = new DeliveryOrderVO(null, "19700101",
				"00110011970010100001");
		DeliveryOrderVO comOrder = arrivedOrder.create(null, orderInfo);
		if (arrivedOrder.save(comOrder).equals(ResultMessage.SUCCEED))
			System.out.println("save succeed!");
		if (arrivedOrder.save(comOrder).equals(ResultMessage.EXITED))
			System.out.println("save failed,order exited");
		DeliveryOrderVO get = arrivedOrder.find("00110011970010100001");
		if (get != null)
			System.out.println("find:id=" + get.getId() + ",date="
					+ get.getTime());
		get = arrivedOrder.find("001100119700101000001");
		if (get == null)
			System.out.println("find failed,not found");
	}

	public static void main(String[] args) {
		DeliveryOrderService_driver driver = new DeliveryOrderService_driver();
		DeliveryOrderService arrivedOrder = new DeliveryOrderService_stub();
		driver.driver(arrivedOrder);
	}
}
