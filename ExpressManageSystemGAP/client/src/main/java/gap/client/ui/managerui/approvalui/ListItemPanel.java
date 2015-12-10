package gap.client.ui.managerui.approvalui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.blcontroller.ApprovalController;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPCheckBox;

public class ListItemPanel extends JPanel {
	// 待审批单据条目
	List<ItemPanel> items;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;
	JFrame frame;

	public ListItemPanel(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		setBackground(Color.WHITE);
		// 布局
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		items = new ArrayList<>();
		for (Object order : ApprovalController.getUnpassedOrder()) {
			addItem(order);
		}
	}

	private void addItem(Object order) {
		items.add(new ItemPanel(order));
	}

	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1, 1, 1, 0);
		}
	}

	class ItemPanel extends JPanel {
        JTextField id,type,date;
        GAPCheckBox select;
        boolean isSelected;
        
		public ItemPanel(Object order) {

		}

		void showDetail() {

		}

		void closeDetail() {

		}

	}
}
