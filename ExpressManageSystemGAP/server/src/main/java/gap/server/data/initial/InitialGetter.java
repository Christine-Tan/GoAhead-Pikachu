package gap.server.data.initial;

import static gap.server.data.initial.InitialTable.historyTableName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gap.common.po.InitialHistoryPO;
import gap.server.data.util.ListMaker;
import gap.server.data.util.SQLBuilder;

public class InitialGetter {
	
	public ArrayList<InitialHistoryPO> getHistoryList(){
		
		
		
	}
	
	
	public class HistoryMaker extends ListMaker<InitialHistoryPO>{

		@Override
		public InitialHistoryPO getPO(ResultSet resultSet) {
			// TODO Auto-generated method stub
			SQLBuilder builder = new SQLBuilder();
			builder.Select("ID").From(historyTableName);
			ResultSet set = builder.excuteQuery();
			
			int maxID = 100;
			
			try {
				maxID = set.getInt("ID");
			} catch (SQLException e) {
				return null;
			}
			
			
		}
		
	}
	
	
}
