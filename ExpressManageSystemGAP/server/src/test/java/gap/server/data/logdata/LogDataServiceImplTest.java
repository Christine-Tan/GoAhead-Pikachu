package gap.server.data.logdata;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.logdataservice.LogDataService;
import gap.common.po.LogPO;
import gap.common.po.UserPO;
import gap.common.util.UserType;
import gap.server.initial.Config;
import gap.server.initial.NetInitial;

import org.junit.Before;
import org.junit.Test;

public class LogDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			LogDataService logdata = (LogDataService) Naming.lookup(Config.url
					+ ServiceName.LOG_DATA_SERVICE);
			UserPO user = new UserPO("000000001", UserType.ADMINISTRATOR,
					"yyf", 0, "0010001", "123456");
			LogPO log1 = new LogPO(user, new Date(System.currentTimeMillis()),
					"test1"), log2 = new LogPO(user, new Date(
					System.currentTimeMillis()), "test2");
			logdata.addLog(log1);
			logdata.addLog(log2);
			for (LogPO log : logdata.getLogList()) {
				System.out.println("姓名：" + log.getUserPO().getUserName()
						+ ",日期:" + log.getDate() + ",操作：" + log.getOperate());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
