package gap.client.ui.bussinessui.billorderui;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.BillVO;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListItemPanel extends JPanel {
	List<ItemPanel> items;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JFrame jf;

	public ListItemPanel(JFrame jf) {
		this.jf = jf;
		setOpaque(false);
		items = new ArrayList<>();
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		BillVO billVO = new BillVO();
		billVO.id = "000000005";
		billVO.name = "yyf";
		billVO.money = 50;
		billVO.date = "2015-02-01";
		addItem(billVO);
	}

	private void addItem(BillVO billVO) {
		items.add(new ItemPanel(billVO));
		reLayout();
	}

	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			ItemPanel item = items.get(i);
			item.setId(String.valueOf(i + 1));
			SwingConsole.addComponent(gb, gcons, this, item, 0, i, 1, 1, 1, 0);
		}
		jf.validate();
	}

	class ItemPanel extends JPanel {
		BillVO billVO;
		GAPTextField id, delivery_id, name, money, date;

		public ItemPanel(BillVO billVO) {
			this.billVO = billVO;
			setPreferredSize(new Dimension(Default.PANEL_WIDTH, 50));
			setOpaque(false);
			id = new GAPTextField(2);
			delivery_id = new GAPTextField(billVO.id, 7);
			name = new GAPTextField(billVO.name, 4);
			money = new GAPTextField(String.valueOf(billVO.money), 3);
			date = new GAPTextField(billVO.date, 7);

			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gcons = new GridBagConstraints();
			setLayout(gb);

			gcons.insets = new Insets(10, 0, 10, 0);
			SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(10, 70, 10, 0);
			SwingConsole.addComponent(gb, gcons, this, delivery_id, 1, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, name, 2, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(10, 70, 10, 0);
			SwingConsole.addComponent(gb, gcons, this, money, 3, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(10, 70, 10, 0);
			SwingConsole.addComponent(gb, gcons, this, date, 4, 0, 1, 1, 0, 0);

			closeEdit();
		}

		void closeEdit() {
			id.closeEdit();
			delivery_id.closeEdit();
			name.closeEdit();
			money.closeEdit();
			date.closeEdit();
		}

		public void setId(String id) {
			this.id.setText(id);
		}
	}
}
