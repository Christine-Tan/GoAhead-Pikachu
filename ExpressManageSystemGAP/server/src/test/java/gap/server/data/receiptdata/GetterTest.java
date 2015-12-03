package gap.server.data.receiptdata;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gap.server.initial.NetInitial;

public class GetterTest {
	PaymentGetter getter;
	@Before
	public void setUp() throws Exception {
		NetInitial.initial();
		getter = new PaymentGetter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPassedPayment() {
		
	}

}
