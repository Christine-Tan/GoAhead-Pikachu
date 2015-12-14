package gap.client.bl.table;

import gap.client.blservice.tableblservice.TableService;
import gap.client.datacontroller.ControllerFactory;
import gap.client.datacontroller.TableDataController;
import gap.client.vo.Cost_ProfitListVO;
import gap.client.vo.OperatingConditionListVO;
import gap.common.po.Cost_profitPO;
import gap.common.util.ResultMessage;

import java.util.ArrayList;
import java.util.Date;

public class TableBlController implements TableService {

	static TableBlController tableBlController;
	TableDataController dataController;

	private TableBlController() {
		dataController = ControllerFactory.getTableDataController();
	}

	public static TableBlController getInstance() {
		if (tableBlController == null) {
			tableBlController = new TableBlController();
		}
		return tableBlController;
	}

	@Override
	public Cost_ProfitListVO getCost_ProfitList() {

		ArrayList<Cost_profitPO> list = dataController.getCost_Profit();
		CostProfitComputer computer = new CostProfitComputer();
	 	return computer.compute(list);
		
	}

	@Override
	public OperatingConditionListVO getOperatingConditionList(Date begin,
			Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage Cost_ProfitExcel(Cost_ProfitListVO costProfitListVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage OperatingConditionExcel(
			OperatingConditionListVO operatingConditionListVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
