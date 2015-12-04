package gap.client.ui.bussinessui.carmanage;

import gap.client.blcontroller.CarManageController;
import gap.client.blcontroller.CarManageController;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.CarVO;
import gap.client.vo.CarVO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class ListItemPanel extends JPanel {
	List<ItemPanel> items;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JButton addButton;
	JFrame frame;

	public ListItemPanel(JFrame frame) {
		this.frame = frame;
		setBackground(Color.white);
		// setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 500));

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

		List<CarVO> cars = CarManageController.getAll();
		for (CarVO car : cars) {
			addItem(car);
		}
	}

	private void addItem(CarVO car) {
		items.add(new ItemPanel(car));
		reLayout();
		frame.validate();
	}

	private void addNewItem() {
		ItemPanel item = new ItemPanel();
		item.original = true;
		item.openEdit();
		try {
			String id = CarManageController.nextId();
			item.id.setText(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		items.add(item);
		reLayout();
		frame.validate();
	}

	private void removeItem(ItemPanel item) {
		items.remove(item);
		remove(item);
		reLayout();
		frame.validate();
	}

	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			ItemPanel item = items.get(i);
			item.setId(i + 1);
			SwingConsole.addComponent(gb, gcons, this, item, 0, i, 1, 1, 1, 0);
		}
		SwingConsole.addComponent(gb, gcons, this, addButton, 0, items.size(),
				1, 1, 1, 0);
	}

	// 每一项
	class ItemPanel extends JPanel {
		CarVO car;
		JButton delete, edit;
		GAPTextField id, car_id, car_num, serve_time;
		GridBagLayout gb;
		GridBagConstraints gcons;
		boolean original;
		boolean edited;

		public ItemPanel() {
			setBackground(Color.white);
			setFocusable(true);
			gb = new GridBagLayout();
			gcons = new GridBagConstraints();
			id = new GAPTextField(3);
			car_id = new GAPTextField(8);

			car_num = new GAPTextField(10);

			serve_time = new GAPTextField(8);

			edit = new GAPButton("E");
			edit.setFont(ComponentStyle.defaultFont);

			delete = new GAPButton("x");
			delete.setFont(ComponentStyle.defaultFont);

			setLayout(gb);
			gcons.insets = new Insets(10, 40, 10, 0);
			SwingConsole.addComponent(gb, gcons, this, id, 0, 0, 1, 1, 0, 0);
			SwingConsole
					.addComponent(gb, gcons, this, car_id, 1, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, car_num, 2, 0, 1, 1, 0,
					0);
			SwingConsole.addComponent(gb, gcons, this, serve_time, 3, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, edit, 4, 0, 1, 1, 0, 0);
			SwingConsole
					.addComponent(gb, gcons, this, delete, 5, 0, 1, 1, 0, 0);

			closeEdit();
		}

		public ItemPanel(CarVO car) {
			this();
			this.car = car;
			car_id.setText(car.getCar_id());
			car_num.setText(car.getCar_num());
			serve_time.setText("" + car.getServe_time());
			setCenter();
		}

		public void setId(int id) {
			this.id.setText(id + "");
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = RenderSetter.OpenRender(g);
			g2d.setColor(ComponentStyle.light_gray);
			int width = getWidth(), height = getHeight();
			g2d.drawLine(10, height - 5, width - 20, height - 5);
		}

		CarVO getCarVO() {
			return new CarVO(car_id.getText(), car_num.getText(), null,
					new Integer(serve_time.getText()));
		}

		void setCenter() {
			id.setHorizontalAlignment(JTextField.CENTER);
			car_id.setHorizontalAlignment(JTextField.CENTER);
			car_num.setHorizontalAlignment(JTextField.CENTER);
			serve_time.setHorizontalAlignment(JTextField.CENTER);
		}

		// 关闭编辑
		void closeEdit() {

			// id.closeEdit();
			edited = false;
			original = false;
		}

		// 启用编辑
		void openEdit() {

		}
	}
}
