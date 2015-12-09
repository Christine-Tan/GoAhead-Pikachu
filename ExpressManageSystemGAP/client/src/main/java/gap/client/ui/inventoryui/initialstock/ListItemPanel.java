package gap.client.ui.inventoryui.initialstock;

import gap.client.blcontroller.DriverManageController;
import gap.client.blcontroller.InventoryController;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.util.LocalInfo;
import gap.client.vo.GoodsVO;
import gap.common.util.SectorType;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListItemPanel extends JPanel {
	// 列表中所有的项
	List<ItemPanel> items;
	GridBagLayout gb;
	GridBagConstraints gcons;
	// 添加button
	JButton addButton;
	JFrame frame;

	public ListItemPanel(JFrame frame) {
		this.frame = frame;
		setBackground(Color.white);

		addButton = new GAPButton("+");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				addNewItem();
			}
		});

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		items = new ArrayList<>();

		List<GoodsVO> VOs = InventoryController.getOneSectorExisted("00110011", "0011001");
		for (int i = 1;i<=VOs.size();i++) {
			addItem(VOs.get(i-1),i);
		}
	}

	/**
	 * 根据一个已有VO添加项
	 * 
	 * @param driver
	 */
	private void addItem(GoodsVO goods,int i) {
		items.add(new ItemPanel(goods,i));
		reLayout();
		frame.validate();
	}

	/**
	 * 添加一个新项目
	 */
	private void addNewItem() {
		ItemPanel item = new ItemPanel(items.size()+1);
		item.original = true;
		item.openEdit();
		items.add(item);
		reLayout();
		frame.validate();
	}

	/**
	 * 移除一项
	 * 
	 * @param item
	 */
	private void removeItem(ItemPanel item) {
		items.remove(item);
		remove(item);
		InventoryController.InitialDelete(item.goods.getExpressorder_id());
//		DriverManageController.delete(item.driver.getId());
		reLayout();
		frame.validate();
	}

	/**
	 * 重新布局
	 */
	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1,
					1, 1, 0);
		}
		SwingConsole.addComponent(gb, gcons, this, addButton, 0, items.size(),
				1, 1, 1, 0);
	}

	// 每一项
	class ItemPanel extends JPanel {
		GoodsVO goods;
		// 显示详细信息、删除、改变编辑状态的按钮
		JButton delete_la, edit_la;
		JLabel id;
		GAPTextField order_id, destination, inDate, location;
		GridBagLayout gb;
		GridBagConstraints gcons;
		boolean original;
		boolean edited, showed;

		public ItemPanel(int i) {
			setBackground(Color.white);
			setFocusable(true);
			setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));
			gb = new GridBagLayout();
			gcons = new GridBagConstraints();

			edit_la = new GAPButton("E");
			edit_la.setFont(ComponentStyle.defaultFont);
			edit_la.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					if (!edited) {
						openEdit();
					} else {
						closeEdit();
						if (original) {
							original = false;
							InventoryController.InitialAdd(goods);
							// DriverManageController.add(driver);
							System.out.println("add");
						} else {
							InventoryController.InitialModify(goods);
							// DriverManageController.modify(driver);
							System.out.println("modify");
						}
					}
				}
			});
			delete_la = new GAPButton("x");
			delete_la.setFont(ComponentStyle.defaultFont);
			delete_la.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					removeItem(ItemPanel.this);
				}
			});
			
			id = new GAPLabel(i+"");
			id.setPreferredSize(new Dimension(40, 25));
			id.setHorizontalAlignment(JLabel.RIGHT);
			
			order_id = new GAPTextField(8);
			order_id.setCenter();
			destination = new GAPTextField(12);
			destination.setCenter();
			inDate = new GAPTextField(7);
			inDate.setCenter();
			location = new GAPTextField(10);
			location.setCenter();
			setLayout(gb);
			gcons.insets = new Insets(0, 10, 0, 10);
			SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, order_id, 1, 0, 1, 1, 0, 0);
			SwingConsole
					.addComponent(gb, gcons, this, inDate, 2, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, location, 3, 0, 1, 1, 0,
					0);
			// gcons.insets = new Insets(10, 80, 10, 0);
			SwingConsole.addComponent(gb, gcons, this, destination, 4, 0, 1, 1,
					0, 0);
			// gcons.insets = new Insets(10, 40, 10, 10);
			SwingConsole.addComponent(gb, gcons, this, edit_la, 5, 0, 1, 1, 0,
					0);
			// gcons.insets = new Insets(10, 10, 10, 10);
			SwingConsole.addComponent(gb, gcons, this, delete_la, 6, 0, 1, 1,
					0, 0);

			closeEdit();
		}

		public ItemPanel(GoodsVO goods,int i) {
			this(i);
			this.goods = goods;
			order_id.setText(goods.getExpressorder_id());
			destination.setText(goods.getDestination());
			location.setText(goods.getLocation());
			inDate.setText(goods.getDate());
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = RenderSetter.OpenRender(g);
			g2d.setColor(ComponentStyle.light_gray);
			int width = getWidth(), height = getHeight();
			g2d.drawLine(10, height - 5, width - 20, height - 5);
		}

		GoodsVO getGoodsVO() {

			return new GoodsVO(order_id.getText(), location.getText(),
					SectorType.CAR, inDate.getText(), "sector_id",
					"belong_sector_id", destination.getText());

		}

		// 关闭编辑
		void closeEdit() {
			order_id.closeEdit();
			destination.closeEdit();
			inDate.closeEdit();
			location.closeEdit();

			edit_la.setText("E");
			goods = getGoodsVO();
			edited = false;
		}

		// 启用编辑
		void openEdit() {
			order_id.openEdit();
			destination.openEdit();
			inDate.openEdit();
			location.openEdit();

			edit_la.setText("√");
			edited = true;
		}
	}
}
