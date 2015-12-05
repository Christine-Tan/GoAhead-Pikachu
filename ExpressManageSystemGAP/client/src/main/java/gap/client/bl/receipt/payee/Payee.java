package gap.client.bl.receipt.payee;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.print.CancelablePrintJob;

import gap.client.vo.PayeeVO;
import gap.common.po.RentPO;
import gap.common.po.TransFarePO;
import gap.common.po.UserPO;
import gap.common.util.PaymentType;

/**
 * 被付款人的逻辑层对象
 * @author 申彬
 *
 */
public abstract class Payee {
	protected PayeeVO payeeVO;
	static SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
	static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	
	abstract PayeeVO makePayeeVO();
	
	public PayeeVO getVO(){
		if(payeeVO==null){
			payeeVO = makePayeeVO();
		}
		return payeeVO;
	}
	
	public PaymentType getType(Object o){
		if(o instanceof UserPO){
			UserPO userPO = (UserPO)o;
			
			//DELIVERY, BUSSINESSCLERK, CENTERCLERK, INVENTORY, ACCOUNTER, MANAGER, ADMINISTRATOR;
			switch (userPO.getType()){
			
			case DELIVERY:
				return PaymentType.DELIVERY;
			case BUSSINESSCLERK:
				return PaymentType.BUSSINESSCLERK;
			case CENTERCLERK:
				return PaymentType.CENTERCLERK;
			case INVENTORY:
				return PaymentType.INVENTORY;
			default:
				return null;
			}
			
		}else if(o instanceof RentPO){
			return PaymentType.RENT;
		}else if(o instanceof TransFarePO){
			return PaymentType.TRANSFARE;
		}
		return null;
	}
	
	public String getNote(Object o){
		PaymentType type = getType(o);
		if(type==null){
			return null;
		}
		Calendar now = Calendar.getInstance();
		
		switch(type){
		
			case DELIVERY:
			case INVENTORY:
			case CENTERCLERK:
			case BUSSINESSCLERK:
			{
				//工资年份
				String month = monthFormat.format(now.getTime());
				return month+"月份工资";
			}
			
			case RENT:
				String year = yearFormat.format(now.getTime());
				return year+"年房租";
			case TRANSFARE:
				TransFarePO transFarePO = (TransFarePO)o;
				return transFarePO.getOrderID();
		}
		return null;
		
	}
	
}
