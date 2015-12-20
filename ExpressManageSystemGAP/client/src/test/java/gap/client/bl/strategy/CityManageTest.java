package gap.client.bl.strategy;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import gap.client.datacontroller.NetModule;
import gap.client.util.City;

public class CityManageTest {
   CityManage city;
	@Before
	public void setUp() throws Exception {
		NetModule.connect();
		city=new CityManage();
	}

	@Test
	public void testGetAll() {
		city.getAll();
	}

	@Test
	public void testGetCity() {
		city.getCity("南京");
		
	}

	@Test
	public void testAddCity() {
	      City vo=new City("南京市","江苏省",117.6,48.1);
	      city.addCity(vo);
	}

	@Test
	public void testGetDistance() {
	
	}

}
