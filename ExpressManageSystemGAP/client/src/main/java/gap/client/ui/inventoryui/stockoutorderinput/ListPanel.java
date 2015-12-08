package gap.client.ui.inventoryui.stockoutorderinput;

import gap.client.ui.UITools.SwingConsole;
import gap.client.util.LocalInfo;
import gap.client.vo.GoodsVO;
import gap.common.util.SectorType;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ListPanel extends JPanel {
	List<ListItem> items;
	List<String> ids;

	public ListPanel() {
		setBackground(Color.white);

		GoodsVO vo = new GoodsVO("0000000001", "汽运区A排A架1位",
				SectorType.CAR, "2015-12-07", LocalInfo.ins_id + "1",
				LocalInfo.ins_id + "1", "江苏省南京市栖霞区");
		items = new ArrayList<ListItem>();
		int size = 5;
		for (int i = 0; i < size; i++) {
			ListItem item = new ListItem(vo);
			items.add(item);
		}

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.insets = new Insets(0, 10, 0, 10);
		for (int i = 0; i < size; i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1,
					1, 1, 0);
		}
	}
	
	public List<String> getOrderIds(){
		ids = new ArrayList<String>();
		for(ListItem item:items){
			String id = item.getGoodsId();
			if(id!=null){
				ids.add(id);
			}
		}
		return ids;
	}
}
