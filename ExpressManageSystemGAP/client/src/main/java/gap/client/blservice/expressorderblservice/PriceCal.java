package gap.client.blservice.expressorderblservice;

import gap.client.bl.distance.City;
import gap.client.vo.ExpressOrderVO;

public abstract class PriceCal {

	protected City city;

	// 返回价格
	public abstract double getPrice(ExpressOrderVO vo);

}
