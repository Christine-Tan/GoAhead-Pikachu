package client.blservice.tableblservice;

import java.util.Date;

import client.vo.Cost_ProfitListVO;
import client.vo.OperatingConditionListVO;
import util.ResultMessage;

public interface TableService {

	public Cost_ProfitListVO getCost_ProfitList();
	public OperatingConditionListVO getOperatingConditionList
											(Date begin,Date end);
	public ResultMessage Cost_ProfitExcel
									(Cost_ProfitListVO costProfitListVO);
	
	public ResultMessage OperatingConditionExcel
									(OperatingConditionListVO operatingConditionListVO);

}
