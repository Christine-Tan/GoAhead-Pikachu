package gap.client.ui.initialUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.List;

import javax.swing.JPanel;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import gap.client.blcontroller.InitialController;
import gap.client.blservice.initialblservice.InitialBlService;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanelWithGird;
import gap.client.ui.UITools.SwingConsole;
import gap.client.util.MessageType;
import gap.common.po.AccountPO;
import gap.common.po.InitialHistoryPO;
import gap.common.po.InitialPeoplePO;
import gap.common.util.ResultMessage;

public class InitialMainPanel extends MainPanelWithGird{

	InitialBlService initialBl;
	CreatInitialPanel creatInitialPanel;
	InitialHistoryPanel historyPanel;
	HorizontalNavi horizontalNavi;
	
	public InitialMainPanel(MainFrame frame) {
		super(frame);
		initialBl = InitialController.getInstance();
		refresh();
	}

	public void refresh() {
		
		InitialHistoryPO historyPO = initialBl.getCurrentInitial();
		
//		for(AccountPO accountPO:historyPO.accountPOs){
//			System.out.println(accountPO.getName());
//		}
//		
//		for(InitialPeoplePO peoplePO:historyPO.initialPeoplePOs){
//			System.out.println(peoplePO.getCityName());
//			System.out.println(peoplePO.businessClerkNum);
//			System.out.println(peoplePO.businessHallNum);
//		}
		
		creatInitialPanel = new CreatInitialPanel(this, historyPO);
		
		List<InitialHistoryPO> historyPOs = initialBl.getInitialHistory();
		historyPanel = new InitialHistoryPanel(this, historyPOs);
		horizontalNavi = new HorizontalNavi(this, historyPanel, creatInitialPanel);
		
		horizontalNavi.setPreferredSize(new Dimension(500, 50));
		
		SwingConsole.addComponent(gb, gcons, this, horizontalNavi, 0, 0, 1, 1, 1, 0);
		
		gcons.fill = GridBagConstraints.BOTH;
		SwingConsole.addComponent(gb, gcons, this, creatInitialPanel, 0, 1, 1, 1, 1, 1);
		
	}

	public void jumpTo(JPanel panel) {
		//dsa
	}

	public void confirm(InitialHistoryPO historyPO) {
		ResultMessage message = initialBl.submitInitial(historyPO);
		if(message.equals(ResultMessage.SUCCEED)){
			MainFrame.setMessage("建账成功", MessageType.succeed, 2000);
		}else{
			MainFrame.setMessage("建账失败", MessageType.alram, 2000);
		}
	}

	
}
