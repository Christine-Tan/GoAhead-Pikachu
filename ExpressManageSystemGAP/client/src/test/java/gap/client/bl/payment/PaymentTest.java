package gap.client.bl.payment;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gap.client.bl.receipt.AccountorReceiptController;
import gap.client.datacontroller.AccountorReceiptDataController;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.NetModule;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.client.vo.PayeeVO;
import gap.client.vo.PaymentListVO;
import gap.common.po.TransFarePO;
import gap.common.util.Gender;
import gap.common.util.UserType;

public class PaymentTest {
	AccountorReceiptController receiptController;
	@Before
	public void setUp() throws Exception {
		User user = new User("000000005", UserType.ACCOUNTER, "xiaoming",
				"123456", "0010001", "小明", Gender.MALE);
		LocalInfo.localuser = user;
		LocalInfo.ins_id = "0010001";
		MainFrame frame = new MainFrame();
		NetModule.initial(frame);
		NetModule.connect();
		
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
	public void testGetTransFare(){
		AccountorReceiptDataController dataController = ControllerFactory.getReceiptDataController();
		
		List<TransFarePO> list = dataController.getTransFare();
		
		for(TransFarePO po : list){
			System.out.println(po.getOrderID()+" "+po.getFare());
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
