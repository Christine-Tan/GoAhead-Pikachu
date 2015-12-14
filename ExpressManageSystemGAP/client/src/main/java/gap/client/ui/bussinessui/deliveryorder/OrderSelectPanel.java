package gap.client.ui.bussinessui.deliveryorder;

import gap.client.blcontroller.ExpressorderController;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.ExpressOrderVO;
import gap.common.util.CurrentOrderType;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderSelectPanel extends JPanel {
	static List<ExpressOrderVO> total_orders = new ArrayList<>();
	private static boolean initialed;
	List<OrderItem> selectItems;
	List<OrderItem> unselectItem;
	JCheckBox checkBox;
	GAPTextField title_order_id, title_add;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JPanel titlePanel;

	public OrderSelectPanel() {
		// TODO 自动生成的构造函数存根
		// setOpaque(false);
		setBackground(Color.white);
		selectItems = new ArrayList<>();
		unselectItem = new ArrayList<>();
		checkBox = new JCheckBox();
		checkBox.setOpaque(false);
		title_order_id = new GAPTextField("快递单号", 12);
		title_order_id.setCenter();
		title_order_id.closeEdit();
		title_add = new GAPTextField("送往地", 20);
		title_add.setCenter();
		title_add.closeEdit();

		checkBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if (e.getStateChange() == ItemEvent.SELECTED) {
					for (int i = 0; !unselectItem.isEmpty();) {
						unselectItem.get(i).selected();
					}
				} else {
					for (int i = 0; !selectItems.isEmpty();) {
						selectItems.get(i).deSelected();
					}
				}
			}
		});

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		titlePanel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = RenderSetter.OpenRender(g);
				g2d.setColor(ComponentStyle.light_gray);
				int width = getWidth(), height = getHeight();
				g2d.drawLine(10, height - 3, width - 20, height - 3);
				// g2d.fillRect(0, 0, width, height);
			}
		};

		titlePanel.setOpaque(false);
		titlePanel.setLayout(gb);

		SwingConsole.addComponent(gb, gcons, titlePanel, checkBox, 0, 0, 1, 1,
				0, 0);
		SwingConsole.addComponent(gb, gcons, titlePanel, title_order_id, 1, 0,
				1, 1, 0.5, 0);
		SwingConsole.addComponent(gb, gcons, titlePanel, title_add, 2, 0, 1, 1,
				0.5, 0);

		initial();

		transreFresh();

	}

	/**
	 * 初始化
	 */
	static void initial() {
		if (!initialed) {
			initialed = true;
			total_orders = ExpressorderController
					.getCurrentOrders(CurrentOrderType.DELIVERY);
		}
	}

	/**
	 * 获得选中订单的订单号
	 * @return
	 */
	public List<String> getOrders() {
		List<String> order = new ArrayList<String>();
		for (OrderItem item : selectItems) {
			order.add(item.getOrderId());
		}
		return order;
	}

	// 跳转刷新
	void transreFresh() {
		removeAll();

		unselectItem.clear();

		for (ExpressOrderVO vo : total_orders) {
			unselectItem.add(new OrderItem(vo));
		}

		gcons.insets = new Insets(10, 5, 10, 5);

		SwingConsole
				.addComponent(gb, gcons, this, titlePanel, 0, 0, 1, 1, 1, 0);
		int i = 0;
		for (; i < selectItems.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, selectItems.get(i), 0,
					i + 1, 1, 1, 1, 0);
		}

		for (int j = 0; j < total_orders.size(); j++) {
			SwingConsole.addComponent(gb, gcons, this, unselectItem.get(j), 0,
					i + j + 1, 1, 1, 1, 0);
		}
	}

	class OrderItem extends JPanel {
		ExpressOrderVO expressorder;
		GAPTextField order_id, target_add;
		JCheckBox check;
		GridBagLayout gb;
		GridBagConstraints gcons;

		public OrderItem(ExpressOrderVO expressorder) {
			setOpaque(false);
			this.expressorder = expressorder;
			check = new JCheckBox();
			check.setOpaque(false);
			check.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO 自动生成的方法存根
					if (e.getStateChange() == ItemEvent.SELECTED) {
						selected();
					} else {
						deSelected();
					}
				}
			});
			order_id = new GAPTextField(expressorder.order_id, 12);
			order_id.setCenter();
			order_id.closeEdit();

			target_add = new GAPTextField(
					expressorder.receiver_info.getDepart(), 20);
			target_add.setCenter();
			target_add.closeEdit();

			gb = new GridBagLayout();
			gcons = new GridBagConstraints();

			setLayout(gb);

			SwingConsole.addComponent(gb, gcons, this, check, 0, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, order_id, 1, 0, 1, 1,
					0.5, 0);
			SwingConsole.addComponent(gb, gcons, this, target_add, 2, 0, 1, 1,
					0.5, 0);
		}

		void selected() {
			check.setSelected(true);
			if (!selectItems.contains(this)) {
				selectItems.add(this);
				unselectItem.remove(this);
				total_orders.remove(expressorder);
			}
		}

		void deSelected() {
			check.setSelected(false);
			if (selectItems.contains(this)) {
				selectItems.remove(this);
				unselectItem.add(this);
				total_orders.add(expressorder);
			}
		}

		String getOrderId() {
			return expressorder.order_id;
		}
	}
}
