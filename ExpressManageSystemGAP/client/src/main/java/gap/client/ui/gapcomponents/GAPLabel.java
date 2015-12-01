package gap.client.ui.gapcomponents;

import javax.swing.JLabel;

public class GAPLabel extends JLabel {
	public GAPLabel() {
		super();
		initial();
	}

	public GAPLabel(String str) {
		super(str);
		initial();
	}

	private void initial() {
		setFont(ComponentStyle.defaultFont);
	}
}
