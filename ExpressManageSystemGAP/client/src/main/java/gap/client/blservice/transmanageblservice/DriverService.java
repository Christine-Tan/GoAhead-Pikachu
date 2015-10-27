package gap.client.blservice.transmanageblservice;

import gap.client.vo.DriverVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface DriverService {
	public List<DriverVO> getAll();

	public DriverVO getSingle(String id);

	public ResultMessage modify(DriverVO vo);

	public ResultMessage delete(String id);

	public ResultMessage add(DriverVO vo);
}
