package gap.client.ui.BaseComponents;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class NavigateBar extends JPanel {

	ArrayList<NavigateButton> buttons = new ArrayList<>();
	UserBox userBox;
	MainFrame mainFrame;

	public NavigateBar(MainFrame frame) {
		mainFrame = frame;
		setLayout(null);
		setBounds(0, 40, 220, 610);
		setBackground(Color.white);
		userBox = new UserBox();
		add(userBox);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = RenderSetter.OpenRender(g);
		graphics2d.setColor(ColorAndFonts.gray);
		int lineWidth = 3;
		graphics2d.fillRect(this.getWidth() - lineWidth, 0, lineWidth,
				this.getHeight());
	}

	public void addButton(NavigateButton button) {
		buttons.add(button);

		// if(button.getHeight()>=this.)

	}

}
