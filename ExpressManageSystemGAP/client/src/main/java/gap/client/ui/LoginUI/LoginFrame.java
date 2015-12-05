package gap.client.ui.LoginUI;
import gap.client.ui.BaseListener.MoveListener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {

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
					
					LoginFrame frame = new LoginFrame();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 330);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
		getContentPane().setLayout(null);
		getContentPane().add(loginPanel);
		MoveListener movelistener = new MoveListener(this);
		addMouseListener(movelistener);
		addMouseMotionListener(movelistener);
	}
}
