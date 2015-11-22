package gap.server.data.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import gap.server.databaseutility.Excutor;

/**
 * 
 * 一个SQL生成器，有执行方法，用法示例如下:<p/>
 * 
 *	SQLBuilder sqlBuilder = new SQLBuilder();	<br/>
 *	sqlBuilder.Select("Name","Balance","Income").From("account").Where("Balance > 10000");<br/>
 *	sqlBuilder.excuteQuery();
 *		
 * @author 申彬
 *
 */
public class SQLBuilder {
	
	public static void main(String[] args) {
		SQLBuilder sqlBuilder = new SQLBuilder();		
		sqlBuilder.Select("Name","Balance","Income").From("account").Where("Balance > 10000");
		sqlBuilder.excuteQuery();
		System.out.println(sqlBuilder.getSQL());
		
	}

	private Excutor excutor;
	private StringBuilder builder;
	public SQLBuilder(){
		excutor = Excutor.getInstance();
		builder = new StringBuilder();
	}
	
	public boolean excute(){
		boolean result = false;
		try {
			result = excutor.excute(builder.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("兄弟你别乱执行呀");
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet excuteQuery(){
		ResultSet resultSet = null;
		try {
			resultSet = excutor.excuteQuery(builder.toString());
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("兄弟你别乱执行呀");
			e.printStackTrace();
		}
		return resultSet;		
	}
	
	public String getSQL(){
		return builder.toString();
	}
	
	public SQLBuilder Select(String ... column){
		builder.append("select ");
		builder.append(column[0]);
		
		for(int i=1;i<column.length;i++){
			builder.append(",");
			builder.append(column[i]);	
		}	
		builder.append(" ");
		return this;
	}
	
	public SQLBuilder From(String tableName){
		builder.append("from ");
		builder.append(tableName);
		builder.append(" ");
		return this;
	}
	
	
	/**
	 * 
	 * 若传入列名，记得调用 EQUALS，或者 AND，或者OR，EQUALS相当于 = <br/>
	 * 直接传入表达式也行
	 * @param col_Or_express
	 * @return
	 */
	public SQLBuilder Where(String col_Or_express){
		builder.append("Where ");
		builder.append(col_Or_express);
		builder.append(" ");
		return this;
	}
	
//	public SQLBuilder_Shen EQUALS(int num){
//		
//	}
	
	private void judgeKeyWord(String judgeWord){
		builder.append(" ");
		builder.append(judgeWord);
		builder.append(" ");
	}
	
	public void clear(){
		if(builder!=null){
			builder.delete(0, builder.length());
		}
	}
	
}
