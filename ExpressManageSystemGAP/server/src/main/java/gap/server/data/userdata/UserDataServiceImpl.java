package gap.server.data.userdata;

import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDataServiceImpl extends UnicastRemoteObject implements
		UserDataService {
	// 表名
	private String tableName = "user";
	// 字段
	private String id_f = "id", username_f = "username",
			password_f = "password", institution_f = "institution",
			rank_f = "rank", userType_f = "userType";
	private InsertSQL insertSQL;
	private UpdateSQL updateSQL;

	public UserDataServiceImpl() throws RemoteException {
		super();
		insertSQL = new InsertSQL(tableName);
		updateSQL = new UpdateSQL(tableName);
	}

	public List<UserPO> getAll() throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<UserPO> users = new ArrayList<UserPO>();
			ResultSet re = NetModule.excutor.excuteQuery("SELECT * FROM user");
			while (re.next()) {
				String id = re.getString(id_f), username = re
						.getString(username_f), password = re
						.getString(password_f), ins_id = re
						.getString(institution_f);
				int rank = re.getInt(rank_f);
				UserType type = UserType.getUserType(re.getString(userType_f));
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
		String user_id = po.getUserId(), username = po.getUserName(), password = po
				.getPassword(), ins_id = po.getIns_id();
		UserType usertype = po.getType();
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
			insertSQL.clear();
			insertSQL.add(id_f, user_id);
			insertSQL.add(userType_f, usertype);
			insertSQL.add(username_f, username);
			insertSQL.add(password_f, password);
			insertSQL.add(institution_f, ins_id);
			insertSQL.add(rank_f, rank);
			String sql = insertSQL.createSQL();
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
			String id = re.getString(id_f), username = re.getString(username_f), password = re
					.getString(password_f), ins_id = re
					.getString(institution_f);
			int rank = re.getInt(rank_f);
			UserType type = UserType.getUserType(re.getString(userType_f));
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
		String user_id = po.getUserId(), username = po.getUserName(), password = po
				.getPassword(), ins_id = po.getIns_id();
		UserType usertype = po.getType();
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
			updateSQL.clear();
			updateSQL.add(institution_f, ins_id);
			updateSQL.add(username_f, username);
			updateSQL.add(password_f, password);
			updateSQL.add(rank_f, rank);
			updateSQL.add(userType_f, usertype);
			updateSQL.setKey(id_f, user_id);
			String sql = updateSQL.createSQL();
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage("failed");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
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
