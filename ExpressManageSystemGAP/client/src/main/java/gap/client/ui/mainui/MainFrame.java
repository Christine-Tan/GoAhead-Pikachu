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
	MainFrameListener listener;

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
		listener = new MainFrameListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
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
//	Map<Rectangle, Cursor> cursorMap = new HashMap<>(8);
	ArrayList<Rectangle> rectangles = new ArrayList<>(8);
	ArrayList<Cursor> cursors = new ArrayList<>(8);
	
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

		cursors.add(new Cursor(Cursor.NE_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.E_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.SE_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.S_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.SW_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.W_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.NW_RESIZE_CURSOR) );
		cursors.add(new Cursor(Cursor.N_RESIZE_CURSOR) );
		
		
//		cursorMap.put(northEast,new Cursor(Cursor.NE_RESIZE_CURSOR) );
//		cursorMap.put(east,		new Cursor(Cursor.E_RESIZE_CURSOR) );
//		cursorMap.put(southEast,new Cursor(Cursor.NW_RESIZE_CURSOR) );
//		cursorMap.put(south,	new Cursor(Cursor.S_RESIZE_CURSOR) );
//		cursorMap.put(southWest,new Cursor(Cursor.SW_RESIZE_CURSOR) );
//		cursorMap.put(west,		new Cursor(Cursor.W_RESIZE_CURSOR) );
//		cursorMap.put(northWest,new Cursor(Cursor.NW_RESIZE_CURSOR) );
//		cursorMap.put(north,	new Cursor(Cursor.N_RESIZE_CURSOR) );


		
		
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
		refrashLoaction();
	
		int cursorType = frame.getCursor().getType();
		
		int nowX = e.getXOnScreen();
		int nowY = e.getYOnScreen();
		
		System.out.println(cursorType);
		
		switch(cursorType){
		
			case Cursor.NE_RESIZE_CURSOR:
			{
				int newWidth = frameWidth+(nowX-ox);
				int newHeight = frameHeight+(oy-nowY);
				int newX = frameX + (nowX-ox);
				int newY = frameY + (nowY-oy);
				frame.setBounds(frameX, newY, newWidth, newHeight);
				break;
			}
			case Cursor.NW_RESIZE_CURSOR:
			{
				int newWidth = frameWidth+(ox-nowX);
				int newHeight = frameHeight+(oy-nowY);
				int newX = frameX + (nowX-ox);
				int newY = frameY + (nowY-oy);
				frame.setBounds(newX, newY, newWidth, newHeight);
				break;
			}
			case Cursor.SE_RESIZE_CURSOR:
			{
				int newWidth = frameWidth+(nowX-ox);
				int newHeight = frameHeight+(nowY-oy);

				
				frame.setBounds(frameX, frameY, newWidth, newHeight);
				break;
			}
			case Cursor.SW_RESIZE_CURSOR:
			{
				int newWidth = frameWidth+(ox-nowX);
				int newHeight = frameHeight+(-oy+nowY);
				int newX = frameX + (nowX-ox);
				int newY = frameY + (nowY-oy);
				frame.setBounds(newX, frameY, newWidth, newHeight);
				break;
			}
			case Cursor.N_RESIZE_CURSOR:
			{
	
				int newHeight = frameHeight+(oy-nowY);
			
				int newY = frameY + (nowY-oy);
				frame.setBounds(frameX, newY, frameWidth, newHeight);
				break;
			}
			case Cursor.S_RESIZE_CURSOR:
			{
				
				int newHeight = frameHeight+(-oy+nowY);	
				frame.setBounds(frameX, frameY, frameWidth, newHeight);
				break;
			}
			case Cursor.W_RESIZE_CURSOR:
			{
				int newWidth = frameWidth+(ox-nowX);

				int newX = frameX + (nowX-ox);

				frame.setBounds(newX, frameY, newWidth, frameHeight);
				break;
			}
			case Cursor.E_RESIZE_CURSOR:
			{
				int newWidth = frameWidth+(nowX-ox);
			
				frame.setBounds(frameX, frameY, newWidth, frameHeight);
				break;
			}
		
		
		}
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		refrashLoaction();
		
		for(int i=0;i<rectangles.size();i++){
			if(rectangles.get(i).contains(e.getPoint())){
				frame.setCursor(cursors.get(i));
				return;
			}			
		}
		
		frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
	
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
		ox = e.getXOnScreen();
		oy = e.getYOnScreen();
		
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
