package gap.server.data.logdata;

import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.dataservice.userdataservice.UserDataService;
import gap.common.po.LogPO;
import gap.common.po.UserPO;
import gap.server.data.userdata.UserDataServiceImpl;
import gap.server.data.util.InsertSQL;
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

	private String tableName = "log";
	private String timef = "time", user_idf = "user_id", operatef = "operate";
	private InsertSQL insertSQL;

	public LogDataServiceImpl() throws RemoteException {
		super();
		insertSQL = new InsertSQL(tableName);
	}

	public List<LogPO> getLogList() throws RemoteException {
		// TODO 自动生成的方法存根
		try {
			List<LogPO> logs = new ArrayList<LogPO>();
			ResultSet re = NetModule.excutor.excuteQuery("SELECT * FROM "
					+ tableName + ";");
			UserDataService userdata = new UserDataServiceImpl();
			while (re.next()) {
				UserPO user = userdata.find(re.getString(user_idf));
				Date date = re.getDate(timef);
				String operate = re.getString(operatef);
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
			// String id = "'" + logPO.getUserPO().getUserId() + "'";
			// String operate = "'" + logPO.getOperate() + "'";
			// String date = "'" + logPO.getDate() + "'";
			// String sql = "INSERT INTO log (user_id,time,operate) VALUES (" +
			// id
			// + "," + date + "," + operate + ");";
			insertSQL.clear();
			insertSQL.add(user_idf, logPO.getUserPO().getUserId());
			insertSQL.add(operatef, logPO.getOperate());
			insertSQL.add(timef, logPO.getDate());
			String sql = insertSQL.createSQL();
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return true;
	}
}
