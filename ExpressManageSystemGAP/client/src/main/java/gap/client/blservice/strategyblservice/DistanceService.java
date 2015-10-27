package gap.client.blservice.strategyblservice;

import gap.client.vo.DistanceVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface DistanceService {
	public List<DistanceVO> getAll();

	public ResultMessage modifyDistance(DistanceVO vo);

	public DistanceVO getDistance(String startCity,String endCity);
	
	public ResultMessage add(DistanceVO vo);
}
