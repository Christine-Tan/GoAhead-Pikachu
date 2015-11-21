package BaseComponents;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	MainFrame mainFrame;
	
	public MainPanel(MainFrame frame){
		mainFrame = frame;
		setBackground(Color.white);
	}
	
}
