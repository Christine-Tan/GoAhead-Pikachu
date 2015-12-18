package gap.client.ui.BaseComponents.FrameInitialler;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.NavigateBar;
import gap.client.ui.BaseComponents.NavigateButton;
import gap.client.ui.bussinessui.arrivedorder.ArrivedOrderPanel;
import gap.client.ui.bussinessui.loadorder.LoadOrderPanel;
import gap.client.util.MessageType;

public class CenterClerkInitaller {

	/**
	 * 初始化中转中心业务员界面
	 * 
	 * @param mainFrame
	 */
	public static void initialCenterClerk(MainFrame mainFrame) {
		NavigateBar navBar = mainFrame.getNavigateBar();
		NavigateButton arrivedOrder = new NavigateButton(mainFrame,
				new ArrivedOrderPanel(mainFrame), navBar, "制定到达单");
		NavigateButton loadOrder = new NavigateButton(mainFrame,
				new LoadOrderPanel(mainFrame), navBar, "制定中转单");

		navBar.addButton(arrivedOrder);
		navBar.addButton(loadOrder);
		navBar.setSelect(arrivedOrder);
		mainFrame.setVisible(true);
		MainFrame.setMessage("登录成功", MessageType.succeed, 3000);
	}
}
