package gap.client.datacontroller;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.InstitutionPO;
import gap.common.util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import static gap.client.datacontroller.NetModule.institutiondataservice;
public class InstitutionDataController {

	protected InstitutionDataController() {
	}

	public ResultMessage add(InstitutionPO po) {
		try {
			return institutiondataservice.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage modify(InstitutionPO po) {
		try {
			return institutiondataservice.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public ResultMessage delete(String ins_id) {
		try {
			return institutiondataservice.delete(ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}

	public List<InstitutionPO> getAll() {
		try {
			return institutiondataservice.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<InstitutionPO> findByCity(String city) {
		try {
			return institutiondataservice.findByCity(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public InstitutionPO findById(String ins_id) {
		try {
			return institutiondataservice.findById(ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public InstitutionPO findByName(String ins_name) {
		try {
			return institutiondataservice.findByName(ins_name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
