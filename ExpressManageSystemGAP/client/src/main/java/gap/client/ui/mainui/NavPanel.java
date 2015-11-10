package gap.client.ui.mainui;

import gap.client.ui.util.Defaut;
import gap.client.ui.util.UIColor;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class NavPanel extends JPanel {
	public Map<NavItem, JPanel> components;
	private MainFrame mainFrame;

	public NavPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		components = new HashMap<NavItem, JPanel>();
		setBackground(UIColor.BACK_GRAY);
		setBorder(BorderFactory.createLineBorder(UIColor.BORDER_GRAY));
		setLayout(null);
	}

	// 添加导航项
	public void addNav(NavItem item, JPanel panel) {
		components.put(item, panel);
		Component co = item.getComponent();
		add(co);
		int y = (components.size() + 1) * Defaut.NAV_HEIGHT + Defaut.NAV_HEIGHT
				/ 2;
		co.setBounds(0, y, Defaut.NAV_WIDTH, Defaut.NAV_HEIGHT);
		co.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component po = (Component) e.getSource();
				Set<NavItem> sets = components.keySet();
				// 点击后的动作
				for (NavItem item : sets) {
					if (item.getComponent() == po) {
						item.setSelected();
						mainFrame.setMainPanel(components.get(item));
					} else {
						item.cancelSelected();
					}
				}
			}
		});
	}
}
