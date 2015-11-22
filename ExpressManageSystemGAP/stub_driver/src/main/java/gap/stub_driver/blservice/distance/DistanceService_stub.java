package gap.stub_driver.blservice.distance;


import gap.client.blservice.strategyblservice.DistanceService;
import gap.client.vo.DistanceVO;
import gap.common.po.CityPO;
import gap.common.util.ResultMessage;
import gap.stub_driver.dataservice.distancedata.DistanceDataService_stub;

import java.util.ArrayList;
import java.util.List;

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
		for (CityPO user : datastub.getAll())
			list.add(getVO(user));
		return list;
	}

	@Override
	public DistanceVO getDistance(String startCity, String endCity) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(startCity,endCity));
	}
	
	private DistanceVO getVO(CityPO po) {
		return new DistanceVO();
	}

	private CityPO getPO(DistanceVO vo) {
		return new CityPO();
	}

	@Override
	public ResultMessage add(DistanceVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

}
