package gap.client.datacontroller.inventorydata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.inventorydataservice.InventoryDataService;
import gap.common.dataservice.orderdataservice.DeliveryOrderDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;

public class InventoryDataController {
	InventoryDataService inventory;

	public InventoryDataController() {
		try {
			inventory = (InventoryDataService) Naming.lookup(RMIConfig.url
					+ ServiceName.INVENTORY_DATA_SERVICE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultMessage add(GoodsPO goodsPO) {
		// TODO Auto-generated method stub
		try {
			return inventory.add(goodsPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage add(List<GoodsPO> goodsPOs) {
		// TODO Auto-generated method stub
		try {
			return inventory.add(goodsPOs);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage delete(String goods_id) {
		// TODO Auto-generated method stub
		try {
			return inventory.delete(goods_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage delete(List<String> goods_ids) {
		// TODO Auto-generated method stub
		try {
			return inventory.delete(goods_ids);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(GoodsPO goods) {
		// TODO Auto-generated method stub
		try {
			return inventory.modify(goods);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(List<GoodsPO> goodsPOs) {
		// TODO Auto-generated method stub
		try {
			return inventory.modify(goodsPOs);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public GoodsPO find(String goods_id) {
		// TODO Auto-generated method stub
		try {
			return inventory.find(goods_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GoodsPO> getOneSector(String sector_id,String ins_id) {
		// TODO Auto-generated method stub
		try {
			return inventory.getOneSector(sector_id, ins_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public List<GoodsPO> getAll() { // TODO Auto-generated method stub try{
	 * return inventory.getAll(); }catch(RemoteException e){
	 * e.printStackTrace(); } return null; }
	 */

	public ResultMessage setAlarm(double alarmValue, String ins_id) {
		// TODO Auto-generated method stub
		try {
			return inventory.setAlarm(alarmValue, ins_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public double getAlarm(String ins_id) {
		// TODO Auto-generated method stub
		try {
			return inventory.getAlarm(ins_id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<GoodsPO> getOneTypeInFlex(String ins_id,String belong_sec_id){
		try {
			return inventory.getOneTypeInFlex(ins_id, belong_sec_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
