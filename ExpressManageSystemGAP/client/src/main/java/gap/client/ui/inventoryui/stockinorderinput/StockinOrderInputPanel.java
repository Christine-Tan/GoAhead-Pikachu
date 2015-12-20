package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.blcontroller.ArrivedOrderController;
import gap.client.blcontroller.ExpressorderController;
import gap.client.blcontroller.StockinOrderController;
import gap.client.datacontroller.ArrivedOrderDataController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.GAPJScrollPane;
import gap.client.ui.gapcomponents.GAPScrollBarUI;
import gap.client.util.LocalInfo;
import gap.client.util.MessageType;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockinOrderVO;
import gap.common.po.ArrivedOrderPO;
import gap.common.util.Address;
import gap.common.util.ExpressType;
import gap.common.util.PeopleInfo;
import gap.common.util.ResultMessage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StockinOrderInputPanel extends MainPanel {
	StockinInfoUI stockinInfo;
	TitlePanel title;
	ButtonArea confirm;
	ListPanel list;
	List<ExpressOrderVO> orders;
	JFrame mainFrame;
	GAPScrollBarUI scrollBar;
	GridBagLayout gb;
	GridBagConstraints gcons;
	List<ArrivedOrderPO> arrivedOrders;
	String id;

	public StockinOrderInputPanel(MainFrame frame) {
		super(frame);
		mainFrame = frame;
		
		confirm = new ButtonArea();
		confirm.submit.setText("生成入库单");
		initial();
		

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		reLayout();
		
		
		
		confirm.submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockinOrderVO vo = getStockinOrderVO();
//				list.reLayout();
				ResultMessage re = StockinOrderController.save(vo);
				if(re.equals(ResultMessage.SUCCEED)){
					MainFrame.setMessage("入库单生成成功", MessageType.succeed, 3000);
//					String  id = arrivedOrders.get(0).getId();
					System.out.println("设置入库"+id);
					StockinOrderController.setOrderStockin(id);
					refresh();
				}else{
					MainFrame.setMessage("入库单为空", MessageType.alram, 3000);
				}
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
		String inDate = stockinInfo.getInDate();
		String id = stockinInfo.getId();
		String ins_id = LocalInfo.ins_id;
		
		StockinOrderVO vo = new StockinOrderVO(goods, inDate, id, ins_id);
		return vo;
	}
	
	public void initial(){
		stockinInfo = new StockinInfoUI();
		title = new TitlePanel();
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
		
		orders = new ArrayList<ExpressOrderVO>();
		arrivedOrders = new ArrayList<ArrivedOrderPO>();
		arrivedOrders = StockinOrderController.getArrivedOrderPO(LocalInfo.getIns_ID());
		if(arrivedOrders!=null&&arrivedOrders.size()>0){
			id = arrivedOrders.get(0).getId();
			System.out.println("初始化："+id);
			Set<String> ids = arrivedOrders.get(0).getOrders().keySet();
			if(ids!=null&&ids.size()>0){
				orders = ExpressorderController.getByOrderIdList(new ArrayList<>(ids));
			}
		}else{
			MainFrame.setMessage("所有到达单已安排入库", MessageType.succeed, 3000);
		}
		
//		
//		Address add = new Address("江苏省", "南京市", "栖霞区");
//		PeopleInfo receiver = new PeopleInfo("", add, "", "");
//		
//		for(int i = 1;i<=1;i++){
//			ExpressOrderVO vo = new ExpressOrderVO(null, receiver, ExpressType.ECONOMIC, 0, null,true, "0000000001","", "","");
//			vo.order_id = "000000000"+i;
//			orders.add(vo);
//		}
//		ExpressOrderVO vo10 = new ExpressOrderVO(null, receiver, ExpressType.ECONOMIC, 0, null,true, "0000000010","", "","");
//		ExpressOrderVO vo11 = new ExpressOrderVO(null, receiver, ExpressType.ECONOMIC, 0, null,true, "0000000011","", "","");
//		ExpressOrderVO vo12 = new ExpressOrderVO(null, receiver, ExpressType.ECONOMIC, 0, null,true, "0000000012","", "","");
//		orders.add(vo10);
//		orders.add(vo11);
//		orders.add(vo12);
		
		
		
		list = new ListPanel(orders);
	}
	
	public void reLayout(){
		removeAll();
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		
		gcons.fill = GridBagConstraints.BOTH;
		SwingConsole.addComponent(gb, gcons, this, stockinInfo, 0, 0, 1, 1, 1,
				0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 1, 1, 1, 1, 0);
		
		GAPJScrollPane js = new GAPJScrollPane(list);
		js.setPreferredSize(new Dimension(Default.PANEL_WIDTH, Math.min(list.items.size(),8)*50+15));
		
		
		SwingConsole.addComponent(gb, gcons, this, js, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 3, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 4, 1, 1, 1, 0);
		mainFrame.validate();
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		initial();
		reLayout();
	}
}
