package gap.client.Presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExitButton extends JLabel{

	Image image = new ImageIcon("images/login/x.png").getImage();
	Image selectedImage = new ImageIcon("images/login/xSelected.png").getImage();
	Image currentImage = image;
	
	public ExitButton(){
		setSize(15, 15);
		addMouseListener(new ExitListener());
	}
	
	public void paintComponent(Graphics g){
		
		g.drawImage(currentImage, 0, 0, 12,12,null);
		
	}
	
	
	class ExitListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			currentImage = selectedImage;
			repaint();
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			currentImage = image;
			repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	
		
		
	}
	
}
