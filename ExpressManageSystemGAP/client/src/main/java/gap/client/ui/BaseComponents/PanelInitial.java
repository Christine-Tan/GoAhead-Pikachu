package gap.client.ui.BaseComponents;

import gap.client.bl.receipt.BillOrder;
import gap.client.ui.bussinessui.arrivedorder.ArrivedOrderPanel;
import gap.client.ui.bussinessui.billorderui.BillOrderPanel;
import gap.client.ui.deliveryui.expressorderinput.ExpressorderInputPanel;
import gap.client.ui.deliveryui.expressorderreceive.ExpressorderReceivePanel;
import gap.client.util.MessageType;

public class PanelInitial {
	public static void initialDelivery(MainFrame mainFrame) {
		NavigateBar navBar = mainFrame.navigateBar;
		ExpressorderInputPanel expressorderInput = new ExpressorderInputPanel(
				mainFrame);
		ExpressorderReceivePanel expressorderReceive = new ExpressorderReceivePanel(
				mainFrame);
		NavigateButton orderInput = new NavigateButton(mainFrame,
				expressorderInput, navBar, "订单信息输入");
		NavigateButton orderReceive = new NavigateButton(mainFrame,
				expressorderReceive, navBar, "收件信息输入");
		navBar.addButton(orderInput);
		navBar.addButton(orderReceive);
		navBar.setSelect(orderInput);
		mainFrame.setVisible(true);
		MainFrame.setMessage("登录成功", MessageType.succeed, 3000);
	}

	public static void initialBussinessclerk(MainFrame mainFrame) {
		NavigateBar navBar = mainFrame.navigateBar;
		NavigateButton arrivedOrder = new NavigateButton(mainFrame,
				new ArrivedOrderPanel(mainFrame), navBar, "制定到达单");
	}
}
