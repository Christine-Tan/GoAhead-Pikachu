package gap.server.data.inventorydata;

import gap.common.dataservice.inventorydataservice.InventoryDataService;
import gap.common.po.GoodsPO;
import gap.common.util.ResultMessage;
import gap.common.util.SectorType;
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
	private String sector_id_f = "sector_id",type_f = "type",ins_id_f = "ins_id",alarmValue_f = "Alarm_Value";
	//表名
	private String sectorItemTable = "sector_item";
	//字段
	private String id_f = "id",location_f = "location",sectorid_f = "sector_id",
			expressorder_id_f = "expressorder_id",time_f = "time",belong_sec_f="belong_sec",destination_f= "destination";
	
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
					excuteQuery("SELECT * FROM sector WHERE ins_id='"+ins_id+"';");
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
						excuteQuery("SELECT * FROM sector_item WHERE sector_id='"+sector_ids.get(i)+"';");
				while(re.next()){
					int id = re.getInt(id_f);
					String location = re.getString(location_f),
							sector_id = re.getString(sectorid_f),
							expressorder_id = re.getString(expressorder_id_f),
							time = re.getString(time_f),
							blong_sector = re.getString(belong_sec_f),
							destination = re.getString(destination_f);
					SectorType type = getSectorType(sector_id.charAt(sector_id.length()-1));
					
					GoodsPO po = new GoodsPO(expressorder_id, location, type, time, sector_id, blong_sector,destination);
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
	
	public SectorType getSectorType(char c){
		switch(c){
		case'0': return SectorType.FLEX;
		case'1': return SectorType.CAR;
		case'2': return SectorType.TRAIN;
		case'3': return SectorType.PLANE;
		default: return null;
		}
	}
	

	@Override
	public ResultMessage add(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String expressorder_id = po.getExpressorder_id(),
				location = po.getLocation(),belong_sector = po.getBelong_sector_id(),
				date = po.getDate(),sector_id = po.getSector_id(),destination = po.getDestination();
		
		try {
			ResultSet re = NetModule.excutor.
					excuteQuery("SELECT * FROM sector_item WHERE expressorder_id='"+expressorder_id+"';");
			if(re.next()){
				System.out.println("订单号为"+expressorder_id+"的订单已经存在");
				return ResultMessage.EXITED;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		
		try {
			sectorItemInsert.clear();
			sectorItemInsert.add(location_f, location);
			sectorItemInsert.add(sectorid_f, sector_id);
			sectorItemInsert.add(expressorder_id_f, expressorder_id);
			sectorItemInsert.add(time_f, date);
			sectorItemInsert.add(belong_sec_f,belong_sector);
			sectorItemInsert.add(destination_f,destination);
			String sql = sectorItemInsert.createSQL();
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage add(List<GoodsPO> expressorders)
			throws RemoteException {
		// TODO Auto-generated method stub
		for(GoodsPO po:expressorders){
			return add(po);
		}
		return ResultMessage.SUCCEED;
		
	}

	@Override
	public ResultMessage delete(String expressorder_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor.
					excuteQuery("DELETE FROM sector_item WHERE expressorder_id='"+expressorder_id+"';");
			
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
		for(String id:expressorders_id){
			return delete(id);
		}
		return ResultMessage.SUCCEED;
	}

	@Override
	public ResultMessage modify(GoodsPO po) throws RemoteException {
		// TODO Auto-generated method stubString expressorder_id = po.getExpressorder_id(),
		String expressorder_id = po.getExpressorder_id(),
				location = po.getLocation(),belong_sector = po.getBelong_sector_id(),
				date = po.getDate(),sector_id = po.getSector_id(),destination = po.getDestination();
		
		try {
			ResultSet re = NetModule.excutor
					.excuteQuery("SELECT *FROM user WHERE id='" + expressorder_id
							+ "';");
			if (!re.next()) {
				return ResultMessage.NOTFOUND;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		
		
		try {
			sectorItemUpdate.clear();
			sectorItemUpdate.add(location_f, location);
			sectorItemUpdate.add(sectorid_f, sector_id);
			sectorItemUpdate.add(time_f, date);
			sectorItemUpdate.add(belong_sec_f,belong_sector);
			sectorItemUpdate.add(destination_f,destination);
			sectorItemUpdate.setKey(expressorder_id_f, expressorder_id);
			String sql = sectorItemUpdate.createSQL();
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.FAILED;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ResultMessage.SUCCEED;
	
	}

	@Override
	public ResultMessage modify(List<GoodsPO> expressorders)
			throws RemoteException {
		// TODO Auto-generated method stub
		
		for(GoodsPO po:expressorders){
			return modify(po);
		}
		return ResultMessage.SUCCEED;
	}

	@Override
	public GoodsPO find(String expressorder_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor.
					excuteQuery("SELECT * FROM sector_item WHERE expressorder_id='"+expressorder_id+"';");
			int id = re.getInt(id_f);
			String location = re.getString(location_f),
					sector_id = re.getString(sectorid_f),
					time = re.getString(time_f),
					blong_sector = re.getString(belong_sec_f),
					destination = re.getString(destination_f);
			SectorType type = getSectorType(sector_id.charAt(sector_id.length()-1));
			
			GoodsPO po = new GoodsPO(expressorder_id, location, type, time, sector_id, blong_sector,destination);
			return po;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查找:错误的快递编号");
		}
		return null;
	}


	@Override
	public ResultMessage setAlarm(double alarmValue,String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
	
		try {
			sectorUpdate.clear();
			sectorUpdate.add(alarmValue_f, alarmValue);
			sectorUpdate.setKey(ins_id, ins_id);
			String sql = sectorUpdate.createSQL();
			NetModule.excutor.excute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCEED;
	}

	@Override
	public double getAlarm(String ins_id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re=NetModule.excutor.excuteQuery("SELECT * FROM sector WHERE ins_id ='"+ins_id+"';");
			re.next();
			String alarm = re.getString(alarmValue_f);
			return Double.parseDouble(alarm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}



}
