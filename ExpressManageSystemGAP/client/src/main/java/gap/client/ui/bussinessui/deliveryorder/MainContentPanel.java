package gap.client.ui.bussinessui.deliveryorder;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;
import gap.client.vo.UserVO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 已选快递员、订单选择panel
 * @author YangYanfei
 *
 */
public class MainContentPanel extends JPanel {
	OrderSelectPanel orderSelectPanel;
	JPanel jp;
	UserBar userBar;
	DeliverySelectPanel deliveryPanel;
	JFrame jf;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public MainContentPanel(JFrame jf) {
		// TODO 自动生成的构造函数存根
		this.jf = jf;
		jp = new JPanel();
		jp.setOpaque(false);
		userBar = new UserBar();
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		// SwingConsole.addComponent(gb, gcons, this, userBar, 0, 0, 1, 1, 1,
		// 0);
		// SwingConsole.addComponent(gb, gcons, this, orderSelectPanel, 0, 1, 1,
		// 1, 1, 1);
	}

	void setDeleverySelectPanel(DeliverySelectPanel deliveryPanel) {
		this.deliveryPanel = deliveryPanel;
	}

	public void setOrderSelectPanel(OrderSelectPanel orderSelectPanel) {
		remove(this.orderSelectPanel);
		this.orderSelectPanel = orderSelectPanel;
		SwingConsole.addComponent(gb, gcons, this, orderSelectPanel, 0, 1, 1,
				1, 1, 1);
	}

	/**
	 * 添加一个已选用户
	 * @param user
	 */
	public void addUser(UserVO user) {
		userBar.addUser(user);
	}

	/**
	 * 删除一个已选用户
	 * @param user
	 */
	void deleteUser(UserBox user) {
		userBar.deleteUser(user);
		deliveryPanel.addUser(user.getUser());
	}

	/**
	 * 已选用户栏面板
	 * @author YangYanfei
	 *
	 */
	class UserBar extends JPanel {
		List<UserBox> users;

		public UserBar() {
			users = new ArrayList<>();
			setLayout(new FlowLayout(FlowLayout.RIGHT));
		}

		/**
		 * 面板添加用户
		 * @param user
		 */
		void addUser(UserVO user) {
			UserBox u = new UserBox(user);
			users.add(u);
			add(u);
			u.addMouseListener(new MouseListener() {

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

				}
			});

		}

		/**
		 * 面板删除用户
		 * @param box
		 */
		void deleteUser(UserBox box) {
			users.remove(box);
			remove(box);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = RenderSetter.OpenRender(g);
			g2d.setColor(ComponentStyle.light_gray);
			int width = getWidth(), height = getHeight();
			g2d.drawLine(10, height - 3, width - 20, height - 3);
		}
	}

	/**
	 * 一个用户框选项
	 * 绑定了一个订单选择面板
	 * @author YangYanfei
	 *
	 */
	class UserBox extends JLabel {
		private int width = 100, height = 100;
		OrderSelectPanel orderSelect;
		UserVO user;
		boolean selected;
		GAPButton delete;

		UserBox(UserVO user) {
			this.user = user;
			setLayout(null);
			setPreferredSize(new Dimension(width, height));
			setOpaque(true);

			delete = new GAPButton("x");
			delete.setOpaque(false);
			delete.setFont(ComponentStyle.defaultFont);
			Dimension size = delete.getPreferredSize();
			add(delete);
			delete.setBounds(width - size.width - 3, -5, size.width,
					size.height);
			 select();
			// orderSelect = new OrderSelectPanel();
		}

		/**
		 * 选择
		 */
		void select() {
			selected = true;
			setOpaque(true);
			setBackground(ColorAndFonts.blue);
			delete.setDefautFont(Color.white);
			delete.setEnterFont(Color.white);
			delete.setPressFont(Color.white);
			delete.setForeground(Color.white);
			repaint();
		}

		/**
		 * 取消选择
		 */
		void deSelect() {
			selected = false;
			setOpaque(false);
			delete.setDefautFont(ColorAndFonts.blue);
			delete.setEnterFont(ColorAndFonts.blue.darker());
			delete.setPressFont(ColorAndFonts.otherDarkBulue);
			delete.setForeground(ColorAndFonts.blue);
			repaint();
		}

		UserVO getUser() {
			return user;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = RenderSetter.OpenRender(g);
			if (selected)
				g2d.setColor(Color.white);
			else
				g2d.setColor(ComponentStyle.blue);
			g2d.setFont(ComponentStyle.plainFont);
			FontMetrics metrics = g2d.getFontMetrics();
			int word_width = metrics.stringWidth(user.getName());
			int word_desent = metrics.getDescent();
			g2d.drawString(user.getName(), (width - word_width) / 2, height
					- word_desent);
		}
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		MainContentPanel main = new MainContentPanel(jf);
		UserVO vo = new UserVO();
		vo.setName("杨雁飞");
		UserBox user = main.new UserBox(vo);

		jf.add(user);
		jf.setLayout(new FlowLayout());
		jf.setBounds(100, 100, 200, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
