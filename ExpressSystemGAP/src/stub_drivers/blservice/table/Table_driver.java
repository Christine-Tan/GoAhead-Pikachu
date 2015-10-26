package stub_drivers.blservice.table;

import java.util.Date;

import client.blservice.tableblservice.TableService;
import client.vo.Cost_ProfitListVO;
import client.vo.OperatingConditionListVO;

public class Table_driver {

	public void drive(TableService stub){
		Date begin = new Date(2011, 1, 1);
		Date end = new Date(2011,10,2);
		Cost_ProfitListVO cost_ProfitListVO = stub.getCost_ProfitList();
		System.out.println("get cost and profit list");
		OperatingConditionListVO operatingConditionListVO = 
				stub.getOperatingConditionList(begin, end);
		System.out.println("get operate list from "+begin.toString()+" to "+end.toString());
		System.out.println(stub.Cost_ProfitExcel(cost_ProfitListVO));
		System.out.println(stub.OperatingConditionExcel(operatingConditionListVO));
		
		
		
	}
	
	public static void main(String[] args) {
		
		new Table_driver().drive(new Table_stub());

	}
	
}
