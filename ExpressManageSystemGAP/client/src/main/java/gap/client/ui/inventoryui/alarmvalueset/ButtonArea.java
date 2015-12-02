package gap.client.ui.inventoryui.alarmvalueset;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonArea extends JPanel{
	public JButton confirm;

	public ButtonArea() {
		setBackground(Color.WHITE);
<<<<<<< HEAD:ExpressManageSystemGAP/client/src/main/java/gap/client/ui/inventoryui/alarmvalueset/ButtonArea.java
		setPreferredSize(new Dimension(Defaut.PANEL_WIDTH, 60));
=======
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 80));
>>>>>>> origin/master:ExpressManageSystemGAP/client/src/main/java/gap/client/ui/inventoryui/ButtonArea.java

		confirm = new GAPButton("确认");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.anchor = GridBagConstraints.CENTER;
		SwingConsole.addComponent(gb, gcons, this, confirm, 0, 0, 1, 1, 1, 0);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(10, 5, width - 20, 5);
	}
}
