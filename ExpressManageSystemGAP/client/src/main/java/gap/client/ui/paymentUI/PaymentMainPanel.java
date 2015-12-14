package gap.client.ui.paymentUI;

import java.util.ArrayList;

import javax.naming.InitialContext;

import gap.client.bl.receipt.AccountorReceiptController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanelWithGird;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.paymentUI.Listener.PaymentSubmitListener;
import gap.client.vo.AccountVO;
import gap.client.vo.PayeeVO;
import gap.client.vo.PaymentListVO;

public class PaymentMainPanel extends MainPanelWithGird{

	AccountorReceiptController receiptController;
	
	HeadPanel headPanel;
	PaymentDisplayPanel displayPanel;
	
	ArrayList<AccountVO> accountVOs;
	PaymentListVO paymentListVO;
	
	ButtonArea buttonArea;
	PaymentSubmitListener submitListener;
	
	public PaymentMainPanel(MainFrame frame) {
		super(frame);
		receiptController = AccountorReceiptController.getInstance();
		
		headPanel = new HeadPanel();
		initial();
	}
	
	private void initial() {
		// TODO Auto-generated method stub
		accountVOs = receiptController.getAccoutList();
		paymentListVO = receiptController.getPaymentList();
		
		displayPanel = new PaymentDisplayPanel
				(this, accountVOs, paymentListVO.getPayeeList());
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("提交付款单");
		
		submitListener = new PaymentSubmitListener(this);
		
		buttonArea.submit.addActionListener(submitListener);
		
		
		SwingConsole.addComponent(gb, gcons, this, headPanel	, 0, 0, 1, 1, 1, 0.2);
		SwingConsole.addComponent(gb, gcons, this, displayPanel , 0, 1, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, headPanel	, 0, 2, 1, 1, 1, 0);
	}

	public void submit() {
		receiptController.submitPaymentList(paymentListVO);
	}
	
}
