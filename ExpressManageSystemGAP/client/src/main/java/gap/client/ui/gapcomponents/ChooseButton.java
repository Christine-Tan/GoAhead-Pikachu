package gap.client.ui.gapcomponents;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButtonUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

public class ChooseButton extends JButton {

	public MouseListener listener;
	public boolean clicked;
	public ChooseButton() {
		super();
		initial();
	}

	public ChooseButton(String mess) {
		super(mess);
		initial();
	}

	public ChooseButton(Icon icon) {
		super(icon);
		initial();
	}

	public ChooseButton(String str, Icon icon) {
		super(str, icon);
		initial();
	}

	private void initial() {
//		clicked = false;
//		setFont(ComponentStyle.buttonFont);
		setFont(ColorAndFonts.getChinese(22));
		
		setBackground(Color.white);
		setForeground(ColorAndFonts.blue);
		setBorder(BorderFactory.createLineBorder(Color.lightGray));
		setFocusable(false);
		setUI(new GAPButtonUI());

		listener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				setBackground(ColorAndFonts.blue);
				setForeground(Color.white);
				clicked = true;
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				setForeground(ColorAndFonts.otherDarkBulue);
				//setBackground(ColorAndFonts.blue);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(!clicked){
					setForeground(ColorAndFonts.blue);
				}else{
					setForeground(Color.white);
				}
				
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
		};
		addMouseListener(listener);
	}
	
	public void toNomal(){
		setBackground(Color.white);
		setForeground(ColorAndFonts.blue);
		clicked = false;
		
	}
	
	public void setSelected(){
		setBackground(ColorAndFonts.blue);
		setForeground(Color.white);
		clicked = true;
	}
}
