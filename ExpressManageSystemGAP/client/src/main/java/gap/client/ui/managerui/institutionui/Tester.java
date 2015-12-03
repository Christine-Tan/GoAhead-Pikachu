package gap.client.ui.managerui.institutionui;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.UserBox.Sex;
import gap.client.ui.UITools.ConstInfo;
import gap.client.util.LocalInfo;

public class Tester {
	public static void main(String[] args) {
		ConstInfo.setJob("营业厅业务员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("000000001");
		ConstInfo.setSex(Sex.man);
		LocalInfo.ins_id = "0010001";
		MainFrame mainFrame = new MainFrame();
		InstitutionPanel panel = new InstitutionPanel(mainFrame);
		mainFrame.setMainPanel(panel);
	}
}