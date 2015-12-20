package gap.client.bl.receipt;

import static org.junit.Assert.*;

import java.util.Calendar;

import gap.client.datacontroller.NetModule;
import gap.client.vo.PayeeVO;
import gap.common.po.PaymentListPO;
import gap.common.util.PaymentType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {
	AccountorReceiptController receipt;

	@Before
	public void setUp() throws Exception {
		NetModule.connect();
		receipt = AccountorReceiptController.getInstance();
	}

	@Test
	public void testGetPaymentList() {
		receipt.getPaymentList();
	}

	@Test
	public void testSubmitPaymentList() {
	}

	@Test
	public void testHandlePaymentList() {
	}

	@Test
	public void testAddPayee() {
		receipt.addPayee(new PayeeVO(PaymentType.CENTERCLERK, "000000001",
				"yyf", Calendar.getInstance(), 100.0, "账户1", "", ""));
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
