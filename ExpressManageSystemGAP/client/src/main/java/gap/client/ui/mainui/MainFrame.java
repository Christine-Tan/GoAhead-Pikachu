package gap.client.ui.mainui;

import gap.client.ui.courierui.ExpressorderInputPanel;
import gap.client.ui.courierui.ExpressorderReceivePanel;
import gap.client.ui.util.Defaut;
import gap.client.ui.util.SwingConsole;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	public JPanel titlePanel, navPanel, mainPanel, messagePanel;
	private GridBagLayout grid;
	private GridBagConstraints gcons;
	private JPanel pa;
	ResizeListener listener;

	public MainFrame() {
		
		grid = new GridBagLayout();
		gcons = new GridBagConstraints();
		pa = (JPanel) getContentPane();
		courierInitial();
		
	}

	void courierInitial() {

		titlePanel = new TitlePanel(this);

		navPanel = new NavPanel(this);
		JPanel panel1 = new ExpressorderInputPanel(), panel2 = new ExpressorderReceivePanel();
		Nav nav1 = new Nav("订单信息输入", null);
		Nav nav2 = new Nav("收件信息输入", null);
		mainPanel = panel1;
		nav1.selected = true;
		((NavPanel) navPanel).addNav(nav1, panel1);
		((NavPanel) navPanel).addNav(nav2, panel2);

		messagePanel = new MessagePanel(this);

		gcons.ipadx = Defaut.NAV_WIDTH;
		gcons.ipady = Defaut.TITLE_HEIGHT;
		gcons.fill = GridBagConstraints.BOTH;
		pa.setLayout(grid);

		SwingConsole
				.addComponent(grid, gcons, pa, titlePanel, 0, 0, 2, 1, 1, 0);
		SwingConsole.addComponent(grid, gcons, pa, navPanel, 0, 1, 1, 2, 0, 1);
		SwingConsole.addComponent(grid, gcons, pa, mainPanel, 1, 1, 1, 1, 1, 1);
		SwingConsole.addComponent(grid, gcons, pa, messagePanel, 1, 2, 1, 1, 1,
				0);

		setUndecorated(true);
		SwingConsole.run(this, 1000, 650);
		listener = new ResizeListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		Graphics2D graphics2d = (Graphics2D)g;
		g.setColor(Color.black);
		graphics2d.fill(listener.east);
		graphics2d.fill(listener.north);
		
	}

	public void setMainPanel(final JPanel mainPanel) {
		remove(MainFrame.this.mainPanel);
		MainFrame.this.mainPanel = mainPanel;
		SwingConsole.addComponent(grid, gcons, pa, mainPanel, 1, 1, 1, 1, 1, 1);
		repaint();
		validate();

	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new MainFrame();

	}

}





