package gap.server.data.strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gap.common.dataservice.strategydataservice.CityDataService;
import gap.common.po.CityPO;
import gap.common.po.InstitutionPO;
import gap.common.util.ResultMessage;
import gap.server.data.util.InsertSQL;
import gap.server.data.util.UpdateSQL;
import gap.server.initial.NetModule;

public class CityDataServiceImpl extends UnicastRemoteObject implements CityDataService {
	// 表名
	private String tablename1 = "city", tablename2 = "citylocation", tablename3 = "province";
	// 字段
	private String id_f = "id", city_f = "city_id", lati_f = "latitude", long_f = "longitude",
			province_f = "province_id", proname_f = "name";

	private InsertSQL insertSQL1, insertSQL2, insertSQL3;

	public CityDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		insertSQL1 = new InsertSQL(tablename1);
		insertSQL2 = new InsertSQL(tablename2);
		insertSQL3 = new InsertSQL(tablename3);
	}

	@Override
	public CityPO find(String name) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			ResultSet re = NetModule.excutor.excuteQuery("SELECT * FROM city WHERE name=" + name + ";");
			re.next();
			ResultSet city = NetModule.excutor
					.excuteQuery("SELECT * FROM citylocation WHERE cityid=" + re.getString(id_f) + ";");
			city.next();
			ResultSet province = NetModule.excutor
					.excuteQuery("SELECT * FROM province WHERE id=" + city.getString(province_f) + ";");
			province.next();
			String proname = province.getString(proname_f);
			double lati = city.getDouble(lati_f), longi = city.getDouble(long_f);
			CityPO po = new CityPO(name, proname, lati, longi);
			return po;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		String cityname = po.getCity(), province = po.getProvince();
		double lati = po.getLatitude(), longi = po.getLongitude();
		try {
			ResultSet re = NetModule.excutor.excuteQuery("SELECT *FROM city WHERE name=" + cityname + "';");
			if (re.next()) {
				System.out.println(re.getString("name"));
				return ResultMessage.EXITED;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
//how to add the citylocation with id pointing to taable city
		try {
			insertSQL1.add(city_f, cityname);
			insertSQL2.add(province_f, province);
			String sql = insertSQL1.createSQL();
			NetModule.excutor.excute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CityPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			List<CityPO> cities = new ArrayList<CityPO>();
			ResultSet city = NetModule.excutor.excuteQuery("SELECT *FROM city");
			while (city.next()) {
				String id = city.getString(id_f), cityname = city.getString("name");
				ResultSet cityloca = NetModule.excutor
						.excuteQuery("SELECT * FROM citylocation WHERE cityid=" + id + ";");
				cityloca.next();
				double lati = cityloca.getDouble(lati_f), longi = cityloca.getDouble(long_f);
				ResultSet province = NetModule.excutor
						.excuteQuery("SELECT * FROM province WHERE id=" + cityloca.getString(province_f) + ";");
				province.next();
				String proname = province.getString(proname_f);
				CityPO po = new CityPO(cityname, proname, lati, longi);
				cities.add(po);
			}
			return cities;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
