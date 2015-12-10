package gap.client.ui.AccountUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.gapcomponents.GAPTextField;

public class AddBox extends JPanel{

    static Image addImage;
    static Image addSelectedImage;
    static Image addClickedImage;
    
    private Image currentImage;
    private String addURL = "images/accountIcon/add.png";
    private String addSelectedURL = "images/accountIcon/addSelected.png";
    private String addClickedURL = "images/accountIcon/addClicked.png";
    private DefaultText_Field nameField;
    private DefaultText_Field balanceField;
    private int width = AccountBox.width;
    private int height = AccountBox.height;
    
    private ConfirmButton confirmButton;
    private CancelButton cancelButton;
    
    private double rate = 1;
    private AddListener listener = new AddListener();
    
    private JPanel addPanel = new JPanel();
    
    private boolean isClicked = false;
    
	public AddBox(){
		setPreferredSize(new Dimension(width, height));
		setLayout(null);
		setOpaque(false);
		if(addImage==null){
			addImage = new ImageIcon(addURL).getImage();
		}
		
		if(addSelectedImage == null){
			addSelectedImage = new ImageIcon(addSelectedURL).getImage();
		}
		
		if(addClickedImage == null){
			addClickedImage = new ImageIcon(addClickedURL).getImage();
		}
		
		currentImage = addImage;
		
		addMouseListener(listener);
		nameField = new DefaultText_Field("账户名称");
		balanceField = new DefaultText_Field("账户余额");
		
		confirmButton = new ConfirmButton(this);
		cancelButton = new CancelButton(this);
		
		confirmButton.setLocation(0, 100);
		cancelButton.setLocation(80, 100);
		
		
		nameField.setControl("\\.+", 1, 20);
		balanceField.setControl("\\d+.(\\d+)?", 1, 20);
		nameField.setBounds(0, height-200, width, 25);
		balanceField.setBounds(0, height-170, width, 25);
		
		addPanel.setBackground(Color.white);
		addPanel.setBounds(0, 0, width, height);
		addPanel.setLayout(null);
		addPanel.add(nameField);
		addPanel.add(balanceField);
		addPanel.add(confirmButton);
		addPanel.add(cancelButton);
		

	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
		Graphics2D graphics2d = RenderSetter.OpenRender(g);		
		graphics2d.drawImage(currentImage, 0, 0, 100, 100, null);
		super.paintComponent(graphics2d);
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(300, 300);
		AddBox box = new AddBox();
		box.setSize(220, 175);
		
		frame.add(box);
		frame.setVisible(true);
		
		
	}	
	
	class AddListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					add(addPanel);
				}
			}.start();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			currentImage = addSelectedImage;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			currentImage = addImage;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			currentImage = addClickedImage;
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			currentImage = addSelectedImage;
			repaint();
		}
		
		
	}
	

}
