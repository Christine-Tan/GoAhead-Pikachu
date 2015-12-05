package gap.client.ui.gapcomponents;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GAPCheckBox extends JButton {
	boolean selected;

	public GAPCheckBox() {
		super();
		initial();
	}

	void initial() {
		setForeground(Color.white);
		setFocusPainted(false);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				normal();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(selected){
					select_focus();
				}else{
					normal_focus();
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
	}

	void normal() {
		setText("");
		setBorder(BorderFactory.createLineBorder(Color.gray));
		setBackground(Color.white);
	}

	void normal_focus() {
		setBorder(ComponentStyle.focus_border);
		setBackground(Color.white);
	}

	void select_focus() {

	}

	void select() {

	}

	void pressed() {

	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new GAPCheckBox());
		jf.setBounds(500, 500, 200, 100);
		jf.setVisible(true);
	}
}
