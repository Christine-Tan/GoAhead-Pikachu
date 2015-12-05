package gap.client.ui.BaseComponents;

import gap.client.ui.UITools.ColorAndFonts;

import java.awt.Color;

import javax.swing.JPanel;



public class MessagePanel extends JPanel {
	private MainFrame mainFrame;

	public MessagePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		Color lighter = ColorAndFonts.blue;
		setBackground(lighter);
		setLayout(null);
	}
}
