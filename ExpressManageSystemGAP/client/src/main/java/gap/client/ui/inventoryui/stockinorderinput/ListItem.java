package gap.client.ui.inventoryui.stockinorderinput;

import gap.client.ui.UITools.Default;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.client.util.LocalInfo;
import gap.client.vo.ExpressOrderVO;
import gap.client.vo.GoodsVO;
import gap.common.util.Address;
import gap.common.util.ExpressType;
import gap.common.util.SectorType;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ListItem extends JPanel {
	Checkbox box;
	GAPTextField id, inDate, destination, sector, location;
	ExpressOrderVO vo = new ExpressOrderVO();

	public ListItem() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(Default.PANEL_WIDTH, 50));

		box = new Checkbox();

		id = new GAPTextField(7);
		id.setText("0000000001");
		// id.setControl("\\d"+"", 20, 20);
		id.setHorizontalAlignment(JTextField.CENTER);

		inDate = new GAPTextField(7);
		inDate.setText("2015-12-03");
		// inDate.setControl("\\d\\d\\d\\d-\\d\\d-\\d\\d", 10, 10);
		inDate.setHorizontalAlignment(JTextField.CENTER);

		destination = new GAPTextField(12);
		destination.setText("南京市栖霞区");
		destination.setHorizontalAlignment(JTextField.CENTER);

		sector = new GAPTextField(5);
		sector.setHorizontalAlignment(JTextField.CENTER);
		sector.setText("航运区");

		location = new GAPTextField(10);
		location.setHorizontalAlignment(JTextField.CENTER);
//		location.setText("A排A架1位");
		
		inDate.setText((new Date(System.currentTimeMillis())).toString());
		inDate.closeEdit();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gcons = new GridBagConstraints();
		setLayout(gb);

		gcons.anchor = GridBagConstraints.CENTER;
		gcons.insets = new Insets(0, 20, 0, 5);
		SwingConsole.addComponent(gb, gcons, this, box, 0, 0, 1, 1, 1, 0);
		gcons.anchor = GridBagConstraints.WEST;
		gcons.insets = new Insets(0, 5, 0, 5);
		SwingConsole.addComponent(gb, gcons, this, id, 1, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, inDate, 2, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, destination, 3, 0, 1, 1, 1,
				0);
		SwingConsole.addComponent(gb, gcons, this, sector, 4, 0, 1, 1, 1, 0);
		SwingConsole.addComponent(gb, gcons, this, location, 5, 0, 1, 1, 1, 0);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = RenderSetter.OpenRender(g);
		g2d.setColor(ComponentStyle.light_gray);
		int width = getWidth(), height = getHeight();
		g2d.drawLine(20, height - 5, width - 30, height - 5);
	}

	public void setLine(ExpressOrderVO vo) {
		id.setText(vo.order_id);
		id.closeEdit();
		
		inDate.setText((new Date(System.currentTimeMillis())).toString());
		
		Address address = vo.receiver_info.getAddress();
		destination.setText(address.getProvince_name()+address.getDistrict_name()+address.getCity_name());
		destination.closeEdit();
		
		sector.setText(ExpressType.getSectorByExpressType(vo.expressType));
		sector.closeEdit();

		// destination.setText();
	}
	
	public GoodsVO getGoodsVO(){
		SectorType sec = SectorType.getSectorTypeByChinese(sector.getText());
		String expressorder_id = id.getText(),
				date = inDate.getText(),
				des = destination.getText(),
				loc = location.getText(),
				sector_id = SectorType.getSectorId(LocalInfo.getIns_ID(), sec),
				belong_sec = sector_id;
				
		return new GoodsVO(expressorder_id, loc, sec, date, sector_id, belong_sec, des);	
	}
	

}
