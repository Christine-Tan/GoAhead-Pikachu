package gap.client.ui.managerui.institutionui;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.blcontroller.CityController;
import gap.client.blcontroller.InstitutionController;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPComboBox;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.CityVO;
import gap.client.vo.InstitutionVO;

public class ListItemPanel extends JPanel {
	List<ItemPanel> items;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JButton addButton;
	JFrame frame;

	public ListItemPanel(JFrame frame) {
		this.frame = frame;
		setBackground(Color.WHITE);
		addButton = new GAPButton("+");
		// 对新增列表项的按钮添加监听
		// 新增一项列表
		// 删除一项列表

		// 布局
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		items = new ArrayList<>();
		List<InstitutionVO> institutions = InstitutionController.getAll();
		for (InstitutionVO institution : institutions) {
			addItem(institution);
		}

	}

	private void addItem(InstitutionVO institution) {
		items.add(new ItemPanel(institution));
		reLayout();
		frame.validate();
	}

	private void addNewItem() {
		ItemPanel item = new ItemPanel();
		item.newly = true;
		item.openEdit();
		items.add(item);
		reLayout();
		frame.validate();
	}

	private void removeItem(ItemPanel ip) {
		items.remove(ip);
		remove(ip);
		InstitutionController.deleteInstitution(ip.vo.getInsId());
		reLayout();
		frame.validate();
	}

	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1, 1, 1, 0);
		}
		SwingConsole.addComponent(gb, gcons, this, addButton, 0, items.size(), 1, 1, 1, 0);
	}

	// 每一个列表项都是一个panel，用GridBagLayout布局
	class ItemPanel extends JPanel {
		InstitutionVO vo;
		GAPTextField ins_id, ins_name, ins_member;
		JComboBox<String> ins_type_list, ins_city_list;
		JButton edit, delete;
		GridBagLayout gbl;
		GridBagConstraints gbc;
		boolean edited, newly;

		public ItemPanel() {
			setBackground(Color.WHITE);
			setFocusable(true);
			gbl = new GridBagLayout();
			gbc = new GridBagConstraints();
			ins_id = new GAPTextField(7);
			ins_name = new GAPTextField(15);
			ins_member = new GAPTextField(5);
			ins_type_list = new GAPComboBox<String>();
			ins_city_list = new GAPComboBox<String>();
			setLayout(gbl);
			// 初始化下拉框列表项
			ins_type_list.addItem("营业厅");
			ins_type_list.addItem("中转中心");

			for (CityVO city : CityController.getAll()) {
				ins_city_list.addItem(city.getCityName());
			}
			// 对编辑按钮添加监听
			edit = new GAPButton("E");
			edit.setFont(ComponentStyle.defaultFont);
			edit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (!edited) {
						openEdit();
					} else {
						closeEdit();
						if (newly) {
							InstitutionController.addInstitution(vo);
						} else {
							InstitutionController.modifyInstitution(vo);
						}
					}
				}
			});

			// 对删除按钮进行监听
			delete = new GAPButton("x");
			delete.setFont(ComponentStyle.defaultFont);
			delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					removeItem(ItemPanel.this);
				}

			});

			// 列表项布局
			gbc.insets = new Insets(10, 0, 10, 20);
			SwingConsole.addComponent(gbl, gbc, this, ins_id, 0, 0, 1, 1, 1, 0);
			gbc.insets = new Insets(10, 28, 10, 50);
			SwingConsole.addComponent(gbl, gbc, this, ins_type_list, 1, 0, 1, 1, 1, 0);
			gbc.insets = new Insets(10, 10, 10, 35);
			SwingConsole.addComponent(gbl, gbc, this, ins_name, 2, 0, 1, 1, 0, 0);
			gbc.insets = new Insets(10, 20, 10, 20);
			SwingConsole.addComponent(gbl, gbc, this, ins_city_list, 3, 0, 1, 1, 0, 0);
			gbc.insets = new Insets(10, 20, 10, 0);
			SwingConsole.addComponent(gbl, gbc, this, ins_member, 4, 0, 1, 1, 0, 0);
			gbc.insets = new Insets(10, 15, 10, 0);
			SwingConsole.addComponent(gbl, gbc, this, edit, 5, 0, 1, 1, 0, 0);
			gbc.insets = new Insets(10, 10, 10, 0);
			SwingConsole.addComponent(gbl, gbc, this, delete, 6, 0, 1, 1, 0, 0);
			// closeEdit();
		}

		public ItemPanel(InstitutionVO vo) {
			this();
			this.vo = vo;
			ins_id.setText(vo.getInsId());
			int type_id;
			ins_type_list.setSelectedIndex(vo.getInsId().charAt(3) - '0');
			ins_name.setText(vo.getInsName());
			// 获得机构所在城市对应的id
			int city_id = 1;
			List<CityVO> cities = CityController.getAll();
			for (int i = 0; i < cities.size(); i++) {
				if (vo.getInsCity().equals(cities.get(i).getCityName()))
					city_id = i;
			}
			ins_city_list.setSelectedIndex(city_id);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = RenderSetter.OpenRender(g);
			g2d.setColor(ComponentStyle.light_gray);
			int width = getWidth(), height = getHeight();
			g2d.drawLine(10, height - 5, width - 20, height - 5);
		}

		InstitutionVO getInstitutionVO() {
			return new InstitutionVO(ins_id.getText(), ins_name.getText(),
					ins_city_list.getItemAt(ins_city_list.getSelectedIndex()), Integer.valueOf(ins_member.getText()));
		}

		void openEdit() {
			ins_id.openEdit();
			ins_name.openEdit();
			ins_member.openEdit();
			ins_type_list.setEditable(true);
			ins_type_list.setFocusable(true);
			ins_city_list.setEditable(true);
			ins_city_list.setFocusable(true);
			edit.setText("√");
			edited = true;
		}

		void closeEdit() {
			ins_id.closeEdit();
			ins_name.closeEdit();
			ins_member.closeEdit();
//			ins_type_list.setEditable(false);
//			ins_type_list.setFocusable(false);
//			ins_city_list.setEditable(false);
//			ins_city_list.setFocusable(false);
			vo = getInstitutionVO();
			edit.setText("E");
			edited = false;
			newly = false;
		}

	}
}
