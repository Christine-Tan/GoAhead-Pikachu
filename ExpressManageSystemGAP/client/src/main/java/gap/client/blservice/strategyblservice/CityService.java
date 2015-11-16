package gap.client.blservice.strategyblservice;

import java.util.List;
import gap.client.vo.CityVO;
import gap.common.util.ResultMessage;

public interface CityService {
	public List<CityVO> getAll();

	public ResultMessage modifyCity(CityVO vo);

	public CityVO getCity(String CityId);
	
	public ResultMessage add(CityVO vo);
}
