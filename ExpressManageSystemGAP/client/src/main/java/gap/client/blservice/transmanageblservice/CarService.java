package gap.client.blservice.transmanageblservice;

import gap.client.vo.CarVO;
import gap.common.util.ResultMessage;

import java.util.List;

public interface CarService {
	public List<CarVO> getAll();

	public CarVO getSingle(String id);

	public ResultMessage modify(CarVO vo);

	public ResultMessage delete(String id);

	public ResultMessage add(CarVO vo);
}
