package gap.client.ui.managerui.approvalui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gap.client.ui.gapcomponents.ComponentStyle;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.ui.gapcomponents.GAPTextField;
import gap.common.po.DeliveryOrderPO;

public class DeliveryOrderDetailPanel extends JPanel{
	//派件快递员和对应的派件快递
	public Map<String, List<String>> deliveryInfo;
	//布局
	GridBagLayout gl1;
	GridBagConstraints gcons;
	
	public DeliveryOrderDetailPanel(DeliveryOrderPO deliveryOrder) {
		// TODO Auto-generated constructor stub
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(ComponentStyle.gray));
	}
   
	class ItemPanel{
		JLabel courierid_jl,orderid_jl;
		List<GAPTextField> ordersid_tf;
		GAPTextField courierid_tf;
		//布局
		GridBagLayout gl2;
		ItemPanel(String courierid,List<String> ordersid){
			setBackground(Color.WHITE);
			setBorder(BorderFactory.createLineBorder(ComponentStyle.gray));
			
			courierid_jl=new GAPLabel("快递员编号");
			orderid_jl=new GAPLabel("派件快递单号");
			
			
		}
	}
}
