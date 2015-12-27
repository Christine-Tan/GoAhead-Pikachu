package gap.client.ui.expressorderquery.components;

import gap.client.ui.UITools.RenderSetter;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JLabel;

public class StringInfo extends JLabel {
	public static int UP = 0, DOWN = 1;
	private int x, y, width, height;
	private static int defautWidth = 150;
	int rowNum, rowHeight, type;
	private FontMetrics fontM;
	private Font defautFont;
	private Point connetPoint;
	String info;

	public StringInfo(String info, Point connectPoint, int type) {
		this.type = type;
		defautFont = new Font("微软雅黑", Font.BOLD, 15);
		this.info = info;
		this.connetPoint = connectPoint;
		fontM = getFontMetrics(defautFont);
		rowHeight = fontM.getHeight();
		rowNum = 1;

		reLocat();
	}

	public void reLocat() {
		rowNum = fontM.stringWidth(info) / defautWidth + 1;
		x = connetPoint.x - defautWidth / 2;
		if (type == 0)
			y = connetPoint.y - rowNum * rowHeight;
		else
			y = connetPoint.y;
		width = defautWidth;
		height = rowHeight * rowNum;
		setBounds(x, y, width, height);

	}

	public void draw(Graphics2D g2d) {
		Font reFont = g2d.getFont();

		g2d.setFont(defautFont);
		String handlingStr = info;
		int row = 1;
		while (handlingStr.length() != 0) {
			int strWidth = 0;
			String temStr = "";
			while (handlingStr.length() != 0
					&& ((strWidth + fontM.charWidth(handlingStr.charAt(0))) < defautWidth)) {
				temStr += handlingStr.charAt(0);
				handlingStr = handlingStr.substring(1);
				strWidth = fontM.stringWidth(temStr);
			}
			System.out.println(temStr);
			System.out.println(connetPoint.x - strWidth / 2);
			System.out.println(y + row * rowHeight);
			if (type == 0) {
				g2d.drawString(temStr, connetPoint.x - strWidth / 2, y + row
						* rowHeight-5);
			} else {
				g2d.drawString(temStr, connetPoint.x - strWidth / 2, y + row
						* rowHeight-5);
			}
			row++;
			temStr = "";
			strWidth = 0;
		}

		g2d.setFont(reFont);
	}
}
