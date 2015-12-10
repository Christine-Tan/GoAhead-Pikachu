package gap.client.ui.AccountUI;

import java.awt.Color;

import org.omg.PortableInterceptor.ServerRequestInfo;

import gap.client.ui.LoginUI.LoginTextListener;
import gap.client.ui.LoginUI.TextInterface;
import gap.client.ui.gapcomponents.GAPTextField;

public class DefaultText_Field extends GAPTextField implements TextInterface {

	boolean hadFocused = false;
	String text;
	
	public DefaultText_Field(String text) {
		super();
		this.text = text;
		setForeground(Color.gray);
		setText(text);
		new LoginTextListener(this);
	}
	@Override
	public boolean hadFocused() {
		// TODO Auto-generated method stub
		return hadFocused;
	}
	
//	public void setText(String t) {
//		setForeground(Color.gray);
//		super.setText(t);
//	};

	@Override
	public void setFocused(boolean focused) {
		// TODO Auto-generated method stub
		hadFocused = focused;
		if (!focused) {
			setForeground(Color.gray);
			setText(text);
		}
	}

}
