package gap.client.bl.receipt.payee;

import gap.client.vo.PayeeVO;
import gap.common.po.TransFarePO;

public class TransFarePayee extends Payee{

	TransFarePO transFarePO;
	public TransFarePayee(TransFarePO transFarePO) {
		// TODO Auto-generated constructor stub
		this.transFarePO = transFarePO;
	}
	
	
	@Override
	PayeeVO makePayeeVO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
