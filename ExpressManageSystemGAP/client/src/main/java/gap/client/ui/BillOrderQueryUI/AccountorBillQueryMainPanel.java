package gap.client.ui.BillOrderQueryUI;

import java.util.List;

import gap.client.blcontroller.AccountorReceiptController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanelWithGird;
import gap.client.ui.UITools.SwingConsole;
import gap.client.vo.InstitutionVO;

public class AccountorBillQueryMainPanel extends MainPanelWithGird{

	AccountorBillQueryBar queryBar;
	AccountorReceiptController receiptController;
	List<InstitutionVO> institutionVOs;
	public AccountorBillQueryMainPanel(MainFrame frame) {
		super(frame);
		receiptController = AccountorReceiptController.getInstance();
		
		
		refresh();
	}
	
	

	@Override
	public void refresh() {
		removeAll();
		institutionVOs = receiptController.getAllInstitution();
		queryBar = new AccountorBillQueryBar(this, institutionVOs);
		SwingConsole.addComponent(gb, gcons, this, queryBar, 0, 0, 1, 1, 1, 0);
	}

}
