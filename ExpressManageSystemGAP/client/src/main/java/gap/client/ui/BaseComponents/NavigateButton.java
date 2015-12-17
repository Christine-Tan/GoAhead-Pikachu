package gap.client.ui.BaseComponents;

import javax.swing.JButton;

public class NavigateButton extends JButton {
	MainFrame mainFrame;
	MainPanel mainPanel;

	public NavigateButton(MainFrame mainFrame, MainPanel mainPanel) {
		this.mainFrame = mainFrame;
		this.mainPanel = mainPanel;
	}

	/**
	 * 设置被选择
	 */
	void select() {

	}

	/**
	 * 设置未被选择
	 */
	void deSelect() {

	}
}
