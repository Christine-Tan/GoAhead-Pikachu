package dataservice.userdataservice;

import java.util.List;

import util.ResultMessage;
import po.CarPO;
import po.UserPO;

public interface UserDataService {
	public List<UserPO> getAll();
	
	public ResultMessage add(UserPO po);

	public UserPO find(String user_id);

	public ResultMessage modify(UserPO po);

	public ResultMessage delete(String user_id);

}
