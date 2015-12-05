package gap.client.ui.managerui.priceui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListItemPanel extends JPanel {
	// 列表中所有的项
	List<ItemPanel> items;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;

	JButton addButton;
	JFrame frame;

	public ListItemPanel(JFrame frame) {
		this.frame = frame;
		setBackground(Color.WHITE);

		// 对列表项里每一个panel进行布局
		items = new ArrayList<>();
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		// 获得所有价格信息

	}

	// 添加一个列表项
	// 新增一个空列表项
	// 删除一个列表项
	// 重新布局
	class ItemPanel {

	}
}
