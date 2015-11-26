package gap.client.datacontroller.strategydata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.strategydataservice.SalaryDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.SalaryPO;
import gap.common.util.ResultMessage;
import gap.common.util.UserType;

public class SalaryDataController {
	SalaryDataService salaryData;

	public SalaryDataController() {
		try {
			salaryData = (SalaryDataService) Naming.lookup(RMIConfig.url + ServiceName.SALARY_DATA_SERVICE);
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

	public SalaryPO find(UserType type) {
		try {
			return salaryData.find(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultMessage add(SalaryPO po) {
		try {
			return salaryData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(SalaryPO po) {
		try {
			return salaryData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<SalaryPO> getAll() {
		try {
			return salaryData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
