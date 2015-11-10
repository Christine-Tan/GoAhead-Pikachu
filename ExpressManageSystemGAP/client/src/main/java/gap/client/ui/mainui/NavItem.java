package gap.client.ui.mainui;

import java.awt.Component;

public interface NavItem {
	// 设置选中
	public void setSelected();

	// 取消选中
	public void cancelSelected();

	// 获得组件
	public Component getComponent();

}
