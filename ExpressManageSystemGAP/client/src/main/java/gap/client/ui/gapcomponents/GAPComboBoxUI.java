package gap.client.ui.gapcomponents;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

public class GAPComboBoxUI<E> extends BasicComboBoxUI {
	JComboBox<E> comboBox;

	public GAPComboBoxUI(JComboBox<E> combo) {
		super();
		this.comboBox = combo;
	}

	protected ComboPopup createPopup() {
		return new GAPComboPoupUI<E>(comboBox);
	}
}
