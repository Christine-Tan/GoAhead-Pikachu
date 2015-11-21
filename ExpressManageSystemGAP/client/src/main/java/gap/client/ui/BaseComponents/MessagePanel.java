package gap.client.ui.BaseComponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import gap.client.ui.UITools.ColorAndFonts;



public class MessagePanel extends JPanel {
	private MainFrame mainFrame;

	public MessagePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		Color lighter = ColorAndFonts.blue;
		setBackground(lighter);
		setLayout(null);
	}
}
