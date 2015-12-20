package gap.client.ui.BaseComponents.FrameInitialler;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.NavigateBar;
import gap.client.ui.BaseComponents.NavigateButton;
import gap.client.ui.administratorui.UserPanel;
import gap.client.util.MessageType;
import gap.common.util.UserType;

public class AdminInitialler {
	/**
	 * 初始化管理员界面
	 * 
	 * @param mainFrame
	 */
	public AdminInitialler() {
		// TODO Auto-generated constructor stub
	}
   
	public static void initialAdmin(MainFrame mainFrame){
		NavigateBar navBar=new NavigateBar(mainFrame);
		NavigateButton user=new NavigateButton(mainFrame, new UserPanel(mainFrame,UserType.ADMINISTRATOR),navBar, "用户管理");
		navBar.addButton(user);
		navBar.setSelect(user);
		mainFrame.setVisible(true);
		MainFrame.setMessage("登录成功", MessageType.succeed, 3000);
	} 
}
