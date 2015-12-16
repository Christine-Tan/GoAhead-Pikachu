package gap.client.ui.managerui.approvalui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.blcontroller.InstitutionController;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.ArrivedOrderVO;

public class ArrivedOrderDetailPanel extends JPanel {
	// 出发机构，到达机构，订单列表，订单编号，订单状态
	JLabel fromIns_jl, toIns_jl, orders_jl, orderId_jl, state_jl;
	// 到达订单的信息
	GAPTextField fromIns, toIns, orderId, state;
	// 到达订单的列表项
	List<ItemPanel> items;
	// 显示详细信息
	JButton detail;
	JPanel detailPanel;
	boolean isDetailed;
	// 布局
	GridBagLayout gb, gb1;
	GridBagConstraints gcons;
	ArrivedOrderVO vo;

	public ArrivedOrderDetailPanel(ArrivedOrderVO arrivedOrder) {
		// TODO Auto-generated constructor stub
		this.vo = arrivedOrder;
		setBackground(Color.WHITE);

		fromIns_jl = new GAPLabel("出发机构");
		toIns_jl = new GAPLabel("到达机构");

		fromIns = new GAPTextField();
		fromIns.setHorizontalAlignment(JTextField.CENTER);
		fromIns.setText(InstitutionController.findById(vo.from_ins_id).getInsName());
		fromIns.closeEdit();

		toIns = new GAPTextField();
		toIns.setHorizontalAlignment(JTextField.CENTER);
		toIns.setText(InstitutionController.findById(vo.des_ins_id).getInsName());
		toIns.closeEdit();

		detail = new GAPButton(">");
		// 对显示到达的订单条目按钮添加监听
		detail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isDetailed) {
					closeDetail();
				} else {
					showDetail();
				}
			}
		});
		orders_jl = new GAPLabel("显示已到达的订单信息");

		// 初始化订单列表
		detailPanel = new JPanel();
		detailPanel.setBackground(Color.white);
		detailPanel.setBorder(BorderFactory.createLineBorder(ComponentStyle.gray));
		gb1 = new GridBagLayout();
		detailPanel.setLayout(gb1);
		// 表头
		orderId_jl = new GAPLabel("订单编号");
		state_jl = new GAPLabel("订单状态");
		items = new ArrayList<>();
		for (Map.Entry<String, String> orders : vo.orders.entrySet()) {
			addItem(new ItemPanel(orders.getKey(), orders.getValue()));
		}
		detailPanel.setVisible(false);

		// 布局
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets = new Insets(10, 20, 10, 20);
		SwingConsole.addComponent(gb, gcons, this, fromIns_jl, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, fromIns, 1, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, toIns_jl, 2, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, toIns, 3, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, detail, 0, 1, 1, 1, 0, 0);
		gcons.insets = new Insets(10, 20, 10, 270);
		SwingConsole.addComponent(gb, gcons, this, orders_jl, 1, 1, 1, 1, 0, 0);
		SwingConsole.addComponent(gb, gcons, this, detailPanel, 0, 3, 1, 1, 1, 0);

	}

	private void addItem(ItemPanel item) {
		items.add(item);
		reLayout();
	}

	private void reLayout() {
		// 布局
		gcons.insets = new Insets(10, 50, 10, 50);
		SwingConsole.addComponent(gb1, gcons, this.detailPanel, orderId_jl, 0, 0, 1, 1, 0, 0);
		SwingConsole.addComponent(gb1, gcons, this.detailPanel, state_jl, 1, 0, 1, 1, 0, 0);
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb1, gcons, this.detailPanel, items.get(i), 0, i, 1, 1, 1, 0);
		}
	}

	private void showDetail() {
		detailPanel.setVisible(true);
		detail.setText("v");
		isDetailed = true;
	}

	private void closeDetail() {
		detailPanel.setVisible(false);
		detail.setText(">");
		isDetailed = false;
	}

	class ItemPanel extends JPanel {
		GAPTextField id_f, state_f;
		GridBagLayout gb2;
		GridBagConstraints gc;

		ItemPanel(String id, String state) {
			setBackground(Color.WHITE);
			id_f = new GAPTextField();
			id_f.setText(id);
			id_f.setHorizontalAlignment(JTextField.CENTER);

			state_f = new GAPTextField();
			state_f.setText(state);
			state_f.setHorizontalAlignment(JTextField.CENTER);

			// 布局
			gb2 = new GridBagLayout();
			gc = new GridBagConstraints();
			setLayout(gb2);
			gc.insets = new Insets(10, 50, 10, 50);
			SwingConsole.addComponent(gb2, gc, this, id_f, 0, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb2, gc, this, state_f, 1, 0, 1, 1, 0, 0);
			closeEdit();
		}

		void closeEdit() {
			id_f.closeEdit();
			state_f.closeEdit();
		}
	}
}
