package client.blservice.userblservice;

import java.util.List;

import client.vo.UserVO;
import po.UserPO;
import util.ResultMessage;

public interface UserService {
	public List<UserVO> getAll();

	public UserVO getSingle(String id);

	public ResultMessage delete(String id);

	public ResultMessage modify(UserVO vo);

	public ResultMessage add(UserVO vo);
}
