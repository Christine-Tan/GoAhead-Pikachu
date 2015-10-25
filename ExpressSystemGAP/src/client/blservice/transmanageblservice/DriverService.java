package client.blservice.transmanageblservice;

import java.util.List;

import util.ResultMessage;
import client.vo.DriverVO;

public interface DriverService {
	public List<DriverVO> getAll();

	public DriverVO getSingle(String id);

	public ResultMessage modify(DriverVO vo);

	public ResultMessage delete(String id);

	public ResultMessage add(DriverVO vo);
}
