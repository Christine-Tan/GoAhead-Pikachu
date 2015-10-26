package stub_drivers.blservice.distance;


import java.util.ArrayList;
import java.util.List;

import po.DistancePO;
import stub_drivers.dataservice.distancedata.DistanceDataService_stub;
import util.ResultMessage;
import client.blservice.strategyblservice.DistanceService;
import client.vo.DistanceVO;

public class DistanceService_stub implements DistanceService{
	DistanceDataService_stub datastub;

	public 	DistanceService_stub() {
		datastub = new 	DistanceDataService_stub();
	}
	
	@Override
	public ResultMessage modifyDistance(DistanceVO vo) {
		// TODO 自动生成的方法存根
		return datastub.modify(getPO(vo));
	}

	@Override
	public List<DistanceVO> getAll() {
		// TODO 自动生成的方法存根
		List<DistanceVO> list = new ArrayList<DistanceVO>();
		for (DistancePO user : datastub.getAll())
			list.add(getVO(user));
		return list;
	}

	@Override
	public DistanceVO getDistance(String startCity, String endCity) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(startCity,endCity));
	}
	
	private DistanceVO getVO(DistancePO po) {
		return new DistanceVO();
	}

	private DistancePO getPO(DistanceVO vo) {
		return new DistancePO();
	}

}
