package gap.client.blservice.initialblservice;

import gap.client.vo.InitialHistoryVO;
import gap.client.vo.InitialVO;
import gap.common.util.ResultMessage;

public interface InitialService {

	public InitialVO getInitialList();

	public ResultMessage submitInitialList(InitialVO initialVO);

	public InitialHistoryVO getInitialHistory();

}
