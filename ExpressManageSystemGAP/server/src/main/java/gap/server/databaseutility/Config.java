package gap.server.databaseutility;

/**
 * 
 * @author YangYanfei
 * 存贮数据库配置信息的类
 */
public class Config {
	/**
	 * 数据库驱动、地址、用户名、密码
	 */
	public static String driver, url, user, password, database;
	public static String filePath = "server/config.txt";

	/**
	 * 读取配置信息
	 */
	public static void config() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://114.212.43.201:3306/bank";
		user = "root";
		password = "";
		database = "transport";
	}
}
