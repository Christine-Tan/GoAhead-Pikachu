package gap.client.ui.AccountUI;

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
import gap.client.ui.BaseComponents.WhiteExitButton;
import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.AccountVO;


public class AccountBox extends JPanel{
	private static Image accountIcon;
	private AccountVO accountVO;
	private String imageURL = "images/accountIcon/account.png";
	private EditableLable nameLabel = new EditableLable();
	private JLabel balanceLabel = new JLabel();

	private DeleteButton deleteButton;
	final int width = 175;
	final int height = 220;
	Color background = Color.white;
	
	MyListener listener = new MyListener();
	
	AccountDisplayPanel accountPanel;
	public AccountBox(AccountDisplayPanel accountDisplayPanel,AccountVO accountVO){
		accountPanel = accountDisplayPanel;
		this.accountVO = accountVO;
		
		
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
		if(accountIcon==null)
		{
			accountIcon = new ImageIcon(imageURL).getImage();
		}	
		setOpaque(false);
		
		//文字居中
		Font font = ColorAndFonts.getChinese(16);
		balanceLabel.setHorizontalAlignment(JLabel.CENTER);
		balanceLabel.setFont(font);
		balanceLabel.setOpaque(false);
		
		nameLabel.setFont(font);
		
		nameLabel.setBounds(0, height-90, width, 25);
		balanceLabel.setBounds(0, height-60, width, 25);
		
		nameLabel.setText(accountVO.getName());
		balanceLabel.setText("余额： "+accountVO.getBalance());
		
		deleteButton = new DeleteButton(this);
		deleteButton.setVisible(false);
		
		add(nameLabel);
		add(balanceLabel);
		add(deleteButton);
		
		addMouseListener(listener);
	}
	

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = RenderSetter.OpenRender(g);
		
		graphics2d.setColor(background);
		graphics2d.fillRect(0, 0, this.getWidth(),this.getHeight()-90);
		
		graphics2d.drawImage
		(accountIcon, 0, -this.getWidth()/10, this.getWidth(), this.getWidth(), null);
	}
	
	
	class MyListener implements MouseListener{

		Color gray = new Color(100, 100, 100, 50);
		Color red = new Color(251, 141, 158,100);
		Color white = Color.white;
		Rectangle rectangle = new Rectangle(0, 0, width-10, height-100);
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(background == red){
				background = gray;
				deleteButton.setVisible(false);
			}else if(background == gray){
				background = red;
				deleteButton.setVisible(true);
			}
			repaint();
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
			if(!rectangle.contains(e.getPoint())){
				background = white;
				deleteButton.setVisible(false);
				repaint();
			}
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
