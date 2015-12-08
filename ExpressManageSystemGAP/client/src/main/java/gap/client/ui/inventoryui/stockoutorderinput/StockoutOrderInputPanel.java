package gap.client.ui.inventoryui.stockoutorderinput;

import gap.client.blcontroller.InstitutionController;
import gap.client.blcontroller.StockoutOrderController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.util.LocalInfo;
import gap.client.util.Transport;
import gap.client.vo.GoodsVO;
import gap.client.vo.StockoutOrderVO;
import gap.common.util.SectorType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class StockoutOrderInputPanel extends MainPanel {
	StockoutInfoPanel stockoutInfo;
	ListPanel list;
	ButtonArea confirm;
	TitlePanel title;
	List<GoodsVO> voList;

	public StockoutOrderInputPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		
		voList = new ArrayList<GoodsVO>();
		for(int i = 1;i<=5;i++){
			GoodsVO vo = new GoodsVO("0000000001", "汽运区A排A架1位",
					SectorType.CAR, "2015-12-07", LocalInfo.ins_id + "1",
					LocalInfo.ins_id + "1", "江苏省南京市栖霞区");
			vo.setExpressorder_id("000000000"+i);
			voList.add(vo);
		}
		stockoutInfo = new StockoutInfoPanel();
		confirm = new ButtonArea();
		confirm.submit.setText("生成出库单");
		list = new ListPanel(voList);
		title = new TitlePanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		JPanel panel = new JPanel();
		SwingConsole.addComponent(gb, gcons, this, stockoutInfo, 0, 0, 1, 1, 1,
				0);
		// 还差一个选项卡
		SwingConsole.addComponent(gb, gcons, this, title, 0, 2, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, list, 0, 3, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel, 0, 4, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 5, 1, 1, 1, 0);
		
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
		
		confirm.submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockoutOrderVO vo = getStockoutOrderVO();
				StockoutOrderController.save(vo);
			}
		});
	}
	
	public void setSelected(boolean bool){
		for(ListItem item:list.items){
			item.setSelected(bool);
		}
	}
	
	public StockoutOrderVO getStockoutOrderVO(){
//		StockoutOrderVO vo = new StockoutOrderVO(expressorder_ids, outDate, target_ins, id, transport, ins_id)
		
		List<String> ids = list.getOrderIds();
		String date = stockoutInfo.getOutDate();
		String target_ins = stockoutInfo.getTargetIns();
		String id = stockoutInfo.getId();
		String transport = Transport.getTransportByName(stockoutInfo.getTransport()).toString();
		StockoutOrderVO vo = new StockoutOrderVO(ids, date, target_ins, id, transport, LocalInfo.ins_id);
		return vo;
		
	}

}
