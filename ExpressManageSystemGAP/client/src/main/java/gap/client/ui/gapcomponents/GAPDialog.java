package gap.client.ui.gapcomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GAPDialog extends JDialog {
	JTextArea textArea;
	JButton cancel;

	public GAPDialog(Frame frame, String title, boolean modal) {
		super(frame, title, modal);
		textArea = new JTextArea();
		textArea.setBackground(Color.white);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setFont(ComponentStyle.defaultFont);
		textArea.setAlignmentX(0.5f);
		textArea.setBorder(BorderFactory.createEmptyBorder());
		cancel = new GAPButton("取消");

		add(textArea, BorderLayout.CENTER);
		add(cancel, BorderLayout.SOUTH);
		setSize(300, 150);
		setLocation(500, 500);
	}

	public void showMessage(String message) {

		textArea.setText(message);
		repaint();
		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setBounds(500, 500, 200, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		GAPDialog dia = new GAPDialog(jf, "测试", true);
		dia.showMessage("这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试这是一个测试");

	}
}
