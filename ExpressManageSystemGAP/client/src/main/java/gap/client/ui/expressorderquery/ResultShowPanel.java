package gap.client.ui.expressorderquery;

import gap.client.blcontroller.ExpressorderController;
import gap.client.exception.InvalidInputException;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.expressorderquery.components.ArcAndString;
import gap.client.ui.expressorderquery.components.Colors;
import gap.client.ui.expressorderquery.components.IdInputCompo;
import gap.client.ui.expressorderquery.components.SmallCircle;
import gap.client.ui.gapcomponents.GAPBorder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 查询结果的显示
 * @author YangYanfei
 *
 */
public class ResultShowPanel extends JPanel {
	int defautinterval = 90, defautstart = 150, defautY = 370, messageY = 220;
	double currentEnd = defautstart;
	static boolean show;

	static String message = "";

	ArcAndString[] arcAndStrings;
	SmallCircle[] circles;
	IdInputCompo id_Input;

	CloseIcon close;

	int length;
	int unit_time = 500;
	int unit_rate = 50;
	Thread changeThread;

	public ResultShowPanel() {
		setLayout(null);
		setOpaque(false);
		setBorder(new GAPBorder());

		id_Input = new IdInputCompo(this);

		close = new CloseIcon();

		add(close);
		add(id_Input);
		id_Input.submit_bu.addMouseListener(new QueryListener());

		id_Input.setBounds(200, 120, 520, 70);
		close.setBounds(960, 10, 25, 25);
	}

	public ResultShowPanel(String[] states) {
		this();
		setStates(states);

	}

	public static void showMessage(String str) {
		message = str;
		show = false;
	}

	public void setStates(String[] states) {
		length = states.length;
		arcAndStrings = new ArcAndString[length];
		circles = new SmallCircle[length];
		for (int i = 0; i < length; i++) {
			arcAndStrings[i] = new ArcAndString(states[i], defautstart + i
					* defautinterval, defautY, (i + 1) % 2, this);
			circles[i] = new SmallCircle(defautstart + i * defautinterval,
					defautY, 7, 5, this);
		}
	}

	public void change() {
		if (changeThread != null && changeThread.isAlive())
			changeThread.interrupt();
		changeThread = new Thread(new ChangeRunnable());
		show = true;
		changeThread.start();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());

		g2d.setColor(Colors.blue);
		g2d.setStroke(new BasicStroke(5));

		// g2d.drawLine(defautstart, defautY, currentEnd, defautY);
		if (show) {
			g2d.draw(new Line2D.Double(defautstart - defautinterval / 3,
					defautY, currentEnd, defautY));
			for (ArcAndString as : arcAndStrings)
				as.draw(g2d);

			for (SmallCircle sc : circles)
				sc.draw(g2d);
		} else {
			Font font = new Font("黑体", Font.PLAIN, 20);
			FontMetrics fontM = getFontMetrics(font);
			g2d.setFont(font);
			g2d.setColor(Colors.red);
			int fontWidth = fontM.stringWidth(message);
			g2d.drawString(message, (830 - fontWidth) / 2, messageY);
		}
	}

	class ChangeRunnable implements Runnable {

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			double deltaX = defautinterval / (double) unit_rate;
			int deltaTime = unit_time / unit_rate;
			currentEnd = defautstart;
			for (int i = 0; i < length; i++) {
				circles[i].change(300, 100);
				arcAndStrings[i].change();
				for (int j = 0; j < unit_rate
						&& (i != (length - 1) || j < unit_rate / 3); j++) {
					currentEnd += deltaX;
					repaint();
					try {
						Thread.sleep(deltaTime);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						return;
					}
				}
			}
		}
	}

	class QueryListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			String order_id = id_Input.getOrderId();
			if (order_id == null)
				return;
			String[] states = ExpressorderController.getStates(order_id);
			if (states == null || states.length == 0) {
				showMessage("订单号不存在，请仔细核对");
				repaint();
				return;
			}
			setStates(states);
			change();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

	}

	class CloseIcon extends JLabel {
		String normalPath = "images\\expressorderquery\\close.png",
				focusPath = "images\\expressorderquery\\close1.png";
		ImageIcon normal, focus;

		public CloseIcon() {
			normal = new ImageIcon(normalPath);
			focus = new ImageIcon(focusPath);
			setIcon(normal);
			setSize(25, 25);
			addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO 自动生成的方法存根
					setIcon(focus);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO 自动生成的方法存根
					setIcon(normal);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO 自动生成的方法存根
					setIcon(normal);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO 自动生成的方法存根
					setIcon(focus);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 自动生成的方法存根
					System.exit(0);
				}
			});
		}
	}
}
