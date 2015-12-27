package gap.client.ui.expressorderquery;

import gap.client.datacontroller.NetModule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class QueryFrame extends JFrame {
	ResultShowPanel result;

	public QueryFrame() {
		setUndecorated(true);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((dimen.width - 1000) / 2, (dimen.height - 550) / 2, 1000, 550);
		setBackground(new Color(0, 0, 0, 0));
		FrameListener listener = new FrameListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result = new ResultShowPanel();
		setContentPane(result);

		setVisible(true);

	}

	public static void main(String[] args) {
		NetModule.connect();
		new QueryFrame();
	}

	class FrameListener implements MouseListener, MouseMotionListener {
		int beforeX;
		int beforeY;
		int beforeFrameX;
		int beforeFrameY;
		boolean isPressed;

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO 自动生成的方法存根
			if (isPressed) {
				int deltaX = e.getXOnScreen() - beforeX;
				int deltaY = e.getYOnScreen() - beforeY;
				setLocation(beforeFrameX + deltaX, beforeFrameY + deltaY);
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			if (e.getY() <= 40) {
				isPressed = true;
				beforeX = e.getXOnScreen();
				beforeY = e.getYOnScreen();
				beforeFrameX = getX();
				beforeFrameY = getY();
			}
			System.out.println(isPressed);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			isPressed = false;
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
}
