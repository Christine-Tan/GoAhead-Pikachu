package gap.client.ui.mainui;

import gap.client.ui.courierui.ExpressorderInputPanel;
import gap.client.ui.courierui.ExpressorderReceivePanel;
import gap.client.ui.util.Defaut;
import gap.client.ui.util.SwingConsole;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	public JPanel titlePanel, navPanel, mainPanel, messagePanel;
	private GridBagLayout grid;
	private GridBagConstraints gcons;
	private JPanel pa;

	public MainFrame() {
		MainFrameListener listener = new MainFrameListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
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

// 监听类
class MainFrameListener implements MouseListener, MouseMotionListener {
	JFrame frame;
	int ox, oy, frameWidth, frameHeight;
	boolean titleselected, resizeselected;

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		frame = (JFrame) e.getSource();
		int x = e.getX(), y = e.getY(), dx = x - ox, dy = y - oy;
		if (titleselected)
			frame.setLocation(frame.getX() + dx, frame.getY() + dy);
		if (resizeselected)
			frame.setSize(frameWidth + dx, frameHeight + dy);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		frame = (JFrame) e.getSource();
		int x = e.getX(), y = e.getY(), width = frame.getWidth(), height = frame
				.getHeight();
		if ((width - x) <= 10 && (height - y) <= 10)
			frame.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
		else
			frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		frame = (JFrame) e.getSource();
		int width = frame.getWidth(), height = frame.getHeight();
		frameWidth = width;
		frameHeight = height;
		ox = e.getX();
		oy = e.getY();
		if (oy < 40)
			titleselected = true;
		if ((width - ox) <= 10 && (height - oy) <= 10)
			resizeselected = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		titleselected = false;
		resizeselected = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

}
