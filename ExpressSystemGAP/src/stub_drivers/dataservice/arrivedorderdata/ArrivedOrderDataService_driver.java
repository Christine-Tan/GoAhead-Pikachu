package stub_drivers.dataservice.arrivedorderdata;

import po.ArrivedOrderPO;
import po.ExpressOrderPO;
import util.ExpressType;
import util.ResultMessage;

public class ArrivedOrderDataService_driver {
	public static void main(String[] args) {
		ArrivedOrderDataService_stub stub = new ArrivedOrderDataService_stub();
		ArrivedOrderPO po = new ArrivedOrderPO(null, "19700101",
				"00100011970010100001");
		if (stub.add(po).equals(ResultMessage.SUCCEED)) {
			System.out.println("add succeed!");
		}
		ArrivedOrderPO get = stub.find("00100011970010100001");
		if (get != null)
			System.out.println("find:id=" + get.getId() + ",date="
					+ get.getTime());
	}
}
