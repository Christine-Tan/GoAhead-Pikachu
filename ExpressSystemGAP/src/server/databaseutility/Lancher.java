package server.databaseutility;

import static server.databaseutility.Config.database;
import static server.databaseutility.Config.driver;
import static server.databaseutility.Config.password;
import static server.databaseutility.Config.url;
import static server.databaseutility.Config.user;
import static server.databaseutility.Excutor.cone;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author YangYanfei
 * 启动数据库服务的类
 */
public class Lancher {
	//启动数据库，返回数据库引用
	public static Excutor lanch() {
		Config.config();
		try {
			// 加载驱动
			Class.forName(driver);
			// 创建连接
			cone = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Excutor ex=Excutor.getInstance();
		ex.excute("USE "+database+";");
		return ex;
	}
}
