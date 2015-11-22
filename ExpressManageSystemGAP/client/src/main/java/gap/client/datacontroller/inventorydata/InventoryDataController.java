package gap.client.datacontroller.inventorydata;

import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.inventorydataservice.InventoryDataService;
import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;

public class InventoryDataController{
	InventoryDataService inventory;

	public ResultMessage add(GoodsPO goodsPO){
		// TODO Auto-generated method stub
		try {
			return inventory.add(goodsPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage add(List<GoodsPO> goodsPOs){
		// TODO Auto-generated method stub
		try{
			return inventory.add(goodsPOs);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage delete(String goods_id) {
		// TODO Auto-generated method stub
		try{
			return inventory.delete(goods_id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage delete(List<String> goods_ids) {
		// TODO Auto-generated method stub
		try{
			return inventory.delete(goods_ids);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(GoodsPO goods)  {
		// TODO Auto-generated method stub
		try{
			return inventory.modify(goods);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(List<GoodsPO> goodsPOs) {
		// TODO Auto-generated method stub
		try{
			return inventory.modify(goodsPOs);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public GoodsPO find(String goods_id)  {
		// TODO Auto-generated method stub
		try{
			return inventory.find(goods_id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	public List<GoodsPO> getAll()  {
		// TODO Auto-generated method stub
		try{
			return inventory.getAll();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage setAlarm(double alarmValue)  {
		// TODO Auto-generated method stub
		try{
			return inventory.setAlarm(alarmValue);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public double getAlarm()  {
		// TODO Auto-generated method stub
		try{
			return inventory.getAlarm();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
