package gap.client.ui.mainui;

import gap.client.ui.courierui.ExpressorderInputPanel;
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

public class MainFrame extends JFrame {
	private JPanel titlePanel, navPanel, mainPanel, messagePanel;

	public MainFrame() {
		MainFrameListener listener = new MainFrameListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		courierInitial();
	}

	void courierInitial() {
		titlePanel = new TitlePanel(this);
		navPanel = new NavPanel(this);
		mainPanel = new ExpressorderInputPanel();
		Nav nav1 = new Nav("订单信息输入", null);
		Nav nav2 = new Nav("收件信息输入", null);
		((NavPanel) navPanel).addNav(nav1, mainPanel);
		((NavPanel) navPanel).addNav(nav2, mainPanel);

		messagePanel = new MessagePanel(this);
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		gcons.ipadx = Defaut.NAV_WIDTH;
		gcons.ipady = Defaut.TITLE_HEIGHT;
		gcons.fill = GridBagConstraints.BOTH;
		JPanel pa = (JPanel) getContentPane();
		pa.setLayout(grid);
		SwingConsole
				.addComponent(grid, gcons, pa, titlePanel, 0, 0, 2, 1, 1, 0);
		SwingConsole.addComponent(grid, gcons, pa, navPanel, 0, 1, 1, 2, 0, 1);
		SwingConsole.addComponent(grid, gcons, pa, mainPanel, 1, 1, 1, 1, 1, 1);
		SwingConsole.addComponent(grid, gcons, pa, messagePanel, 1, 2, 1, 1, 1,
				0);
		setUndecorated(true);
		// setCursor(UICursor.CURSOR1);
		SwingConsole.run(this, 1000, 650);
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
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
