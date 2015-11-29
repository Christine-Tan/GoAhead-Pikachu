package gap.client.blservice.strategyblservice;

import java.util.List;

import gap.client.util.City;
import gap.client.vo.CityVO;

public interface CityService {
	public List<CityVO> getAll();

	public void modifyCity(City city);

	public CityVO getCity(String City);

	public void addCity(City city);

	public double getDistance(City city1, City city2);
}
