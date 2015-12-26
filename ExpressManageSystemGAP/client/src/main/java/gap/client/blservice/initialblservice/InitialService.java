package gap.client.blservice.initialblservice;

import java.util.List;

import gap.common.po.InitialHistoryPO;
import gap.common.util.ResultMessage;

public interface InitialService {

	public InitialHistoryPO getCurrentInitial();

	public ResultMessage submitInitialList(InitialHistoryPO initialVO);

	public List<InitialHistoryPO> getInitialHistory();

}
