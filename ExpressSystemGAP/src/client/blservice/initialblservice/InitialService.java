package client.blservice.initialblservice;

import client.vo.InitialHistoryVO;
import client.vo.InitialVO;
import util.ResultMessage;

public interface InitialService {

	public InitialVO getInitialList();
	public ResultMessage submitInitialList(InitialVO initialVO);
	public InitialHistoryVO getInitialHistory();
	
}
