package gap.client.blservice.manageblservice;

import gap.client.vo.InstitutionVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface InstitutionService {
	public List<InstitutionVO> getAll();

	public InstitutionVO getSingle(String id);

	public ResultMessage modify(InstitutionVO vo);

	public ResultMessage delete(String id);

	public ResultMessage add(InstitutionVO vo);
}
