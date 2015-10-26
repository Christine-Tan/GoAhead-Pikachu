package client.blservice.initialblservice;

public interface InitialService {

	public InitialVO getInitialList();
	public ResultMessage submitInitialList(InitialVO initialVO);
	public InitialHistoryVO getInitialHistory();
	
}
