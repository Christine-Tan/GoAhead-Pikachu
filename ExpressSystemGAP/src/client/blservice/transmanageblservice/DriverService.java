package client.blservice.transmanageblservice;

import client.vo.DriverVO;

public interface DriverService {
	public DriverVO[] getAll();

	public DriverVO getSingle(String id);

	public void modify(DriverVO vo);

	public void delete(String id);

	public void add(DriverVO vo);
}
