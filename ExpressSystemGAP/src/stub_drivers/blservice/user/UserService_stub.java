package stub_drivers.blservice.user;

import java.util.ArrayList;
import java.util.List;
import po.UserPO;
import stub_drivers.dataservice.userdata.UserDataService_stub;
import util.ResultMessage;
import client.blservice.userblservice.UserService;
import client.vo.UserVO;

public class UserService_stub implements UserService{
	UserDataService_stub datastub;

	public UserService_stub() {
		datastub = new UserDataService_stub();
	}
	
	@Override
	public List<UserVO> getAll() {
		// TODO 自动生成的方法存根
		List<UserVO> list = new ArrayList<UserVO>();
		for (UserPO user : datastub.getAll())
			list.add(getVO(user));
		return list;
	}

	@Override
	public UserVO getSingle(String id) {
		// TODO 自动生成的方法存根
		return getVO(datastub.find(id));
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO 自动生成的方法存根
		return datastub.delete(id);
	}

	@Override
	public ResultMessage modify(UserVO vo) {
		// TODO 自动生成的方法存根
		return datastub.modify(getPO(vo));
	}

	@Override
	public ResultMessage add(UserVO vo) {
		// TODO 自动生成的方法存根
		return datastub.add(getPO(vo));
	}

	private UserVO getVO(UserPO po) {
		return new UserVO();
	}

	private UserPO getPO(UserVO vo) {
		return new UserPO();
	}
}
