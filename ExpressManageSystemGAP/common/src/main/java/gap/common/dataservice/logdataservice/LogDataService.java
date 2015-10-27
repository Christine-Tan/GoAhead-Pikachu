package gap.common.dataservice.logdataservice;

import gap.common.po.LogPO;

public interface LogDataService {

	public LogPO getLogList();

	public Boolean addLog(LogPO logPO);

}
