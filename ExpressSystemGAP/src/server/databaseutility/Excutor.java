package server.databaseutility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author YangYanfei
 * 执行SQL语句对数据库进行处理的类
 */
public class Excutor {
	protected static Connection cone;
	private static Excutor excutor;

	public static Excutor getInstance() {
		if (excutor == null)
			excutor = new Excutor();
		return excutor;
	}

	/**
	 * 执行查询语句
	 * @param sql 具体查询的sql语句
	 * @return 查询的结果集
	 */
	public ResultSet excuteQuery(String sql) {
		if (cone == null)
			throw new NullPointerException("数据库未连接");
		try {
			Statement statement = cone.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 执行语句
	 * @param sql 具体的sql语句
	 * @return 查询的结果集
	 */
	public void excute(String sql){
		if (cone == null)
			throw new NullPointerException("数据库未连接");
		try {
			Statement statement = cone.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
