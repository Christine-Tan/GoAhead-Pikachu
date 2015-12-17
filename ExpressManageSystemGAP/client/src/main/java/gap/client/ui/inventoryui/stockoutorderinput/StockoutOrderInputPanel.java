package gap.client.ui.inventoryui.stockoutorderinput;

import gap.client.blcontroller.InstitutionController;
import gap.client.blcontroller.InventoryController;
import gap.client.blcontroller.StockoutOrderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.inventoryui.initialstock.ListItemPanel;
import gap.client.util.LocalInfo;
import gap.client.util.MessageType;
import gap.client.util.Transport;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.ResultMessage;
import gap.common.util.SectorType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StockoutOrderInputPanel extends MainPanel {
	StockoutInfoPanel stockoutInfo;
	ListPanel list;
	ButtonArea confirm;
	TitlePanel title;
	List<GoodsVO> voList;
	ChoosePanel choose;
	JFrame frame;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public StockoutOrderInputPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		voList = new ArrayList<GoodsVO>();
		
		initialList(LocalInfo.ins_id+"1");
		
		choose = new ChoosePanel();
		stockoutInfo = new StockoutInfoPanel();
		confirm = new ButtonArea();
		confirm.submit.setText("生成出库单");
		list = new ListPanel(voList);
		title = new TitlePanel();

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		reLayout();
		
		title.box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int state = e.getStateChange();
				if(state == ItemEvent.SELECTED){
					setSelected(true);
				}else{
					setSelected(false);
				}
			}
		});
		
		choose.car.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initialList(LocalInfo.ins_id+"1");
				list = new ListPanel(voList);
				choose.plane.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
		
		choose.train.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initialList(LocalInfo.ins_id+"2");
				list = new ListPanel(voList);
				choose.car.toNomal();
				choose.plane.toNomal();
				reLayout();
			}
		});

		choose.plane.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				initialList(LocalInfo.ins_id+"3");
				list = new ListPanel(voList);
				choose.car.toNomal();
				choose.train.toNomal();
				reLayout();
			}
		});
		
		confirm.submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockoutOrderVO vo = getStockoutOrderVO();
				ResultMessage re = StockoutOrderController.save(vo);
				if(re.equals(ResultMessage.SUCCEED)){
					MainFrame.setMessage("出库单生成成功", MessageType.succeed, 2000);
				}else{
					MainFrame.setMessage("出库单为空", MessageType.alram, 2000);
				}
			}
		});
	}
	
	public void initialList(String sector_id){
		voList = InventoryController.getOneSectorExisted(sector_id, LocalInfo.ins_id);
		if(voList.size()==0){
			MainFrame.setMessage("该分区快递为空", MessageType.normal, 2000);
		}
	}
	
	public void reLayout(){
		removeAll();
		JPanel panel = new JPanel();
		SwingConsole.addComponent(gb, gcons, this, stockoutInfo, 0, 0, 1, 1, 1,
				0);
		// 还差一个选项卡
		SwingConsole.addComponent(gb, gcons, this, choose, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, title, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 4, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 5, 1, 1, 1, 0);
		frame.validate();
	}
	
	public void setSelected(boolean bool){
		for(ListItem item:list.items){
			item.setSelected(bool);
		}
	}
	
	public StockoutOrderVO getStockoutOrderVO(){
		
		List<String> ids = list.getOrderIds();
		String date = stockoutInfo.getOutDate();
		String target_ins = stockoutInfo.getTargetIns();
		String id = stockoutInfo.getId();
		String transport = Transport.getTransportByName(stockoutInfo.getTransport()).toString();
		StockoutOrderVO vo = new StockoutOrderVO(ids, date, target_ins, id, transport, LocalInfo.ins_id);
		return vo;
		
	}

}
