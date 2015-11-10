package gap.client.ui.mainui;

import gap.client.ui.util.UIColor;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	private MainFrame mainFrame;

	public TitlePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(UIColor.BACK_GRAY);
		setBorder(BorderFactory.createLineBorder(UIColor.BORDER_GRAY));
		setLayout(null);
	}
}
