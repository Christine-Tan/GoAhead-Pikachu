package client.blservice.transmanageblservice;

import client.vo.CarVO;

public interface CarService {
	public CarVO[] getAll();

	public CarVO getSingle(String id);

	public void modify(CarVO vo);

	public void delete(String id);

	public void add(CarVO vo);
}
