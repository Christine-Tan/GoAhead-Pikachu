package client.dataservice.userdataservice;

import client.po.ResultMessage;
import client.po.UserPO;

public interface UserDataService {
	public ResultMessage add(UserPO po);

	public UserPO find(String user_id);

	public ResultMessage modify(UserPO po);

	public ResultMessage delete(String user_id);
}
