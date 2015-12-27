package gap.client.ui.managerui.logui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.vo.LogVO;

public class LogDetailPanel extends JPanel {
	List<DetailItem> detailItems;
	// 布局
	GridBagLayout gbd;
	GridBagConstraints gcons;

	public LogDetailPanel(List<LogVO> logs) {
		// TODO Auto-generated constructor stub
		setBackground(Color.white);
		detailItems = new ArrayList<>();
		for (LogVO log : logs) {
			detailItems.add(new DetailItem(log));
		}
		reLayout();
	}

	private void reLayout() {
		gbd = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gbd);
		gcons.insets = new Insets(5, 100, 5, 100);
		for (int i = 0; i < detailItems.size(); i++) {
			SwingConsole.addComponent(gbd, gcons, this, detailItems.get(i), 0, i, 1, 1, 3, 0);
		}
	}

	class DetailItem extends JPanel {
		JLabel time_jl, user_jl, operation_jl;
		String time, user, operation;
		// 布局
		GridBagLayout gbdi;

		public DetailItem(LogVO log) {
			setBackground(Color.WHITE);
			time = log.getDate().substring(10, log.getDate().length()-1);
			user = log.getUser().getUserName();
			operation = log.getOperate();
			System.out.println("time=" + time + "user=" + user + "operate=" + operation);
			time_jl = new GAPLabel(time);
			user_jl = new GAPLabel(user);
			operation_jl = new GAPLabel(operation);

			gbdi = new GridBagLayout();
			gcons = new GridBagConstraints();
			setLayout(gbdi);
			gcons.insets = new Insets(5, 20, 5, 50);
			SwingConsole.addComponent(gbdi, gcons, this, time_jl, 0, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 30, 5, 30);
			SwingConsole.addComponent(gbdi, gcons, this, user_jl, 1, 0, 1, 1, 0, 0);
			gcons.insets = new Insets(5, 30, 5, 0);
			SwingConsole.addComponent(gbdi, gcons, this, operation_jl, 2, 0, 1, 1, 0, 0);
		}

	}
}
