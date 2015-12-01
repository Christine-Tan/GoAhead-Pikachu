package gap.client.ui.BaseComponents;

import gap.client.ui.gapcomponents.GAPJScrollPane;

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
//		setFocusable(false);
	}

	public JScrollPane getJsPanel() {
		if (jspanel == null)
			jspanel = new GAPJScrollPane(this);
		return jspanel;
	}

}
