package gap.client.ui.paymentUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.validator.PublicClassValidator;

import gap.client.ui.UITools.ColorAndFonts;
import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.UITools.SwingConsole;
import gap.client.vo.AccountVO;
import gap.client.vo.PayeeVO;
import gap.common.util.PaymentType;


/**
 * 
 * 表示一类付款项的panel，类型有工资，运费，租金
 * @author 申彬
 *
 */
public class PayeeClassPanel extends PanelWithGrid{
	JLabel nameLabel;
	PaymentMainPanel mainPanel;
	PaymentDisplayPanel displayPanel;
	
	ArrayList<PayeeItem> items;
	HashMap<PaymentType	, String> nameMap;

	ArrayList<AccountVO> accountVOs;
	ArrayList<PayeeVO> payees;
	
	
	
	public PayeeClassPanel
		(PaymentMainPanel mainPanel,
				PaymentDisplayPanel displayPanel,ArrayList<AccountVO> accountVOs,
				ArrayList<PayeeVO> payees,String name){
		
		this.mainPanel = mainPanel;
		this.displayPanel = displayPanel;
		this.payees = payees;
		
		setBackground(Color.white);
		
		nameLabel = new JLabel(name);
		nameLabel.setOpaque(true);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(ColorAndFonts.getChinese(20));
		nameLabel.setBackground(Color.white);
		
		items = new ArrayList<>();
		for(PayeeVO payeeVO:payees){
			PayeeItem anItem = new PayeeItem(payeeVO, accountVOs);
			items.add(anItem);
		}
		
		int itemNum = items.size();
		nameLabel.setPreferredSize
			(new Dimension(PaymentTableHeader.leftGap-10,itemNum* PaymentTableHeader.height));
		
		
		gridBagConstraints.insets = new Insets(5, 0, 5, 0);
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		SwingConsole.addComponent
		(gridBagLayout, gridBagConstraints, this, nameLabel, 0, 0, 1, itemNum, 0, 1);
		
		
		
		for(int i=0;i<itemNum;i++){	
			SwingConsole.addComponent(gridBagLayout, gridBagConstraints, this, 
					items.get(i), 1, i, 1, 1, 1, 0.1);
			
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		if(items.size()>0){
		
			Graphics2D graphics2d = RenderSetter.OpenRender(g);
			g.setColor(Color.gray);
		
			graphics2d.drawLine(0, getHeight()-2, getWidth(), getHeight()-2);
		}
		
	}
	
}
