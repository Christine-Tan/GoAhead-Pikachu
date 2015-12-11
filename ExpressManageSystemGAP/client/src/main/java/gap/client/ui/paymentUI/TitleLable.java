package gap.client.ui.paymentUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;

public class TitleLable extends JLabel{

	String text;
	Color textColor = Color.black;
	Color shadowColor = Color.darkGray;
	Font font = ColorAndFonts.getChinese(30);
	
	int textLength = 0;
	int textHeight = 0;
	
	public TitleLable(String text){
		this.text = text;
		textLength = this.text.length()*30;
		textHeight = 30;
	}
	
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = RenderSetter.OpenRender(g);
		int width = getWidth();
		int height = getHeight();
		
		
	}
	
	
	
}
