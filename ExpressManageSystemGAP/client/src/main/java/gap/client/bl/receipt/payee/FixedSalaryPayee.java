package gap.client.bl.receipt.payee;

import java.util.Iterator;
import java.util.List;

import gap.client.vo.PayeeVO;
import gap.common.po.SalaryPO;
import gap.common.po.UserPO;

/**
 * 
 * 固定工资付款人
 * @author 申彬
 *
 */
public class FixedSalaryPayee extends Payee{
	UserPO userPO;
	Iterator<SalaryPO> salaryItr;
	public FixedSalaryPayee(UserPO userPO,Iterator<SalaryPO> salaryItr) {
		// TODO Auto-generated constructor stub
		this.userPO = userPO;
		this.salaryItr = salaryItr;
	}
	
	@Override
	PayeeVO makePayeeVO() {
		
	}

}
