package gap.client.ui.mainui;

import gap.client.ui.util.UIColor;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	private MainFrame mainFrame;

	public MessagePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(UIColor.MESSAGE_BLUE);
		setBorder(BorderFactory.createLineBorder(UIColor.BORDER_GRAY));
		setLayout(null);
	}
}
