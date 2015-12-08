package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.ui.UITools.SwingConsole;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.common.util.Address;
import gap.common.util.ExpressType;
import gap.common.util.PeopleInfo;
import gap.common.util.ReceiveInfo;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ListPanel extends JPanel {
	List<ListItem> items;
	List<ExpressOrderVO> expressorders;
	List<GoodsVO> goods;

	public ListPanel() {
		setBackground(Color.white);
		
		Address add = new Address("江苏省", "南京市", "栖霞区");
		PeopleInfo receiver = new PeopleInfo("", add, "", "");
		ExpressOrderVO vo = new ExpressOrderVO(null, receiver, ExpressType.STANDARD, 0, null,true, "00000000000000000001","", "");
		
		items = new ArrayList<ListItem>();
		int size = 10;
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
}
