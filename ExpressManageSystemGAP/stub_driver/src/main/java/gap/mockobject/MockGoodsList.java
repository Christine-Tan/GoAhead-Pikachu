package gap.mockobject;

import java.util.List;

import gap.client.blservice.inventoryblservice.GoodsList;
import gap.client.vo.ArrivedOrderVO;

public class MockGoodsList extends GoodsList{

	@Override
	public List getPrice(ArrivedOrderVO vo) {
		// TODO Auto-generated method stub
		return vo.getOrders();
	}

}
