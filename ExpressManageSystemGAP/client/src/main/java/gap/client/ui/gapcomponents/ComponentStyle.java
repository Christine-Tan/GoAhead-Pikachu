package gap.client.ui.gapcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class ComponentStyle {
	public final static int PANEL_WIDTH = 850, PANEL_HEIGHT = 150;
	public final static int TITLE_FONT_SIZE = 15, ITEM_FONT_SIZE = 15;
	public final static Font defaultFont = new Font("微软雅黑", Font.PLAIN, 15),buttonFont=new Font("微软雅黑", Font.PLAIN, 25);

	public final static Color blue = new Color(Integer.parseInt("3399CC", 16)),
			light_gray = new Color(Integer.parseInt("DDDDDD", 16)),
			gray = new Color(Integer.parseInt("888888", 16));

	public final static Border text_border = BorderFactory
			.createBevelBorder(BevelBorder.LOWERED, ComponentStyle.light_gray,
					ComponentStyle.gray);

}
