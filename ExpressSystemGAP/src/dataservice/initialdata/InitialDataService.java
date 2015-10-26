package dataservice.initialdata;

import java.util.List;

import po.InitialPO;

public interface InitialDataService {

	public boolean addInitial(InitialPO initialPO);
	public List<InitialPO> getHistory();
	
}
