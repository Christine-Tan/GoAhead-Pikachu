package gap.client.bl.strategy;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import gap.client.datacontroller.NetModule;
import gap.client.vo.PriceVO;

public class PriceManageTest {
    PriceManage price;
	@Before
	public void setUp() throws Exception {
		NetModule.connect();
		price=new PriceManage();
	}

	@Test
	public void testGetAll() {
         price.getAll();
	}

	@Test
	public void testGetPrice() {
        price.getPrice("南京");
	}

	@Test
	public void testModifyPrice() {
		PriceVO vo=new PriceVO();
       price.modifyPrice(vo);
	}

	@Test
	public void testAddPrice() {
        PriceVO vo=new PriceVO();
        price.addPrice(vo);
	}

}
