package gap.client.ui.inventoryui.observestock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.common.util.Gender;
import gap.common.util.UserType;

public class Test {
	public static void main(String[] args) {
		User user = new User("000000005", UserType.INVENTORY, "xiaoming",
				"123456", "0010001", "小红", Gender.FEMALE);
		LocalInfo.localuser = user;
		LocalInfo.ins_id = "0011001";
		MainFrame mainFrame = new MainFrame();
		ObserveStockPanel panel = new ObserveStockPanel(mainFrame);
		mainFrame.setMainPanel(panel);
		
	}
}
