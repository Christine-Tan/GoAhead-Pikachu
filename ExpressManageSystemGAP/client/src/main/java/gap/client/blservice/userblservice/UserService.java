package gap.client.blservice.userblservice;

import gap.client.vo.UserVO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

import java.util.List;

public interface UserService {
	public List<UserVO> getAll(UserType userType);

	public UserVO findById(String id);

	public UserVO findByUsername(String username);

	public ResultMessage delete(String id);

	public ResultMessage modify(UserVO vo);

	public ResultMessage add(UserVO vo);
}
