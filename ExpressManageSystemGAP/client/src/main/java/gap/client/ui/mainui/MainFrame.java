package gap.client.ui.mainui;

import gap.client.ui.courierui.ExpressorderInputPanel;
import gap.client.ui.courierui.ExpressorderReceivePanel;
import gap.client.ui.util.Defaut;
import gap.client.ui.util.SwingConsole;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
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
		MainFrameListener listener = new MainFrameListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
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
	int ox, oy, frameWidth, frameHeight, frameX, frameY;
	boolean titleselected, se_resizeselected, e_resizeselected,
			s_resizeselected;
	
	Rectangle northEast = new Rectangle();
	Rectangle east = new Rectangle();
	Rectangle southEast = new Rectangle();
	Rectangle south = new Rectangle();
	Rectangle southWest = new Rectangle();
	Rectangle west = new Rectangle();
	Rectangle northWest = new Rectangle();
	Rectangle north = new Rectangle();
	Map<Rectangle, Cursor> cursorMap = new HashMap<>(8);
	ArrayList<Rectangle> rectangles = new ArrayList<>(8);
	
	
	public MainFrameListener(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		refrashLoaction();
		rectangles.add(northEast);
		rectangles.add(east);
		rectangles.add(southEast);
		rectangles.add(south);
		rectangles.add(southWest);
		rectangles.add(west);
		rectangles.add(northWest);
		rectangles.add(north);

		
		cursorMap.put(northEast,new Cursor(Cursor.NE_RESIZE_CURSOR) );
		cursorMap.put(east,		new Cursor(Cursor.E_RESIZE_CURSOR) );
		cursorMap.put(southEast,new Cursor(Cursor.NW_RESIZE_CURSOR) );
		cursorMap.put(south,	new Cursor(Cursor.S_RESIZE_CURSOR) );
		cursorMap.put(southWest,new Cursor(Cursor.SW_RESIZE_CURSOR) );
		cursorMap.put(west,		new Cursor(Cursor.W_RESIZE_CURSOR) );
		cursorMap.put(northWest,new Cursor(Cursor.NW_RESIZE_CURSOR) );
		cursorMap.put(north,	new Cursor(Cursor.N_RESIZE_CURSOR) );
		

		
		
	}
	
	private void refrashLoaction(){
		int width = frame.getWidth();
		int height = frame.getHeight();
		
		northEast.setBounds(width-10, 0,10,10);
		east.setBounds(width-10, 10, 10, height-20);
		southEast.setBounds(width-10,height-10,10,10);
		south.setBounds(10, height-10, width-20, 10);
		southWest.setBounds(0,height-10,10,10);
		west.setBounds(0, 10, 10, height-20);
		northWest.setBounds(0, 0, 10, 10);
		north.setBounds(10, 0, width-20, 10);		
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根

		for(Rectangle rect:cursorMap.keySet()){
			if(rect.contains(e.getPoint())){
				frame.setCursor(cursorMap.get(rect));
			}
		}

		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		refrashLoaction();
	
		for(Rectangle rect:cursorMap.keySet()){
			if(rect.contains(e.getPoint())){
				frame.setCursor(cursorMap.get(rect));
			}
		}
	
		
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
	
		int width = frame.getWidth(), height = frame.getHeight();
		frameWidth = width;
		frameHeight = height;
		frameX = frame.getX();
		frameY = frame.getY();
		ox = e.getX();
		oy = e.getY();
		if (oy < Defaut.TITLE_HEIGHT)
			titleselected = true;
		if ((width - ox) <= 10 && (height - oy) <= 10)
			se_resizeselected = true;
		if ((width - ox) <= 10 && (10 <= oy && oy <= height - 10))
			e_resizeselected = true;
		if ((height - oy) <= 10 && 10 <= ox && ox <= width - 10)
			s_resizeselected = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		titleselected = false;
		se_resizeselected = false;
		e_resizeselected = false;
		s_resizeselected = false;
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
