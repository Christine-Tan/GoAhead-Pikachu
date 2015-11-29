package gap.client.ui.bussinessui;

import javax.swing.JTextField;

public class GAPTextField extends JTextField {
	public GAPTextField() {
		super();
		initial();
	}

	public GAPTextField(int column) {
		super(column);
		initial();
	}

	private void initial() {
		setBorder(ComponentStyle.text_border);
		setFont(ComponentStyle.defaultFont);
	}
}
