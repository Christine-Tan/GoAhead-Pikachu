package gap.client.ui.inventoryui.checkstock;

import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ListPanel extends JPanel {
	List<ListItem> list;
	String sector_id;
	GridBagLayout gb;
	GridBagConstraints gcons;

	public ListPanel(final int rowNum,String sector_id) {
		this.sector_id = sector_id;
		setBackground(Color.white);
		setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0,
				ComponentStyle.light_gray));

		list = new ArrayList<ListItem>();
		gb = new GridBagLayout();
		gcons = new GridBagConstraints();
		setLayout(gb);
		gcons.insets = new Insets(0, 10, 0, 10);
		gcons.anchor = GridBagConstraints.CENTER;

		gcons.insets = new Insets(10, 0, 0, 0);
		flush(rowNum, sector_id);
	}
	
	void flush(int rowNum,String sector_id){
		list.clear();
		removeAll();
		for (int i = 0; i < rowNum; i++) {
			list.add(new ListItem(rowNum, i,sector_id));
			System.out.println(sector_id);
			SwingConsole.addComponent(gb, gcons, this, list.get(i), 0, i, 1, 1, 1,
					0);
		}
	}
}
