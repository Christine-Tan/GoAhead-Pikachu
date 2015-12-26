package gap.client.ui.managerui.logui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gap.client.blcontroller.LogController;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.vo.LogVO;

public class LogListItemPanel extends JPanel {
	HashMap<String, List<LogVO>> logMap;
	List<ItemPanel> items;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public LogListItemPanel() {
		// TODO Auto-generated constructor stub
		setBackground(Color.WHITE);
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();

		items = new ArrayList<>();
		logMap = LogController.getLogByDate();
		Iterator it = logMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<LogVO>> entry = (Map.Entry<String, List<LogVO>>) it.next();
			String date = entry.getKey();
			List<LogVO> logs = entry.getValue();
			items.add(new ItemPanel(date, logs));
		}
	}

	private void reLayout() {
		setLayout(gb);
		gcons.insets = new Insets(10, 0, 5, 0);
		for (int i = 0; i < items.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, items.get(i), 0, i, 1, 1, 1, 0);
		}
	}
}

class ItemPanel extends JPanel {
	JLabel date_jl, detail_jl;
	JPanel detailPanel;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;

	public ItemPanel(String date, List<LogVO> logs) {
		setBackground(Color.WHITE);
		date_jl = new GAPLabel(date);
		detail_jl = new GAPLabel(">");
		detailPanel = new DetailPanel(logs);
		// 布局
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets = new Insets(5, 10, 5, 10);
		SwingConsole.addComponent(gb, gcons, this, detail_jl, 0, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(5, 10, 5, 400);
		SwingConsole.addComponent(gb, gcons, this, date_jl, 1, 0, 1, 1, 0, 0);
		gcons.insets = new Insets(5, 10, 5, 10);
		SwingConsole.addComponent(gb, gcons, this, detailPanel, 0, 1, 1, 1, 2, 0);
	}
}

class DetailPanel extends JPanel {

	List<DetailItem> detailItems;
	// 布局
	GridBagLayout gb;
	GridBagConstraints gcons;

	public DetailPanel(List<LogVO> logs) {

		for (LogVO log : logs) {
			detailItems.add(new DetailItem(log));
		}
	}

	private void reLayout() {
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets = new Insets(5, 10, 5, 0);
		for (int i = 0; i < detailItems.size(); i++) {
			SwingConsole.addComponent(gb, gcons, this, detailItems.get(i), 0, i, 1, 1, 1, 0);
		}
	}
}

class DetailItem extends JPanel {
	JLabel time_jl, user_jl, operation_jl;
	String time, user, operation;
    //布局
	GridBagLayout gb;
	GridBagConstraints gcons;
	
	public DetailItem(LogVO log) {
		time = log.getDate().substring(10, log.getDate().length());
         user=log.getUser().getUserName();
         operation=log.getOperate();
         time_jl=new GAPLabel(time);
         user_jl=new GAPLabel(user);
         operation_jl=new GAPLabel(operation);
         
         gb=new GridBagLayout();
         gcons=new GridBagConstraints();
         setLayout(gb);
         gcons.insets=new Insets(5, 20, 5, 50);
         SwingConsole.addComponent(gb, gcons, this, time_jl, 0, 0, 1, 1, 0, 0);
         gcons.insets=new Insets(5, 30, 5, 30);
         SwingConsole.addComponent(gb, gcons, this, user_jl, 1, 0, 1, 1, 0, 0);
         gcons.insets=new Insets(5, 30,5, 100);
         SwingConsole.addComponent(gb, gcons, this, operation_jl, 2, 0, 1, 1, 0, 0);
         
	}
}
