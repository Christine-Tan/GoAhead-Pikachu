package gap.client.ui.AccountUI.CancelBehave;

import gap.client.ui.AccountUI.AddBox;

public class BoxCancelBehave implements CancelBehave{
	AddBox box;
	public BoxCancelBehave(AddBox box) {
		this.box = box;
	}
	@Override
	public void behave() {
		// TODO Auto-generated method stub
		box.cancel();
	}

}
