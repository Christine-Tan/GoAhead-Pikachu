package gap.client.ui.bussinessui.expressorderreceive;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPJScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ExpressorderReceivePanel extends MainPanel {
	TitlePanel titlePanel;
	ListItemPanel listItemPanel;

	public ExpressorderReceivePanel(MainFrame frame) {
		super(frame);
		// TODO 自动生成的构造函数存根
		titlePanel = new TitlePanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setBackground(Color.white);

		SwingConsole
				.addComponent(gb, gcons, this, titlePanel, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 1, 1, 1, 1, 1);
		
	}

	public static void main(String[] args) {

		ExpressorderReceivePanel pa = new ExpressorderReceivePanel(null);
		JScrollPane js = new GAPJScrollPane(pa);
		JFrame jf = new JFrame();
		jf.setContentPane(js);
		// jf.getContentPane().add(pa);
		jf.setSize(1024, 768);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
