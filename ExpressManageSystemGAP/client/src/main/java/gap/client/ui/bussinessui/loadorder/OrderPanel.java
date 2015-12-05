package gap.client.ui.bussinessui.loadorder;

import gap.client.vo.ExpressOrderVO;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class OrderPanel extends JPanel {
	JPanel searchPanel, titlePanel;
	List<ExpressOrderVO> orders;

	class OrderItemPanel extends JPanel {
		ExpressOrderVO order;
		JCheckBox check;
	}

}
