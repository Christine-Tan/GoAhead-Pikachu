package gap.client.blservice.strategyblservice;

import gap.client.vo.PriceVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface PriceService {
	public List<PriceVO> getAll();

	public ResultMessage modifyPrice(PriceVO vo);

	public PriceVO getPrice(String city_id);
	
	public ResultMessage add(PriceVO vo);
	
}
