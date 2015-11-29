package gap.client.ui.BaseComponents;

import gap.client.ui.bussinessui.GAPJScrollPane;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainPanel extends JPanel {

	MainFrame mainFrame;

	private JScrollPane jspanel;

	public MainPanel(MainFrame frame) {
		mainFrame = frame;
		setBackground(Color.white);
	}

	public JScrollPane getJsPanel() {
		if (jspanel == null)
			jspanel = new GAPJScrollPane(this);
		return jspanel;
	}

}
