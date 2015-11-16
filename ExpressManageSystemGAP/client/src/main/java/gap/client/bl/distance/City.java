package gap.client.bl.distance;

import java.util.List;
import gap.client.blservice.strategyblservice.CityService;
import gap.client.vo.CityVO;
import gap.common.util.ResultMessage;

public class City implements CityService{
    DistanceCal distanceCal;
    
	public City(DistanceCal c) {
		distanceCal = c;
	}

	@Override
	public List<CityVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyCity(CityVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityVO getCity(String CityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(CityVO vo) {
		// TODO Auto-generated method stub
		
		return null;
	}
        
}
