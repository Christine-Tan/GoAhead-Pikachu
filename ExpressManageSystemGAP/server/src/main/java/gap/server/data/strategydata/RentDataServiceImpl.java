package gap.server.data.strategydata;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gap.common.dataservice.strategydataservice.RentDataService;
import gap.common.po.RentPO;
import gap.common.util.ResultMessage;
import gap.server.initial.NetModule;

public class RentDataServiceImpl extends UnicastRemoteObject implements RentDataService{
    //表名
	String tablename="rent",instable="institution";
	//字段
	String money_f="money",lastPaid_f="lastPaid",insti_f="institution_id";
	
	public RentDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public List<RentPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		List<RentPO> rents=new ArrayList<RentPO>();
		try {
			ResultSet re=NetModule.excutor.excuteQuery("SELECT rent.money money_f,institution.name institution_f,rent.lastPaid lastPaid_f  FROM rent,institution WHERE institution.id=rent.institution_id;");
			while (re.next()){
				 String institution=re.getString("institution_f");
				 Date lastPaid=re.getDate("lastPaid_f");
				 double money=Double.valueOf(re.getString("money_f"));
			}
			return rents;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
