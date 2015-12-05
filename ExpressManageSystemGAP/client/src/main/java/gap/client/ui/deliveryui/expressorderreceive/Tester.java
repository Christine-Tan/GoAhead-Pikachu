package gap.client.ui.deliveryui.expressorderreceive;

import gap.client.ui.BaseComponents.MainFrame;
import gap.client.ui.BaseComponents.UserBox.Sex;
import gap.client.util.ConstInfo;

public class Tester {
	public static void main(String []args){
		ConstInfo.setJob("营业厅业务员");
		ConstInfo.setName("王小二");
		ConstInfo.setNumber("000000005");
		ConstInfo.setSex(Sex.man);
		MainFrame mainFrame=new MainFrame();
		ExpressorderReceivePanel panel=new ExpressorderReceivePanel(mainFrame);
		mainFrame.setMainPanel(panel);
	}
}
