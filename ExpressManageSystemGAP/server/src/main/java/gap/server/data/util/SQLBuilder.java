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
 *	sqlBuilder.excuteQuery();<p/>
 *
 *	excute和excuteQuery执行完了之后会自动清空builder
 * @author 申彬
 *
 */
public class SQLBuilder {
	
	public static void main(String[] args) {
		SQLBuilder sqlBuilder = new SQLBuilder();		
		sqlBuilder.Select("T.account","T.balance").From("account").AS("T")
			.Where("Balance").EQUALS(150).AND("Income").EQUALS(200);
		
		//sqlBuilder.excuteQuery();
		System.out.println(sqlBuilder.getSQL());
		
		sqlBuilder.clear();
		sqlBuilder.InsertInto("account", "(balance,name,income)").Values("(15,100,'test')");
		System.out.println(sqlBuilder.getSQL());
		sqlBuilder.clear();
		sqlBuilder.InsertInto("account").Values(15,100,"test");
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
		String sql = builder.toString();
		clear();
		try {
			result = excutor.excute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL语句有问题");
			e.printStackTrace();
		}

		return result;
	}
	
	public ResultSet excuteQuery(){
		ResultSet resultSet = null;
		String sql = builder.toString();
		clear();
		try {
			resultSet = excutor.excuteQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("SQL语句有问题");
			e.printStackTrace();
		}
		
		return resultSet;		
	}
	
	public String getSQL(){
		return builder.toString();
	}
	
	public SQLBuilder InsertInto(String table,String ... column){
		builder.append("Insert into ");
		builder.append(table);
		builder.append(" ");
		
		makeList(column,true);
		return this;
	}
	
	public SQLBuilder Values(Object ... values) {
		builder.append("Values ");
		if(values.length==0){
			System.out.println("值列表为空");
		}
		makeList(values, false);
		return this;
			
	}
	
	private void makeList(Object[] objects,boolean isColumnName){
		if(objects.length==0)
		{
			return;
		}else
		{
			boolean hasBra = false;
			if(objects[0] instanceof String){
				String s = (String) objects[0];
				hasBra = s.contains("(");
			}
			
			if(!hasBra){
				leftBra();
			}
			
			for(int i=0;i<objects.length;i++){
				if(i>0){
					builder.append(",");
				}
				//在不是列名的情况下，string是特殊情况，需要加单引号。
				//同时也允许用户直接传(150,20,'aa')这样的形式进来，所以假如没有括号才特殊处理
				if(!isColumnName && (objects[i] instanceof String) && !hasBra){
					String value = objects[i].toString();
					handleString(value);
				}else{
					builder.append(objects[i].toString());
				}
			}
			
			if(!hasBra){
				rightBra();
			}
			builder.append(" ");
		}
	}
	
	public SQLBuilder Select(String ... column){
		builder.append("select ");
		
		if(column.length==0)
		{
			return this;
		}
		
		makeList(column, true);
		return this;
	}
	
	public SQLBuilder From(String tableName){
		builder.append("from ");
		builder.append(tableName);
		builder.append(" ");
		return this;
	}
	
	public SQLBuilder leftBra(){
		builder.append("(");
		return this;
	}
	public SQLBuilder rightBra(){
		builder.append(")");
		return this;
	}
	
	public SQLBuilder AS(String alias){
		builder.append("AS "+alias+" ");
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
	
	public SQLBuilder EQUALS(int num){
		judgeKeyWord("=");
		builder.append(num+" ");
		return this;
	}
	
	public SQLBuilder EQUALS(double num){
		judgeKeyWord("=");
		builder.append(num+" ");
		return this;
	}

	public SQLBuilder EQUALS(String string){
		judgeKeyWord("=");
		handleString(string);
		builder.append(" ");
		return this;		
	}
	
	public SQLBuilder AND(String string){
		builder.append("AND ");
		builder.append(string+" ");
		return this;
	}
	
	public SQLBuilder OR(String string){
		builder.append("OR ");
		builder.append(string);
		return this;
	}
	
	
	private void handleString(String string){
		builder.append("'");
		builder.append(string);
		builder.append("'");
	}
	
	private void judgeKeyWord(String judgeWord){
		builder.append(judgeWord);
		builder.append(" ");
	}
	
	public void clear(){
		if(builder!=null){
			builder.delete(0, builder.length());
		}
	}
	
}
