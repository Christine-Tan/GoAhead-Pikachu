package gap.client.ui.AccountUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import gap.client.ui.UITools.RenderSetter;


public class AccountBox extends JPanel{
	private static Image accountIcon;
	private String imageURL = "images/accountIcon/account.png";
	
	AccountDisplayPanel accountPanel;
	public AccountBox(AccountDisplayPanel accountDisplayPanel){
		accountPanel = accountDisplayPanel;
		setPreferredSize(new Dimension(150, 150));
		if(accountIcon==null){
			accountIcon = new ImageIcon(imageURL).getImage();
		}	
		setOpaque(false);
	}
	

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = RenderSetter.OpenRender(g);
		graphics2d.drawImage(accountIcon, 0, -this.getWidth()/10, this.getWidth(), this.getHeight(), null);
	}
	
}
