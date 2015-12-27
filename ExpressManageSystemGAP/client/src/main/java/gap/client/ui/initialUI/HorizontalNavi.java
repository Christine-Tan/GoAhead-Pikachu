package gap.client.ui.initialUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ChooseButton;
import gap.client.ui.paymentUI.PanelWithGrid;
import gap.common.po.InitialPeoplePO;

public class HorizontalNavi extends PanelWithGrid{
	
	ChooseButton historyButton;
	ChooseButton initialButton;
	
	InitialMainPanel mainPanel;
	InitialHistoryPanel historyPanel;
	CreatInitialPanel creatInitialPanel;
	
	InitialPanelListener listener;
	
	public HorizontalNavi
	(InitialMainPanel mainPanel,
			InitialHistoryPanel historyPanel,CreatInitialPanel creatInitialPanel){
		this.mainPanel = mainPanel;
		this.historyPanel = historyPanel;
		this.creatInitialPanel = creatInitialPanel;
		
		
		listener = new InitialPanelListener();
		
		historyButton = new ChooseButton("查看期初信息", historyPanel);
		initialButton = new ChooseButton("新建期初信息", creatInitialPanel);
		
		historyButton.addMouseListener(listener);
		initialButton.addMouseListener(listener);
		
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, historyButton, 0, 0, 1, 1, 0, 1);
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints ,this, initialButton, 1, 0, 1, 1, 0, 1);
	}
	
	class InitialPanelListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			ChooseButton button = (ChooseButton)e.getSource();
			mainPanel.jumpTo(button.getPanel());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
	}
	
}