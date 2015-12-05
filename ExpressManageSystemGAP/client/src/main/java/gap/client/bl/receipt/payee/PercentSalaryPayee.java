package gap.client.bl.receipt.payee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import gap.client.bl.receipt.PaymentList;
import gap.client.datacontroller.AccountorReceiptDataController;
import gap.client.vo.PayeeVO;
import gap.common.po.AccountPO;
import gap.common.po.SalaryPO;
import gap.common.po.UserPO;
import gap.common.util.PaymentType;
import gap.common.util.UserType;

/**
 * 提成人员payee
 * @author 申彬
 *
 */
public class PercentSalaryPayee extends Payee{
	UserPO userPO;
	Iterator<SalaryPO> salaryItr;
	AccountorReceiptDataController controller;
	
	public PercentSalaryPayee(UserPO userPO,Iterator<SalaryPO> salaryItr
			,AccountorReceiptDataController controller) {
		this.userPO = userPO;
		this.salaryItr = salaryItr;
		this.controller = controller;
	}
	
	@Override
	PayeeVO makePayeeVO() {
		//快递员提成比
		SalaryPO percent=null;
		while(salaryItr.hasNext()){
			SalaryPO aPO = salaryItr.next();
			if(aPO.getType().equals(UserType.DELIVERY)){
				percent = aPO;
				break;
			}	
		}
		
		if(percent==null){
			System.out.println("未找到快递员的策略");
			return null;
		}
		
		double sumMoney = computeDeliveryMoney(userPO.getUserId());
		double salary = sumMoney * percent.getSalary();
		PaymentType type = getType(userPO);
		
		ArrayList<AccountPO> accountList = PaymentList.getAccounts();
		int index = (int)(accountList.size()*Math.random());
		AccountPO account = accountList.get(index);
		
//		(PaymentType type, String userID, String userName,
//				Calendar lastPaydate,double money,
//				String accountName,String entry,String note) 
		PayeeVO vo = new PayeeVO(type, userPO.getUserId(), userPO.getName(),null,sumMoney,
							account.getName(),type.getEntry(),getNote(userPO));
		return vo;
		
	}
	
	/**
	 * 根据快递员编号算他从上月到现在的快递费
	 * @param userID
	 * @return
	 */
	double computeDeliveryMoney(String userID){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		double sumMoney = 0;
		
		Calendar start = Calendar.getInstance();
		start.setTime(userPO.getLastPayDate());
		
		Calendar end = Calendar.getInstance();
		
		//当start的时间比end的时间靠前
		while(start.compareTo(end)<0){
			String stringDate = format.format(start.getTime());
			double oneDayMoney = controller.getDeliveryMoney(stringDate, userID);
			sumMoney+=oneDayMoney;
			
			start.add(Calendar.DATE, 1);
		}
		
		return sumMoney;	
	}
	
	

}
