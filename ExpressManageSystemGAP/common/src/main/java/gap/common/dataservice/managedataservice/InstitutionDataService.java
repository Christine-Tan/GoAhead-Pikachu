package gap.common.dataservice.managedataservice;

import gap.common.po.InstitutionPO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface InstitutionDataService {
	public ResultMessage add(InstitutionPO po);

	public InstitutionPO find(String ins_id);

	public ResultMessage modify(InstitutionPO po);

	public ResultMessage delete(String ins_id);

	public List<InstitutionPO> getAll();
}
