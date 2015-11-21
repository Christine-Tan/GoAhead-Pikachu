package BaseComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BaseComponents.TitleButton.Type;
import BaseListener.ResizeListener;
import UITools.ColorAndFonts;
import UITools.SwingConsole;

public class TitlePanel extends JPanel{

	MainFrame mainFrame;
	GridBagLayout gridBagLayout = new GridBagLayout();
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	private static final long serialVersionUID = 1L;
	
	TitleButton exitButton;
	TitleButton iconButton;
	public TitlePanel(MainFrame frame){
		mainFrame = frame;
		setLayout(gridBagLayout);	
		setSize(1000,30);
		
		exitButton = new TitleButton(mainFrame,Type.close);
		iconButton = new TitleButton(mainFrame,Type.iconified);
		
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		gridBagConstraints.ipadx = 25;
//		gridBagConstraints.ipady = 5;
		gridBagConstraints.fill = gridBagConstraints.BOTH;
		
		SwingConsole.addComponent(gridBagLayout, gridBagConstraints, this, 
				label, 0, 0, 1, 2, 1, 1);
		
		SwingConsole.addComponent(gridBagLayout, gridBagConstraints, this, 
				label2, 1, 0, 1, 1, 0, 1);
		
		SwingConsole.addComponent(gridBagLayout, gridBagConstraints, this, 
				iconButton, 1, 1, 1, 1, 0.01, 2.5);
		
		SwingConsole.addComponent(gridBagLayout, gridBagConstraints, this, 
				exitButton, 2, 1, 1, 1, 0.01, 2.5);
		
		
		
	}
	


	
	public class ResizeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			exitButton.setLocation(mainFrame.getWidth()-30, 12);
		}
		
		
	}
	
	
}
