package gap.client.ui.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingConsole {
	private SwingConsole() {
	}

	private static boolean Screencenter = true;
	private static boolean closeOperation = true;

	public static boolean getScreencenter() {
		return Screencenter;
	}

	public static void setScreencenter(boolean screencenter) {
		Screencenter = screencenter;
	}

	public static boolean isCloseOperation() {
		return closeOperation;
	}

	public static void setCloseOperation(boolean closeOperation) {
		SwingConsole.closeOperation = closeOperation;
	}

	public static void run(final JFrame f, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				if (closeOperation)
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);

				// ������ʾ
				if (Screencenter) {
					Dimension screensize = Toolkit.getDefaultToolkit()
							.getScreenSize(); // ��õ�ǰ��Ļ�Ĵ�С
					Dimension framesize = f.getSize(); // ��õ�ǰ���ڵĴ�С
					int x = (int) screensize.getWidth() / 2
							- (int) framesize.getWidth() / 2; // ����Ҫ��ʾ�Ĵ��ڵ����Ͻǵ�����
					int y = (int) screensize.getHeight() / 2
							- (int) framesize.getHeight() / 2;
					f.setLocation(x, y);
				} else
					f.setLocation(0, 0);

			}
		});

	}

	public static void addComponent(GridBagLayout gb, GridBagConstraints gcons,
			JPanel pa, Component com, int x, int y, int w, int h, double wx,
			double wy) {
		pa.add(com);
		gcons.gridx = x;
		gcons.gridy = y;
		gcons.gridheight = h;
		gcons.gridwidth = w;
		gcons.weightx = wx;
		gcons.weighty = wy;
		gb.setConstraints(com, gcons);
	}
}
