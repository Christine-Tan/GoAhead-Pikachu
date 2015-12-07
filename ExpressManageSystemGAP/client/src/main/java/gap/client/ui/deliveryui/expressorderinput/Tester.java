package gap.client.ui.deliveryui.expressorderinput;

import gap.client.datacontroller.NetModule;
import gap.client.ui.BaseComponents.MainFrame;
import gap.client.util.LocalInfo;
import gap.client.util.User;
import gap.common.util.Gender;
import gap.common.util.UserType;

public class Tester {
	public static void main(String[] args) {
		LocalInfo.ins_id = "0010001";
		User user = new User("000000005", UserType.DELIVERY, "xiaoming",
				"123456", "0010001", "小明", Gender.MALE);
		LocalInfo.localuser = user;
		MainFrame mainFrame = new MainFrame();
		NetModule.initial(mainFrame);
		NetModule.connect();
		ExpressorderInputPanel panel = new ExpressorderInputPanel(mainFrame);
		mainFrame.setMainPanel(panel);
	}
}
