package gap.client.ui.AccountUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import gap.client.ui.UITools.Default;
import gap.client.vo.AccountVO;

public class AccountDisplayPanel extends JPanel{

	ArrayList<AccountVO> accounts;
	AccountManagePanel accountManagePanel;
	JViewport viewport;
	FlowLayout flow;
	
	final int hGarp = 50;//水平间隙
	final int vGarp = 10;//垂直间隙
	
	HashMap<AccountBox, AccountVO> accountMap;
	public AccountDisplayPanel
	(AccountManagePanel accountManagePanel, ArrayList<AccountVO> accountVOs,
			JViewport viewport){
		
		accounts = accountVOs;		
		this.accountManagePanel = accountManagePanel;
		accountMap = new HashMap<>(accounts.size());
		
		this.viewport = viewport;
		
		setOpaque(false);
		
		viewport.addComponentListener(new MyResizeListener());
		
		flow = new FlowLayout(FlowLayout.LEFT, 50, 10);
		setLayout(flow);
		repaint();
		addAccountBox();
		reSize();
	}
	
	public void reSize(){
		
		if(viewport==null){
			return;
		}
		int containerWidth = viewport.getWidth();
		int containerHeight = viewport.getHeight();


		
		if(accountMap.keySet().isEmpty()){
			return;
		}
		//面板格式不对，还没有被完全new出来
		if(containerWidth<=0 || containerHeight<=0){
			return;
		}
		
		int boxWidth = AccountBox.width;
		int boxHeight = AccountBox.height;
		//一行最多放几个box
		int numberInRow = containerWidth/(boxWidth +  hGarp);
		//有多少行
		int rowNumber = accounts.size()/numberInRow;

		
		
		if(accounts.size()%numberInRow>0){
			rowNumber++;
		}
		
		int width = numberInRow * (boxWidth + 2* hGarp);
		int height = rowNumber * (boxHeight + 2* vGarp);
		setPreferredSize(new Dimension(width, height));
		flow.layoutContainer(this);
		accountManagePanel.revalidate();
		accountManagePanel.repaint();
		
	}
	
	public void addAccountBox(){
		for(AccountVO vo : accounts){
			AccountBox box = new AccountBox(this, vo);
			accountMap.put(box, vo);
			add(box);
		}
		
	}
	
	class MyResizeListener implements ComponentListener{

		@Override
		public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent e) {
			// TODO Auto-generated method stub
			reSize();
		}

		@Override
		public void componentShown(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
