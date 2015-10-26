package dataservice.initialdata;

public interface InitialDataService {

	public boolean addInitial(InitialPO initialPO);
	public List<initialPO> getHistory();
	
}
