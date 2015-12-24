package gap.server.data.initial;

import static gap.server.data.initial.InitialTable.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import gap.common.po.AccountPO;
import gap.common.po.InitialHistoryPO;
import gap.common.po.InitialPeoplePO;
import gap.common.po.InitialStockPO;
import gap.server.data.util.ListMaker;
import gap.server.data.util.SQLBuilder;

public class InitialGetter {
	
	public ArrayList<InitialHistoryPO> getHistoryList(){
		
		HistoryMaker maker = new HistoryMaker();
		SQLBuilder builder = new SQLBuilder();
		builder.Select("ID").From(historyTableName);
		
		ArrayList<InitialHistoryPO> pos = maker.getList(builder);
		return pos;
	}
	
	
	public class HistoryMaker extends ListMaker<InitialHistoryPO>{

		@Override
		public InitialHistoryPO getPO(ResultSet resultSet) {
			// TODO Auto-generated method stub
			SQLBuilder builder = new SQLBuilder();
			builder.Select("ID").From(historyTableName);
			ResultSet set = builder.excuteQuery();
			
			int ID = 100;
			
			try {
				ID = set.getInt("ID");
			} catch (SQLException e) {
				return null;
			}
			
			PeopleMaker peopleMaker = new PeopleMaker();
			builder.clear();
			builder.Select("*").From(peopleTableName).
				Where(initialHistory_col).EQUALS(ID);
			ArrayList<InitialPeoplePO> peoplePOs = peopleMaker.getList(builder);
			
			StockMaker stockMaker = new StockMaker();
			builder.clear();
			builder.Select("*").From(stockTableName).
				Where(initialHistory_col).EQUALS(ID);
			ArrayList<InitialStockPO> stockPOs = stockMaker.getList(builder);
			
			AccountMaker accountMaker = new AccountMaker();
			builder.clear();
			builder.Select("*").From(accountName_col).
				Where(initialHistory_col).EQUALS(ID);
			ArrayList<AccountPO> accountPOs = accountMaker.getList(builder);
			
			InitialHistoryPO historyPO = 
					new InitialHistoryPO(accountPOs, peoplePOs, stockPOs);
			return historyPO;
		}
		
	}
	
	public class PeopleMaker extends ListMaker<InitialPeoplePO>{
		
		@Override
		public InitialPeoplePO getPO(ResultSet resultSet) {
			
			
			try {
				String city = resultSet.getString(city_col);
				int businessHall = resultSet.getInt(busHall_col);
				int center = resultSet.getInt(center_col);
				int courier = resultSet.getInt(courier_col);
				int businessClerk = resultSet.getInt(busClerk_col);
				int centerClerk = resultSet.getInt(centerClerk_col);
				int stockMan = resultSet.getInt(stockMan_col);
				
				int[] numbers = new int[6];
				numbers[0] = businessHall;
				numbers[1] = center;
				numbers[2] = courier;
				numbers[3] = businessClerk;
				numbers[4] = centerClerk;
				numbers[5] = stockMan;
				
				InitialPeoplePO po = new InitialPeoplePO(city, numbers);
				return po;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		
		
	}
	
	public class StockMaker extends ListMaker<InitialStockPO>{

		@Override
		public InitialStockPO getPO(ResultSet resultSet) {
			
			try {
				String name = resultSet.getString(stockName_col);
				int goodsNum = resultSet.getInt(goodsNum_col);
				double occupiedRate = resultSet.getDouble(occupiedRate_col);
				InitialStockPO po = new InitialStockPO(name, goodsNum, occupiedRate);
				return po;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public class AccountMaker extends ListMaker<AccountPO>{

	public AccountPO getPO(ResultSet resultSet) {
			try {
				String name = resultSet.getString(accountName_col);
				double balance = resultSet.getDouble(balance_col);
				AccountPO po = new AccountPO(name, balance);
				return po;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
			
			
		}
		
	}
}
