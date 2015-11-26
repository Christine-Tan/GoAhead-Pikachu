package gap.client.datacontroller.managedata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import gap.common.dataservice.ServiceName;
import gap.common.dataservice.managedataservice.InstitutionDataService;
import gap.common.netconfig.RMIConfig;
import gap.common.po.InstitutionPO;
import gap.common.util.ResultMessage;

public class InstitutionDataController {
	InstitutionDataService institutionData;

	public InstitutionDataController() {
		try {
			institutionData = (InstitutionDataService) Naming.lookup(RMIConfig.url + ServiceName.INSTITUTION_DATA_SERVICE);
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

	public ResultMessage add(InstitutionPO po) {
		try {
			return institutionData.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
	public ResultMessage modify(InstitutionPO po){
		try {
			return institutionData.modify(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
	public ResultMessage delete(String ins_id) {
		try {
			return institutionData.delete(ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAILED;
	}
	public List<InstitutionPO> getAll(){
		try {
			return institutionData.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<InstitutionPO> findByCity(String city){
		try {
			return institutionData.findByCity(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public InstitutionPO findById(String ins_id){
		try {
			return institutionData.findById(ins_id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
