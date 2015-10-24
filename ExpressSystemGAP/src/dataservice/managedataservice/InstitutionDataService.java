package dataservice.managedataservice;

import po.InstitutionPO;
import po.ResultMessage;

public interface InstitutionDataService {
	public ResultMessage add(InstitutionPO po);

	public InstitutionPO find(String ins_id);

	public ResultMessage modify(InstitutionPO po);

	public ResultMessage delete(String ins_id);
}
