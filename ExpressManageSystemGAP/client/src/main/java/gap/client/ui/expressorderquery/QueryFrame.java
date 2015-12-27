package gap.client.ui.expressorderquery;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class QueryFrame extends JFrame {
	ResultShowPanel result;
	public QueryFrame() {
		setUndecorated(true);
		setBounds(200, 200, 800, 600);
		setVisible(true);
		FrameListener listener=new FrameListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result=new  ResultShowPanel();
		setContentPane(result);
		
		result.chang();
		
		result.repaint();
		validate();
	}

	public static void main(String[] args) {
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
