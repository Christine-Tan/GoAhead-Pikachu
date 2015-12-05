package gap.client.bl.receipt.payee;

import gap.client.vo.PayeeVO;
import gap.common.po.RentPO;

public class RentPayee extends Payee{

	RentPO rentPO;
	public RentPayee(RentPO rentPO) {
		// TODO Auto-generated constructor stub
		this.rentPO = rentPO;
	}
	
	@Override
	PayeeVO makePayeeVO() {
		// TODO Auto-generated method stub
		return null;
	}

}
