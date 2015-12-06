package gap.client.ui.inventoryui.observestock;

import gap.client.blcontroller.StockinOrderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.util.LocalInfo;
import gap.client.vo.StockinOrderVO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

public class ObserveStockPanel extends MainPanel{
	ButtonArea confirm;
	TitlePanel stockinTitle,stockoutTitle;
	ListPanel stockinList,stockoutList;
	TotalNumPanel stockinTotal,stockoutTotal,totalNum;
	ChoosePanel sectors;
	PeriodPanel period;
	
	public ObserveStockPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		
		confirm = new ButtonArea();
		confirm.submit.setText("确认");
		sectors = new ChoosePanel();
		period = new PeriodPanel();
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		
		SwingConsole.addComponent(gb, gcons, this, sectors, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, period, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 11, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 12, 1, 1, 1, 0);
		period.confirm.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String beginDate = period.getBeginDate();
				String endDate = period.getEndDate();
				String ins_id = LocalInfo.getIns_ID();
				
				stockinTitle = new TitlePanel("入库");
				stockoutTitle = new TitlePanel("出库");
				List<StockinOrderVO> list = StockinOrderController.getRequired(beginDate, endDate, ins_id);
				stockinList = new ListPanel(list);
				String inTotal  = StockinOrderController.getTotalNum(list)+"";
				stockinTotal = new TotalNumPanel("入库", "180");
				
			}
		});
		
		stockoutList = new ListPanel(null);
		
		stockoutTotal = new TotalNumPanel("出库", "180");
		totalNum = new TotalNumPanel("库存","3600");
		
		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));
		
		SwingConsole.addComponent(gb, gcons, this, stockinTitle, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockinList, 0, 4, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockinTotal, 0, 5, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockoutTitle, 0, 6, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockoutList, 0, 7, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, stockoutTotal, 0, 8, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 9, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, totalNum, 0, 10, 1, 1, 1, 0);
		
	}

}
