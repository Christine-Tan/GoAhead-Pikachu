package gap.client.ui.bussinessui.arrivedorder;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPComboBox;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.ArrivedState;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListItemPanel extends JPanel {

	class ItemPanel extends JPanel {
		JButton detail;
		JLabel car_id, departure_ins_name, guard_name, driver_name, comment;

	}

	class DetailPanel extends JPanel {
		JLabel id_la, order_id_la, target_la, arrived_state_la;
		List<JComboBox<String>> arrivedstates;
		List<ExpressOrderVO> expressOrder;
		GridBagLayout gb;
		GridBagConstraints gcons;

		public DetailPanel(List<ExpressOrderVO> expressOrder) {
			super();
			gb = new GridBagLayout();
			gcons = new GridBagConstraints();
			setLayout(gb);
			this.expressOrder = expressOrder;
			arrivedstates = new ArrayList<JComboBox<String>>();
			for (int i = 0; i < expressOrder.size(); i++) {
				GAPComboBox<String> combobox = new GAPComboBox<>();
				combobox.addItem(ArrivedState.toChinese(ArrivedState.COMPLETE));
				combobox.addItem(ArrivedState.toChinese(ArrivedState.DAMAGE));
				combobox.addItem(ArrivedState.toChinese(ArrivedState.LOST));
				arrivedstates.add(combobox);
			}

			id_la = new GAPLabel("编号");
			order_id_la = new GAPLabel("订单编号");
			target_la = new GAPLabel("目的地");
			arrived_state_la = new GAPLabel("到达状态");
			SwingConsole.addComponent(gb, gcons, this, id_la, 0, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, order_id_la, 1, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, target_la, 2, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, arrived_state_la, 3, 0,
					1, 1, 0, 0);
			for (int i = 0; i < expressOrder.size(); i++) {
				addItem(expressOrder.get(i), i + 1);
			}

		}

		void addItem(ExpressOrderVO express, int i) {
			JLabel id = new GAPLabel("" + i), order_id = new GAPLabel(
					express.order_id), target = new GAPLabel(
					express.sender_info.getAddress().getCity_name());

			SwingConsole.addComponent(gb, gcons, this, id, 0, i, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, order_id, 1, i, 1, 1, 0,
					0);
			SwingConsole
					.addComponent(gb, gcons, this, target, 2, i, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this,
					arrivedstates.get(i - 1), 3, i, 1, 1, 0, 0);
		}

	}
}
