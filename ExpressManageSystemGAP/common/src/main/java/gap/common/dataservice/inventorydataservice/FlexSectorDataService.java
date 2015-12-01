package gap.common.dataservice.inventorydataservice;

import gap.common.util.ResultMessage;

import java.rmi.Remote;

public interface FlexSectorDataService extends Remote {
	public ResultMessage add(String beginShelf,String endShelf,String sector_id);
}
