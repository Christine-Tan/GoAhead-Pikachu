package gap.client.ui.managerui.approvalui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gap.client.blcontroller.ApprovalController;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

public class TitlePanel extends JPanel {
	JLabel total, result;
	protected static JTextField num_f;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public TitlePanel() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 80));
		setBackground(Color.WHITE);
		total = new GAPLabel("一共有");
		result = new GAPLabel("张待审批单据");
		num_f = new GAPTextField();
		//这里要自动刷新数据
		// 获得所有待审批单据
		List<Object> approvals = ApprovalController.getUnpassedOrder();
		num_f.setText(approvals.size()+"");

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
        gcons.insets=new Insets(50,10,20,0);
        SwingConsole.addComponent(gb, gcons, this, total, 0, 0, 1, 1, 0, 0);
        gcons.insets=new Insets(50,5,20,0);
        SwingConsole.addComponent(gb, gcons, this, num_f, 1, 0, 1, 1, 0, 0);
        gcons.insets=new Insets(50,5,20,500);
        SwingConsole.addComponent(gb, gcons, this, result, 2, 0, 1, 1, 0, 0);
	}

}
