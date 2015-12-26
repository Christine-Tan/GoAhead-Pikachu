package gap.client.datacontroller;

import java.rmi.RemoteException;
import java.util.List;

import gap.common.po.AccountPO;
import gap.common.po.CityPO;
import gap.common.po.InitialHistoryPO;
import gap.common.po.UserPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

import static gap.client.datacontroller.NetModule.initialDataService;
import static gap.client.datacontroller.NetModule.citydataservice;
import static gap.client.datacontroller.NetModule.userdataservice;
import static gap.client.datacontroller.NetModule.accountDataService;
import static gap.client.datacontroller.NetModule.inventorydataservice;

public class InitialDataController {
	
//仓库根据中转中心查，名字叫城市名+仓库,容量是一个枚举*4
	
	protected InitialDataController(){}
	
	public ResultMessage addInitial(InitialHistoryPO initialPO){
		
		try{
			return initialDataService.addInitial(initialPO);
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
			
	}

	public List<InitialHistoryPO> getHistory(){
		try{
			return initialDataService.getHistory();
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}	
	}
	
	public List<CityPO> getAllCity(){
		
		try{
			return citydataservice.getAll();
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<UserPO> getAllUser(UserType userType){
		try{
			return userdataservice.getAll(userType);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<AccountPO> getAllAccount(){
		try{
			return accountDataService.getAccountList();
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
}
