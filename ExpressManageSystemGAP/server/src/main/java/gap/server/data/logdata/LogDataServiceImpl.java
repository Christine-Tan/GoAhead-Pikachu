package gap.server.data.logdata;

import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.po.LogPO;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;
import gap.server.data.userdata.UserDataServiceImpl;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDataServiceImpl extends UnicastRemoteObject implements
		LogDataService {

	public LogDataServiceImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public List<LogPO> getLogList() throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<LogPO> logs = new ArrayList<LogPO>();
			ResultSet re = NetModule.excutor.excuteQuery("SELECT * FROM log;");
			UserDataService userdata = new UserDataServiceImpl();
			while (re.next()) {
				UserPO user = userdata.find(re.getString("user_id"));
				Date date = re.getDate("time");
				String operate = re.getString("operate");
				logs.add(new LogPO(user, date, operate));
			}
			return logs;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return null;
	}

	public Boolean addLog(LogPO logPO) throws RemoteException {
		// TODO 自动生成的方法存根

		try {
			String id = "'" + logPO.getUserPO().getUserId() + "'";
			String operate = "'" + logPO.getOperate() + "'";
			String date = "'" + logPO.getDate() + "'";
			String sql = "INSERT INTO log (user_id,time,operate) VALUES (" + id
					+ "," + date + "," + operate + ");";
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
