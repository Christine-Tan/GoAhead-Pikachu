package gap.client.datacontroller.userdata;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

public class UserDataController {
	UserDataService userData;

	public UserDataController() {
		try {
			userData = (UserDataService) Naming.lookup(RMIConfig.url + ServiceName.USER_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<UserPO> getAll(UserType userType) {
		try {
			return userData.getAll(userType);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(UserPO po) {
		try {
			return userData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserPO findById(String user_id) {
		try {
			return userData.findById(user_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UserPO findByUsername(String username) {
		try {
			return userData.findByUsername(username);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage modify(UserPO po) {
		try {
			return userData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage delete(String user_id) {
		try {
			return userData.delete(user_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<UserPO> findUnpaidUser(Date date) {
		try {
			return userData.findUnpaidUser(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage setPaid(String user_id) {
		try {
			return userData.setPaid(user_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
}
