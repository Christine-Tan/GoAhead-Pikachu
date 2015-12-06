package gap.client.ui.inventoryui.observestock;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PeriodPanel extends JPanel{
	JLabel from,to;
	JButton confirm;
	JTextField beginDate,endDate;
	
	public PeriodPanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,80));
		
		from = new GAPLabel("from");
		to = new GAPLabel("to");
		confirm = new GAPButton("确认");
		confirm.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		beginDate = new GAPTextField(10);
		endDate = new GAPTextField(10);
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100,50));
		panel1.setBackground(null);
		panel1.setOpaque(false);  
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(100,50));
		panel2.setBackground(null);
		panel2.setOpaque(false); 
		
		SwingConsole.addComponent(gb, gcons, this, panel1, 0, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, from, 1, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, beginDate, 2, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, to, 3, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, endDate, 4, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, confirm, 5, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, panel2, 6, 0, 1, 1, 1, 0);
	}
	
	public String getBeginDate(){
		return beginDate.getText();
	}
	
	public String getEndDate(){
		return endDate.getText();
	} 
	
	
	
}
