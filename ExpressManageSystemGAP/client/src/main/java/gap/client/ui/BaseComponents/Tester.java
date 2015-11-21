package BaseComponents;

import BaseComponents.UserBox.Sex;
import UITools.ConstInfo;

public class Tester {
	public static void main(String[] args) {
		ConstInfo.setJob("财务人员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("1412501060");
		ConstInfo.setSex(Sex.man);
		new MainFrame();
	}
}
