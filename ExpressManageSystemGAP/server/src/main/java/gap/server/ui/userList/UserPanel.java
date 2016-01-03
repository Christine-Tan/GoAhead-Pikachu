package gap.server.ui.userList;

import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;

import gap.common.po.UserPO;
import gap.server.ui.ServiceLeftPanel;
import gap.server.ui.tools.PanelWithGrid;
import gap.server.ui.tools.SwingConsole;

public class UserPanel extends PanelWithGrid{
	private ArrayList<UserLabel> userPOList = new ArrayList<>();
	JLabel empty;
	public UserPanel(){
		gridBagConstraints.insets = new Insets(5, 10, 10, 5);
		
		empty = new JLabel();
		setBackground(ServiceLeftPanel.grayColor);
	}
	
	public void addUser(UserPO aUserPO,String IP){
		UserLabel userLabel = new UserLabel(aUserPO, IP);
		userPOList.add(userLabel);
		
		remove(empty);
		gridBagLayout.removeLayoutComponent(empty);
		
		SwingConsole.addComponent
		(gridBagLayout, gridBagConstraints, this, userLabel,0, userPOList.size()-1, 1, 1, 1, 0);
		
		SwingConsole.addComponent
		(gridBagLayout, gridBagConstraints, this, empty, 0, userPOList.size(), 1, 1, 1, 1);
		
		Container container = getParent();
		container.validate();
		container.repaint();
	} 

}
