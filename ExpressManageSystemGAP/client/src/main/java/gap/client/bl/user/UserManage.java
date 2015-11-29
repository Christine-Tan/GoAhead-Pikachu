package gap.client.bl.user;

import java.util.ArrayList;
import java.util.List;

import gap.client.blservice.userblservice.UserService;
import gap.client.datacontroller.controllerfactory.ControllerFactory;
import gap.client.datacontroller.userdata.UserDataController;
import gap.client.util.AbstractOperation;
import gap.client.util.Operation;
import gap.client.util.User;
import gap.client.vo.UserVO;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

public class UserManage implements UserService{
    List<Operation> operations;
    UserDataController controller;
    public UserManage(){
		controller=ControllerFactory.getUserDataController();
		operations = new ArrayList<Operation>();
    }
	@Override
	public List<UserVO> getAll(UserType userType) {
		// TODO Auto-generated method stub
       List<UserVO> users=new ArrayList<UserVO>();
       for(UserPO po:controller.getAll(userType)){
    	   User user=new User(po);
    	   users.add(user.toUserVO());
       }
		return users;
	}

	@Override
	public UserVO getSingle(String id) {
		// TODO Auto-generated method stub
		User user=new User(controller.findById(id));
		return user.toUserVO();
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultMessage modify(UserVO vo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultMessage add(UserVO vo) {
		// TODO Auto-generated method stub
		
		return null;
	}
 
	class AddOperation extends AbstractOperation{

		public AddOperation(Object args) {
			super(controller, "add", args);
			// TODO Auto-generated constructor stub
		}
		
	}
}
