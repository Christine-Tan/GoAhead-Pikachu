package stub_drivers.dataservice.institution;

import java.util.ArrayList;
import java.util.List;

import po.InstitutionPO;
import util.ResultMessage;
import dataservice.managedataservice.InstitutionDataService;

public class InstitutionDataService_stub implements InstitutionDataService{
	private ArrayList<InstitutionPO>  list;

	public  InstitutionDataService_stub() {
		list = new ArrayList<InstitutionPO>();
	}
	
	@Override
	public ResultMessage add(InstitutionPO po) {
		// TODO 自动生成的方法存根
		for (InstitutionPO institution : list)
			if (po.getInsId().equals(institution.getInsId()))
				return ResultMessage.EXITED;
		list.add(po);
		return ResultMessage.SUCCEED;
	}

	@Override
	public InstitutionPO find(String ins_id) {
		// TODO 自动生成的方法存根
		for (InstitutionPO institution : list)
			if (ins_id.equals(institution.getInsId()))
				return institution;
		return null;
	}

	@Override
	public ResultMessage modify(InstitutionPO po) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < list.size(); i++) {
			if (po.getInsId().equals(list.get(i).getInsId()))
				list.remove(i);
				list.add(po);
				return ResultMessage.SUCCEED;
			}
		return ResultMessage.NOTFOUND;
	}
	

	@Override
	public ResultMessage delete(String ins_id) {
		// TODO 自动生成的方法存根
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getInsId().equals(ins_id)) {
				list.remove(i);
				return ResultMessage.SUCCEED;
			}
		}
		return ResultMessage.NOTFOUND;
	}

	@Override
	public List<InstitutionPO> getAll() {
		// TODO 自动生成的方法存根
		return list;
	}
}
