package client.blservice.strategyblservice;

import java.util.List;

import util.ResultMessage;
import client.vo.DistanceVO;

public interface DistanceService {
	public List<DistanceVO> getAll();

	public ResultMessage modifyDistance(DistanceVO vo);

	public DistanceVO getDistance(String startCity,String endCity);
}
