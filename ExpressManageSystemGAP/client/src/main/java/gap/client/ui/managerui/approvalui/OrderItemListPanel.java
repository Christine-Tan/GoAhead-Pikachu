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
import gap.client.vo.ArrivedOrderVO;
import gap.client.vo.BillOrderVO;
import gap.client.vo.DeliveryOrderVO;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.LoadOrderVO;
import gap.client.vo.StockinOrderVO;
import gap.client.vo.StockoutOrderVO;

public class OrderItemListPanel extends JPanel {
	// 列表中所有的项
	List<ItemPanel> items;
	List<Object> orders;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;
	// 判断是否被全选
	boolean allSelected;
	JFrame frame;

	public OrderItemListPanel(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		setBackground(Color.WHITE);
		allSelected = false;
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

	public boolean allSelect(boolean allSelected) {
		this.allSelected = allSelected;
		if (this.allSelected) {
			for (ItemPanel item : items) {
				item.select.setSelected(false);
				item.selected = false;
			}
			this.allSelected = false;
		} else {
			for (ItemPanel item : items) {
				item.select.setSelected(true);
				item.selected = true;
			}
			this.allSelected = true;
		}
		return this.allSelected;
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
			
			if (order instanceof ArrivedOrderVO) {
				System.out.println("arrivedOrder");
				ArrivedOrderVO arrivedOrder = (ArrivedOrderVO) order;
				order_id.setText(arrivedOrder.id);
				type.setText("到达单");
				date.setText(arrivedOrder.time);
			} else if (order instanceof BillOrderVO) {
				System.out.println("billOrder");
				BillOrderVO billOrder = (BillOrderVO) order;
				order_id.setText("0000000000000");
				type.setText("收款单");
				date.setText(billOrder.date.toString());
			} else if (order instanceof DeliveryOrderVO) {
				System.out.println("deliveryOrder");
				DeliveryOrderVO deliveryOrder = (DeliveryOrderVO) order;
				order_id.setText(deliveryOrder.id);
				type.setText("派件单");
				date.setText(deliveryOrder.time);
			} else if (order instanceof ExpressOrderVO) {
				System.out.println("expressOrder");
				ExpressOrderVO expressOrder = (ExpressOrderVO) order;
				order_id.setText(expressOrder.order_id);
				type.setText("寄件单");
				date.setText("0000-00-00");
			} else if (order instanceof LoadOrderVO) {
				System.out.println("loadOrder");
				LoadOrderVO loadOrder = (LoadOrderVO) order;
				order_id.setText(loadOrder.order_id);
				type.setText("装车单");
				date.setText(loadOrder.date);
			} else if (order instanceof StockinOrderVO) {
				System.out.println("stockinOrder");
				StockinOrderVO stockinOrder = (StockinOrderVO) order;
				order_id.setText(stockinOrder.getId());
				type.setText("入库单");
				date.setText(stockinOrder.getInDate());
			} else if (order instanceof StockoutOrderVO) {
				System.out.println("stockoutOrder");
				StockoutOrderVO stockoutOrder = (StockoutOrderVO) order;
				order_id.setText(stockoutOrder.getId());
				type.setText("出库单");
				date.setText(stockoutOrder.getOutDate());
			}else{
				System.out.println("no corresponding ordertype");
			}
			
			detail = new GAPButton(">");
			select = new GAPCheckBox();
			select.setSelected(false);
			selected = false;
			// 添加选中按钮的监听
			select.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (selected) {
						select.setSelected(false);
						selected = false;
					} else {
						select.setSelected(true);
						selected = true;
					}
				}
			});
            
//			order_id.closeEdit();
//			type.closeEdit();
//			date.closeEdit();
			// 布局
			gbl = new GridBagLayout();
			setLayout(gbl);
			gcons.insets = new Insets(10, 5, 10, 20);
			SwingConsole.addComponent(gbl, gcons, this, detail, 0, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(10, 0, 10, 0);
			SwingConsole.addComponent(gbl, gcons, this, order_id, 1, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(10, 10, 10, 0);
			SwingConsole.addComponent(gbl, gcons, this, type, 2, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gbl, gcons, this, date, 3, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(10, 55, 10, 30);
			SwingConsole.addComponent(gbl, gcons, this, select, 4, 0, 1, 1, 0, 0);
		}
	}
}
