package gap.server.data.inventorydata;

import gap.common.dataservice.inventorydataservice.InventoryDataService;
import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDataServiceImpl extends UnicastRemoteObject implements InventoryDataService{
	
	//表名
	private String sectorTable = "sector";
	//字段
	private String sector_id_f = "sector_id",type_f = "type",ins_id_f = "ins_id";
	//表名
	private String sectorItemTable = "sector_item";
	//字段
	private String id_f = "id",location_f = "location",sectorid_f = "sector_id",
			expressorder_id_f = "expressorder_id",time_f = "time",belong_sec_f="belone_sec";
	
	private InsertSQL sectorInsert,sectorItemInsert;
	private UpdateSQL sectorUpdate,sectorItemUpdate;
	
	
	public InventoryDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		sectorInsert = new InsertSQL(sectorTable);
		sectorUpdate = new UpdateSQL(sectorTable);
		sectorItemInsert = new InsertSQL(sectorItemTable);
		sectorItemUpdate = new UpdateSQL(sectorItemTable);
		
	}
	
	@Override
	public List<GoodsPO> getAll(String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> sector_ids = new ArrayList<String>();
		try {
			ResultSet re = NetModule.excutor.
					excuteQuery("SELECT * FROM sector WHERE ins_id="+ins_id+";");
			if(!re.next()){
				System.out.println("中转中心编号不存在！！！");
				return null;
			}
			while(re.next()){
				String sector_id = re.getString(sector_id_f);
				sector_ids.add(sector_id);
			}
			
			if(sector_ids.size()!=4){
				System.out.println("中转中心编号不存在！！！");
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<GoodsPO> goodsPOs = new ArrayList<GoodsPO>();
		try {
			for(int i = 0;i<sector_ids.size();i++){
				ResultSet re = NetModule.excutor.
						excuteQuery("SELECT * FROM sector_item WHERE sector_id="+sector_ids.get(i)+";");
				while(re.next()){
					int id = re.getInt(id_f);
					String location = re.getString(location_f),
							sector_id = re.getString(sectorid_f),
							expressorder_id = re.getString(expressorder_id_f),
							time = re.getString(time_f),
							/*这里有疑问，time存放的格式是data,可不可以用String将其读出来???????*/
							blong_sector = re.getString(belong_sec_f);
					
					GoodsPO po = new GoodsPO(expressorder_id, location, blong_sector, time);
					/*这里也有问题，belong_sec的存放格式要不要变成SectorType?????????*/
					goodsPOs.add(po);
				}
				
			}
			return goodsPOs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<GoodsPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String expressorder_id = po.getExpressorder_id(),
				location = po.getLocation(),
				date = po.getDate(),
				sector = po.getSector();
		return null;
	}

	@Override
	public ResultMessage add(List<GoodsPO> expressorders)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String expressorder_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			/*delete 后面要不要*号????????*/
			ResultSet re = NetModule.excutor.
					excuteQuery("DELETE FROM sector_item WHERE expressorder_id="+expressorder_id+";");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除：快递编号不存在");
			return ResultMessage.NOTFOUND;
		}
		return ResultMessage.NOTFOUND;
	}

	@Override
	public ResultMessage delete(List<String> expressorders_id)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(GoodsPO expressorder) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(List<GoodsPO> expressorders)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsPO find(String expressorder_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor.
					excuteQuery("SELECT * FROM sector_item WHERE expressorder_id="+expressorder_id+";");
			int id = re.getInt(id_f);
			String location = re.getString(location_f),
					sector_id = re.getString(sectorid_f),
					time = re.getString(time_f),
					/*这里有疑问，time存放的格式是data,可不可以用String将其读出来???????*/
					blong_sector = re.getString(belong_sec_f);
			
			GoodsPO po = new GoodsPO(expressorder_id, location, blong_sector, time);
			return po;
			/*这里也有问题，belong_sec的存放格式要不要变成SectorType?????????*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找:错误的快递编号");
		}
		return null;
	}

	/*警戒值要不要持久化*/

	@Override
	public ResultMessage setAlarm(double alarmValue) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAlarm() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}



}
