package gap.client.ui.BaseComponents;

import gap.client.ui.BaseComponents.UserBox.Sex;
import gap.client.ui.UITools.ConstInfo;

public class Tester {
	public static void main(String[] args) {
		ConstInfo.setJob("财务人员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("1412501060");
		ConstInfo.setSex(Sex.man);
		new MainFrame();
	}
}
