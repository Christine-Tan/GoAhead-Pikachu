package gap.client.ui.BaseComponents;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.ConstInfo;
import gap.client.ui.UITools.RenderSetter;



public class UserBox extends JLabel{

	String job;
	String name;
	String number;
	Sex sex;
	Image photo;
	public UserBox() {
		// TODO Auto-generated constructor stub
		this.job = ConstInfo.getJob();
		this.name = ConstInfo.getName();
		this.number = ConstInfo.getNumber();
		this.sex = ConstInfo.getSex();
		
		setBounds(0,5,220,125);
		
		String photoURL = "images/";
		switch (sex) {
		case man:
			photo = new ImageIcon(photoURL+"manPhoto.png").getImage();
			break;
		case woman:
			photo = new ImageIcon(photoURL+"womanPhoto.png").getImage();
			break;
		}
		

		
	}
	
	public enum Sex{
		man,woman
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d =  RenderSetter.OpenRender(g);
		
		int startX = 105;
		int startY = 30;
		int gap = 35;
		
		if(photo!=null){
			graphics2d.drawImage(photo, 2, 0, null);
		}
		graphics2d.setFont(ColorAndFonts.getChinese(19));
		graphics2d.drawString(job, startX, startY);
		graphics2d.drawString(name, startX, startY+gap);
		graphics2d.drawString(number, startX, startY+2*gap);
		
	}
	
}
