package gap.client.ui.deliveryui.expressorderinput;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.UserBox.Sex;
import gap.client.ui.UITools.ConstInfo;

public class Tester {
	public static void main(String []args){
		ConstInfo.setJob("营业厅业务员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("000000001");
		ConstInfo.setSex(Sex.man);
		MainFrame mainFrame=new MainFrame();
		ExpressorderInputPanel panel=new ExpressorderInputPanel(mainFrame);
		mainFrame.setMainPanel(panel);
	}
}
