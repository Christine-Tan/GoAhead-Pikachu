package gap.client.ui.inventoryui.initialstock;

import gap.client.ui.UITools.ConstInfo;
import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.common.util.ReceiveInfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ListItemPanel extends JPanel {
	List<ItemPanel> items;
	JButton jb;
	GridBagLayout gb;
	GridBagConstraints gcons;
	JFrame jframe;
	String errMess;

	public ListItemPanel(JFrame jf) {
		jframe = jf;
		setBackground(Color.white);

		items = new ArrayList<ListItemPanel.ItemPanel>();
		jb = new GAPButton("+");
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								// TODO 自动生成的方法存根
								addItemPanel();
								jframe.validate();
							}
						});
					}
				}).start();

			}
		});
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);

		addItemPanel();
		reLayout();
	}

	public List<ReceiveInfo> getReceiveInfos() {
		List<ReceiveInfo> infos = new ArrayList<ReceiveInfo>();
		for (ItemPanel item : items) {
			infos.add(item.getReceiveInfo());
		}
		return infos;
	}

	// 加入新的一项
	public void addItemPanel() {
		items.add(new ItemPanel(items.size() + 1));
		reLayout();
	}

	// 移除一项
	public void removeItemPanel(ItemPanel itemPanel) {
		items.remove(itemPanel);
		remove(itemPanel);
		reLayout();
	}

	private void reLayout() {
		for (int i = 0; i < items.size(); i++) {
			ItemPanel item = items.get(i);
			item.setId(String.valueOf(i + 1));
			if (i == items.size() - 1)
				item.setLast(true);
			else
				item.setLast(false);
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1,
					1, 1, 0);
		}
		SwingConsole.addComponent(gb, gcons, this, jb, 0, items.size(), 1, 1,
				1, 0);
	}

	class ItemPanel extends JPanel {

		JLabel id;
		JButton delete;
		GAPTextField order_id, destination, inDate, location;
		boolean last;

		public ItemPanel(int id) {
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(Default.PANEL_WIDTH,50));

			this.id = new GAPLabel(String.valueOf(id));
//			this.id.setBackground(Color.red);
			this.id.setPreferredSize(new Dimension(80,30));
			this.id.setHorizontalAlignment(JLabel.RIGHT);
			delete = new GAPButton("x");
			delete.setFont(ComponentStyle.defaultFont);
			delete.addMouseListener(new MouseListener() {

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
					removeItemPanel(ItemPanel.this);
					jframe.validate();
				}
			});
			order_id = new GAPTextField(8);
			order_id.setText("0000000001");
			destination = new GAPTextField(9);
			destination.setText("南京市栖霞区");
			inDate = new GAPTextField(8);
			inDate.setText("2015-12-04");
//			receiver_date.setControl("\\d\\d\\d\\d-\\d\\d-\\d\\d", 10, 10);
			location = new GAPTextField(7);
			location.setText("A排A架1位");

			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gcons = new GridBagConstraints();
			setLayout(gb);
			
			gcons.anchor = GridBagConstraints.CENTER;
			gcons.insets = new Insets(0, 5, 0, 15);
			SwingConsole.addComponent(gb, gcons, this, this.id, 0, 0, 1, 1, 1,
					0);
			gcons.anchor = GridBagConstraints.CENTER;
			gcons.insets = new Insets(0, 10, 0, 10);
			SwingConsole.addComponent(gb, gcons, this, order_id, 1, 0, 1, 1, 1,
					0);
			SwingConsole.addComponent(gb, gcons, this, destination, 2, 0, 1, 1, 1,
					0);
			SwingConsole.addComponent(gb, gcons, this, inDate, 3, 0, 1,
					1, 1, 0);
			SwingConsole.addComponent(gb, gcons, this, location, 4, 0, 1, 1, 1,
					0);
			gcons.anchor = GridBagConstraints.WEST;
			gcons.insets = new Insets(0, 5, 0, 15);
			SwingConsole
					.addComponent(gb, gcons, this, delete, 5, 0, 1, 1, 1, 0);

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (last) {
				Graphics2D g2d = RenderSetter.OpenRender(g);
				g2d.setColor(ComponentStyle.light_gray);
				int width = getWidth(), height = getHeight();
				g2d.drawLine(20, height - 5, width - 30, height - 5);
			}
		}

		public void setLast(boolean last) {
			this.last = last;
		}

		public ReceiveInfo getReceiveInfo() {
			String order = order_id.getText(), receiver_name = destination
					.getText(), date = inDate.getText(), com = location
					.getText();
			return new ReceiveInfo(order, receiver_name, date,
					ConstInfo.getNumber(), com);
		}

		public void setId(String str) {
			id.setText(str);
		}

	}
}
