package gap.client.blservice.inventoryblservice;

import java.util.List;

import gap.client.vo.ArrivedOrderVO;

public abstract class GoodsList {
	
	public abstract List getPrice(ArrivedOrderVO vo);
}
