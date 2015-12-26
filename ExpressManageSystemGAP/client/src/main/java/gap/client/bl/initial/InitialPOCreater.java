package gap.client.bl.initial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import gap.client.datacontroller.InitialDataController;
import gap.common.po.AccountPO;
import gap.common.po.CityPO;
import gap.common.po.InitialHistoryPO;
import gap.common.po.InstitutionPO;

/**
 * 
 * 读取当前信息创建 期初信息
 * @author 申彬
 *
 */
public class InitialPOCreater {
	InitialDataController dataController;
	
	ArrayList<AccountPO> accountPOs;
	ArrayList<String> cityStrings;
	
	public InitialPOCreater(InitialDataController dataController){
		this.dataController = dataController;
	}
	
	public InitialHistoryPO creatPO(){
		
		accountPOs = new ArrayList<>(dataController.getAllAccount());
		List<CityPO> cityPOs = dataController.getAllCity();
		
		cityStrings = new ArrayList<>(cityPOs.size());
		for(CityPO cityPO : cityPOs){
			cityStrings.add(cityPO.getCity());
		}
		
		List<InstitutionPO> institutionPOs = dataController.getInititution();
		
		
		
	}
	
	
}
