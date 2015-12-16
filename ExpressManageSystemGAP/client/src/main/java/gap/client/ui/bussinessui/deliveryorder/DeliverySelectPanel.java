package gap.client.ui.bussinessui.deliveryorder;

import gap.client.blcontroller.UserController;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.util.LocalInfo;
import gap.client.vo.UserVO;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeliverySelectPanel extends JPanel {
	MainContentPanel mainContentPanel;
	List<UserVO> users;
	JFrame jf;
	JPanel titlePanel;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public DeliverySelectPanel(JFrame jf) {
		this.jf = jf;
		users = new ArrayList<UserVO>();
		titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		titlePanel.add(new GAPTextField("编号", 9));
		titlePanel.add(new GAPTextField("姓名", 4));

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
	}

	public void refresh() {
		removeAll();
		users = UserController.getAllDelivery(LocalInfo.ins_id);
		reLatout();
	}

	/**
	 * 重新布局
	 */
	private void reLatout() {
		removeAll();

		Collections.sort(users, new Comparator<UserVO>() {

			@Override
			public int compare(UserVO o1, UserVO o2) {
				// TODO 自动生成的方法存根
				int id1 = new Integer(o1.getUserId());
				int id2 = new Integer(o2.getUserId());
				if (id1 < id2)
					return -1;
				else if (id1 > id2)
					return 1;
				return 0;
			}
		});
		SwingConsole
				.addComponent(gb, gcons, this, titlePanel, 0, 0, 1, 1, 0, 0);

		for (int i = 0; i < users.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this,
					new ItemPanel(users.get(i)), 0, i + 1, 1, 1, 0, 0);
		}

		jf.validate();
	}

	public void setMainContentPanel(MainContentPanel mainContentPanel) {
		this.mainContentPanel = mainContentPanel;
	}

	void addUser(UserVO user) {
		users.add(user);
		reLatout();
	}

	void deleteUser(ItemPanel panel) {
		users.remove(panel.user);
		mainContentPanel.addUser(panel.user);
		reLatout();
	}

	class ItemPanel extends JPanel {
		UserVO user;
		GAPTextField name, id;
		GAPButton addButton;

		public ItemPanel(UserVO user) {
			this.user = user;
			name = new GAPTextField(user.getName(), 4);
			id = new GAPTextField(user.getUserId(), 9);
			addButton = new GAPButton("添加");
			addButton.setFont(ComponentStyle.defaultFont);
			setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
			add(id);
			add(name);
			add(addButton);

			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					deleteUser(ItemPanel.this);
				}
			});
		}
	}

}
