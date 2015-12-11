package gap.client.ui.paymentUI;

import gap.client.bl.receipt.AccountorReceiptController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanelWithGird;

public class PaymentMainPanel extends MainPanelWithGird{

	AccountorReceiptController receiptController;
	public PaymentMainPanel(MainFrame frame) {
		super(frame);
		receiptController = AccountorReceiptController.getInstance();
	}
	
}
