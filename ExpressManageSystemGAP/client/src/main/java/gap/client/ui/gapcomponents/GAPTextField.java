package gap.client.ui.gapcomponents;

import gap.client.ui.UITools.GapTextControll;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GAPTextField extends JTextField {
	TextListener listener;
	boolean edited;

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
		listener.setControl(regex, maxLength, minLength);
	}

	// 警告样式
	private void alarm() {
		setBackground(ComponentStyle.red);
		setFont(ComponentStyle.defaultFont);
		setBorder(ComponentStyle.text_border);
		Container con = getParent();
		while (!(con instanceof JFrame)) {
			con = con.getParent();
		}
		con.validate();
		con.repaint();
	}

	// 获得焦点样式
	private void gainFocus() {
		setBackground(Color.white);
		setFont(ComponentStyle.defaultFont);
		setBorder(ComponentStyle.focus_border);
	}

	// 普通样式
	private void normal() {
		if (listener == null) {
			listener = new TextListener();
			addFocusListener(listener);
		}
		edited = true;
		setBackground(Color.white);
		setBorder(ComponentStyle.text_border);
		setFont(ComponentStyle.defaultFont);
		validate();
	}

	// 关闭编辑样式
	public void closeEdit() {
		edited = false;
		setEditable(false);
		setFocusable(false);
		setBorder(BorderFactory.createEmptyBorder());
	}

	// 打开编辑样式
	public void openEdit() {
		edited = true;
		setEditable(true);
		setFocusable(true);
		normal();
	}

	class TextListener implements FocusListener {
		boolean controled;
		String regex;
		int maxLen, minLen;

		/**
		 * 默认为输入无要求
		 */
		public TextListener() {
			// TODO 自动生成的构造函数存根
			controled = false;
			maxLen = -1;
			minLen = -1;
			regex = null;
		}

		public void setControl(String regex, int maxLen, int minLen) {
			this.regex = regex;
			this.maxLen = maxLen;
			this.minLen = minLen;
			controled = true;
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO 自动生成的方法存根
			gainFocus();
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO 自动生成的方法存根
			String text = getText();
			if (controled
					&& (minLen != -1 && maxLen != -1 && (text.length() < minLen || text
							.length() > maxLen))) {
				alarm();
			} else if (edited) {
				normal();
			} else {
				closeEdit();
			}

		}
	}
}
