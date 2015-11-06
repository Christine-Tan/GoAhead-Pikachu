package gap.client.Presentation;

import javax.swing.*;
import java.awt.*;

public class TextFieldTest extends JFrame {

	LoginPanel loginPanel = new LoginPanel();

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					
					TextFieldTest frame = new TextFieldTest();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TextFieldTest() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
		getContentPane().setLayout(null);
		getContentPane().add(loginPanel);
		

	}
	
	

	
	
	
	class MyText extends JTextField{
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
		//	g.fillRect(0, 0, 30, 20);
					
		}
		
	}
}
