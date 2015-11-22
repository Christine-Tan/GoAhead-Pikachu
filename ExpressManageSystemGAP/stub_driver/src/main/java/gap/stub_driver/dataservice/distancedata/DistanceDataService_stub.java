package gap.stub_driver.dataservice.distancedata;

import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.po.CityPO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.List;

public class DistanceDataService_stub implements CityDataService{
	private ArrayList<CityPO>  list;

	public DistanceDataService_stub() {
		list = new ArrayList<CityPO>();
	}
	
	@Override
	public CityPO find(String startCity,String endCity) {
		// TODO 自动生成的方法存根
		for (CityPO distance : list)
			if (startCity.equals(distance.getStartCity())&&endCity.equals(distance.getEndCity()))
				return distance;
		return null;
	}

	@Override
	public ResultMessage add(CityPO po) {
		// TODO 自动生成的方法存根
		for (CityPO distance : list)
			if (po.getStartCity().equals(distance.getStartCity())&&po.getEndCity().equals(distance.getEndCity()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage modify(CityPO po) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < list.size(); i++) {
			if (po.getStartCity().equals(list.get(i).getStartCity())&&po.getEndCity().equals(list.get(i).getEndCity()))
				list.remove(i);
				list.add(po);
				return ResultMessage.SUCCEED;
			}
		return ResultMessage.NOTFOUND;
	}

	public List<CityPO> getAll() {
		// TODO 自动生成的方法存根
		return list;
	}
}
