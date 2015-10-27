package gap.common.dataservice.initialdata;

import gap.common.po.InitialPO;

import java.util.List;

public interface InitialDataService {

	public boolean addInitial(InitialPO initialPO);

	public List<InitialPO> getHistory();

}
