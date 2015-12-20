package gap.client.bl.approval;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gap.client.datacontroller.NetModule;

public class ApprovalTest {
    Approval approval;
	@Before
	public void setUp() throws Exception {
		NetModule.connect();
		approval=new Approval();
	}

	@Test
	public void testGetUnpassedOrder() {
	   approval.getUnpassedOrder();
	}

	@Test
	public void testApprove() {
	}

}
