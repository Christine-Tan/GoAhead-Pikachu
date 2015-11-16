package gap.testers;

import static org.junit.Assert.*;

import org.junit.Test;

import gap.client.bl.distance.DistanceCal;
import gap.client.vo.CityVO;
import gap.mockobject.MockDistanceCal;

public class GetDistanceTest {


	@Test
	public void test() {
		CityVO city1=new CityVO("Beijing");
		CityVO city2=new CityVO("Shanghai");
		CityVO city3=new CityVO("Nanjing");
		DistanceCal distanceCal=new MockDistanceCal();
		assertEquals(distanceCal.getDistance(city1, city2),341.7,0.01);
		assertEquals(distanceCal.getDistance(city1, city3),480.9,0.01);
		fail("Not yet implemented");
	}

}
