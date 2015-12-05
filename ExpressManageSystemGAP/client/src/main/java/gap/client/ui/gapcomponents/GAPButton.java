package gap.client.ui.gapcomponents;

import gap.client.ui.UITools.ColorAndFonts;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GAPButton extends JButton {
	public GAPButton() {
		super();
		initial();
	}

	public GAPButton(String mess) {
		super(mess);
		initial();
	}

	private void initial() {
		setFont(ComponentStyle.buttonFont);
		setBackground(Color.white);
		setForeground(ColorAndFonts.blue);
		setBorder(BorderFactory.createEmptyBorder());
		setFocusable(false);
		setUI(new GAPButtonUI());
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				setBackground(Color.white);
				setForeground(ColorAndFonts.blue);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				setForeground(Color.white);
				setBackground(ColorAndFonts.blue);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				setForeground(ColorAndFonts.blue);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				setForeground(ColorAndFonts.blue.darker());
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
	}
}
