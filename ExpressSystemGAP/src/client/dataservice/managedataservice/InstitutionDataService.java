package client.dataservice.managedataservice;

import client.po.InstitutionPO;
import client.po.ResultMessage;

public interface InstitutionDataService {
	public ResultMessage add(InstitutionPO po);

	public InstitutionPO find(String ins_id);

	public ResultMessage modify(InstitutionPO po);

	public ResultMessage delete(String ins_id);
}
