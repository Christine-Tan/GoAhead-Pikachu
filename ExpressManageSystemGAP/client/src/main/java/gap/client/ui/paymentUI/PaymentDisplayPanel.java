package gap.client.ui.paymentUI;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import gap.client.ui.UITools.SwingConsole;
import gap.client.vo.AccountVO;
import gap.client.vo.PayeeVO;
import gap.common.util.PaymentType;

public class PaymentDisplayPanel extends PanelWithGrid{

	PaymentMainPanel mainPanel;
	ArrayList<AccountVO> accountVOs;
	ArrayList<PayeeVO> payeeVOs;
	ArrayList<PayeeClassPanel> panels;
	PaymentTableHeader header;
	
	//用来储存不同类型的payee的数组
	
	ArrayList<PayeeVO> salaryVOs = new ArrayList<>();
	ArrayList<PayeeVO> transFareVOs = new ArrayList<>();
	ArrayList<PayeeVO> rentVOs = new ArrayList<>();
	ArrayList<PayeeVO> rewardVOs = new ArrayList<>();
	
	HashMap<PaymentType,ArrayList<PayeeVO> > typeMap;
	
	public PaymentDisplayPanel(PaymentMainPanel mainPanel,ArrayList<AccountVO> accountVOs,
			ArrayList<PayeeVO> payeeVOs){
		
		this.mainPanel = mainPanel;
		this.accountVOs = accountVOs;
		this.payeeVOs = payeeVOs;
		
		header = new PaymentTableHeader();
		
		typeMap = new HashMap<>();
		
		typeMap.put(PaymentType.DELIVERY, salaryVOs);
		typeMap.put(PaymentType.BUSSINESSCLERK, salaryVOs);
		typeMap.put(PaymentType.CENTERCLERK, salaryVOs);
		typeMap.put(PaymentType.INVENTORY, salaryVOs);
		typeMap.put(PaymentType.RENT, rentVOs);
		typeMap.put(PaymentType.TRANSFARE, transFareVOs);
		typeMap.put(PaymentType.REWARD, rewardVOs);
		
		
		
		
	}
	
	public void initial(ArrayList<PayeeVO> payeeVOs){
		this.payeeVOs = payeeVOs;
		
		for(ArrayList<PayeeVO> panel:typeMap.values()){
			panel.clear();
		}
		
		//将不同类型的收款人分拣到不同的组里边
		for(PayeeVO aPayee:payeeVOs){
			ArrayList<PayeeVO> aList = typeMap.get(aPayee.getType());
			aList.add(aPayee);
		}
		
		if(panels==null){
			panels = new ArrayList<>();
		}else{
			panels.clear();
		}
		
		PayeeClassPanel salaryPanel = new PayeeClassPanel
				(mainPanel, this, accountVOs, salaryVOs, "工资");
		
		PayeeClassPanel transPanel = new PayeeClassPanel
				(mainPanel, this, accountVOs, transFareVOs, "运费");
		
		PayeeClassPanel rentPanel = new PayeeClassPanel
				(mainPanel, this, accountVOs, rentVOs, "租金");
		
		panels.add(salaryPanel);
		panels.add(transPanel);
		panels.add(rentPanel);
		
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, header, 0, 0, 1, 1, 1, 0.2);
		
		for(int i=0;i<panels.size();i++){
			PayeeClassPanel aPanel = panels.get(i);
			SwingConsole.addComponent
				(gridBagLayout, gridBagConstraints, this, aPanel, 0, i+1, 1, 1, 1, 1);
		}
		
		
	}
	
}
