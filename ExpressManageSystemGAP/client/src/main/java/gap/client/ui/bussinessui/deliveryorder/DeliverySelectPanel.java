package gap.client.ui.bussinessui.deliveryorder;

import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.UserVO;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DeliverySelectPanel extends JPanel {
	GAPTextField id_input;
	JButton search;
	MainContentPanel mainContentPanel;

	public DeliverySelectPanel() {

	}

	public void setMainContentPanel(MainContentPanel mainContentPanel) {
		this.mainContentPanel = mainContentPanel;
	}

	void addUser(UserVO user) {

	}

}
