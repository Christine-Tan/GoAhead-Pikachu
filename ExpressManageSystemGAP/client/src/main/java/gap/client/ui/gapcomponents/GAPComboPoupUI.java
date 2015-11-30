package gap.client.ui.gapcomponents;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboPopup;

public class GAPComboPoupUI extends BasicComboPopup {

	public GAPComboPoupUI(JComboBox combo) {
		super(combo);
		// TODO 自动生成的构造函数存根
	}

	protected JScrollPane createScroller() {
		return new GAPJScrollPane();
	}

}
