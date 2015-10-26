package dataservice.managedataservice;

import java.util.List;
import po.InstitutionPO;
import util.ResultMessage;

public interface InstitutionDataService {
	public ResultMessage add(InstitutionPO po);

	public InstitutionPO find(String ins_id);

	public ResultMessage modify(InstitutionPO po);

	public ResultMessage delete(String ins_id);
	
	public List<InstitutionPO> getAll();
}
