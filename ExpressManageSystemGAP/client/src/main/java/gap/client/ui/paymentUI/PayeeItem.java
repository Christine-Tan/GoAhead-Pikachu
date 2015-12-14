package gap.client.ui.paymentUI;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gap.client.bl.receipt.payee.Payee;
import gap.client.ui.UITools.SwingConsole;
import gap.client.ui.gapcomponents.GAPComboBox;
import gap.client.ui.gapcomponents.GAPLabel;
import gap.client.vo.AccountVO;
import gap.client.vo.PayeeVO;
import gap.common.util.PaymentType;

public class PayeeItem extends PanelWithGrid{
	
	PayeeVO vo;
	
	GAPLabel payDate;
	GAPLabel recevier;
	GAPComboBox<AccountVO> accountCombox;
	//条目，如快递员工资，业务员工资
	GAPLabel item;
	GAPLabel money;
	//备注，如12月工资，运单号
	GAPLabel comment;
	
	ArrayList<AccountVO> accountVOs;
	
	JComponent[] components;
	
	private static String dateString=null; 
	
	public PayeeItem(PayeeVO vo,ArrayList<AccountVO> accountVOs){
		this.vo = vo;
		this.accountVOs = accountVOs;
		setBackground(Color.white);
		if(dateString==null){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dateString = format.format(calendar.getTime());
		}
		
		payDate = new GAPLabel(dateString);
		recevier = new GAPLabel(vo.getUserName());
		
		accountCombox = new GAPComboBox<>();
		
		for(AccountVO oneAccount:accountVOs){
			accountCombox.addItem(oneAccount);
			
			//把payee中的账户名设为默认选择项
			if(oneAccount.getName().equals(vo.getAccountName())){
				accountCombox.setSelectedItem(oneAccount);
			}
		}
		
		
		item = new GAPLabel(vo.getEntry());
		
		String moneyString = String.format("%.2f", vo.getMoney());
		money = new GAPLabel(moneyString+"元");
		comment = new GAPLabel(vo.getNote());
		
		components = new JComponent[6];
		components[0] = payDate;
		components[1] = recevier;
		components[2] = accountCombox;
		components[3] = item;
		components[4] = money;
		components[5] = comment;
		
		for(int i=0;i<components.length;i++){
			
			if(components[i]==accountCombox){
				continue;
			}
			
			components[i].setPreferredSize
				(new Dimension(PaymentTableHeader.widthArgs[i], PaymentTableHeader.height));
		}
		
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, payDate, 0, 0, 1, 1, 1, 1);
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, recevier, 1, 0, 1, 1, 1, 1);
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, accountCombox, 2, 0, 1, 1, 1, 1);
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, item, 3, 0, 1, 1, 1, 1);
		
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, money, 4, 0, 1, 1, 1, 1);
		SwingConsole.addComponent
			(gridBagLayout, gridBagConstraints, this, comment, 5, 0, 1, 1, 1, 1);
		
	}
	
//	public static void main(String[] args) {
//		
//		try {
//			UIManager
//			.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//				| UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JFrame frame = new JFrame("test");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//frame.setLayout(null);
//		frame.setSize(300, 300);
//		
//		PayeeVO vo = new PayeeVO(PaymentType.BUSSINESSCLERK, "00110011",
//					"小花", null, 1000, "主账户", "营业厅业务员工资", "12月工资");
//		ArrayList<AccountVO> accountVOs = new ArrayList<>();
//		accountVOs.add(new AccountVO("账户111111111",8000));
//		accountVOs.add(new AccountVO("账户2",8000));
//		accountVOs.add(new AccountVO("账户3",8000));
//		PayeeItem payeeItem = new PayeeItem(vo, accountVOs);
//		frame.add(payeeItem);
//		
//		frame.setVisible(true);
//	
//	
//	}
}
