package gap.client.ui.gapcomponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

public class GAPComboBox<E> extends JComboBox<E> {
	public GAPComboBox() {
		super();
		setRenderer(new GAPCellRender<E>());
		setBackground(Color.white);
		setFocusable(false);
		setFont(ComponentStyle.defaultFont);
		setMaximumRowCount(6);
//		setUI(new GAPComboBoxUI<>(this));
	}
}
