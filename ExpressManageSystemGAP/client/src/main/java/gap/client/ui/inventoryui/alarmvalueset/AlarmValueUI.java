package gap.client.ui.inventoryui.alarmvalueset;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPTextField;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;

public class AlarmValueUI extends JPanel{
	public JTextField alarmValue;
//	public JScrollPane scroller;
	
	public AlarmValueUI(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH,80));
		
		alarmValue = new JTextField(10);
		alarmValue.setBorder(ComponentStyle.text_border);
		alarmValue.setFont(new Font("微软雅黑", Font.PLAIN, 60));
		alarmValue.setHorizontalAlignment(JTextField.CENTER);
		alarmValue.setForeground(ComponentStyle.gray);
		alarmValue.setText("80");
//		scroller = new JScrollPane(alarmValue);
		
//		this.setLayout(null);
//		this.add(alarmValue);
//		GridBagLayout gb = new GridBagLayout();
//		GridBagConstraints gcons = new GridBagConstraints();
//		setLayout(gb);
//		gcons.insets=new Insets(10, 10, 10, 10);
//		gcons.anchor = GridBagConstraints.CENTER;
//		SwingConsole.addComponent(gb, gcons, this, alarmValue, 0, 0, 1, 1, 1, 0);
		this.add(alarmValue);
	}
	
//	public static void main(String[] args) {
//		AlarmValueUI alarm = new AlarmValueUI();
//		JFrame jf = new JFrame();
//		jf.getContentPane().add(alarm);
//		jf.setSize(300, 400);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);
//	}
}