package BaseComponents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BaseListener.MoveListener;
import BaseListener.ResizeListener;
import UITools.ColorAndFonts;
import UITools.Defaut;
import UITools.SwingConsole;



public class MainFrame extends JFrame{
	TitlePanel titlePanel;
	NavigateBar navigateBar;
	MainPanel mainPanel;
	MessagePanel messagePanel;
	
	MoveListener moveListener;
	ResizeListener resizeListener;
	
	private GridBagLayout grid;
	private GridBagConstraints gcons;
	

	public MainFrame(){
		
		setSize(Defaut.WIDTH, Defaut.HEIGHT);
		setUndecorated(true);
		
		JPanel contentPanel = (JPanel) this.getContentPane();
		contentPanel.setBackground(Color.white);
		
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		grid = new GridBagLayout();
		gcons = new GridBagConstraints();
		
		gcons.ipadx = Defaut.NAV_WIDTH;
		gcons.ipady = Defaut.TITLE_HEIGHT;
		gcons.fill = GridBagConstraints.BOTH;
		contentPanel.setLayout(grid);
		
		titlePanel = new TitlePanel(this);
		navigateBar = new NavigateBar(this);
		mainPanel = new MainPanel(this);
		messagePanel = new MessagePanel(this);
		
		moveListener = new MoveListener(this);
		resizeListener = new ResizeListener(this);
		addMouseListener(moveListener);
		addMouseMotionListener(moveListener);
		addMouseListener(resizeListener);
		addMouseMotionListener(resizeListener);
		
		
		SwingConsole.addComponent(grid, gcons, contentPanel, titlePanel, 0, 0, 2, 1, 1, 0);
		SwingConsole.addComponent(grid, gcons, contentPanel, navigateBar, 0, 1, 1, 2, 0, 1);
		SwingConsole.addComponent(grid, gcons, contentPanel, mainPanel, 1, 1, 1, 1, 1, 1);
		SwingConsole.addComponent(grid, gcons, contentPanel, messagePanel, 1, 2, 1, 1, 1,0);
		
		
		setVisible(true);		

	}
	

	
}
