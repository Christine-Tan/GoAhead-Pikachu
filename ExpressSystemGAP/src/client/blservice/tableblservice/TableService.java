package client.blservice.tableblservice;

import java.util.Date;

public interface TableService {

	public Cost_ProfitListVO getCost_ProfitList();
	public OperatingConditionList getOperatingConditionList
											(Date begin,Date end);
	public ResultMessage Cost_ProfitExcel
									(CostProfitListVO costProfitListVO);
	
	public ResultMessage OperatingConditionExcel
									(OperatingConditionListVO operatingConditionListVO)

}
