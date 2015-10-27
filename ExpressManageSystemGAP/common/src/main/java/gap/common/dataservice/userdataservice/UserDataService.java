package gap.common.dataservice.userdataservice;

import gap.common.po.UserPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface UserDataService {
	public List<UserPO> getAll();

	public ResultMessage add(UserPO po);

	public UserPO find(String user_id);

	public ResultMessage modify(UserPO po);

	public ResultMessage delete(String user_id);

}
