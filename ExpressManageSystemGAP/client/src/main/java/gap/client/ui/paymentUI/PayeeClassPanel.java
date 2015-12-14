package gap.client.ui.paymentUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.validator.PublicClassValidator;

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
		
		nameLabel = new JLabel(name);
		items = new ArrayList<>();
		for(PayeeVO payeeVO:payees){
			PayeeItem anItem = new PayeeItem(payeeVO, accountVOs);
			items.add(anItem);
		}
		
		int itemNum = items.size();
		nameLabel.setPreferredSize
			(new Dimension(PaymentTableHeader.leftGap,itemNum* PaymentTableHeader.height));
		
		SwingConsole.addComponent
		(gridBagLayout, gridBagConstraints, this, nameLabel, 0, 0, 1, itemNum, 0, 1);
		
		for(int i=0;i<itemNum;i++){
			
			SwingConsole.addComponent(gridBagLayout, gridBagConstraints, this, 
					items.get(i), 1, i, 1, 1, 1, 0.1);
			
		}
		
	}
	
}
