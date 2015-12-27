package gap.client.blservice.initialblservice;

import java.util.List;

import gap.common.po.InitialHistoryPO;
import gap.common.util.ResultMessage;

public interface InitialBlService {

	public InitialHistoryPO getCurrentInitial();

	public ResultMessage submitInitial(InitialHistoryPO initialPO);

	public List<InitialHistoryPO> getInitialHistory();

}
