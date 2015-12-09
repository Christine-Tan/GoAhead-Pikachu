package gap.client.ui.gapcomponents;

import gap.client.ui.UITools.RenderSetter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class LoadPanel extends JComponent {
	JFrame jframe;
	Thread loadThread;
	LoadIcon icon;
	ExecutorService excutor;

	public LoadPanel(JFrame jframe) {
		this.jframe = jframe;
		setLayout(new BorderLayout());
		icon = new LoadIcon();
		add(icon);
		excutor = Executors.newSingleThreadExecutor();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(new Color(1f, 1f, 1f, 0.5f));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	public void load(Runnable runnable) {
		jframe.setGlassPane(this);
		setVisible(true);
		// repaint();
		runnable.run();
		setVisible(false);
	}
	//
	// public static void main(String[] args) {
	// JFrame jf = new JFrame();
	// Runnable runnable = new Runnable() {
	//
	// @Override
	// public void run() {
	// // TODO 自动生成的方法存根
	// for (int i = 0; i < 100; i++) {
	// System.out.println(i);
	// try {
	// Thread.sleep(50);
	// } catch (InterruptedException e) {
	// // TODO 自动生成的 catch 块
	// e.printStackTrace();
	// }
	// }
	// }
	// };
	// SwingConsole.run(jf, 1024, 768);
	// jf.add(new JButton("test"));
	// LoadPanel load = new LoadPanel();
	// load.load(jf, runnable);
	// }
}
