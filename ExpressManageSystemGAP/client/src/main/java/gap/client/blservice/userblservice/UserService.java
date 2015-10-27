package gap.client.blservice.userblservice;

import gap.client.vo.UserVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface UserService {
	public List<UserVO> getAll();

	public UserVO getSingle(String id);

	public ResultMessage delete(String id);

	public ResultMessage modify(UserVO vo);

	public ResultMessage add(UserVO vo);
}
