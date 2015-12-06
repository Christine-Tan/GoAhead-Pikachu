package gap.client.ui.bussinessui.arrivedorder;

import gap.client.blcontroller.ExpressorderController;
import gap.client.blcontroller.InstitutionController;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPComboBox;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.InstitutionVO;
import gap.client.vo.LoadOrderVO;
import gap.client.vo.UserVO;
import gap.common.util.ArrivedState;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class ListItemPanel extends JPanel {

	class ItemPanel extends JPanel {
		JButton detail;
		JLabel car_id, departure_ins_name, guard_name, driver_name, comment;
		DetailPanel detailPanel;
		JCheckBox checkBox;
		boolean showed;

		public ItemPanel(List<LoadOrderVO> orders) {

		}

		public ItemPanel(LoadOrderVO loadOrder) {
			super();
			// detailPanel = new DetailPanel();
			List<ExpressOrderVO> list = ExpressorderController
					.getByOrderIdList(loadOrder.orders);
			InstitutionVO depature_ins = InstitutionController
					.findById(loadOrder.departureins_id);
			checkBox = new JCheckBox();
			checkBox.setBackground(Color.white);
			car_id = new GAPLabel(loadOrder.car_id);
			departure_ins_name = new GAPLabel(depature_ins.getInsName());
			
			comment = new GAPLabel(loadOrder.comment);
			detailPanel = new DetailPanel(list);
			detail = new GAPButton(">");
			detail.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					if (showed) {
						hideDetail();
					} else {
						showDetail();
					}
				}
			});

			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gcons = new GridBagConstraints();
			setLayout(gb);

			SwingConsole
					.addComponent(gb, gcons, this, detail, 0, 0, 1, 1, 0, 0);
			SwingConsole
					.addComponent(gb, gcons, this, car_id, 1, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, departure_ins_name, 2,
					0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, guard_name, 3, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, driver_name, 4, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, comment, 5, 0, 1, 1, 0,
					0);
		}

		void showDetail() {
			showed = true;
			detail.setText("v");
			detailPanel.setVisible(true);
		}

		void hideDetail() {
			showed = false;
			detail.setText(">");
			detailPanel.setVisible(false);
		}
	}

	/**
	 * 详细信息的面板
	 * @author YangYanfei
	 *
	 */
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
