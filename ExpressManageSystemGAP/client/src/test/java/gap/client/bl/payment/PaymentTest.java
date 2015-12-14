package gap.client.bl.payment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gap.client.bl.receipt.AccountorReceiptController;
import gap.client.vo.PayeeVO;
import gap.client.vo.PaymentListVO;

public class PaymentTest {
	AccountorReceiptController receiptController;
	@Before
	public void setUp() throws Exception {
		receiptController = AccountorReceiptController.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPaymentList() {
		PaymentListVO list = receiptController.getPaymentList();
		
		for(PayeeVO vo:list.getPayeeList()){
			
			System.out.println(vo.getUserName()+"  "+vo.getAccountName());
		}
	}

	@Test
	public void testSubmitPaymentList() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandlePaymentList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAccoutList() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPayee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePayee() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyPayee() {
		fail("Not yet implemented");
	}

	@Test
	public void testPaymentExcel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBillOrderByDateOrIns() {
		fail("Not yet implemented");
	}

	@Test
	public void testHandleBillOrder() {
		fail("Not yet implemented");
	}

}
