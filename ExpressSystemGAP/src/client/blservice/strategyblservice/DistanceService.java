package client.blservice.strategyblservice;

import client.vo.DistanceVO;

public interface DistanceService {
	public void modifyDistance(DistanceVO vo);

	public DistanceVO getDistance();
}
