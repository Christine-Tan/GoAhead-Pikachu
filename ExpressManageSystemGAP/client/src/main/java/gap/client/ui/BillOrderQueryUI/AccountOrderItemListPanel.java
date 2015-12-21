package gap.client.ui.BillOrderQueryUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.blcontroller.ApprovalController;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.ui.paymentUI.paymentDetail.PaymentDetailPanel;
import gap.common.po.ArrivedOrderPO;
import gap.common.po.BillOrderPO;
import gap.common.po.DeliveryOrderPO;
import gap.common.po.ExpressOrderPO;
import gap.common.po.LoadOrderPO;
import gap.common.po.PaymentListPO;
import gap.common.po.StockinOrderPO;
import gap.common.po.StockoutOrderPO;

public class AccountOrderItemListPanel extends JPanel {
	// 列表中所有的项
	List<ItemPanel> items;
	List<Object> orders;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;
	AccountorBillQueryMainPanel queryMainPanel;
	JLabel emptyLabel;
	JLabel textLabel;

	public AccountOrderItemListPanel
	(AccountorBillQueryMainPanel queryMainPanel) {

		this.queryMainPanel = queryMainPanel;
		orders = new ArrayList<>();
		setBackground(Color.WHITE);
//		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 900));
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		items = new ArrayList<>();
		
		textLabel = new JLabel("还没有查询收款单");
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setForeground(Color.gray);
		textLabel.setFont(ColorAndFonts.getChinese(30));
		
		emptyLabel = new JLabel();
		
		gcons.fill = GridBagConstraints.BOTH;
		SwingConsole.addComponent(gb, gcons, this, textLabel, 0, 0, 1, 1, 1, 1);
		

	}
	
	public void refresh(ArrayList<Object> orderPOs){
		removeAll();
		items.clear();
		this.orders = orderPOs;
		if(orders.size()==0){
			gcons.fill = GridBagConstraints.BOTH;
			SwingConsole.addComponent(gb, gcons, this, textLabel, 0, 0, 1, 1, 1, 1);
			return;
		}
		
		for (Object order : orders) {
			items.add(new ItemPanel(order));
		}
		
		showItems();
		queryMainPanel.validate();
	}
	
	public void cancel(){
		removeAll();
		items.clear();
		orders.clear();
		gcons.fill = GridBagConstraints.BOTH;
		SwingConsole.addComponent(gb, gcons, this, textLabel, 0, 0, 1, 1, 1, 1);
	}
   
	private void showItems() {
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1, 1, 1, 0);
		}
		SwingConsole.addComponent(gb, gcons, this, emptyLabel, 0, items.size(), 1, 1, 1, 1);
	}

	class ItemPanel extends JPanel {
		GAPTextField order_id, type, date;
		JButton detail;

		// 详细信息面板
		JPanel detailPanel;
		// 布局
		GridBagLayout gbl;
		// 是否显示详细信息
		boolean detailed;
		Object order;

		ItemPanel(Object ob) {
			setBackground(Color.WHITE);
			this.order = ob;
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
			if (order instanceof BillOrderPO) {
				BillOrderPO billOrder = (BillOrderPO) order;
				order_id.setText(billOrder.getId());
				type.setText("收款单");
				date.setText(billOrder.getBillDate().toString());
			} else if (order instanceof PaymentListPO) {
				PaymentListPO paymentList = (PaymentListPO) order;
				order_id.setText(paymentList.getPaymentID());
				type.setText("付款单");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = format.format(paymentList.getDate().getTime());
				date.setText(dateString);
			} else {
				System.out.println("no corresponding ordertype");
			}


			// 对显示详细信息的按钮添加监听
			detail = new GAPButton(">");
			detail.setFont(ComponentStyle.defaultFont);
			detail.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (detailed) {
						closeDetail();
					} else {
						showDetail();
					}
				}
			});
			
			// 确定订单的类型
			if (order instanceof BillOrderPO) {
				detailPanel = new BillOrderDetailPanel((BillOrderPO) order);
			} else if (order instanceof PaymentListPO) {
                detailPanel=new PaymentDetailPanel((PaymentListPO)order);
			}
			
			detailPanel.setVisible(false);
			// 布局
			gbl = new GridBagLayout();
			setLayout(gbl);
			gcons.insets = new Insets(5, 55, 10, 20);
			SwingConsole.addComponent(gbl, gcons, this, detail, 0, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 0, 10, 0);
			SwingConsole.addComponent(gbl, gcons, this, order_id, 1, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 10, 10, 0);
			SwingConsole.addComponent(gbl, gcons, this, type, 2, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gbl, gcons, this, date, 3, 0, 1, 1, 0, 0);


			gcons.insets = new Insets(5, 10, 5, 10);
			SwingConsole.addComponent(gbl, gcons, this, detailPanel, 0, 1, 6, 1, 0, 0);
		}



		void showDetail() {
			order_id.setForeground(ColorAndFonts.blue);
			type.setForeground(ColorAndFonts.blue);
			date.setForeground(ColorAndFonts.blue);
			detailPanel.setVisible(true);
			detailed = true;
			detail.setText("v");
		}

		void closeDetail() {
			order_id.setForeground(Color.BLACK);
			type.setForeground(Color.BLACK);
			date.setForeground(Color.BLACK);
			detailPanel.setVisible(false);
			detailed = false;
			detail.setText(">");
		}
	}
}
