package gap.client.ui.gapcomponents;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.plaf.basic.BasicButtonUI;

public class GAPButtonUI extends BasicButtonUI {
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect,
			Rectangle textRect, Rectangle iconRect) {
		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ColorAndFonts.blue);
		g2d.fillRect(viewRect.x, viewRect.y, viewRect.width, viewRect.height);
	}

}
