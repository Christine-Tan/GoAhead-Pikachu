package gap.client.ui.inventoryui.checkstock;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.UserBox.Sex;
import gap.client.util.ConstInfo;

public class Test {
	public static void main(String[] args) {
		ConstInfo.setJob("库存管理人员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("0000000001");
		ConstInfo.setSex(Sex.man);
		MainFrame mainFrame = new MainFrame();
		CheckStockPanel panel = new CheckStockPanel(mainFrame);
		mainFrame.setMainPanel(panel);
	}
}