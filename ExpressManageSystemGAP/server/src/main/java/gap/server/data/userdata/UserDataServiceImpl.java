package gap.server.data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;
import gap.server.initial.NetModule;

public class UserDataServiceImpl extends UnicastRemoteObject implements
		UserDataService {

	public UserDataServiceImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public List<UserPO> getAll() throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<UserPO> users = new ArrayList<UserPO>();
			ResultSet re = NetModule.excutor.excuteQuery("SELECT * FROM user");
			while (re.next()) {
				String id = re.getString("id"), username = re
						.getString("username"), password = re
						.getString("password"), ins_id = re
						.getString("institution");
				int rank = re.getInt("rank");
				UserType type = UserType.getUserType(re.getString("userType"));
				UserPO po = new UserPO(id, type, username, rank, ins_id,
						password);
				users.add(po);
			}
			return users;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String user_id = "'" + po.getUserId() + "'", username = "'"
				+ po.getUserName() + "'", password = "'" + po.getPassword()
				+ "'", ins_id = "'" + po.getIns_id() + "'";
		UserType usertype = po.getType();
		String type = "'" + usertype + "'";
		int rank = po.getRank();
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM user WHERE id=" + user_id + ";");
			if (re.next()) {
				System.out.println(re.getString("username"));
				return ResultMessage.EXITED;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		try {
			String sql = "INSERT INTO user (id,usertype,rank,username,password,institution) VALUES ("
					+ user_id
					+ ","
					+ type
					+ ","
					+ rank
					+ ","
					+ username
					+ ","
					+ password + "," + ins_id + ");";
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return ResultMessage.SUCCEED;
	}

	public UserPO find(String user_id) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM user WHERE id=" + user_id + ";");
			re.next();
			String id = re.getString("id"), username = re.getString("username"), password = re
					.getString("password"), ins_id = re
					.getString("institution");
			int rank = re.getInt("rank");
			UserType type = UserType.getUserType(re.getString("userType"));
			UserPO po = new UserPO(id, type, username, rank, ins_id, password);
			return po;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage modify(UserPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		String user_id = "'" + po.getUserId() + "'", username = "'"
				+ po.getUserName() + "'", password = "'" + po.getPassword()
				+ "'", ins_id = "'" + po.getIns_id() + "'";
		UserType usertype = po.getType();
		String type = "'" + usertype + "'";
		int rank = po.getRank();
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM user WHERE id=" + user_id + ";");
			if (!re.next()) {
				return ResultMessage.NOTFOUND;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		try {
			String sql = "UPDATE user set username=" + username + ",password="
					+ password + ",institution=" + ins_id + ",userType=" + type
					+ ",rank=" + rank + " WHERE id=" + user_id + ";";
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return ResultMessage.SUCCEED;
	}

	public ResultMessage delete(String user_id) throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			NetModule.excutor.excute("DELETE FROM user WHERE id=" + user_id
					+ ";");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		}
		return ResultMessage.SUCCEED;
	}

}
