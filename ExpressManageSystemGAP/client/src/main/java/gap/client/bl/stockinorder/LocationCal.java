package gap.client.bl.stockinorder;

import java.util.List;

import gap.client.vo.GoodsVO;
import gap.common.util.SectorType;

public abstract class LocationCal {
	public abstract String setLocation(GoodsVO vo);
	
	public abstract String getLocation(GoodsVO vo);
	
}
