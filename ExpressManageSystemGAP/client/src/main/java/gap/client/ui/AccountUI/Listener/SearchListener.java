package gap.client.ui.AccountUI.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.print.attribute.standard.MediaSize.NA;

import gap.client.ui.AccountUI.AccountManagePanel;
import gap.client.ui.bussinessui.carmanage.QueryPanel;


public class SearchListener implements MouseListener{

	AccountManagePanel managePanel;
	QueryPanel queryPanel;
	
	public SearchListener(AccountManagePanel managePanel,QueryPanel queryPanel){
		this.managePanel = managePanel;
		this.queryPanel = queryPanel;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String key = queryPanel.getKey();
		managePanel.searchAccount(key);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
