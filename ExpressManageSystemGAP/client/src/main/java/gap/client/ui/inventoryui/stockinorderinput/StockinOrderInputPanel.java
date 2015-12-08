package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.blcontroller.StockinOrderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.util.LocalInfo;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.util.Address;
import gap.common.util.ExpressType;
import gap.common.util.PeopleInfo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class StockinOrderInputPanel extends MainPanel {
	StockinInfoUI stockinInfo;
	TitlePanel title;
	ButtonArea confirm;
	ListPanel list;
	List<ExpressOrderVO> orders;

	public StockinOrderInputPanel(MainFrame frame) {
		super(frame);
		orders = new ArrayList<ExpressOrderVO>();
		
		Address add = new Address("江苏省", "南京市", "栖霞区");
		PeopleInfo receiver = new PeopleInfo("", add, "", "");
		
		for(int i = 1;i<=9;i++){
			ExpressOrderVO vo = new ExpressOrderVO(null, receiver, ExpressType.ECONOMIC, 0, null,true, "0000000001","", "");
			vo.order_id = "000000000"+i;
			orders.add(vo);
		}

		stockinInfo = new StockinInfoUI();
		title = new TitlePanel();
		confirm = new ButtonArea();
		confirm.submit.setText("生成入库单");
		list = new ListPanel(orders);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		JPanel panel = new JPanel();
		// gcons.insets = new Insets(0,10,0,10);
		// gcons.fill = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, stockinInfo, 0, 0, 1, 1, 1,
				0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 4, 1, 1, 1, 0);
		
		title.box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					setSelected(true);
				} else {
					setSelected(false);
				}
				
			}
		});
		
		confirm.submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockinOrderVO vo = getStockinOrderVO();
				StockinOrderController.save(vo);
			}
		});
		

	}
	
	public void setSelected(Boolean bool){
		for(ListItem item:list.items){
			item.setSelected(bool);
		}
	}
	
	public StockinOrderVO getStockinOrderVO(){
		
		List<GoodsVO> goods = list.getGoodsVOs();
		System.out.println(goods.size());
		String inDate = stockinInfo.date_text.getText();
		String id = stockinInfo.id_text.getText();
		String ins_id = LocalInfo.ins_id;
		
		StockinOrderVO vo = new StockinOrderVO(goods, inDate, id, ins_id);
		return vo;
	}
}
