package gap.client.ui.deliveryui.expressorderreceive;

import gap.client.ui.UITools.ConstInfo;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.common.util.ReceiveInfo;

import java.awt.Color;
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
import javax.swing.JTextField;
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
		JTextField order_id, receiver, receiver_date, comment;
		boolean last;

		public ItemPanel(int id) {
			setBackground(Color.WHITE);

			this.id = new GAPLabel(String.valueOf(id));
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
			receiver = new GAPTextField(6);
			receiver_date = new GAPTextField(8);
			comment = new GAPTextField(22);

			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gcons = new GridBagConstraints();
			setLayout(gb);
			gcons.insets = new Insets(10, 10, 10, 20);
			SwingConsole.addComponent(gb, gcons, this, this.id, 0, 0, 1, 1, 0,
					0);
			SwingConsole.addComponent(gb, gcons, this, order_id, 1, 0, 1, 1, 0,
					0);
			SwingConsole.addComponent(gb, gcons, this, receiver, 2, 0, 1, 1, 0,
					0);
			SwingConsole.addComponent(gb, gcons, this, receiver_date, 3, 0, 1,
					1, 0, 0);
			SwingConsole.addComponent(gb, gcons, this, comment, 4, 0, 1, 1, 0,
					0);
			gcons.insets = new Insets(10, 0, 10, 0);
			SwingConsole
					.addComponent(gb, gcons, this, delete, 5, 0, 1, 1, 0, 0);

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (last) {
				Graphics2D g2d = RenderSetter.OpenRender(g);
				g2d.setColor(ComponentStyle.light_gray);
				int width = getWidth(), height = getHeight();
				g2d.drawLine(10, height - 5, width - 20, height - 5);
			}
		}

		public void setLast(boolean last) {
			this.last = last;
		}

		public ReceiveInfo getReceiveInfo() {
			String order = order_id.getText(), receiver_name = receiver
					.getText(), date = receiver_date.getText(), com = comment
					.getText();
			return new ReceiveInfo(order, receiver_name, date,
					ConstInfo.getNumber(), com);
		}

		public void setId(String str) {
			id.setText(str);
		}

	}
}
