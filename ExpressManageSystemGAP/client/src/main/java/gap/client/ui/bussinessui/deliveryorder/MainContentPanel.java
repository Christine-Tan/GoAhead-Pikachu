package gap.client.ui.bussinessui.deliveryorder;

import gap.client.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * 已选快递员、订单选择panel
 * @author YangYanfei
 *
 */
public class MainContentPanel extends JPanel {

	class UserBar {
		List<UserVO> users;

		public UserBar() {
			users = new ArrayList<UserVO>();
		}
	}

	class UserBox {

	}
}
