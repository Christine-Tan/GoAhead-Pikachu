package gap.server.data.util;

import gap.server.databaseutility.Excutor;

public class SQLBuilder_Shen {

	Excutor excutor;
	private StringBuilder builder;
	public SQLBuilder_Shen(){
		excutor = Excutor.getInstance();
		builder = new StringBuilder();
	}
	
	public SQLBuilder_Shen Select(String ... column){
		builder.append("select ");
		builder.append(column[0]);
		builder.append(" ");
		
		for(int i=1;i<column.length;i++){
			builder.append(",");
			builder.append(column[i]);
			builder.append(" ");
		}	
		return this;
	}
	
	public SQLBuilder_Shen From(String tableName){
		builder.append("from ");
		builder.append(tableName);
		builder.append(" ");
		return this;
	}
	
	
	/**
	 * 
	 * 若传入列名，记得调用 EQUALS，或者 AND，或者OR，EQUALS相当于 = 
	 * 直接传入表达式也行
	 * @param col_Or_express
	 * @return
	 */
	public SQLBuilder_Shen Where(String col_Or_express){
		builder.append(" ");
		builder.append(col_Or_express);
		builder.append(" ");
	}
	
	
	public void clear(){
		if(builder!=null){
			builder.delete(0, builder.length());
		}
	}
	
}
