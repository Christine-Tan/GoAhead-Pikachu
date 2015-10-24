package client.blservice.userblservice;

import po.UserPO;

public interface UserService {
	public UserPO[] getAll();

	public UserPO getSingle(String id);

	public void delete(String id);

	public void modify(UserPO po);

	public void add(UserPO po);
}
