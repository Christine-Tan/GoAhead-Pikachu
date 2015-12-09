package gap.client.ui.AccountUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.gapcomponents.GAPTextField;

public class AddBox extends JPanel{

    static Image addImage;
    static Image sureImage;
    private String addURL = "images/accountIcon/add.png";
    private String sureURL = "images/sure.gif";
    private DefaultText_Field nameField;
    private DefaultText_Field balanceField;
    private int width = AccountBox.width;
    private int height = AccountBox.height;
    
	public AddBox(){
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
		if(addImage==null){
			addImage = new ImageIcon(addURL).getImage();
		}
		
		if(sureImage==null){
			sureImage = new ImageIcon(sureURL).getImage();
		}
		
		nameField = new DefaultText_Field("账户名称");
		balanceField = new DefaultText_Field("账户余额");
		
		nameField.setControl("\\.+", 1, 20);
		balanceField.setControl("\\d+.(\\d+)?", 1, 20);
		nameField.setBounds(0, height-90, width, 25);
		balanceField.setBounds(0, height-60, width, 25);
		
		setBackground(Color.BLACK);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2d = RenderSetter.OpenRender(g);
		graphics2d.drawImage(sureImage, 0, 0, 100, 100, null);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.add(new AddBox());
		frame.setVisible(true);
		
		
	}	
	

}
