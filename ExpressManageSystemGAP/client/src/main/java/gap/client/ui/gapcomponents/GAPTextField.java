package gap.client.ui.gapcomponents;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import gap.client.ui.UITools.GapTextControll;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GAPTextField extends JTextField {
	public GAPTextField() {
		super();
		normal();
	}

	public GAPTextField(int column) {
		super(column);
		normal();
	}

	public GAPTextField(String str, int columns) {
		super(str);
		setColumns(columns);
		normal();
	}

	/**
	 * 设置字符框内的内容应该满足的格式
	 * @param regex
	 * @param length
	 */
	public void setControl(String regex, final int minLength,
			final int maxLength) {
		setDocument(new GapTextControll(regex, maxLength));
		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						String text = getText();
						if (text.length() < minLength
								|| text.length() > maxLength) {
							alarm();
							return;
						}
					}
				});

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						normal();
					}
				});
			}
		});
	}

	private void alarm() {
		// setBorder(ComponentStyle.alarm_border);
		setBackground(ComponentStyle.red);
		setFont(ComponentStyle.defaultFont);
		// repaint();
		Container con = getParent();
		while (!(con instanceof JFrame)) {
			con = con.getParent();
		}
		con.validate();
		con.repaint();
	}

	private void normal() {
		setBackground(Color.white);
		setBorder(ComponentStyle.text_border);
		setFont(ComponentStyle.defaultFont);
		validate();
	}

	public void closeEdit() {
		setEditable(false);
		setFocusable(false);
		setBorder(BorderFactory.createEmptyBorder());
	}

	public void openEdit() {
		setEditable(true);
		setFocusable(true);
		setBorder(ComponentStyle.text_border);
	}
}
