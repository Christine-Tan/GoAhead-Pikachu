package dataservice.logdataservice;

import po.LogPO;

public interface LogDataService {

	public LogPO getLogList();
	public Boolean addLog(LogPO logPO);
		
}
