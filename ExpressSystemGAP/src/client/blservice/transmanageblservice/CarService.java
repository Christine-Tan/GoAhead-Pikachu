package client.blservice.transmanageblservice;

import java.util.List;

import util.ResultMessage;
import client.vo.CarVO;

public interface CarService {
	public List<CarVO> getAll();

	public CarVO getSingle(String id);

	public ResultMessage modify(CarVO vo);

	public ResultMessage delete(String id);

	public ResultMessage add(CarVO vo);
}
