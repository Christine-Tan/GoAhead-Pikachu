package gap.client.ui.bussinessui;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.vo.DriverVO;
import gap.common.util.Gender;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListItemPanel extends JPanel {
	List<ItemPanel> items;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public ListItemPanel() {

		setBackground(Color.white);
		// setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 500));

		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		items = new ArrayList<>();

		items.add(new ItemPanel(new DriverVO("0010001001", "0010001", "杨雁飞",
				"1996-03-01", "500113199603013932", "15520065137",
				"2015-03-01", Gender.MALE)));
		reLayout();
	}

	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1,
					1, 1, 0);
		}
	}

	class ItemPanel extends JPanel {
		DriverVO driver;
		JLabel birth_la, phone_la, license_la;
		JButton detail_la, delete_la, edit_la;
		GAPTextField id, name, gender, id_card, birth, phone, driverLi_due;
		GridBagLayout gb;
		GridBagConstraints gcons;
		JPanel detailPanel;

		public ItemPanel(DriverVO driver) {
			this.driver = driver;
			// this.setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 200));
			setBackground(Color.white);
			gb = new GridBagLayout();
			gcons = new GridBagConstraints();

			detail_la = new GAPButton(">");
			detail_la.setFont(ComponentStyle.defaultFont);
			detail_la.addMouseListener(new MouseListener() {
				boolean showed = false;

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO 自动生成的方法存根

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO 自动生成的方法存根

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO 自动生成的方法存根

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO 自动生成的方法存根

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 自动生成的方法存根
					if (showed) {
						closeDetail();
						showed = false;
						detail_la.setText(">");
					} else {
						showDetail();
						showed = true;
						detail_la.setText("v");
					}
				}
			});
			edit_la = new GAPButton();
			delete_la = new GAPButton("x");
			delete_la.setFont(ComponentStyle.defaultFont);
			id = new GAPTextField(driver.getId(), 8);
			name = new GAPTextField(driver.getName(), 4);
			switch (driver.getGender()) {
			case MALE:
				gender = new GAPTextField("男", 2);
				break;
			case FEMALE:
				gender = new GAPTextField("女", 2);
				break;
			}
			id_card = new GAPTextField(driver.getIdentity_number(), 15);

			birth_la = new GAPLabel("生日：");
			birth = new GAPTextField(driver.getBirth(), 7);

			phone_la = new GAPLabel("手机：");
			phone = new GAPTextField(driver.getPhone(), 8);

			license_la = new GAPLabel("行驶证期限：");
			driverLi_due = new GAPTextField(driver.getDriving_license_due(), 7);

			detailPanel = new JPanel();
			detailPanel.setBackground(Color.white);
			detailPanel.setBorder(BorderFactory
					.createLineBorder(ComponentStyle.gray));
			GridBagLayout gb1 = new GridBagLayout();
			detailPanel.setLayout(gb1);
			gcons.insets = new Insets(10, 20, 10, 20);
			gcons.fill = GridBagConstraints.BOTH;
			SwingConsole.addComponent(gb1, gcons, detailPanel, birth_la, 0, 0,
					1, 1, 0, 0);
			SwingConsole.addComponent(gb1, gcons, detailPanel, birth, 1, 0, 1,
					1, 0, 0);
			SwingConsole.addComponent(gb1, gcons, detailPanel, phone_la, 2, 0,
					1, 1, 0, 0);
			SwingConsole.addComponent(gb1, gcons, detailPanel, phone, 3, 0, 1,
					1, 0, 0);
			SwingConsole.addComponent(gb1, gcons, detailPanel, license_la, 0,
					1, 1, 1, 0, 0);
			SwingConsole.addComponent(gb1, gcons, detailPanel, driverLi_due, 1,
					1, 1, 1, 0, 0);

			setLayout(gb);
			gcons.fill = GridBagConstraints.NONE;
			SwingConsole.addComponent(gb, gcons, this, detail_la, 0, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, id, 1, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, name, 2, 0, 1, 1, 0, 0);
			SwingConsole
					.addComponent(gb, gcons, this, gender, 3, 0, 1, 1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, id_card, 4, 0, 1, 1, 0,
					0);
			SwingConsole.addComponent(gb, gcons, this, delete_la, 5, 0, 1, 1,
					0, 0);
			SwingConsole.addComponent(gb, gcons, this, detailPanel, 1, 1, 4, 1,
					0, 0);
			detailPanel.setVisible(false);

			// closeEdit();
		}

		void showDetail() {
			detailPanel.setVisible(true);
		}

		void closeDetail() {
			detailPanel.setVisible(false);
		}

		void closeEdit() {
			id.closeEdit();
			name.closeEdit();
			gender.closeEdit();
			id_card.closeEdit();
			birth.closeEdit();
			phone.closeEdit();
			driverLi_due.closeEdit();
		}
	}
}
