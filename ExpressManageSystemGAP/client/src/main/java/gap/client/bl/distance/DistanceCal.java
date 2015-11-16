package gap.client.bl.distance;

import gap.client.vo.CityVO;

public abstract class DistanceCal {
    //返回距离 
	public abstract double getDistance(CityVO startCity,CityVO endCity);
}
