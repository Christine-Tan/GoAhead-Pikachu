package gap.client.ui.managerui.institutionui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.MainPanel;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ButtonArea;
import gap.client.ui.gapcomponents.GAPJScrollPane;

/**
 * 总经理机构管理界面
 * 
 * @author seven
 */
public class InstitutionPanel extends MainPanel {
	QueryPanel queryPanel;
	TitlePanel titlePanel;
	ButtonArea buttonArea;

	public InstitutionPanel(MainFrame frame) {
		super(frame);
		titlePanel = new TitlePanel();
		queryPanel = new QueryPanel();
		buttonArea = new ButtonArea();
		buttonArea.submit.setText("保存修改");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		JPanel jp = new JPanel();
		jp.setOpaque(false);
		SwingConsole.addComponent(gb, gcons, this, queryPanel, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, titlePanel, 0, 1, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, jp, 0, 2, 1, 1, 1, 1);
		SwingConsole.addComponent(gb, gcons, this, buttonArea, 0, 3, 1, 1, 1, 0);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		InstitutionPanel ip = new InstitutionPanel(null);
		JScrollPane js = new GAPJScrollPane(ip);

		jf.setContentPane(js);
		jf.setSize(1024, 768);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
