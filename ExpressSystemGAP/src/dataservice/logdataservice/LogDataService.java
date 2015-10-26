package dataservice.logdataservice;

public interface LogDataService {

	public logPO getLogList();
	public Boolean addLog(LogPO logPO);
		
}
