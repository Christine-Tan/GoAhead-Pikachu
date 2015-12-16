package gap.client.ui.managerui.approvalui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.blcontroller.ApprovalController;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPCheckBox;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.BillOrderPO;
import gap.common.po.DeliveryOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.po.LoadOrderPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;

public class OrderItemListPanel extends JPanel {
	// 列表中所有的项
	List<ItemPanel> items;
	List<Object> orders;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;
	JFrame frame;

	public OrderItemListPanel(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		setBackground(Color.WHITE);
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		items = new ArrayList<>();
		orders = ApprovalController.getUnpassedOrder();
		for (Object order : orders) {
			items.add(new ItemPanel(order));
		}
		showItems();
	}

	private void showItems() {
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1, 1, 1, 0);
		}
	}

	class ItemPanel extends JPanel {
		GAPTextField order_id, type, date;
		JButton detail;
		GAPCheckBox select;
		// 布局
		GridBagLayout gbl;
		// 是否被选中
		boolean selected;

		ItemPanel(Object order) {
			setBackground(Color.WHITE);
			// 组件初始化
			order_id = new GAPTextField(20);
			type = new GAPTextField(13);
			date = new GAPTextField(10);
			this.setLayout(gbl);
			order_id.setHorizontalAlignment(JTextField.CENTER);
			type.setHorizontalAlignment(JTextField.CENTER);
			date.setHorizontalAlignment(JTextField.CENTER);
			order_id.closeEdit();
			type.closeEdit();
			date.closeEdit();
			if (order instanceof ArrivedOrderPO) {
				ArrivedOrderPO arrivedOrder = (ArrivedOrderPO) order;
				order_id.setText(arrivedOrder.getId());
				type.setText("到达单");
				date.setText(arrivedOrder.getTime());
			} else if (order instanceof BillOrderPO) {
				BillOrderPO billOrder = (BillOrderPO) order;
				order_id.setText(billOrder.getId());
				type.setText("收款单");
				date.setText(billOrder.getBillDate().toString());
			} else if (order instanceof DeliveryOrderPO) {
				DeliveryOrderPO deliveryOrder = (DeliveryOrderPO) order;
				order_id.setText(deliveryOrder.getId());
				type.setText("派件单");
				date.setText(deliveryOrder.getTime());
			} else if (order instanceof ExpressOrderPO) {
				ExpressOrderPO expressOrder = (ExpressOrderPO) order;
				order_id.setText(expressOrder.getOrder_id());
				type.setText("寄件单");
				date.setText(expressOrder.getTime());
			} else if (order instanceof LoadOrderPO) {
				LoadOrderPO loadOrder = (LoadOrderPO) order;
				order_id.setText(loadOrder.getOrder_id());
				type.setText("装车单");
				date.setText(loadOrder.getDate());
			} else if (order instanceof StockinOrderPO) {
				StockinOrderPO stockinOrder = (StockinOrderPO) order;
				order_id.setText(stockinOrder.getId());
				type.setText("入库单");
				date.setText(stockinOrder.getInDate());
			} else if (order instanceof StockoutOrderPO) {
				StockoutOrderPO stockoutOrder = (StockoutOrderPO) order;
				order_id.setText(stockoutOrder.getId());
				type.setText("出库单");
				date.setText(stockoutOrder.getOutDate());
			} else {
				System.out.println("no corresponding ordertype");
			}

			detail = new GAPButton(">");
			select = new GAPCheckBox();

			// 布局
			gbl = new GridBagLayout();
			setLayout(gbl);
			gcons.insets = new Insets(5, 5, 10, 20);
			SwingConsole.addComponent(gbl, gcons, this, detail, 0, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 0, 10, 0);
			SwingConsole.addComponent(gbl, gcons, this, order_id, 1, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 10, 10, 0);
			SwingConsole.addComponent(gbl, gcons, this, type, 2, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gbl, gcons, this, date, 3, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 55, 10, 30);
			SwingConsole.addComponent(gbl, gcons, this, select, 4, 0, 1, 1, 0, 0);
		}

		void setSelected(boolean bool) {
			this.select.setSelected(bool);
		}

	}
}
