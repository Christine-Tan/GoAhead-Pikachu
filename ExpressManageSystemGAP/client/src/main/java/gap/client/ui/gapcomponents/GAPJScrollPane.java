package gap.client.ui.gapcomponents;

import gap.client.ui.UITools.ColorAndFonts;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class GAPJScrollPane extends JScrollPane {
	public GAPJScrollPane() {
		super();
		intial();
	}

	public GAPJScrollPane(Component pa) {
		// TODO 自动生成的构造函数存根
		super(pa);
		intial();
	}

	private void intial() {
//		getVerticalScrollBar().setUI(new GAPScrollBarUI());
//		getHorizontalScrollBar().setUI(new GAPScrollBarUI());
		getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		getHorizontalScrollBar().setPreferredSize(new Dimension(0, 12));
		setBorder(BorderFactory.createLineBorder(ColorAndFonts.gray));
	}

}
