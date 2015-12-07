package gap.client.ui.BaseComponents;

import gap.client.ui.BaseListener.MoveListener;
import gap.client.ui.BaseListener.ResizeListener;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainFrame extends JFrame {
	TitlePanel titlePanel;
	NavigateBar navigateBar;
	MainPanel mainPanel;
	MessagePanel messagePanel;

	MoveListener moveListener;
	ResizeListener resizeListener;

	private GridBagLayout grid;
	private GridBagConstraints gcons;

	public MainFrame() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// BasicLookAndFeel metal = new MetalLookAndFeel() {
			//
			// public UIDefaults getDefaults() {
			// UIDefaults defaults = super.getDefaults();
			// // Object o = defaults.get("ScrollBarUI");
			// defaults.remove("ScrollBarUI");
			// defaults.put("ScrollBarUI",
			// "com.sun.java.swing.plaf.windows.WindowsScrollBarUI");
			//
			// defaults.get("ScrollBarUI");
			// return defaults;
			// }
			//
			// };
			//
			// UIManager.setLookAndFeel(metal);

		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(Default.WIDTH, Default.HEIGHT);
		setUndecorated(true);

		JPanel contentPanel = (JPanel) this.getContentPane();
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(BorderFactory
				.createLineBorder(ColorAndFonts.gray));

		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		grid = new GridBagLayout();
		gcons = new GridBagConstraints();

		gcons.ipadx = Default.NAV_WIDTH;
		gcons.ipady = Default.TITLE_HEIGHT;
		gcons.fill = GridBagConstraints.BOTH;
		contentPanel.setLayout(grid);

		titlePanel = new TitlePanel(this);
		navigateBar = new NavigateBar(this);
		mainPanel = new MainPanel(this);
		messagePanel = new MessagePanel(this);

		moveListener = new MoveListener(this);
		resizeListener = new ResizeListener(this);
		addMouseListener(moveListener);
		addMouseMotionListener(moveListener);
		addMouseListener(resizeListener);
		addMouseMotionListener(resizeListener);

		SwingConsole.addComponent(grid, gcons, contentPanel, titlePanel, 0, 0,
				2, 1, 1, 0);
		SwingConsole.addComponent(grid, gcons, contentPanel, navigateBar, 0, 1,
				1, 2, 0, 1);
		SwingConsole.addComponent(grid, gcons, contentPanel,
				mainPanel.getJsPanel(), 1, 1, 1, 1, 1, 1);
		SwingConsole.addComponent(grid, gcons, contentPanel, messagePanel, 1,
				2, 1, 1, 1, 0);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void setMainPanel(MainPanel panel) {
		if (mainPanel != null)
			remove(mainPanel.getJsPanel());
		this.mainPanel = panel;
		SwingConsole.addComponent(grid, gcons, (JPanel) getContentPane(),
				mainPanel.getJsPanel(), 1, 1, 1, 1, 1, 1);
		validate();
	}

}
