package stub_drivers.blservice.initial;

import client.blservice.initialblservice.InitialService;
import client.vo.InitialHistoryVO;
import client.vo.InitialVO;
import util.ResultMessage;

public class Initial_stub implements InitialService {

	@Override
	public InitialVO getInitialList() {
		// TODO Auto-generated method stub
		return new InitialVO();
	}

	@Override
	public ResultMessage submitInitialList(InitialVO initialVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCEED;
	}

	@Override
	public InitialHistoryVO getInitialHistory() {
		// TODO Auto-generated method stub
		return new InitialHistoryVO();
	}

}
