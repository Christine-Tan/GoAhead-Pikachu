package gap.server.data.initial;

import gap.common.po.AccountPO;
import gap.common.po.InitialHistoryPO;
import gap.common.po.InitialPeoplePO;
import gap.common.po.InitialStockPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.SQLBuilder;
import static gap.server.data.initial.InitialTable.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InitialAdder {
	
	public static void addInitial(InitialHistoryPO po){
		SQLBuilder builder = new SQLBuilder();
		
		builder.Select("MAX(ID)").From(historyTableName);
		ResultSet set = builder.excuteQuery();
		int maxID = 100;
		
		try {
			maxID = set.getInt("ID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		maxID++;
		
		builder.InsertInto(historyTableName).Values(
					maxID,
					po.getDate(),
					po.getTotalBusinessHall(),
					po.getTotalCenter(),
					po.getTotalCourier(),
					po.getTotalBusinessClerk(),
					po.getTotalCenterClerk(),
					po.getTotalStockman(),
					po.getTotalWarehouse(),
					po.getTotalStock(),
					po.getTotalAccount(),
					po.getTotalBalance()
				);
		builder.excute();
		
		builder.clear();
		
		
		for(AccountPO accountPO:po.accountPOs){
			builder = new SQLBuilder();
			builder.InsertInto(accountTableName, accountName_col,balance_col,initialHistory_col).
				Values(accountPO.getName(),accountPO.getBalance(),maxID);
		}
		
		for(InitialPeoplePO peoplePO:po.initialPeoplePOs){
			builder = new SQLBuilder();
			builder.InsertInto(
						peopleTableName, 
						city_col,
						busHall_col,
						center_col,
						courier_col,
						busClerk_col,
						centerClerk_col,
						stockMan_col,
						initialHistory_col
					).Values(
						peoplePO.getCityName(),
						peoplePO.getBusinessHallNum(),
						peoplePO.getCenterNum(),
						peoplePO.getCourierNum(),
						peoplePO.getBusinessClerkNum(),
						peoplePO.getCenterClerkNum(),
						peoplePO.getStockmanNum(),
						maxID
					);
			builder.excute();
		}
		
		for(InitialStockPO stockPO:po.initialStockPOs){
			builder = new SQLBuilder();
			builder.InsertInto(stockTableName, 
						stockName_col,
						goodsNum_col,
						occupiedRate_col,
						initialHistory_col
					).Values(
						stockPO.getStockName(),
						stockPO.getGoodsNum(),
						stockPO.getOccupiedRate(),
						maxID
					);
			builder.excute();
		}
		
	}

}
