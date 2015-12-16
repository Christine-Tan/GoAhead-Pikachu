package gap.client.ui.managerui.approvalui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.vo.BillOrderVO;
import gap.common.po.BillPO;

public class BillOrderDetailPanel extends JPanel {
	JLabel billname_jl, date_jl;
	List<ItemPanel> items;
	BillOrderVO vo;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;

	public BillOrderDetailPanel(BillOrderVO billOrder) {
		// TODO Auto-generated constructor stub
		this.vo = billOrder;
		setBackground(Color.WHITE);

		billname_jl = new GAPLabel("款项名称");
		date_jl = new GAPLabel("收款时间");
        
		for (BillPO po : vo.bills) {
			addItem(new ItemPanel(po));
		}
	}

	private void addItem(ItemPanel item) {
		items.add(item);
		reLayout();
	}

	private void reLayout() {
        gb=new GridBagLayout();
        gcons=new GridBagConstraints();
        gcons.insets=new Insets(5,50,5,0);
        SwingConsole.addComponent(gb, gcons, this, billname_jl, 0, 0, 1, 1, 0, 0);
        SwingConsole.addComponent(gb, gcons, this, date_jl, 1, 0, 1, 1, 0, 0);
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons,this, items.get(i), 0, i, 1, 1, 1, 0);
		}
	}

	class ItemPanel extends JPanel{
		JTextField billname, date;
		ItemPanel(BillPO po) {
                   
		}
	}
}
