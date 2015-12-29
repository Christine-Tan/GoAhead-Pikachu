package gap.client.ui.initialUI.initialStock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.javafx.property.adapter.PropertyDescriptor.Listener;

import gap.client.ui.AccountUI.AccountDisplayPanel;
import gap.client.ui.AccountUI.AccountManagePanel;
import gap.client.ui.AccountUI.DeleteButton;
import gap.client.ui.AccountUI.EditableLable;
import gap.client.ui.AccountUI.ComponentBehave.NameChangeBehave;
import gap.client.ui.BaseComponents.WhiteExitButton;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.ColorChanger;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.AccountVO;
import gap.common.po.AccountPO;
import gap.common.po.InitialStockPO;


public class StockBox extends JPanel{

	private InitialStockPO stockPO;

	private JLabel nameLabel;
	private JLabel goodsNumLabel;

	protected static int width = 155;
	protected static int height = 180;
	
	Color background = Color.white;
	Color occupiedColor;
	
	MyListener listener = new MyListener();
	
	ColorChanger changer;
	
	public StockBox(InitialStockPO stockPO){

		this.stockPO = stockPO;
		
		
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
			
		setOpaque(false);
		
		double rate = stockPO.getOccupiedRate();
		changer = new ColorChanger(ColorAndFonts.blue, ColorAndFonts.redOrange, rate);
		occupiedColor = changer.change();
		
		Font font = ColorAndFonts.getChinese(16);
		goodsNumLabel = new JLabel();
		goodsNumLabel.setHorizontalAlignment(JLabel.CENTER);
		goodsNumLabel.setFont(font);
		goodsNumLabel.setOpaque(false);
		
		nameLabel = new JLabel();
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(font);
		nameLabel.setOpaque(false);
		
		nameLabel.setBounds(0, height-70, width, 25);
		goodsNumLabel.setBounds(0, height-40, width, 25);
		
		nameLabel.setText(stockPO.getStockName());
		goodsNumLabel.setText("库存： "+stockPO.getGoodsNum()+"件");
		
		add(nameLabel);
		add(goodsNumLabel);	
		addMouseListener(listener);
	}
	

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = RenderSetter.OpenRender(g);
		
		graphics2d.setColor(background);
		graphics2d.fillRect(0, 10, this.getWidth(),this.getHeight()-20);
		
		
		int yloc = 15;
		int rectWidth = 90;
		int xloc = (getWidth()-rectWidth)/2;
		
		graphics2d.setColor(Color.gray);
		graphics2d.drawRect(xloc, yloc, rectWidth,rectWidth);
		
		int occupiedHeight = (int)(rectWidth*stockPO.getOccupiedRate());
		
		if(occupiedColor!=null){
			graphics2d.setColor(occupiedColor);
			int fillY = (rectWidth-occupiedHeight)+yloc;
			graphics2d.fillRect(xloc, fillY, rectWidth, occupiedHeight);
		}
		
	}
	
	public void mouseExit(){
		listener.mouseExited(null);
	}
	

	
	class MyListener implements MouseListener{

		Color gray = new Color(100, 100, 100, 50);
		Color red = new Color(251, 141, 158,100);
		Color white = Color.white;
		Rectangle rectangle = new Rectangle(0, 0, width-10, height-100);
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
	
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			background = gray;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
				background = white;
				repaint();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
