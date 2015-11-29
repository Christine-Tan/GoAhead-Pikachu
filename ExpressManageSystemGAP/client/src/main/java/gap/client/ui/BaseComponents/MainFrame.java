package gap.client.ui.BaseComponents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalScrollBarUI;

import gap.client.ui.BaseListener.MoveListener;
import gap.client.ui.BaseListener.ResizeListener;
import gap.client.ui.UITools.Defaut;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.bussinessui.GAPScrollBarUI;

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
//			UIManager
//			.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			BasicLookAndFeel metal = new MetalLookAndFeel(){

				public UIDefaults getDefaults(){
					UIDefaults defaults = super.getDefaults();
					//Object o = defaults.get("ScrollBarUI");
					defaults.remove("ScrollBarUI");
					defaults.put("ScrollBarUI","com.sun.java.swing.plaf.windows.WindowsScrollBarUI");
					
				
					defaults.get("ScrollBarUI");
					return defaults;
				}
				
			};
			
			UIManager.setLookAndFeel(metal);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(Defaut.WIDTH, Defaut.HEIGHT);
		setUndecorated(true);

		JPanel contentPanel = (JPanel) this.getContentPane();
		contentPanel.setBackground(Color.white);

		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		grid = new GridBagLayout();
		gcons = new GridBagConstraints();

		gcons.ipadx = Defaut.NAV_WIDTH;
		gcons.ipady = Defaut.TITLE_HEIGHT;
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
		SwingConsole.addComponent(grid, gcons, contentPanel, mainPanel.getJsPanel(), 1, 1,
				1, 1, 1, 1);
		SwingConsole.addComponent(grid, gcons, contentPanel, messagePanel, 1,
				2, 1, 1, 1, 0);

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
